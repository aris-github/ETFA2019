/**
 * 
 */
package concept.util;

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
import CAEX215.InterfaceFamilyType;
import CAEX215.InternalElementType;
import CAEX215.RoleClassType;
import CAEX215.RoleFamilyType;
import CAEX215.SystemUnitClassType;
import CAEX215.SystemUnitFamilyType;
import concept.model.AMLConceptConfig;
import concept.model.AMLQueryConfig;
import concept.model.BasicAMLConceptConfig;
import concept.model.GenericAMLConceptModel;
import concept.model.IAMLConceptConfig;
import concept.tree.GenericTree;
import concept.tree.GenericTreeNode;

/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 *
 */
public class GenericAMLConceptModelUtils{
			
	/**
	 * serialize the tree to a caex object that has the config parameters as its attributes explicitly
	 * also traverse the tree to handle all child objects
	 * @param <T>
	 * @return the caex object representing the AMLQuery model
	 */
	public static <T extends IAMLConceptConfig> CAEXObject toConfiguredCAEXObject (GenericTree<GenericAMLConceptModel<T>> tree) {
		
		GenericAMLConceptModel<T> acm = tree.getRoot().data;	
		
		CAEXObject obj = acm.toConfiguredCAEXObject();
		
		if (obj instanceof AttributeType) {
			
			AttributeType attr = (AttributeType) obj;
			
			// handle child attributes
			for(GenericTreeNode<GenericAMLConceptModel<T>> child : tree.getRoot().getChildren()) {
				GenericTree<GenericAMLConceptModel<T>> childTree = new GenericTree<GenericAMLConceptModel<T>>(child); 				
				if(childTree.getRoot().data.getObj() instanceof AttributeType)
					attr.getAttribute().add((AttributeType) toConfiguredCAEXObject(childTree));
			}
			
			return attr;
		}
		
		else if (obj instanceof ExternalInterfaceType) {
			
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;
			
			// handle child attributes
			for(GenericTreeNode<GenericAMLConceptModel<T>> child : tree.getRoot().getChildren()) {
				GenericTree<GenericAMLConceptModel<T>> childTree = new GenericTree<GenericAMLConceptModel<T>>(child); 				
				if(childTree.getRoot().data.getObj() instanceof AttributeType)
					ei.getAttribute().add((AttributeType) toConfiguredCAEXObject(childTree));
			}
			
			return ei;
		}
				
		else if(obj instanceof InterfaceClassType) {
			
			InterfaceClassType ic = (InterfaceClassType) obj;
			
			// handle child attributes
			for(GenericTreeNode<GenericAMLConceptModel<T>> child : tree.getRoot().getChildren()) {
				GenericTree<GenericAMLConceptModel<T>> childTree = new GenericTree<GenericAMLConceptModel<T>>(child); 				
				if(childTree.getRoot().data.getObj() instanceof AttributeType)
					ic.getAttribute().add((AttributeType) toConfiguredCAEXObject(childTree));
			}
			
			return ic;
		}
		
		else if (obj instanceof RoleClassType) {
			
			RoleClassType rc = (RoleClassType) obj;
			
			// handle child attributes and interfaces
			for(GenericTreeNode<GenericAMLConceptModel<T>> child : tree.getRoot().getChildren()) {
				GenericTree<GenericAMLConceptModel<T>> childTree = new GenericTree<GenericAMLConceptModel<T>>(child); 				
				if(childTree.getRoot().data.getObj() instanceof AttributeType)
					rc.getAttribute().add((AttributeType) toConfiguredCAEXObject(childTree));
				if(childTree.getRoot().data.getObj() instanceof ExternalInterfaceType)
					rc.getExternalInterface().add((ExternalInterfaceType) toConfiguredCAEXObject(childTree));				
			}
			
			return rc;
		}
		
		else if (obj instanceof InternalElementType) {
			
			InternalElementType ie = (InternalElementType) obj;
			
			// handle child attributes and interfaces
			for(GenericTreeNode<GenericAMLConceptModel<T>> child : tree.getRoot().getChildren()) {
				GenericTree<GenericAMLConceptModel<T>> childTree = new GenericTree<GenericAMLConceptModel<T>>(child); 				
				if(childTree.getRoot().data.getObj() instanceof AttributeType)
					ie.getAttribute().add((AttributeType) toConfiguredCAEXObject(childTree));
				if(childTree.getRoot().data.getObj() instanceof ExternalInterfaceType)
					ie.getExternalInterface().add((ExternalInterfaceType) toConfiguredCAEXObject(childTree));
				if(childTree.getRoot().data.getObj() instanceof InternalElementType)
					ie.getInternalElement().add((InternalElementType) toConfiguredCAEXObject(childTree));
			}
			
			return ie;
		}
		
		else if (obj instanceof SystemUnitClassType) {
			
			SystemUnitClassType suc = (SystemUnitClassType) obj;
			
			// handle child attributes and interfaces
			for(GenericTreeNode<GenericAMLConceptModel<T>> child : tree.getRoot().getChildren()) {
				GenericTree<GenericAMLConceptModel<T>> childTree = new GenericTree<GenericAMLConceptModel<T>>(child); 				
				if(childTree.getRoot().data.getObj() instanceof AttributeType)
					suc.getAttribute().add((AttributeType) toConfiguredCAEXObject(childTree));
				if(childTree.getRoot().data.getObj() instanceof ExternalInterfaceType)
					suc.getExternalInterface().add((ExternalInterfaceType) toConfiguredCAEXObject(childTree));
				if(childTree.getRoot().data.getObj() instanceof InternalElementType)
					suc.getInternalElement().add((InternalElementType) toConfiguredCAEXObject(childTree));
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
	 * @param <T>
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T extends IAMLConceptConfig> void fuse (GenericTreeNode<GenericAMLConceptModel<T>> node) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {				
		
		// use set to ensure uniqueness of nodes
		// this set contains one object from a pair, which shall be removed later
		Set<GenericTreeNode<GenericAMLConceptModel<T>>> toRemove = new HashSet<GenericTreeNode<GenericAMLConceptModel<T>>>();
		
		// go through the children 
		for(GenericTreeNode<GenericAMLConceptModel<T>> child : node.getChildren()) {
			
			// if the child is already in the remove list, avoid removing its counter part
			if(toRemove.contains(child)) {
				continue;
			}
			CAEXObject cObj = child.data.getObj();
//			// get the object without the config attribute: two objects are a pair if they have same CAEX structure except the config attribute
			CAEXObject cObjNoConig = removeConfig(cObj);
			
			// compare the child with other children
			for(GenericTreeNode<GenericAMLConceptModel<T>> other : node.getChildren()) {
				
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
							for(GenericTreeNode<GenericAMLConceptModel<T>> grandChildOther : other.getChildren()) {
								// change the parent of the grand child other to child
								child.addChild(grandChildOther);								
								// check recursively if further fusion is required
								fuse(child);
							}	
						}						
						
						// fuse cardinalities
						if(child.data.getConfig().canBeFusedWith(other.data.getConfig())) {
							if(child.data.getConfig() instanceof BasicAMLConceptConfig && other.data.getConfig() instanceof BasicAMLConceptConfig) {
								int cMin = ((BasicAMLConceptConfig) child.data.getConfig()).getMinCardinality();
								int cMax = ((BasicAMLConceptConfig) child.data.getConfig()).getMaxCardinality();
								int oMin = ((BasicAMLConceptConfig) other.data.getConfig()).getMinCardinality();
								int oMax = ((BasicAMLConceptConfig) other.data.getConfig()).getMaxCardinality();
								if(oMin != 1 && cMin == 1)
									((BasicAMLConceptConfig) child.data.getConfig()).setMinCardinality(oMin);
								if(oMax != -1 && cMax == -1)
									((BasicAMLConceptConfig) child.data.getConfig()).setMaxCardinality(oMax);	
								
								if( ((BasicAMLConceptConfig) child.data.getConfig()).isPrimary() || ((BasicAMLConceptConfig) other.data.getConfig()).isPrimary() )
									((BasicAMLConceptConfig) child.data.getConfig()).setPrimary(true);
							}							
						}												
																															
					}													
				}				
			}			
		}
		
		// remove all nodes in the toRemove list. Their counterparts contain the fused cardinality now
		for(GenericTreeNode<GenericAMLConceptModel<T>> rNode : toRemove) {
			rNode.getParent().removeChild(rNode);
		}
		
		for(GenericTreeNode<GenericAMLConceptModel<T>> child : node.getChildren()) {
			fuse(child);
		}
	}
	
	public static <T extends IAMLConceptConfig> Set<GenericTreeNode<GenericAMLConceptModel<T>>> getPrimaryObjs (GenericTreeNode<GenericAMLConceptModel<T>> root) {
		
		Set<GenericTreeNode<GenericAMLConceptModel<T>>> primaries = new HashSet<GenericTreeNode<GenericAMLConceptModel<T>>>();
		for(GenericTreeNode<GenericAMLConceptModel<T>> node : root.getDescendantOrSelf()) {
			if(node.data.getConfig() instanceof BasicAMLConceptConfig) {
				if(((BasicAMLConceptConfig) node.data.getConfig()).isPrimary())
					primaries.add(node);
			}				
		}
		
		return primaries;
	}

		
	public static <T extends IAMLConceptConfig> Set<GenericTreeNode<GenericAMLConceptModel<T>>> getPrimaryObjs (GenericTree<GenericAMLConceptModel<T>> tree) {
		
		return getPrimaryObjs(tree.getRoot());
	}
	
	public static boolean isAMLConceptModel(Object obj) {
		
		boolean is = false;
		if(obj instanceof AttributeType){			
			for(AttributeType attr : ((AttributeType) obj).getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					is = true;
			}						
		}
		
		else if(obj instanceof ExternalInterfaceType) {
			for(AttributeType attr : ((ExternalInterfaceType) obj).getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					is = true;
			}
		}
		
		else if(obj instanceof RoleClassType) {
			for(AttributeType attr : ((RoleClassType) obj).getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					is = true;
			}
		}
		
		else if(obj instanceof InterfaceClassType) {
			for(AttributeType attr : ((InterfaceClassType) obj).getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					is = true;
			}
		}
		
		else if(obj instanceof SystemUnitClassType) {
			for(AttributeType attr : ((SystemUnitClassType) obj).getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					is = true;
			}
		}
		
		else if(obj instanceof InternalElementType) {
			for(AttributeType attr : ((InternalElementType) obj).getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					is = true;
			}
		}
		
		return is;
	}
	
	public static <T extends IAMLConceptConfig> GenericTreeNode<GenericAMLConceptModel<T>> parse (CAEXObject obj, Class<T> type) throws InstantiationException, IllegalAccessException{
	
		GenericTreeNode<GenericAMLConceptModel<T>> root = new GenericTreeNode<GenericAMLConceptModel<T>>();
		root.data = new GenericAMLConceptModel<T>(type);				
		
		// Note: this will only be called if the root is not "queryConfig"!
		if(obj instanceof AttributeType) {
			AttributeType attr = (AttributeType) obj;
			if(!attr.getName().equals(IAMLConceptConfig.CONFIG)) {
				root.data.fromConfiguredCAEXObj(obj);
				for(AttributeType sub : attr.getAttribute()) {					
					if(!sub.getName().equals(IAMLConceptConfig.CONFIG)) {					
						root.addChild(parse(sub, type));
					}
				}	
				
				// clear the children of the attribute
//				if(type == AMLConceptConfig.class) {					
//					attr.getAttribute().clear();
//				}
			}
			else {
				System.err.println("AMLConceptModelTreeParser.parse: the given caex object for parsing is a top level AML concept attribute!");
			}	
		}

		else if(obj instanceof InterfaceClassType && !(obj instanceof InterfaceFamilyType) && !(obj instanceof ExternalInterfaceType)) {			
			InterfaceClassType ic = (InterfaceClassType) obj;
			root.data.fromConfiguredCAEXObj(obj);
			for(AttributeType attr : ic.getAttribute()) {
				if(!attr.getName().equals(IAMLConceptConfig.CONFIG)) {
					root.addChild(parse(attr, type));
				}
			}			
			// clear the children of the ic
//			if(type == AMLConceptConfig.class) {
//				ic.getAttribute().clear();
//			}
		}
		
		else if(obj instanceof ExternalInterfaceType) {
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;
			root.data.fromConfiguredCAEXObj(obj);
			for(AttributeType attr : ei.getAttribute()) {
				if(!attr.getName().equals(IAMLConceptConfig.CONFIG)) {
					root.addChild(parse(attr, type));
				}
			}
			
			// add the link constraints to the AMLQuery model
			if(type == AMLQueryConfig.class) {
				((AMLQueryConfig) root.data.getConfig()).setLinkConstraints(AMLLinkCollector.getPartnersOfEI(ei));
			}
				
			// clear the children of ei
//			if(type == AMLConceptConfig.class) {
//				ei.getAttribute().clear();
//			}
		}
		
		else if(obj instanceof RoleClassType && !(obj instanceof RoleFamilyType)) {
			RoleClassType rc = (RoleClassType) obj;		
			root.data.fromConfiguredCAEXObj(obj);
			for(AttributeType attr : rc.getAttribute()) {
				if(!attr.getName().equals(IAMLConceptConfig.CONFIG)) {
					root.addChild(parse(attr, type));
				}
			}
			
			for(ExternalInterfaceType ei : rc.getExternalInterface()) {
				root.addChild(parse(ei, type));
			}
			// clear the children of rc
//			if(type == AMLConceptConfig.class) {
//				rc.getAttribute().clear();
//				rc.getExternalInterface().clear();
//			}
		}
		
		else if(obj instanceof InternalElementType) {
			InternalElementType ie = (InternalElementType) obj;
			root.data.fromConfiguredCAEXObj(obj);
			for(AttributeType attr : ie.getAttribute()) {
				if(!attr.getName().equals(IAMLConceptConfig.CONFIG)) {
					root.addChild(parse(attr, type));
				}
			}
			
			for(ExternalInterfaceType ei : ie.getExternalInterface()) {
				root.addChild(parse(ei, type));
			}
			
			for(InternalElementType sub : ie.getInternalElement()) {
				root.addChild(parse(sub, type));
			}
			// clear the children of ie: IL and SRC are not CAEX Object children
//			if(type == AMLConceptConfig.class) {
//				ie.getAttribute().clear();
//				ie.getExternalInterface().clear();
//				ie.getInternalElement().clear();
//			}
		}		
		
		else if(obj instanceof SystemUnitClassType && !(obj instanceof SystemUnitFamilyType)) {
			SystemUnitClassType suc = (SystemUnitClassType) obj;
			root.data.fromConfiguredCAEXObj(obj);
			for(AttributeType attr : suc.getAttribute()) {
				if(!attr.getName().equals(IAMLConceptConfig.CONFIG)) {
					root.addChild(parse(attr, type));
				}
			}
			
			for(ExternalInterfaceType ei : suc.getExternalInterface()) {
				root.addChild(parse(ei, type));
			}
			
			for(InternalElementType ie : suc.getInternalElement()) {
				root.addChild(parse(ie, type));
			}
			
			// clear the children of suc: IL and SRC are not CAEX Object children
//			if(type == AMLConceptConfig.class) {
//				suc.getAttribute().clear();
//				suc.getExternalInterface().clear();
//				suc.getInternalElement().clear();
//			}
		}
	
		else {
			System.err.println("AMLConceptModelParser.parse: the given caex object is of type [" + obj.getClass() + "], which is not supported by AML concept models!");
			return null;
		}
		
		return root;
	}
}
