/**
 * 
 */
package tree;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;

//import AML2XQuery.TransitiveClosure;
import CAEX215.AttributeType;
import CAEX215.CAEXObject;
import CAEX215.ExternalInterfaceType;
import CAEX215.InterfaceClassType;
import CAEX215.InternalElementType;
import CAEX215.RoleClassType;
import CAEX215.SystemUnitClassType;
import concept.model.AMLConceptModel;
import concept.tree.GenericTree;
import concept.tree.GenericTreeNode;

/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 *
 */
public class AMLConceptModelTree extends GenericTree<AMLConceptModel>{
	
	public AMLConceptModelTree (GenericTreeNode<AMLConceptModel> root) {
		this.root = root;
	}
	
	public AMLConceptModelTree (AMLConceptModel acm) {
		this.root.data = acm;
	}
		
	/**
	 * copy constructor
	 */
	public AMLConceptModelTree(AMLConceptModelTree other) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		super(other);
	}	
	
	/**
	 * serialize the tree to a caex object that has the config parameters as its attributes explicitly
	 * also traverse the tree to handle all child objects
	 * @return the caex object representing the AMLQuery model
	 */
	public CAEXObject toCAEXObject () {
		
		AMLConceptModel acm = this.root.data;	
		
		CAEXObject obj = acm.toCAEXObject();
		
		if (obj instanceof AttributeType) {
			
			AttributeType attr = (AttributeType) obj;
			
			// handle child attributes
			for(GenericTreeNode<AMLConceptModel> child : this.root.getChildren()) {
				AMLConceptModelTree childTree = new AMLConceptModelTree(child); 
				CAEXObject childObj = child.data.toCAEXObject();				
				if(childObj instanceof AttributeType)
					attr.getAttribute().add((AttributeType) childTree.toCAEXObject());
			}
			
			return attr;
		}
		
		else if (obj instanceof ExternalInterfaceType) {
			
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;
			
			// handle child attributes
			for(GenericTreeNode<AMLConceptModel> child : this.root.getChildren()) {
				AMLConceptModelTree childTree = new AMLConceptModelTree(child); 
				CAEXObject childObj = child.data.toCAEXObject();				
				if(childObj instanceof AttributeType)
					ei.getAttribute().add((AttributeType) childTree.toCAEXObject());
			}
			
			return ei;
		}
				
		else if(obj instanceof InterfaceClassType) {
			
			InterfaceClassType ic = (InterfaceClassType) obj;
			
			// handle child attributes
			for(GenericTreeNode<AMLConceptModel> child : this.root.getChildren()) {
				AMLConceptModelTree childTree = new AMLConceptModelTree(child); 
				CAEXObject childObj = child.data.toCAEXObject();				
				if(childObj instanceof AttributeType)
					ic.getAttribute().add((AttributeType) childTree.toCAEXObject());
			}
			
			return ic;
		}
		
		else if (obj instanceof RoleClassType) {
			
			RoleClassType rc = (RoleClassType) obj;
			
			// handle child attributes and interfaces
			for(GenericTreeNode<AMLConceptModel> child : this.root.getChildren()) {
				AMLConceptModelTree childTree = new AMLConceptModelTree(child); 
				CAEXObject childObj = child.data.toCAEXObject();				
				if(childObj instanceof AttributeType)
					rc.getAttribute().add((AttributeType) childTree.toCAEXObject());
				if(childObj instanceof ExternalInterfaceType)
					rc.getExternalInterface().add((ExternalInterfaceType) childTree.toCAEXObject());
			}
			
			return rc;
		}
		
		else if (obj instanceof InternalElementType) {
			
			InternalElementType ie = (InternalElementType) obj;
			
			// handle child attributes and interfaces
			for(GenericTreeNode<AMLConceptModel> child : this.root.getChildren()) {
				AMLConceptModelTree childTree = new AMLConceptModelTree(child); 
				CAEXObject childObj = child.data.toCAEXObject();				
				if(childObj instanceof AttributeType)
					ie.getAttribute().add((AttributeType) childTree.toCAEXObject());
				if(childObj instanceof ExternalInterfaceType)
					ie.getExternalInterface().add((ExternalInterfaceType) childTree.toCAEXObject());
				if(childObj instanceof InternalElementType)
					ie.getInternalElement().add((InternalElementType) childTree.toCAEXObject());
			}
			
			return ie;
		}
		
		else if (obj instanceof SystemUnitClassType) {
			
			SystemUnitClassType suc = (SystemUnitClassType) obj;
			
			// handle child attributes and interfaces
			for(GenericTreeNode<AMLConceptModel> child : this.root.getChildren()) {
				AMLConceptModelTree childTree = new AMLConceptModelTree(child); 
				CAEXObject childObj = child.data.toCAEXObject();				
				if(childObj instanceof AttributeType)
					suc.getAttribute().add((AttributeType) childTree.toCAEXObject());
				if(childObj instanceof ExternalInterfaceType)
					suc.getExternalInterface().add((ExternalInterfaceType) childTree.toCAEXObject());
				if(childObj instanceof InternalElementType)
					suc.getInternalElement().add((InternalElementType) childTree.toCAEXObject());
			}
			
			return suc;
		}			
		
		else
			return null;		
	}
	
	
	
	private static CAEXObject removeConfig (CAEXObject obj) {
		if(obj instanceof AttributeType) {
			AttributeType attr = (AttributeType) obj;			
			ListIterator<AttributeType> iter = attr.getAttribute().listIterator();
			while(iter.hasNext()) {
				if(iter.next().getName().equalsIgnoreCase("queryConfig")) {
					iter.remove();
				}
			}	
			return attr;
		}
		
		else if(obj instanceof InterfaceClassType) {
			InterfaceClassType ic = (InterfaceClassType) obj;
			ListIterator<AttributeType> iter = ic.getAttribute().listIterator();
			while(iter.hasNext()) {
				if(iter.next().getName().equalsIgnoreCase("queryConfig")) {
					iter.remove();
				}
			}
			return ic;
		}
		
		else if(obj instanceof RoleClassType) {
			RoleClassType rc = (RoleClassType) obj;
			ListIterator<AttributeType> iter = rc.getAttribute().listIterator();
			while(iter.hasNext()) {
				if(iter.next().getName().equalsIgnoreCase("queryConfig")) {
					iter.remove();
				}
			}
			return rc;
		}
		
		else if(obj instanceof SystemUnitClassType) {
			SystemUnitClassType suc = (SystemUnitClassType) obj;
			ListIterator<AttributeType> iter = suc.getAttribute().listIterator();
			while(iter.hasNext()) {
				if(iter.next().getName().equalsIgnoreCase("queryConfig")) {
					iter.remove();
				}
			}
			return suc;
		}
		
		else if(obj instanceof ExternalInterfaceType) {
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;
			ListIterator<AttributeType> iter = ei.getAttribute().listIterator();
			while(iter.hasNext()) {
				if(iter.next().getName().equalsIgnoreCase("queryConfig")) {
					iter.remove();
				}
			}
			return ei;
		}
		
		else if(obj instanceof InternalElementType) {
			InternalElementType ie = (InternalElementType) obj;
			ListIterator<AttributeType> iter = ie.getAttribute().listIterator();
			while(iter.hasNext()) {
				if(iter.next().getName().equalsIgnoreCase("queryConfig")) {
					iter.remove();
				}
			}
			return ie;
		}
		
		else {
			System.err.println("AMLConceptTree.removeConfig: the given caex object shall not contain any config: " + obj);
			return obj;
		}				
	}
	
	/**
	 * While being translated from OWL, cardinalities and nested attributes are distributed over a pair objects, 
	 *  - for cardinality: one holding the min, the other one holding the max, since OWL cardinality restriction is stated in two different expressions
	 *  - for nested attributes: each data property holds the path from the root attribute to one leaf, e.g.
	 *  		- the attribute frame.(x, y) will become two data properties has_frame_x and has_frame_y, which need to be fused to one CAEX attribute
	 * This function fuses such pairs by looking at the children of each object, and combine the restrictions of a pair into one single object
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void fuse (GenericTreeNode<AMLConceptModel> node) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {				
		
		// use set to ensure uniqueness of nodes
		// this set contains one object from a pair, which shall be removed later
		Set<GenericTreeNode<AMLConceptModel>> toRemove = new HashSet<GenericTreeNode<AMLConceptModel>>();
		
		// go through the children 
		for(GenericTreeNode<AMLConceptModel> child : node.getChildren()) {
			
			// if the child is already in the remove list, avoid removing its counter part
			if(toRemove.contains(child)) {
				continue;
			}
			CAEXObject cObj = child.data.getObj();
			// get the object without the config attribute: two objects are a pair if they have same CAEX structure except the config attribute
			CAEXObject cObjNoConig = removeConfig(cObj);
			
			// compare the child with other children
			for(GenericTreeNode<AMLConceptModel> other : node.getChildren()) {
				
				// if the child is already in the remove list, avoid removing its counter part
				if(toRemove.contains(other)) {
					continue;
				}
				
				// get rid of the same object
				if(!other.equals(child)) {
					CAEXObject oObj = other.data.getObj();
					CAEXObject oObjNoConfig = removeConfig(oObj);
					
					// check if both nodes have the same CAEX object
					if(EcoreUtil.equals(cObjNoConig, oObjNoConfig)) {											
						// delete one
						toRemove.add(other);				
						
						// if both configs are the same: fuse them
						if(child.data.getConfig().equals(other.data.getConfig())) {
							for(GenericTreeNode<AMLConceptModel> grandChildOther : other.getChildren()) {
								// change the parent of the grand child other to child
								child.addChild(grandChildOther);								
								// check recursively if further fusion is required
								fuse(child);
							}	
						}						
						
						// fuse cardinalities
						if(child.data.getConfig().equalsWithoutCardinality(other.data.getConfig())) {
							int cMin = child.data.getConfig().getMinCardinality();
							int cMax = child.data.getConfig().getMaxCardinality();
							int oMin = other.data.getConfig().getMinCardinality();
							int oMax = other.data.getConfig().getMaxCardinality();
							if(oMin != 1 && cMin == 1)
								child.data.getConfig().setMinCardinality(oMin);
							if(oMax != -1 && cMax == -1)
								child.data.getConfig().setMaxCardinality(oMax);
						}												
																															
					}													
				}				
			}			
		}
		
		// remove all nodes in the toRemove list. Their counterparts contain the fused cardinality now
		for(GenericTreeNode<AMLConceptModel> rNode : toRemove) {
			rNode.getParent().removeChild(rNode);
		}
		
		for(GenericTreeNode<AMLConceptModel> child : node.getChildren()) {
			fuse(child);
		}
	}

		
	public Set<GenericTreeNode<AMLConceptModel>> getPrimaryObjs () {
		
		Set<GenericTreeNode<AMLConceptModel>> primaries = new HashSet<GenericTreeNode<AMLConceptModel>>();
		for(GenericTreeNode<AMLConceptModel> node : this.root.getDescendantOrSelf()) {
			if(node.data.getConfig().isPrimary())
				primaries.add(node);
		}
		
		return primaries;
	}
	
}
