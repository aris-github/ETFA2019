/**
 * 
 */
package translation.complex;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLCardinalityRestriction;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLQuantifiedObjectRestriction;
import org.semanticweb.owlapi.model.OWLRestriction;

import concept.model.*;
import CAEX215.AttributeType;
import CAEX215.CAEX215Factory;
import CAEX215.CAEXObject;
import CAEX215.ExternalInterfaceType;
import CAEX215.InterfaceClassType;
import CAEX215.InternalElementType;
import CAEX215.RoleClassType;
import CAEX215.RoleRequirementsType;
import CAEX215.SystemUnitClassLibType;
import concept.tree.GenericTree;
import concept.tree.GenericTreeNode;
import constants.AMLClassIRIs;
import constants.AMLObjectPropertyIRIs;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;
import utils.OWLExpressionUtils;

/**
 * @author aris
 *
 */
public class AMLConceptTree extends GenericTree<AMLConcept>{
	
	private static final OWL2AMLConverter AML_CONVERTER = new OWL2AMLConverter();	
	private static CAEX215Factory caexFactory = CAEX215Factory.eINSTANCE;	
	private static OWLDataFactory owlFactory = new OWLDataFactoryImpl();
	
	private boolean isExpanded = false;
	private boolean hasInverseRoles = false;
	
	public AMLConceptTree() {		
	}
	
	/**
	 * generate a tree from a root node
	 * @param root
	 */
//	public AMLConceptTree(GenericTreeNode<AMLConcept> root) {
//		this.root = root;
//		this.hasInverseRoles = OWLExpressionUtils.hasAMLInverseRole(root.data.getExpression());
//	}
	
	/**
	 * generate a tree from an owl class expression
	 * @param ce
	 */
	public AMLConceptTree(OWLClassExpression ce) {
		this.root = new GenericTreeNode<AMLConcept>();
		this.root.data = new AMLConcept();
//		this.root.data.setExpression(ce);
		// use negation normal form instead of original expression
		// note that data property with value restriction will be changed to existential restriction with a filler of one value
		// has_manufacturer value "KUKA" --> has_manufacturer some {KUKA}
		this.root.data.setExpression(ce.getNNF());
		this.hasInverseRoles = OWLExpressionUtils.hasAMLInverseRole(ce);
	}
	
	/**
	 * Deep copy constructor
	 * @param other
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public AMLConceptTree(AMLConceptTree other) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		super(other);
		this.isExpanded = other.isExpanded;
		this.hasInverseRoles = other.hasInverseRoles;
	}	
	
	
	/**
	 * Generate tree patterns for owl class expressions: start from a tree with a single root, expand it to a set of trees
	 * - case disjunction: make duplicates of the tree for each operand 
	 * - case conjunction: expand each of the operands 
	 * - case filler: expand the filler
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public Set<AMLConceptTree> expand() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Set<AMLConceptTree> trees = new HashSet<AMLConceptTree>();
		
		if(this.root.data.getExpression() == null) {
			trees.add(this);
		}
		
		else if(!OWLExpressionUtils.isExpandable(this.root.data.getExpression())) {
			trees.add(this);
		}
		
		// case disjunction: for each operand make a new tree and set its caex and primary flag to the disjunction 
		else if(OWLExpressionUtils.isDisjunctive(this.root.data.getExpression())) {
			OWLObjectUnionOf disjunctions = (OWLObjectUnionOf) this.root.data.getExpression();
			for(OWLClassExpression op : disjunctions.getOperands()) {
				AMLConceptTree opTree = new AMLConceptTree(op);
				opTree.root.data.setCaexType(this.root.data.getCaexType());
				opTree.root.data.setPrimary(this.root.data.isPrimary());
				Set<AMLConceptTree> opTreeExpanded = opTree.expand();
				trees.addAll(opTreeExpanded);
			}
		}

		// case conjunction: for each operand add a child node to the current node
		// need to care about nested disjunction and conjunctions
		// for example, if we have "A and (B or C)"
		// then we would produce two trees for (B or C)
		// and we need to add "A" to both of them
		else if(OWLExpressionUtils.isConjunctive(this.root.data.getExpression())) {
			
			// maintain a set of trees in case the operands expand to multiple trees
			// then we need to muliplex them
			Set<AMLConceptTree> clones = new HashSet<AMLConceptTree>(); 			
			// we add the current tree to it
			clones.add(this);				
			
			// flatten the conjunction
			// it wouldn't be a problem from DL-Learner results
			// but during inverse role removing, we might have nested intersections
			OWLObjectIntersectionOf conjunctions = (OWLObjectIntersectionOf) this.root.data.getExpression();
			OWLObjectIntersectionOf flat = OWLExpressionUtils.flattenConjunction(conjunctions);
			this.root.data.setExpression(flat);
			
			for(OWLClassExpression op : flat.getOperands()) {
				
				AMLConceptTree opTree = new AMLConceptTree(op);
				Set<AMLConceptTree> opTreeExpanded = opTree.expand();
				
				// no further disjunction in the operand
				if(opTreeExpanded.size() == 1) {				
					// for each tree we need to add the child
					// we might have several already, since one operand of the conjunction could be a disjunction, which would produce several trees
					// each of the disjunctive tree is saved in clones.
					for(Iterator<AMLConceptTree> iterator = clones.iterator(); iterator.hasNext();) {
						AMLConceptTree clone = iterator.next();
						clone.root.addChild(opTree.root);
					}
				}
				else { // further disjunctions in the operand
					
					// we have disjunctions somewhere, so that the expanded opTree has size > 1
					// clone the current tree with number of disjunctions
					// that is, size of the opTreeExpanded
					Set<AMLConceptTree> clonesForDisjunctionsInOperand = new HashSet<AMLConceptTree>();
					for(Iterator<AMLConceptTree> iterator = clones.iterator(); iterator.hasNext();) {
						AMLConceptTree clone = iterator.next();
					
						// newClones holds the clones of already existing clones
						Set<AMLConceptTree> newClones = new HashSet<AMLConceptTree>();
						
						// we only clone each existing tree n-1 times (MULTIPLEXING), since
						// say we have 2 disjunctions, and originally have 2 trees A and B
						// then we need 4 trees after clone
						// if we clone A twice and B twice, then we have A + A1 + A2 + B + B1 + B2: 6 trees
						for(int i = 1; i < opTreeExpanded.size(); i++) {
							AMLConceptTree newClone = new AMLConceptTree(clone);
							newClones.add(newClone);
						}
						
						// add the expanded opTree but not the opTree itself
						// e.g. for (A or B) and C, we want at the end two trees:
						// - (A or B) and C 
						//   - A
						//   - C
						// - (A or B) and C
						//   - B
						//   - C
						// we do not want any disjunction in the tree, e.g.
						// - (A or B) and C
						//   - A or B
						//     - A
						//   - C
						Iterator<AMLConceptTree> iteratorExpanded = opTreeExpanded.iterator();
						clone.root.addChild(iteratorExpanded.next().root);
						
						for(AMLConceptTree newClone : newClones) {
							// we do not need to concern about the range
							// since it is synchronized implicitly with the previous addchild and "i=1"
							newClone.root.addChild(iteratorExpanded.next().root);
						}
						
						clonesForDisjunctionsInOperand.addAll(newClones);
					}
					clones.addAll(clonesForDisjunctionsInOperand);
						
				}
			}//end for each operand in conjunction
			
			trees.addAll(clones);
			
		} // end conjunctions
				
		else if(OWLExpressionUtils.isFillerExpandable(this.root.data.getExpression())) {		
			// maintain a set of trees in case the operands expand to multiple trees
			// then we need to multiplex them
			Set<AMLConceptTree> clones = new HashSet<AMLConceptTree>(); 			
			// we add the current tree to it
			clones.add(this);				
			
			OWLQuantifiedObjectRestriction restriction = (OWLQuantifiedObjectRestriction) this.root.data.getExpression();
			OWLClassExpression filler = restriction.getFiller();
			
			// make a new tree for the filler and expand it
			AMLConceptTree opTree = new AMLConceptTree(filler);			
			Set<AMLConceptTree> opTreeExpanded = opTree.expand();
			
			// no disjunction in the operand
			if(opTreeExpanded.size() == 1) {
				// for each tree we need to add the child: we might have several already
				for(Iterator<AMLConceptTree> iterator = clones.iterator(); iterator.hasNext();) {
					AMLConceptTree clone = iterator.next();
					clone.root.addChild(opTree.root);
				}
			}
			// TODO: duplicate code as in the conjunction part
			else { // further disjunctions in the filler
				
				// we have disjunctions somewhere, so that the expanded opTree has size > 1
				// clone the current tree with number of disjunctions
				// that is, size of the opTreeExpanded	
				Set<AMLConceptTree> clonesForDisjunctionsInOperand = new HashSet<AMLConceptTree>();
				for(Iterator<AMLConceptTree> iterator = clones.iterator(); iterator.hasNext();) {
					AMLConceptTree clone = iterator.next();
					Set<AMLConceptTree> newClones = new HashSet<AMLConceptTree>();
					
					// we only clone each existing tree n-1 times (MULTIPLEXING), since
					// say we have 2 disjunctions, and originally have 2 trees A and B
					// then we need 4 trees after clone
					// if we clone A twice and B twice, then we have A + A1 + A2 + B + B1 + B2: 6 trees
					for(int i = 1; i < opTreeExpanded.size(); i++) {
						AMLConceptTree newClone = new AMLConceptTree(clone);
						newClones.add(newClone);
					}
					
					// add the expanded opTree but not the opTree itself
					// e.g. for (A or B) and C, we want at the end two trees:
					// - (A or B) and C 
					//   - A
					//   - C
					// - (A or B) and C
					//   - B
					//   - C
					// we do not want any disjunction in the tree, e.g.
					// - (A or B) and C
					//   - A or B
					//     - A
					//   - C
					Iterator<AMLConceptTree> iteratorExpanded = opTreeExpanded.iterator();						
					clone.root.addChild(iteratorExpanded.next().root);
					
					for(AMLConceptTree newClone : newClones) {
						// we do not need to concern about the range
						// since it is synchronized implicitly with the previous addchild and "i=1"
						newClone.root.addChild(iteratorExpanded.next().root);
					}
					clonesForDisjunctionsInOperand.addAll(newClones);					
				}
				clones.addAll(clonesForDisjunctionsInOperand);
			}
			trees.addAll(clones);
		}
		
		for(AMLConceptTree tree : trees) {
			tree.isExpanded = true;
		}		
		return trees;
	}
	
	/**
	 * remove the inverse role restrictions in an expanded AML concept tree.
	 * inverse roles only appear continuously at the upper part of the tree
	 * that means, from the root to some node - all are inverse roles
	 * there might be siblings which are not inverse roles
	 * but inverse roles must build a property chain: a non-interrupted path in the tree
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public AMLConceptTree removeInverseRole() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		if(!this.isExpanded) {
			System.err.println("AMLConceptTree.removeInverseRole: tree is not expanded yet!");
			return null;
		}
					
		AMLConceptTree noInverse = new AMLConceptTree(this);
		
		// 1: if the root has an inverse role somewhere
		if(OWLExpressionUtils.hasAMLInverseRole(root.data.getExpression())) {

			// 1.1: if it is an object property expression, then one of: hasIE, hasEI, isIEOf, isEIOf
			if(root.data.getExpression() instanceof OWLQuantifiedObjectRestriction) {
				OWLObjectPropertyExpression ope = ((OWLQuantifiedObjectRestriction) root.data.getExpression()).getProperty();
				OWLClassExpression filler = ((OWLQuantifiedObjectRestriction) root.data.getExpression()).getFiller();
				
				// 1.1.1: it is itself an inverse role
				if(OWLExpressionUtils.hasAMLInverseRoleAsProperty(ope)) {					
					// 1.1.1.1: filler is complex (since it is an object property, either one child possible or none)
					//  - if one child: complex filler (as from expand())
					//  - if no child: simple filler, handle it later
					if(!root.getChildren().isEmpty()) {			
						// For complex filler, we need to "move" the filler from the child of the object property to a new root
						// - copy the filler node
						// - create a new root which clones the filler node
						// - set new root to "IE" (ignoring SUC, IC, RC)
						// - set new root to none primary, since it did not exist before
						// - create a new child node by changing the old filler node to hasIE/hasEI some owl:Thing
						// - add new the new child node to the new root node as child (since the new root is a conjunction)
						// - extend the new root description with hasIE/hasEI some owl:Thing
						
						// we copy the filler of the restriction
						// using iterator.next since only one child (one filler) possible
						GenericTreeNode<AMLConcept> child = new GenericTreeNode<AMLConcept>(root.getChildren().iterator().next(), true);
						
						// copy the child (filler) to a new root node (deeply)
						GenericTreeNode<AMLConcept> newRoot = new GenericTreeNode<AMLConcept>(child);
						// TODO: ignoring SUC, RC, IC
						newRoot.data.setCaexType(AMLClassIRIs.INTERNAL_ELEMENT);
						// the new root shall not be returned: it did not exist before
						newRoot.data.setPrimary(false);						
						
						// we copy the current node (inverse role restriction) and modify it later to be owl:THING
						GenericTreeNode<AMLConcept> newChild = new GenericTreeNode<AMLConcept> (root, true);																
						if(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF.toString().contains(OWLExpressionUtils.getAMLPropertyName(ope))) {
//							newChild.data.setCaexType(AMLClassIRIs.INTERNAL_ELEMENT);
							newChild.data.setExpression(owlFactory.getOWLObjectSomeValuesFrom(owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT), owlFactory.getOWLThing()));
						}						
						else if(AMLObjectPropertyIRIs.IS_EXTERNAL_INTERFACE_OF.toString().contains(OWLExpressionUtils.getAMLPropertyName(ope))) {
//							newChild.data.setCaexType(AMLClassIRIs.EXTERNAL_INTERFACE);
							newChild.data.setExpression(owlFactory.getOWLObjectSomeValuesFrom(owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE), owlFactory.getOWLThing()));
						}
						// clear the children, since we have moved them to the new root
						newChild.getChildren().clear();
						
						// add description from the new child to the new root
						newRoot.data.setExpression(owlFactory.getOWLObjectIntersectionOf(newRoot.data.getExpression(), newChild.data.getExpression()));
						
						// add new child to the new root
						newRoot.addChild(newChild);
						
						// in case the filler is a conjunction: we flatten it
						if(child.data.getExpression() instanceof OWLObjectIntersectionOf) {
							for(GenericTreeNode<AMLConcept> grandchild : child.getChildren()) {
								newRoot.addChild(grandchild);
							}
						}else {
							newRoot.addChild(child);	
						}
						
						// if the filler is atomic, we manually add one child to the new root, representing the filler
						// for example, root = isIEOf some A
						// then after doing all things above, we have
						// A and (hasIE some Thing) 
						//  - hasIE some Thing
						// but we want to have A also as child - to simulate the expand function on conjunctions
						// therefore we add A also as child, and it becomes
						// A and (hasIE some Thing)
						//  - hasIE some Thing
						//  - A
						if(child.data.getExpression().isClassExpressionLiteral()) {
							newRoot.addChild(new GenericTreeNode<AMLConcept>(child, true));							
						}
						
						// flatten the new root in case it has nested intersections
						newRoot.data.setExpression(OWLExpressionUtils.flattenConjunction((OWLObjectIntersectionOf) newRoot.data.getExpression())); 
												
						noInverse.root = newRoot;								
					}
					// 1.1.1.2: the object property has simple filler: no filler child node
					else {
						// For simple filler, we need to create a new root with the filler description
						// - create a new root which has the filler description
						// - set new root to "IE" (ignoring SUC, IC, RC)
						// - set new root to none primary, since it did not exist before
						// - create a new child node with hasIE/hasEI some owl:Thing
						// - add new the new child node to the new root node as child (since the new root is a conjunction)
						// - extend the new root description with hasIE/hasEI some owl:Thing

						// we copy the filler of the restriction
						// here we need to manually set the caex type, the description and the pprimary of the new child since the new child is fresh created (in the previous case, it was copied from the filler node)
						GenericTreeNode<AMLConcept> newChild = new GenericTreeNode<AMLConcept>(new AMLConcept());
						if(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF.toString().contains(OWLExpressionUtils.getAMLPropertyName(ope))) {
							newChild.data.setCaexType(AMLClassIRIs.INTERNAL_ELEMENT);
							newChild.data.setExpression(owlFactory.getOWLObjectSomeValuesFrom(owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT), owlFactory.getOWLThing()));
						}						
						else if(AMLObjectPropertyIRIs.IS_EXTERNAL_INTERFACE_OF.toString().contains(OWLExpressionUtils.getAMLPropertyName(ope))) {
							newChild.data.setCaexType(AMLClassIRIs.EXTERNAL_INTERFACE);
							newChild.data.setExpression(owlFactory.getOWLObjectSomeValuesFrom(owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE), owlFactory.getOWLThing()));
						}
						newChild.data.setPrimary(root.data.isPrimary());
						
						
						// copy the child (filler) to a new root node (deeply)
						GenericTreeNode<AMLConcept> newRoot = new GenericTreeNode<AMLConcept>(new AMLConcept(filler));
						// TODO: ignoring SUC, RC, IC
						newRoot.data.setCaexType(AMLClassIRIs.INTERNAL_ELEMENT);
						// the new root shall not be returned: it did not exist before
						newRoot.data.setPrimary(false);	
						
						// add description from the new child to the new root
						newRoot.data.setExpression(owlFactory.getOWLObjectIntersectionOf(newRoot.data.getExpression(), newChild.data.getExpression()));
						// add new child to the new root
						newRoot.addChild(newChild);
						
						// if the filler is simple therefore no child, we manually add one child to the new root, representing the filler
						// for example, root = isIEOf some (price > 10)
						// then after doing all things above, we have
						// (price > 10) and (hasIE some Thing) 
						//  - hasIE some Thing
						// but we want to have (price>10) also as child - to simulate the expand function on conjunctions
						// (price > 10) and (hasIE some Thing)
						//  - hasIE some Thing
						//  - price > 10
						GenericTreeNode<AMLConcept> newChild2 = new GenericTreeNode<AMLConcept>(new AMLConcept(filler));
						// leave caex type and primary as default
						newRoot.addChild(newChild2);
						
						
						noInverse.root = newRoot;
					}
				}
			} // end 1.1: object restriction
			
			// 1.2: it is a conjunction
			// we need to separate the operands of the conjunction into the "inverse role" and "non-inverse role" sets
			// construct a new child node representing everything that is non-inverse role: if there were any inverse role in one operand, it must be directly there (not only nested)
			// for each inverse role, construct an hasIE/hasIE some owl:Thing, and "move" the filler of the inverse role to the new root
			// add the new child node as a child of the new root node
			else if(root.data.getExpression() instanceof OWLObjectIntersectionOf) {
				// we need a new root for all inverse role operands - there must be some since we know that the conjunction contains inverse roles - which can not only be nested within some operands
				GenericTreeNode<AMLConcept> newRoot = new GenericTreeNode<AMLConcept>();				
				newRoot.data = new AMLConcept();
				newRoot.data.setCaexType(AMLClassIRIs.INTERNAL_ELEMENT);
				
				// we construct a new child, holding all descriptions other than inverse role restrictions 
				// the caex type would be clear if we traverse the tree afterwards
				// the primary flag shall be the same as the conjunction - it is still the same object, but just isolated from inverse roles - which represents constraints on nodes above it
				GenericTreeNode<AMLConcept> nonInverseChild = new GenericTreeNode<AMLConcept>();
				nonInverseChild.data = new AMLConcept();
				nonInverseChild.data.setPrimary(root.data.isPrimary());
				// the description of the node shall be only existential quantification since it gets level up in the tree
				OWLObjectSomeValuesFrom nonInverseChildCe = null;	
				
				// fix the object property of children, for both the nonInverseChild and the inverse part
				OWLObjectProperty childProperty = null;
				if(root.data.getCaexType().equals(AMLClassIRIs.INTERNAL_ELEMENT)) {
					childProperty = owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT);
//					nonInverseChild.data.setCaexType(AMLClassIRIs.INTERNAL_ELEMENT);
				}							
				else if(root.data.getCaexType().equals(AMLClassIRIs.EXTERNAL_INTERFACE)) {
					childProperty = owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE);
//					nonInverseChild.data.setCaexType(AMLClassIRIs.EXTERNAL_INTERFACE);
				}
				else {
					System.err.println("AMLTree.removeInverseRoles: child of intersection is neither IE nor EI");
				}
				
				for(GenericTreeNode<AMLConcept> op : root.getChildren()) {
					// 1.2.1: if the op is atomic - add it to nonInverseChild by making a hasIE/hasEI some op.C
//					if(op.data.getExpression().isClassExpressionLiteral() || op.data.getExpression() instanceof OWLQuantifiedDataRestriction) {
					if(!(op.data.getExpression() instanceof OWLQuantifiedObjectRestriction)) {
						
						// if the non inverse child has no expression yet
						if(nonInverseChildCe == null) {
							// convert atomic description to hasIE/hasEI some op.C
							nonInverseChildCe = owlFactory.getOWLObjectSomeValuesFrom(childProperty, op.data.getExpression());
						}else {
							// extend the expression of the non inverse child by adding conjunctive terms to its filler
							// the conjunctive term is the description of the child
							OWLClassExpression nonInverseChildFiller = nonInverseChildCe.getFiller();
							nonInverseChildFiller = owlFactory.getOWLObjectIntersectionOf(nonInverseChildFiller, op.data.getExpression());
							nonInverseChildCe = owlFactory.getOWLObjectSomeValuesFrom(childProperty, nonInverseChildFiller);
						}								
						
						// reset the description of the non inverse child
						nonInverseChild.data.setExpression(nonInverseChildCe);
//						// add the op as a child to the non inverse child
						nonInverseChild.addChild(op);
					}
					
					// nested conjunction will happen during the removing procedure
//					if(op.data.getExpression() instanceof OWLObjectIntersectionOf) {
//						
//					}
										
					// 1.2.2: if the op is object restriction
					// - if it is inverse role: extend the new root with it
					// - if it is non-inverse: extend the nonInverseChild with it
//					if(op.data.getExpression() instanceof OWLQuantifiedObjectRestriction) {
					else {
						OWLObjectPropertyExpression operandProperty = ((OWLQuantifiedObjectRestriction) op.data.getExpression()).getProperty();
						OWLClassExpression operandFiller = ((OWLQuantifiedObjectRestriction) op.data.getExpression()).getFiller();
						
						// 1.2.2.1: if this op is not an inverse role
						// - add the op to the child of the new op node
						if(!OWLExpressionUtils.hasAMLInverseRoleAsProperty(operandProperty)) {
							
//							OWLObjectProperty property = null;
//							if(root.data.getCaexType().equals(AMLClassIRIs.INTERNAL_ELEMENT)) {
//								property = owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT);
//							}							
//							else if(root.data.getCaexType().equals(AMLClassIRIs.EXTERNAL_INTERFACE)) {
//								property = owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE);
//							}
//							else {
//								System.err.println("AMLTree.removeInverseRoles: child of intersection is neither IE nor EI");
//							}
							
							// if the non inverse child has no expression yet
							if(nonInverseChildCe == null) {
								// set its description to the operand
								nonInverseChildCe = owlFactory.getOWLObjectSomeValuesFrom(childProperty, op.data.getExpression());								
							}else {
								// extend the expression of the non inverse child by adding conjunctive terms to its filler
								// the conjunctive term is the description of the child
								OWLClassExpression nonInverseChildFiller = nonInverseChildCe.getFiller();
								nonInverseChildFiller = owlFactory.getOWLObjectIntersectionOf(nonInverseChildFiller, op.data.getExpression());
								nonInverseChildCe = owlFactory.getOWLObjectSomeValuesFrom(childProperty, nonInverseChildFiller);
							}	
							// reset the description of the non inverse child
							nonInverseChild.data.setExpression(nonInverseChildCe);
							// add the op as a child to the non inverse child
							nonInverseChild.addChild(op);						
						}
						
						// 1.2.2.2: if the op is inverse role restriction, then it either has no child or only one child which is its filler
						// each inverse role becomes a hasIE/hasEI some owl:Thing, which has to be merged with existing nonInverseChildCE, i.e. merge them as hasIE/hasEI some (C and Thing and Thing ....)
						// so if the nonInverseChild already has some filler, we can ignore it
						// the filler of inverse roles need to be intersected in the new root: so we do need a inverse child thing to combine every filler of inverse roles 
						else {
							if(!op.getChildren().isEmpty()) {											
								// we copy the filler of the restriction
								// using iterator.next since only one child (one filler) possible
								GenericTreeNode<AMLConcept> grandChild = new GenericTreeNode<AMLConcept>(op.getChildren().iterator().next(), true);
								
								if(newRoot.data.getExpression() == null) {
									newRoot.data.setExpression(grandChild.data.getExpression());									
								}
								else {
									newRoot.data.setExpression(owlFactory.getOWLObjectIntersectionOf(newRoot.data.getExpression(), grandChild.data.getExpression()));
								}
//								newRoot.copyChildrenRec(grandChild);
								if(grandChild.data.getExpression() instanceof OWLObjectIntersectionOf) {
									for(GenericTreeNode<AMLConcept> grandgrandchild : grandChild.getChildren()) {
										newRoot.addChild(grandgrandchild);
									}
								}else {
									newRoot.addChild(grandChild);
								}
								
//								newRoot.data.setExpression(OWLExpressionUtils.flattenConjunction((OWLObjectIntersectionOf) newRoot.data.getExpression()));
								
								// we do not do this any more since it is redundant
//								// make a new child for hasIE/hasEI some owl:Thing since we have moved the filler to the new root
//								GenericTreeNode<AMLConcept> newChild = new GenericTreeNode<AMLConcept> (grandChild, true);
//								newChild.data.setExpression(owlFactory.getOWLObjectSomeValuesFrom(childProperty, owlFactory.getOWLThing()));
//								 add description from the new child to the new root
//								newRoot.data.setExpression(owlFactory.getOWLObjectIntersectionOf(newRoot.data.getExpression(), newChild.data.getExpression()));								
//								// add new child to the new root
//								newRoot.addChild(newChild);										
							}
							// 1.1.1.2: the object property has simple filler: no filler child node
							else {								
								
								if(newRoot.data.getExpression() == null) {
									newRoot.data.setExpression(operandFiller);									
								}
								else {
									newRoot.data.setExpression(owlFactory.getOWLObjectIntersectionOf(newRoot.data.getExpression(), operandFiller));
								}
									
								//  we do not do this any more since it is redundant
//								GenericTreeNode<AMLConcept> newChild = new GenericTreeNode<AMLConcept>(new AMLConcept());
//								newChild.data.setExpression(owlFactory.getOWLObjectSomeValuesFrom(childProperty, owlFactory.getOWLThing()));
//								newChild.data.setPrimary(root.data.isPrimary());
//								 add description from the new child to the new root
//								newRoot.data.setExpression(owlFactory.getOWLObjectIntersectionOf(newRoot.data.getExpression(), newChild.data.getExpression()));
//								// add new child to the new root
//								newRoot.addChild(newChild);
								
								// if the filler is simple therefore no child, we manually add one child to the new root, representing the filler
								// for example, root = isIEOf some A
								// then after doing all things above, we have
								// A and (hasIE some Thing) 
								//  - hasIE some Thing
								// but we want to have A also as child - to simulate the expand function on conjunctions
								// therefore we add A also as child, and it becomes
								// A and (hasIE some Thing)
								//  - hasIE some Thing
								//  - A
								GenericTreeNode<AMLConcept> newChild2 = new GenericTreeNode<AMLConcept>(new AMLConcept(operandFiller));
								// leave caex type and primary as default
								newRoot.addChild(newChild2);				
								
//								newRoot.data.setExpression(OWLExpressionUtils.flattenConjunction((OWLObjectIntersectionOf) newRoot.data.getExpression()));
							}
						}
					}
				} // end : all children in conjunction				
				
				// after handling all children, we add the non inverse child to the root
				if(newRoot.data.getExpression() == null) {
					if(nonInverseChildCe != null) {
						newRoot.data.setExpression(nonInverseChildCe);
						// add the new op node to the new root
						newRoot.addChild(nonInverseChild);
//						GenericTreeNode<AMLConcept> copyOfNonInverseChild = new GenericTreeNode<AMLConcept>(nonInverseChild);
//						AMLConceptTree tree = new AMLConceptTree(copyOfNonInverseChild);
//						AMLConceptTree expanded = tree.expand().iterator().next();
//						newRoot.addChild(expanded.root);
					}
				}else {
					if(nonInverseChildCe != null) {
						newRoot.data.setExpression(owlFactory.getOWLObjectIntersectionOf(newRoot.data.getExpression(), nonInverseChildCe));
						// add the new op node to the new root
						newRoot.addChild(nonInverseChild);
//						GenericTreeNode<AMLConcept> copyOfNonInverseChild = new GenericTreeNode<AMLConcept>(nonInverseChild);
//						AMLConceptTree tree = new AMLConceptTree(copyOfNonInverseChild);
//						AMLConceptTree expanded = tree.expand().iterator().next();
//						newRoot.addChild(expanded.root);
					}					
				}
	
				// flatten the root description
				if(newRoot.data.getExpression() instanceof OWLObjectIntersectionOf)
					newRoot.data.setExpression(OWLExpressionUtils.flattenConjunction((OWLObjectIntersectionOf) newRoot.data.getExpression()));
				
				noInverse.root = newRoot;
			} // end 1.2: intersection
			
			else {
				// we have discussed object property and conjunctions so far
				// in other cases (theoretically only atomic concepts), there can not be any inverse roles involved
				System.err.println("AMLConceptTree.removeInverseRole: in case of existing inverse roles, encounting the expression [" + root.data.getExpression() + "] which is neither conjunction nor object property!");
			}
						
			// recursively remove the inverse roles in the tree
			return noInverse.removeInverseRole();
		} // end 1: has some inverse role
		
		// if there is no inverse roles
		this.hasInverseRoles = false;
		return this;
	}
	
	/**
	 * get the caex type of a node
	 * if the node does not have a caex type yet, we check its parent (recursively)
	 * to avoid multiple traverse, we set the nodes caex type afterwards
	 * @param node
	 * @return
	 */
	public static IRI getCAEXType(GenericTreeNode<AMLConcept> node) {
		if(node.data.getCaexType() == null) {
			if(node.getParent() != null) {
				if(node.getParent().data.getExpression() instanceof OWLRestriction) {
					String propertyName = OWLExpressionUtils.getAMLPropertyName(((OWLRestriction) node.getParent().data.getExpression()).getProperty());
					if(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT.toString().contains(propertyName)) 
					{
						node.data.setCaexType(AMLClassIRIs.INTERNAL_ELEMENT);
					}
					else if(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE.toString().contains(propertyName))
					{
						node.data.setCaexType(AMLClassIRIs.EXTERNAL_INTERFACE);
					}
					else if(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF.toString().contains(propertyName)) {
						// if the parent has an inverse role: the type of this node is undefined - need to be unrolled first
						System.err.println("AMLTree.getCAEXType: encounter inverse role while getting caex type of a node");
						return null;
					}
					else if(AMLObjectPropertyIRIs.IS_EXTERNAL_INTERFACE_OF.toString().contains(propertyName)) {
						// if the parent has an inverse role: the type of this node is undefined - need to be unrolled first
						System.err.println("AMLTree.getCAEXType: encounter inverse role while getting caex type of a node");
						return null;
					}
					else {
						// shall not happen, since we have only two object properties (ignore inverse roles first)
						node.data.setCaexType(AMLClassIRIs.ATTRIBUTE);
					}
				}
				else if(node.getParent().data.getExpression() instanceof OWLObjectIntersectionOf) {
					// this is valid, since if the current node has to have a parent of intersection only
					node.data.setCaexType(node.getParent().data.getCaexType());
				}
				else {
					// this is not possible
					System.err.println("OWLTreeNode.getCAEXType(): the current node has no caex type, its parent is of type: " + node.getParent().getClass().getSimpleName());
				}					
			}
			else
				System.err.println("OWLTreeNode.getCAEXType: the owl tree node has no caex type nor a parent!");
		}
		return node.data.getCaexType();
	}
	
	/**
	 * generate a tree for a concept object which is a (nested) AML attribute
	 * @param acm
	 * @return
	 */
	private static GenericTreeNode<AMLConceptModel> getAMLConceptModelTreeNodeForNestedAttribute (AMLConceptModel acm) {
		
		GenericTreeNode<AMLConceptModel> root = null;
		
		AttributeType attr = (AttributeType) acm.getObj();							
		String name = attr.getName();
		
		//TODO: here we assume the descendant attributes are separated by "_"
		String tokens[] = name.split("_");
		
		// if tokens has only one element, then the attribute is not nested
		if(tokens.length == 1) {
			root = new GenericTreeNode<AMLConceptModel>(acm);
		}
		
		// otherwise, generate a tree node for each of the nested ones
		else {
			List<AMLConceptModel> tokenObjs = new ArrayList<AMLConceptModel>();
			for(int i = 0; i < tokens.length; i++) {
				AttributeType tokenAttr = CAEX215Factory.eINSTANCE.createAttributeType();
				tokenAttr.setName(tokens[i]);
				
				// for the last one, we apply the constraints and the config
				if(i == tokens.length-1) {
					tokenAttr.getConstraint().addAll(attr.getConstraint());
					tokenObjs.add(new AMLConceptModel(tokenAttr, acm.getConfig()));
				}
				// for previous ones, use standard config
				else
					tokenObjs.add(new AMLConceptModel(tokenAttr, new AMLConceptAttributes()));				
			}
			
			List<GenericTreeNode<AMLConceptModel>> nodes = new ArrayList<GenericTreeNode<AMLConceptModel>>();
			root = new GenericTreeNode<AMLConceptModel>(tokenObjs.get(0));
			nodes.add(root);
			
			for(int i = 1; i < tokenObjs.size(); i++) {
				GenericTreeNode<AMLConceptModel> descendant = new GenericTreeNode<AMLConceptModel>(tokenObjs.get(i));
				nodes.get(i-1).addChild(descendant);
				nodes.add(descendant);
			}					
		}
		
		return root;
		
	}
	
	/**
	 * transforms an AML concept tree (represented by its root node) to an AMLQuery model
	 * this shall be done after inverse role restrictions are removed from the AML concept tree
	 * @param node
	 * @return
	 */
	public static GenericTreeNode<AMLConceptModel> toAMLConceptModelTreeNode(GenericTreeNode<AMLConcept> node) {		
		
		// get rid of unreasonable root expressions
		if(node.getParent() == null) {
			// for root node, it shall not have special cardinality restrictions
			if(node.data.getExpression() instanceof OWLCardinalityRestriction) {
				System.err.println("AMLConceptTree.toAMLQueryNode: the root node is a cardinality restriction!");
				return null;
			}
		}
		
		// the given concept tree shall not contain any inverse roles
		if(OWLExpressionUtils.hasAMLInverseRole(node.data.getExpression())) {
			System.err.println("AMLConceptTree.toAMLQueryNode: node has inverse roles!");
			return null;
		}
		
		GenericTreeNode<AMLConceptModel> aml = null;
		
		if(OWLExpressionUtils.isExpandable(node.data.getExpression())) {			
			// if data is intersection, then the OWL2AMLConverter will return null
			// we need to handle this explicitly here
			if(node.data.getExpression() instanceof OWLObjectIntersectionOf) {
								
				CAEXObject caex = OWL2AMLConverter.getCAEXObjectSimple(getCAEXType(node));
				AMLConceptAttributes config = new AMLConceptAttributes();
				
				config.setPrimary(node.data.isPrimary());
				AMLConceptModel acm = new AMLConceptModel(caex, config);
				aml = new GenericTreeNode<AMLConceptModel>(acm);
				
				// otherwise				
				if(caex instanceof InternalElementType) {
					for(GenericTreeNode<AMLConcept> child: node.getChildren()) {
						
						// if it is THING, then it was generated from inverse role removement
						// we add a child to the acm model
						// do this before atomic test, since Thing is atomic
						if(child.data.getExpression().isOWLThing()) {
							CAEXObject caexChild = OWL2AMLConverter.getCAEXObjectSimple(getCAEXType(child));
							AMLConceptAttributes configChild = new AMLConceptAttributes();
							configChild.setPrimary(child.data.isPrimary());
							GenericTreeNode<AMLConceptModel> childNode = new GenericTreeNode<AMLConceptModel>(new AMLConceptModel(caexChild, configChild));
							aml.addChild(childNode);
						}
						else if(child.data.getExpression().isOWLNothing()) {
							System.err.println("AMLConceptTree.toAMLConceptModelTreeNode: encounting an OWL:Nothing!");
						}
						// if the child is (negated atomic), add RR to IE
						else if(child.data.getExpression().isClassExpressionLiteral()) {
							RoleRequirementsType rr = caexFactory.createRoleRequirementsType();
							rr.setRefBaseRoleClassPath(OWLExpressionUtils.getAMLClassName(child.data.getExpression()));
							((InternalElementType) caex).setRoleRequirements(rr);;
							// if the reference was a negated atomic: set negated to true
							if(child.data.getExpression() instanceof OWLObjectComplementOf) {
								aml.data.getConfig().setNegated(true);
							}
						}
						else
							// otherwise, add child node
							aml.addChild(toAMLConceptModelTreeNode(child));
//							aml.addChild(toAMLQueryNode(new AMLConceptTree(child)));
					}					
				}
				else if(caex instanceof ExternalInterfaceType) {
					for(GenericTreeNode<AMLConcept> child: node.getChildren()) {
						
						// if it is THING, then it was generated from inverse role removement
						// we add a child to the acm model
						// do this before atomic test, since Thing is atomic
						if(child.data.getExpression().isOWLThing()) {
							CAEXObject caexChild = OWL2AMLConverter.getCAEXObjectSimple(getCAEXType(child));
							AMLConceptAttributes configChild = new AMLConceptAttributes();
							configChild.setPrimary(child.data.isPrimary());
							GenericTreeNode<AMLConceptModel> childNode = new GenericTreeNode<AMLConceptModel>(new AMLConceptModel(caexChild, configChild));
							aml.addChild(childNode);
						}
						// for (nested) atomics, we make a Class reference for EI nodes
						else if(child.data.getExpression().isClassExpressionLiteral() || child.data.getExpression().isOWLThing()) {
							((ExternalInterfaceType) acm.getObj()).setRefBaseClassPath(OWLExpressionUtils.getAMLClassName(child.data.getExpression()));
							
							// if the reference was a negated atomic: set negated to true
							if(child.data.getExpression() instanceof OWLObjectComplementOf) {
								aml.data.getConfig().setNegated(true);
							}
						}
						else
							// otherwise, add child node
							aml.addChild(toAMLConceptModelTreeNode(child));
//							aml.addChild(toAMLQueryNode(new AMLConceptTree(child)));
					}
				}
				else if(caex instanceof SystemUnitClassLibType) {
					//TODO
				}
				else if(caex instanceof RoleClassType) {
					//TODO
				}
				else if(caex instanceof InterfaceClassType) {
					//TODO
				}
				else if(caex instanceof AttributeType) {
					//TODO
				}
				else {
					
				}					
			} // end: intersection
			
			else if (node.data.getExpression() instanceof OWLRestriction){			
				
				AMLConceptModel acm = node.data.getExpression().accept(AML_CONVERTER);				
				acm.getConfig().setPrimary(node.data.isPrimary());
				
				// if the acm object is a nested AML attribute, we need to unfold it since it is flattened to something like "dimension_weight, dimension_height, dimension_width"
				// for such attributes, we need to generate a hierarchy of AMLQueryTreeNodes
				if(acm.getObj() instanceof AttributeType) {					
					aml = getAMLConceptModelTreeNodeForNestedAttribute(acm);
				}
				else {
					aml = new GenericTreeNode<AMLConceptModel>(acm);
				}
				
				
				// there can only be one child though - the filler
				// this child can however be a conjunction
				// - atomic: handle it directly
				// - restricion: recursive
				// - conjunction: for each operand, if it is atomic handle it directly, if it is restriction recursive
				for(GenericTreeNode<AMLConcept> child: node.getChildren()) {
					if(child.data.getExpression().isClassExpressionLiteral()) {				
						
						// if the reference was a negated atomic: set negated to true
						if(child.data.getExpression() instanceof OWLObjectComplementOf) {
							aml.data.getConfig().setNegated(true);
						}
						
						if(acm.getObj() instanceof InternalElementType) {
							RoleRequirementsType rr = caexFactory.createRoleRequirementsType();
							rr.setRefBaseRoleClassPath(OWLExpressionUtils.getAMLClassName(child.data.getExpression()));
							((InternalElementType) aml.data.getObj()).setRoleRequirements(rr);														
						}
						else if(acm.getObj() instanceof ExternalInterfaceType) {
							((ExternalInterfaceType) aml.data.getObj()).setRefBaseClassPath(OWLExpressionUtils.getAMLClassName(child.data.getExpression()));
						}
						else if(acm.getObj() instanceof SystemUnitClassLibType) {
							//TODO
						}
						else if(acm.getObj() instanceof RoleClassType) {
							//TODO
						}
						else if(acm.getObj() instanceof InterfaceClassType) {
							//TODO
						}
						else if(acm.getObj() instanceof AttributeType) {
							//TODO
						}
						else {
							
						}						
					}
					
					else if(child.data.getExpression() instanceof OWLObjectIntersectionOf) {
						// TODO: there is no need to check conjunctions inside conjunctions: REALLY?
						// now we use sys.err 
						for(GenericTreeNode<AMLConcept> grandChild : child.getChildren()) {
							if(grandChild.data.getExpression().isClassExpressionLiteral()) {	
								
								// if the reference was a negated atomic: set negated to true
								// if we only have RR (no SRC), then this could only happen once
								// we can not handle SRC, e.g. hasIE(not A and not B and C): this is not possible to do using a single attribute negated 
								if(grandChild.data.getExpression() instanceof OWLObjectComplementOf) {
									aml.data.getConfig().setNegated(true);
								}
								
								if(acm.getObj() instanceof InternalElementType) {
									RoleRequirementsType rr = caexFactory.createRoleRequirementsType();
									rr.setRefBaseRoleClassPath(OWLExpressionUtils.getAMLClassName(grandChild.data.getExpression()));
									((InternalElementType) aml.data.getObj()).setRoleRequirements(rr);;												
								}
								else if(acm.getObj() instanceof ExternalInterfaceType) {
									((ExternalInterfaceType) aml.data.getObj()).setRefBaseClassPath(OWLExpressionUtils.getAMLClassName(grandChild.data.getExpression()));
								}
								else if(acm.getObj() instanceof SystemUnitClassLibType) {
									//TODO
								}
								else if(acm.getObj() instanceof RoleClassType) {
									//TODO
								}
								else if(acm.getObj() instanceof InterfaceClassType) {
									//TODO
								}
								else if(acm.getObj() instanceof AttributeType) {
									//TODO
								}
								else {
									
								}						
							}
							else if(grandChild.data.getExpression() instanceof OWLObjectIntersectionOf) {
								System.err.println("AMLConceptTree.toAMLQueryNode: intersection inside intersection while handling filler of intersection");
							}
							else {
								GenericTreeNode<AMLConceptModel> cnode = toAMLConceptModelTreeNode(grandChild);
//								GenericTreeNode<AMLConceptModel> cnode = toAMLQueryNode(new AMLConceptTree(child));
								if(cnode != null)
									aml.addChild(cnode);
							}
						}
					}
					else {
						GenericTreeNode<AMLConceptModel> cnode = toAMLConceptModelTreeNode(child);
//						GenericTreeNode<AMLConceptModel> cnode = toAMLQueryNode(new AMLConceptTree(child));
						if(cnode != null)
							aml.addChild(cnode);
					}
				}
			}  // end: restriction
			else {
				System.err.println("OWLTreeNode.toAMLQueryTreeNode: node neither intersection nor restriction");
			}
		} // end: complex
		
		else{
			
			// it is either atomic or negated atomic
			if(node.data.getExpression().isClassExpressionLiteral() || node.data.getExpression() instanceof OWLObjectComplementOf) {
				if(node.getParent() == null) {
					CAEXObject caex = OWL2AMLConverter.getCAEXObjectSimple(getCAEXType(node));
					AMLConceptAttributes config = new AMLConceptAttributes();
					config.setPrimary(node.data.isPrimary());
					
					if(node.data.getExpression() instanceof OWLObjectComplementOf)
						config.setNegated(true);
					
					AMLConceptModel acm = new AMLConceptModel(caex, config);															
					
					if(caex instanceof InternalElementType) {
						RoleRequirementsType rr = caexFactory.createRoleRequirementsType();
						rr.setRefBaseRoleClassPath(OWLExpressionUtils.getAMLClassName(node.data.getExpression()));
						((InternalElementType) caex).setRoleRequirements(rr);;					
					}
					else if(caex instanceof ExternalInterfaceType) {
						((ExternalInterfaceType) acm.getObj()).setRefBaseClassPath(OWLExpressionUtils.getAMLClassName(node.data.getExpression()));
					}
					else if(caex instanceof SystemUnitClassLibType) {
						//TODO
					}
					else if(caex instanceof RoleClassType) {
						//TODO
					}
					else if(caex instanceof InterfaceClassType) {
						//TODO
					}
					else if(caex instanceof AttributeType) {
						//TODO	
					}
					else {
						
					}
					
					aml = new GenericTreeNode<AMLConceptModel>(acm);
				}
				else {
					// shall not happen: for all atomic cases being not the root, we have done it somewhere before while looking at atomic children
					// this happens when we did inverse role handling where the non inverse child has a disjunction of atomics
				}
			} // end : atomic or negated atomic
			
			
			// it is either a simple restriction or negated simple restriction
			else if (node.data.getExpression() instanceof OWLRestriction){
				
				// get the AML acm object from the role restriction		
				AMLConceptModel roleQuery = node.data.getExpression().accept(AML_CONVERTER);
				
				if(roleQuery != null) {					
					// if the node is root: we need an additional acm object as parent
					if(node.getParent() == null) {
						CAEXObject caex = OWL2AMLConverter.getCAEXObjectSimple(getCAEXType(node));
						AMLConceptAttributes config = new AMLConceptAttributes();
						config.setPrimary(node.data.isPrimary());
						aml = new GenericTreeNode<AMLConceptModel>(new AMLConceptModel(caex, config));
						
						// if the acm object is a nested AML attribute, we need to unfold it since it is flattened to something like "dimension_weight, dimension_height, dimension_width"
						// for such attributes, we need to generate a hierarchy of AMLQueryTreeNodes
						if(roleQuery.getObj() instanceof AttributeType) {					
							aml.addChild(getAMLConceptModelTreeNodeForNestedAttribute(roleQuery));
						}
						else {
							aml.addChild(new GenericTreeNode<AMLConceptModel>(roleQuery));
						}
						
//						aml.addChild(new GenericTreeNode<AMLConceptModel>(roleQuery));
					}
					else	{			
						roleQuery.getConfig().setPrimary(node.data.isPrimary());
						// if the acm object is a nested AML attribute, we need to unfold it since it is flattened to something like "dimension_weight, dimension_height, dimension_width"
						// for such attributes, we need to generate a hierarchy of AMLQueryTreeNodes
						if(roleQuery.getObj() instanceof AttributeType) {					
							aml	= getAMLConceptModelTreeNodeForNestedAttribute(roleQuery);
						}
						else {
							aml	= new GenericTreeNode<AMLConceptModel>(roleQuery);
						}
//						aml	= new GenericTreeNode<AMLConceptModel>(roleQuery);
					}
				}
			}// end:restriction
		}
		
		return aml;
	}	
}
