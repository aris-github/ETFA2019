package translation.complex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.xml.type.AnyType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.vocab.OWLFacet;

import CAEX215.AttributeType;
import CAEX215.CAEXObject;
import CAEX215.ExternalInterfaceType;
import CAEX215.InterfaceClassType;
import CAEX215.InternalElementType;
import CAEX215.NominalScaledTypeType;
import CAEX215.OrdinalScaledTypeType;
import CAEX215.RoleClassType;
import CAEX215.SystemUnitClassType;
import CAEX215.util.AMLHelperFunctions;
import concept.model.GenericAMLConceptModel;
import concept.model.AMLConceptConfig;
import concept.tree.GenericTreeNode;
import concept.util.GenericAMLConceptModelUtils;
import constants.AMLObjectPropertyIRIs;
import constants.Consts;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;
import utils.ConjunctionMinimizer;

public class AML2OWLConverter {
	
	OWLDataFactory owlFactory = new OWLDataFactoryImpl();
	
//	Set<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>> done = new HashSet<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>>();
	
	// a hash map holding already computed owl class expressions of nodes, i.e. (node, owl)
	Map<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>, OWLClassExpression> done = new HashMap<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>, OWLClassExpression>();
	
//	private GenericTreeNode<AbstractAMLConceptModel<OWLAMLConceptConfig>> findPrimaryNode (GenericTreeNode<AbstractAMLConceptModel<OWLAMLConceptConfig>> genericTreeNode) {
//		
//		for(GenericTreeNode<AbstractAMLConceptModel<OWLAMLConceptConfig>> node : genericTreeNode.getDescendantOrSelf()) {
//			// primary was a flag of nodes in AMLConceptTree (OWL tree)
//			// returned is a flag of nodes in AMLQueryModel (AML tree)
//			// they are consistent after transforming an AMLConceptTree to AMLQueryModel
//			if(node.data.getConfig().isPrimary()) {
//				return (GenericTreeNode<AbstractAMLConceptModel<OWLAMLConceptConfig>>) node; 
//			}
//		}
//		
//		System.err.println("Could not found the primary node in the tree of: " + genericTreeNode.toString());
//		return null;
//	}
	
	private OWLClassExpression toOWLClassExpression (OWLObjectProperty property, OWLClassExpression filler, AMLConceptConfig config) {

		OWLClassExpression ce = null;
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Note that we do not consider negations here since we already handled them in toOWLClassExpressionRec
		// the filler is already the form we finally want
		// we just need to figure out what kind of OWL expression we need
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		if(!config.isNegated() && config.getMinCardinality() == 1 && config.getMaxCardinality() == -1) {
//			ce = owlFactory.getOWLObjectSomeValuesFrom(property, filler);
//			return ce;
//		}
//		
//		// some not C
//		if(config.isNegated() && config.getMinCardinality() == 1) {
//			ce = owlFactory.getOWLObjectSomeValuesFrom(property, owlFactory.getOWLObjectComplementOf(filler));
//			return ce;
//		}
//		
//		// all C
//		if(config.isNegated() && config.getMinCardinality() == 0) {
//			ce = owlFactory.getOWLObjectAllValuesFrom(property, filler);
//			return ce;
//		}
//		
//		// all not C
//		if(!config.isNegated() && config.getMinCardinality() == 0) {
//			ce = owlFactory.getOWLObjectAllValuesFrom(property, owlFactory.getOWLObjectComplementOf(filler));
//			return ce;
//		}
		
		if(config.getMinCardinality() == 1 && config.getMaxCardinality() == -1) {
			ce = owlFactory.getOWLObjectSomeValuesFrom(property, filler);
		}
		
		// for universal restriction, we need to inverse the filler
		// count(X) = 0 --> r only not(X)
		else if(config.getMinCardinality() == 0 && config.getMaxCardinality() == 0) {
			ce = owlFactory.getOWLObjectAllValuesFrom(property, owlFactory.getOWLObjectComplementOf(filler));
		}
		
		// at least n C
		else if(config.getMinCardinality() > 1) {
			ce = owlFactory.getOWLObjectMinCardinality(config.getMinCardinality(), property, filler);
			
			// for at-least restriction, we need to explicitly represent the upper bound if it is not unlimited
			// at most n C
			if(config.getMaxCardinality() != -1) {
				if(ce == null)
					ce = owlFactory.getOWLObjectMaxCardinality(config.getMaxCardinality(), property, filler);
				else
					// in case both min and max exists
					ce = owlFactory.getOWLObjectIntersectionOf(ce, owlFactory.getOWLObjectMaxCardinality(config.getMaxCardinality(), property, filler));
			}
			
		}
		
		// at most n C
		else if(config.getMaxCardinality() != -1) {			
			ce = owlFactory.getOWLObjectMaxCardinality(config.getMaxCardinality(), property, filler);
			
			// for at-most restriction, we need to explicitly represent the lower bound if it is not 0
			if(config.getMinCardinality() > 0) {
				ce = owlFactory.getOWLObjectIntersectionOf(ce, owlFactory.getOWLObjectMinCardinality(config.getMinCardinality(), property, filler));
			}			
		}
		
		else {
			System.err.println("AML2OWL.toOWLClassExpression: meeting a configuration which we do not know how to map to OWL: " + config.toString());
		}
		
		return ce;
	}
	
	private String getDataPropertyName (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> node) {
		
		String name = "";
		if(node.data.getObj() instanceof AttributeType) {
			if(node.getParent() != null)
				name = getDataPropertyName((GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) node.getParent()) + "_" + node.data.getObj().getName();
			else
				name = node.data.getObj().getName();
		}
		
		return name;
	}
	
	
	/**
	 * try to build the complement of the input class based on aml concept attributes
	 * using the mapping between OWL constructors and AML concept attributes
	 * @param filler
	 * @param config
	 * @return
	 */
	private OWLClassExpression tryBuildComplement (OWLClassExpression ce, AMLConceptConfig config) {
//		if(config.isNegated() && !(config.getMinCardinality() == 0 && config.getMaxCardinality() == 0))
//			return owlFactory.getOWLObjectComplementOf(ce);
//		if(!config.isNegated() && (config.getMinCardinality() == 0 && config.getMaxCardinality() == 0))
//			return owlFactory.getOWLObjectComplementOf(ce);
//		return ce;
		return owlFactory.getOWLObjectComplementOf(ce);
	}
	
	/**
	 * traverse the tree structure with the given node as the root
	 * produce an OWL class expression for this tree structure
	 * @param node
	 * @return OWL class expression for node
	 */
	private OWLClassExpression toOWLClassExpressionRecursive (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> node, boolean isEntryPoint) {
				
		OWLClassExpression ce = null;
		CAEXObject obj = node.data.getObj();
		AMLConceptConfig config = (AMLConceptConfig) node.data.getConfig();		
		
		// attributes are mapped to data properties with value constraints
		// TODO: how to handle sub attributes?
		if(obj instanceof AttributeType) {
			AttributeType attr = (AttributeType) obj;
			
			// in case no name: ignore
			if(attr.getName() == null) {
				return null;
			}
			
			// TODO: dirty: duplicate code from aml_owl.AttributeHandler
//			IRI iri = IRI.create(Consts.importer_pref + "has_" + attr.getName());
			IRI iri = IRI.create(Consts.importer_pref + "has" + getDataPropertyName(node));
			OWLDataProperty dataProperty = owlFactory.getOWLDataProperty(iri);
			
			// TODO: data types ignored for now
			// check value or constraints of the attribute
			String value = AMLHelperFunctions.fromAMLAnyType(attr.getValue());
			if(value != null) {
				OWLLiteral literalValue = owlFactory.getOWLLiteral(value);
				OWLDataRange inversedValue = owlFactory.getOWLDataComplementOf(owlFactory.getOWLDataOneOf(literalValue));
				// check if we need to negate the local data range
				// Notice that the negation shall not be applied to child attributes
				if(config.isNegated())
					ce = owlFactory.getOWLDataSomeValuesFrom(dataProperty, inversedValue);
				else
					ce = owlFactory.getOWLDataHasValue(dataProperty, literalValue);		
			}
			else if(attr.getConstraint() != null && !attr.getConstraint().isEmpty()) {
				// TODO: assume only one constraint								
				
				// for nominal scaled types, we need an intersection of data has value for each possible value 
				if(attr.getConstraint().get(0).getNominalScaledType() != null) {
					NominalScaledTypeType nst = attr.getConstraint().get(0).getNominalScaledType();
					Set<OWLLiteral> literals = new HashSet<OWLLiteral>();
					for(AnyType anytype : nst.getRequiredValue()) {
						literals.add(owlFactory.getOWLLiteral(AMLHelperFunctions.fromAMLAnyType(anytype)));
					}
										
					OWLDataRange range = owlFactory.getOWLDataOneOf(literals);
					if(config.isNegated()) {
						range = owlFactory.getOWLDataComplementOf(range);
					}
						
					ce = owlFactory.getOWLDataSomeValuesFrom(dataProperty, range);
					
//					OWLDataHasValue dhv = owlFactory.getOWLDataHasValue(dataProperty, literal);
//					
//					if(ce == null)
//						ce = dhv;
//					else
//						ce = owlFactory.getOWLObjectIntersectionOf(ce, dhv);												

				}
				
				// for ordnial scaled types, we need data range for min and max
				if(attr.getConstraint().get(0).getOrdinalScaledType() != null) {
					OrdinalScaledTypeType ost = attr.getConstraint().get(0).getOrdinalScaledType();
					if(ost.getRequiredMinValue() != null) {
						OWLLiteral min = owlFactory.getOWLLiteral(Double.valueOf(AMLHelperFunctions.fromAMLAnyType(ost.getRequiredMinValue())));
						OWLDataRange range = owlFactory.getOWLDatatypeRestriction(owlFactory.getDoubleOWLDatatype(), OWLFacet.MIN_INCLUSIVE, min);
						
						if(config.isNegated()) {
							range = owlFactory.getOWLDataComplementOf(range);
						}
						
						if(ce == null)
							ce = owlFactory.getOWLDataSomeValuesFrom(dataProperty, range);
						else 
							ce = owlFactory.getOWLObjectIntersectionOf(ce, owlFactory.getOWLDataSomeValuesFrom(dataProperty, range));
					}
					
					if(ost.getRequiredMaxValue() != null) {
						OWLLiteral max = owlFactory.getOWLLiteral(Double.valueOf(AMLHelperFunctions.fromAMLAnyType(ost.getRequiredMaxValue())));
						OWLDataRange range = owlFactory.getOWLDatatypeRestriction(owlFactory.getDoubleOWLDatatype(), OWLFacet.MIN_INCLUSIVE, max);
						
						if(config.isNegated()) {
							range = owlFactory.getOWLDataComplementOf(range);
						}
						
						if(ce == null)
							ce = owlFactory.getOWLDataSomeValuesFrom(dataProperty, range);
						else 
							ce = owlFactory.getOWLObjectIntersectionOf(ce, owlFactory.getOWLDataSomeValuesFrom(dataProperty, range));
						
						// in case it has also a minimum
//						if(ce != null) 
//							ce = owlFactory.getOWLObjectIntersectionOf(ce, owlFactory.getOWLDataSomeValuesFrom(dataProperty, atmost));							
//						else
//							ce = owlFactory.getOWLDataSomeValuesFrom(dataProperty, atmost);
					}																			
				}
			}
						
			// this is the case that no value conditions present
			// make data property with no range constraint
//			else {
//				ce = owlFactory.getOWLDataSomeValuesFrom(dataProperty, owlFactory.getTopDatatype());
//			}
			
			for(GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> child : node.getChildren()) {
				GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> cNode = (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) child;
				OWLClassExpression childCE = toOWLClassExpressionRecursive(cNode, false);
				if(ce == null)
					ce = childCE;
				else
					ce = owlFactory.getOWLObjectIntersectionOf(ce, childCE);
				
			}
			
			// data properties do not consider universal or cardinality restrictions
			// we only handle existential restrictions here
			if(ce == null)
//				System.err.println("AML2OWLConvert.toOWLClassExpressionRecursive: could not make an owl expression for the attribute: " + attr.getName());
				ce = owlFactory.getOWLDataSomeValuesFrom(dataProperty, owlFactory.getTopDatatype());
			
//			if(config.isNegated())
//				ce = owlFactory.getOWLObjectComplementOf(ce);
//			else {
//				if(config.isNegated())
//					ce = owlFactory.getOWLObjectComplementOf(ce);	
//			}									
		} // end attribute
		
		// External interfaces are mapped to object relations to its referenced class
		else if(obj instanceof ExternalInterfaceType) {
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;
			
			OWLObjectProperty hasEI = owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE);						
			OWLClassExpression filler = owlFactory.getOWLThing();
			
			// set the filler if exists
			if(ei.getRefBaseClassPath() != null) {
				String classref = ei.getRefBaseClassPath();			
				String className = "";
				
				if(classref.contains("/"))
					className = classref.substring(classref.lastIndexOf("/")+1);
				else
					className = classref;
				
				filler = owlFactory.getOWLClass(IRI.create(className));		
				
				// check if we need to negate the local class reference
				// Notice that the negation shall not be applied to child attributes
				if(config.isNegated())
					filler = tryBuildComplement(filler, config);
			}		
			
			// extend the object property with attributes, eis and sub ies
			for(GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> child : node.getChildren()) {			
				GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> cNode = (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) child;
				// get rid of already handled nodes
//				if(!cNode.isConverted) {
//				if(!done.contains(cNode)) {
//					OWLClassExpression childCE = toOWLClassExpressionRecursive(cNode, false);
//					
//					if(filler == null)
//						filler = childCE;
//					else
//						filler = owlFactory.getOWLObjectIntersectionOf(filler, childCE);	
//				}
				
				OWLClassExpression childCE = null;
				if(!done.containsKey(cNode)) {
					childCE = toOWLClassExpressionRecursive(cNode, false);					
				}else {
					childCE = toOWLClassExpressionRecursive(cNode, false);
				}
				
				if(filler == null)
					filler = childCE;
				else
					filler = owlFactory.getOWLObjectIntersectionOf(filler, childCE);

			}		
			
			// make the object property using the final filler
			// Notice: this means that the config of the external interface will affect its sub objects
			if(filler == null)
				filler = owlFactory.getOWLThing();
			
			if(!isEntryPoint)
				ce = toOWLClassExpression(hasEI, filler, config);
			else
				ce = filler;
		}// end EI
		
		// If the concept object is an interface class, then it is asking for something which is an interface class
		// In this case, we ignore the class name but uses the reference to super class
		// also, we use the attributes of the interface class specification
		else if (obj instanceof InterfaceClassType) {
			InterfaceClassType ic = (InterfaceClassType) obj;
			
			OWLClassExpression parent = null;
			if(ic.getRefBaseClassPath() != null) {
				String classref = ic.getRefBaseClassPath();			
				String className = "";
				
				if(classref.contains("/"))
					className = classref.substring(classref.lastIndexOf("/")+1);
				else
					className = classref;
				
				parent = owlFactory.getOWLClass(IRI.create(className));
				
				// check if we need to negate the local class reference
				// Notice that the negation shall not be applied to child attributes
				if(config.isNegated())
					parent = tryBuildComplement(parent, config);
			}
			
			// use the parent class as its class description
			if(parent!= null)
				ce = parent;
			
			// add sub elements (can only be attributes) as conditions
			for(GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> child : node.getChildren()) {
				GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> cNode = (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) child;
//				if(!cNode.isConverted) {
//				if(!done.contains(cNode)) {
//					OWLClassExpression childCE = toOWLClassExpressionRecursive(cNode, false);
//					if(ce == null)
//						ce = childCE;
//					else
//						ce = owlFactory.getOWLObjectIntersectionOf(ce, childCE);
//				}
				OWLClassExpression childCE = null;
				if(!done.containsKey(cNode)) {
					childCE = toOWLClassExpressionRecursive(cNode, false);					
				}else {
					childCE = toOWLClassExpressionRecursive(cNode, false);
				}
				
				if(ce == null)
					ce = childCE;
				else
					ce = owlFactory.getOWLObjectIntersectionOf(ce, childCE);
			}			
		}// end IC
		
		// If the concept object is a role class, then it is asking for something which is a role class
		// In this case, we ignore the class name but uses the reference to super class
		// also, we use the attributes of the role class specification
		else if (obj instanceof RoleClassType) {
			RoleClassType rc = (RoleClassType) obj;
			
			OWLClassExpression parent = null;
			if(rc.getRefBaseClassPath() != null) {
				String classref = rc.getRefBaseClassPath();			
				String className = "";
				
				if(classref.contains("/"))
					className = classref.substring(classref.lastIndexOf("/")+1);
				else
					className = classref;
				
				parent = owlFactory.getOWLClass(IRI.create(className));
				
				// check if we need to negate the local class reference
				// Notice that the negation shall not be applied to child attributes
				if(config.isNegated())
					parent = tryBuildComplement(parent, config);

			}
			
			// use the parent class as its class description
			if(parent!= null)
				ce = parent;
			
			// add sub elements as conditions: attributes, EIs
			for(GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> child : node.getChildren()) {
				GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> cNode = (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) child;
//				if(!cNode.isConverted) {
//				if(!done.contains(cNode)) {
//					OWLClassExpression childCE = toOWLClassExpressionRecursive(cNode, false);
//					if(ce == null)
//						ce = childCE;
//					else
//						ce = owlFactory.getOWLObjectIntersectionOf(ce, childCE);
//				}
				OWLClassExpression childCE = null;
				if(!done.containsKey(cNode)) {
					childCE = toOWLClassExpressionRecursive(cNode, false);					
				}else {
					childCE = toOWLClassExpressionRecursive(cNode, false);
				}
				
				if(ce == null)
					ce = childCE;
				else
					ce = owlFactory.getOWLObjectIntersectionOf(ce, childCE);
			}			
		} // end RC
		
		// Internal elements are mapped to object relations to its referenced class
		else if (obj instanceof InternalElementType) {
			InternalElementType ie = (InternalElementType) obj;
			OWLObjectProperty hasIE = owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT);
			OWLClassExpression filler = null;
			
			// TODO: ignored the suc reference of an IE
			
			// TODO: ignored the SRCs
			
			// TODO: now, DL can not differ between attributes of a RR and attributes of the IE itself!
			// 		(AML-XQuery) do support this feature
			//		right now, we assume that attributes come with the IE directly
			
			// set the filler if RR exists
			if(ie.getRoleRequirements() != null) {
				String classref = ie.getRoleRequirements().getRefBaseRoleClassPath();			
				String className = "";
				
				if(classref.contains("/"))
					className = classref.substring(classref.lastIndexOf("/")+1);
				else
					className = classref;
				
				filler = owlFactory.getOWLClass(IRI.create(className));
				
				// check if we need to negate the local class reference
				// Notice that the negation shall not be applied to child attributes
				if(config.isNegated())
					filler = tryBuildComplement(filler, config);
			}
			
			// extend the object property with attributes, eis and sub ies
			for(GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> child : node.getChildren()) {
				GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> cNode = (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) child;
//				if(!cNode.isConverted) {
//				if(!done.contains(cNode)) {
//					OWLClassExpression childCE = toOWLClassExpressionRecursive(cNode, false);
//					
//					if(filler == null)
//						filler = childCE;
//					else
//						filler = owlFactory.getOWLObjectIntersectionOf(filler, childCE);
//				}
				
				OWLClassExpression childCE = null;
				if(!done.containsKey(cNode)) {
					childCE = toOWLClassExpressionRecursive(cNode, false);					
				}else {
					childCE = toOWLClassExpressionRecursive(cNode, false);
				}
				
				if(filler == null)
					filler = childCE;
				else
					filler = owlFactory.getOWLObjectIntersectionOf(filler, childCE);
			}		
			
			// make the object property using the final filler
			// Notice: this means that the config of the internal element will affect its sub objects
			if(filler == null)
				filler = owlFactory.getOWLThing();
			
			if(!isEntryPoint)
				ce = toOWLClassExpression(hasIE, filler, config);
			else
				ce = filler;
		}
		
		// If the concept object is a system unit class, then it is asking for something which is a system unit class
		// In this case, we ignore the class name and the reference to super class
		// also, we use the attributes, eis and ies of the system unit class specification
		else if (obj instanceof SystemUnitClassType) {			
			
//			SystemUnitClassType suc = (SystemUnitClassType) obj;
			
			//TODO: SUC reference ignored
			//TODO: SRC ignored
			
			// add sub elements as conditions: attributes, EIs, IEs
			for(GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> child : node.getChildren()) {
				GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> cNode = (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) child;
//				if(!cNode.isConverted) {
//				if(!done.contains(cNode)) {
//					if(child.data.getObj() instanceof AttributeType) {
//						OWLClassExpression childCE = toOWLClassExpressionRecursive(cNode, false);
//						if(ce == null)
//							ce = childCE;
//						else
//							ce = owlFactory.getOWLObjectIntersectionOf(ce, childCE);					
//					}
//				}
				OWLClassExpression childCE = null;
				if(!done.containsKey(cNode)) {
					childCE = toOWLClassExpressionRecursive(cNode, false);					
				}else {
					childCE = toOWLClassExpressionRecursive(cNode, false);
				}
				
				if(ce == null)
					ce = childCE;
				else
					ce = owlFactory.getOWLObjectIntersectionOf(ce, childCE);
			}				
		}
		
//		if(!((AMLConceptConfig) node.data.getConfig()).isPrimary()){
//			done.add(node);	
//		}
		
		// avoid recomputation of already handled nodes
//		done.add(node);
		done.put(node, ce);
		
		return ce;
	}
	
	private OWLClassExpression getParentOWLClassExpressionRec (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> node) {
		
		if(node.getParent() == null)
			return null;
		
		GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> parent = (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) node.getParent();
		
		OWLObjectProperty inverseProperty = null;
		if(node.data.getObj() instanceof InternalElementType)
			inverseProperty = owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF);
		else if(node.data.getObj() instanceof ExternalInterfaceType)
			inverseProperty = owlFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.IS_EXTERNAL_INTERFACE_OF);
		else {
			System.err.println("AML2OWLConvert.getParentOWLClassExpressionRec: cannot generate inverse property for the node: " + node);
			return null;
		}
		
		// here, we have cycles since the current node will appear as child of its own parent
		// which causes stack overflow 
		OWLClassExpression filler = toOWLClassExpressionRecursive(parent, true);
		
		if(parent.getParent() != null) {
			filler = owlFactory.getOWLObjectIntersectionOf(filler, getParentOWLClassExpressionRec((GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>) parent.getParent()));
		}
		
		return owlFactory.getOWLObjectSomeValuesFrom(inverseProperty, filler);		
	}
	
	public OWLClassExpression toOWLClassExpression (GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> genericTreeNode) {
		
//		GenericTreeNode<AbstractAMLConceptModel<OWLAMLConceptConfig>> primary = findPrimaryNode(genericTreeNode);
		Set<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>> primaries = GenericAMLConceptModelUtils.getPrimaryObjs(genericTreeNode);
		
		if(primaries.size() != 1)
			return null;
		
		GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> primary = primaries.iterator().next();
		// downwards traversing for the description of the primary node itself
		OWLClassExpression primaryCE = toOWLClassExpressionRecursive(primary, true);		
				
		// upwards traversing for the description of predecessors
		// this is required if the primary node is not the root, i.e. it has predecessors
		if(primary.getParent() != null) {
			OWLClassExpression parentCE = getParentOWLClassExpressionRec(primary);
			primaryCE = owlFactory.getOWLObjectIntersectionOf(primaryCE, parentCE);
		}
		
		return primaryCE;
	}
	
	/**
	 * clean the class expression by 
	 * 	 - removing owl:Thing from intersections
	 * @param ce
	 * @return
	 */
	public OWLClassExpression cleanse (OWLClassExpression ce) {
		ConjunctionMinimizer minimizer = new ConjunctionMinimizer();
		return ce.accept(minimizer).getNNF();
	}

}
