/**
 * 
 */
package tree;

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
import concept.model.BasicAMLConceptAttributes;
import concept.model.AMLConceptModel;
import concept.tree.GenericTreeNode;


/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 * This class is the parser of an AML concept model, which is modeled as a normal CAEX object with AML concept attributes 
 */
public class AMLConceptModelTreeParser {	

	private AMLConceptModelParser parser;
	
	public AMLConceptModelTreeParser() {
		parser = new AMLConceptModelParser();
	}


	/**
	 * parse a caex object with AML concept attributes to an AML concept model tree
	 * the child objects of the input is traversed to produce the tree in a depth-first manner
	 * @param obj
	 * @return
	 */
	public GenericTreeNode<AMLConceptModel> parse(CAEXObject obj) {	
		
		GenericTreeNode<AMLConceptModel> root = new GenericTreeNode<AMLConceptModel>();
		
		// Note: this will only be called if the root is not "queryConfig"!
		if(obj instanceof AttributeType) {
			
			AttributeType attr = (AttributeType) obj;
			
			if(!attr.getName().equals(BasicAMLConceptAttributes.CONFIG)) {
				root.data = parser.parse(obj);
				
				for(AttributeType sub : attr.getAttribute()) {					
					if(!sub.getName().equals(BasicAMLConceptAttributes.CONFIG)) {
						GenericTreeNode<AMLConceptModel> child = parse(sub);
						if(child != null)
							root.addChild(child);
					}
				}
				
				// clear the children of the attribute
				attr.getAttribute().clear();
			}
			else {
				System.err.println("AMLConceptModelTreeParser.parse: the given caex object for parsing is a top level AML concept attribute!");
				return null;
			}				
		}

		else if(obj instanceof InterfaceClassType && !(obj instanceof InterfaceFamilyType) && !(obj instanceof ExternalInterfaceType)) {			
			InterfaceClassType ic = (InterfaceClassType) obj;			
			root.data = parser.parse(ic);
			
			for(AttributeType attr : ic.getAttribute()) {
				if(!attr.getName().equals(BasicAMLConceptAttributes.CONFIG)) {
					GenericTreeNode<AMLConceptModel> child = parse(attr);
					if(child != null)
						root.addChild(child);
				}
			}
			
			// clear the children of the ic
			ic.getAttribute().clear();
		}
		
		else if(obj instanceof ExternalInterfaceType) {
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;
			root.data = parser.parse(ei);
			
			for(AttributeType attr : ei.getAttribute()) {
				if(!attr.getName().equals(BasicAMLConceptAttributes.CONFIG)) {
					GenericTreeNode<AMLConceptModel> child = parse(attr);
					if(child != null)
						root.addChild(child);
				}
			}
			// clear the children of ei
			ei.getAttribute().clear();
		}
		
		else if(obj instanceof RoleClassType && !(obj instanceof RoleFamilyType)) {
			RoleClassType rc = (RoleClassType) obj;
			root.data = parser.parse(rc);
			
			for(AttributeType attr : rc.getAttribute()) {
				if(!attr.getName().equals(BasicAMLConceptAttributes.CONFIG)) {
					GenericTreeNode<AMLConceptModel> child = parse(attr);
					if(child != null)
						root.addChild(child);
				}
			}
			
			for(ExternalInterfaceType ei : rc.getExternalInterface()) {
				root.addChild(parse(ei));
			}
			// clear the children of rc
			rc.getAttribute().clear();
			rc.getExternalInterface().clear();
		}
		
		else if(obj instanceof InternalElementType) {
			InternalElementType ie = (InternalElementType) obj;
			root.data = parser.parse(ie);

			for(AttributeType attr : ie.getAttribute()) {
				if(!attr.getName().equals(BasicAMLConceptAttributes.CONFIG)) {
					GenericTreeNode<AMLConceptModel> child = parse(attr);
					if(child != null)
						root.addChild(child);
				}
			}
			
			for(ExternalInterfaceType ei : ie.getExternalInterface()) {
				root.addChild(parse(ei));
			}
			
			for(InternalElementType sub : ie.getInternalElement()) {
				root.addChild(parse(sub));
			}
			// clear the children of ie: IL and SRC are not CAEX Object children 
			ie.getAttribute().clear();
			ie.getExternalInterface().clear();
			ie.getInternalElement().clear();
		}		
		
		else if(obj instanceof SystemUnitClassType && !(obj instanceof SystemUnitFamilyType)) {
			SystemUnitClassType suc = (SystemUnitClassType) obj;
			root.data = parser.parse(suc);

			for(AttributeType attr : suc.getAttribute()) {
				if(!attr.getName().equals(BasicAMLConceptAttributes.CONFIG)) {
					GenericTreeNode<AMLConceptModel> child = parse(attr);
					if(child != null)
						root.addChild(child);
				}
			}
			
			for(ExternalInterfaceType ei : suc.getExternalInterface()) {
				root.addChild(parse(ei));
			}
			
			for(InternalElementType sub : suc.getInternalElement()) {
				root.addChild(parse(sub));
			}
			
			// clear the children of suc: IL and SRC are not CAEX Object children 
			suc.getAttribute().clear();
			suc.getExternalInterface().clear();
			suc.getInternalElement().clear();	
		}
	
		else {
			System.err.println("AMLConceptModelParser.parse: the given caex object is of type [" + obj.getClass() + "], which is not supported by AML concept models!");
			return null;
		}
		
		return root;
	}
}
