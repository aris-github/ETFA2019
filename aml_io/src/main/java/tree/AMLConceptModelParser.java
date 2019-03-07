package tree;

import java.util.ArrayList;
import java.util.List;

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
import CAEX215.util.AMLHelperFunctions;
import concept.model.AMLConceptAttributes;
import concept.model.AMLConceptModel;

public class AMLConceptModelParser {
	
	public AMLConceptModelParser() {
		// TODO Auto-generated constructor stub
	}

	// parse a single CAEX object with the AML concept attributes
	public AMLConceptModel parse(CAEXObject obj) {	
		
		AMLConceptAttributes config = new AMLConceptAttributes();
		AMLConceptModel acm = new AMLConceptModel();
		List<AttributeType> attrObjs = new ArrayList<AttributeType>();
		
		if(obj instanceof AttributeType) {
			AttributeType attr = (AttributeType) obj;			
			// config (besides from the configuration attributes, each attribute is also a query object)
			if(!attr.getName().equalsIgnoreCase(AMLConceptAttributes.CONFIG)) {
				config = genConfig(attr.getAttribute(), attrObjs);
				// the real handling of value constraints is to be done by the query generator
			}
//			// clear the children of the attribute
//			attr.getAttribute().clear();
		}

		else if(obj instanceof InterfaceClassType && !(obj instanceof InterfaceFamilyType) && !(obj instanceof ExternalInterfaceType)) {			
			InterfaceClassType ic = (InterfaceClassType) obj;			
			config = genConfig(ic.getAttribute(), attrObjs);		
//			// clear the children of the ic
//			ic.getAttribute().clear();
		}
		
//		else if(obj instanceof InterfaceFamilyType) {
//			InterfaceFamilyType ift = (InterfaceFamilyType) obj;			
//			config = genConfig(ift.getAttribute(), attrObjs);	
//			// clear the children of the if
//			ift.getAttribute().clear();
//			ift.getInterfaceClass().clear();
//		}
		
		else if(obj instanceof ExternalInterfaceType) {
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;			
			config = genConfig(ei.getAttribute(), attrObjs);
//			// clear the children of ei
//			ei.getAttribute().clear();
		}
		
		else if(obj instanceof RoleClassType && !(obj instanceof RoleFamilyType)) {
			RoleClassType rc = (RoleClassType) obj;												
			config = genConfig(rc.getAttribute(), attrObjs);			
//			// clear the children of rc
//			rc.getAttribute().clear();
//			rc.getExternalInterface().clear();
		}
		
//		else if(obj instanceof RoleFamilyType) {
//			RoleFamilyType rf = (RoleFamilyType) obj;								
//			// config
//			config = genConfig(rf.getAttribute(), attrObjs);
//			// clear the children of rf
//			rf.getAttribute().clear();
//			rf.getExternalInterface().clear();
//			rf.getRoleClass().clear();
//		} 
		
		else if(obj instanceof InternalElementType) {
			InternalElementType ie = (InternalElementType) obj;
			config = genConfig(ie.getAttribute(), attrObjs);
//			// clear the children of ie: IL and SRC are not CAEX Object children 
//			ie.getAttribute().clear();
//			ie.getExternalInterface().clear();
//			ie.getInternalElement().clear();
		}		
		
		else if(obj instanceof SystemUnitClassType && !(obj instanceof SystemUnitFamilyType)) {
			SystemUnitClassType suc = (SystemUnitClassType) obj;			
			config = genConfig(suc.getAttribute(), attrObjs);
//			// clear the children of suc: IL and SRC are not CAEX Object children 
//			suc.getAttribute().clear();
//			suc.getExternalInterface().clear();
//			suc.getInternalElement().clear();			
		}
		
//		else if(obj instanceof SystemUnitFamilyType) {
//			SystemUnitFamilyType suf = (SystemUnitFamilyType) obj;			
//			config = genConfig(suf.getAttribute(), attrObjs);
//			// clear the children of suf: IL and SRC are not CAEX Object children 
//			suf.getAttribute().clear();
//			suf.getExternalInterface().clear();
//			suf.getInternalElement().clear();
//			suf.getSystemUnitClass().clear();
//		}
		
		else {
			System.err.println("AMLConceptModelParser.parse: the given caex object is of type [" + obj.getClass() + "], which is not supported by AML concept models!");
			return null;
		}
				
		if(config.getMaxCardinality() < config.getMinCardinality() && config.getMaxCardinality() != -1) {
			System.err.println("maximum cardinliaty (" + config.getMaxCardinality() + ") smaller than the minimum cardinality (" + config.getMinCardinality() + ")");
			System.err.println(" - changing cardinilities to -1 (unbounded)");
			config.setMaxCardinality(-1);
			config.setMinCardinality(1);	
		}
		
		if(config.getMaxCardinality() < -1) {
			System.err.println("maximum cardinliaty (" + config.getMaxCardinality() + ") <-1");
			System.err.println(" - same as -1, set it to -1");
			config.setMaxCardinality(-1);
//			cardinalityError = true;
		}
		
		if(config.getMinCardinality() < -1) {
			System.err.println("minimum cardinliaty (" + config.getMinCardinality() + ") <0");
			System.err.println("same as 0, set it to 0");
			config.setMinCardinality(0);
		}
				
		acm.setObj(obj);
		acm.setConfig(config);

		return acm;
	}
	
	private AMLConceptAttributes genConfig(List<AttributeType> attributes, List<AttributeType> attrObjs) {
		AMLConceptAttributes config = new AMLConceptAttributes();
		
		for(int i = 0; i < attributes.size(); i++) {
			AttributeType attr = attributes.get(i);
			if(attr.getName().equalsIgnoreCase(AMLConceptAttributes.CONFIG)) {
				for(AttributeType child : attr.getAttribute()) {
					if(child.getName().equalsIgnoreCase(AMLConceptAttributes.CONFIG_PRIMARY)) {
						Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
						if(b!=null)
							config.setPrimary(b.booleanValue());				
					}
					else if(child.getName().equalsIgnoreCase(AMLConceptAttributes.CONFIG_NEGATED)) {
						Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
						if(b!=null)
							config.setNegated(b.booleanValue());				
					}
					else if(child.getName().equalsIgnoreCase(AMLConceptAttributes.CONFIG_ID)) {
						Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
						if(b!=null)
							config.setIdentifiedById(b.booleanValue());				
					}
					else if(child.getName().equalsIgnoreCase(AMLConceptAttributes.CONFIG_NAME)) {
						Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
						if(b!=null)
							config.setIdentifiedByName(b.booleanValue());				
					}
					else if(child.getName().equalsIgnoreCase(AMLConceptAttributes.CONFIG_MAX)) {
						Integer b = AMLHelperFunctions.getAMLAttributeValueInteger(child);
						if(b != null)
							config.setMaxCardinality(b.intValue());
					}
					else if(child.getName().equalsIgnoreCase(AMLConceptAttributes.CONFIG_MIN)) {
						Integer b = AMLHelperFunctions.getAMLAttributeValueInteger(child);
						if(b != null)
							config.setMinCardinality(b.intValue());
					}
					else
						System.err.println("unknown query config parameter [" + child.getName() + "]!");
				}
			}			
			else{
				attrObjs.add(attr);
			}
		}		
		return config;
	}
}
