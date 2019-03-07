/**
 * 
 */
package concept.model;

import org.eclipse.emf.ecore.xml.type.AnyType;

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

/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 * This class represents the AML Concept Model that encapsulate a CAEXObject with its concept attributes
 * The underlying caex object can only be: Attr, IC, RC, SUC, IE, EI
 */

public class AMLConceptModel{
	
	private CAEXObject caexObj;
	
	private AMLConceptAttributes config;
	
	public AMLConceptModel() {
		// TODO Auto-generated constructor stub
	}
	
	public AMLConceptModel(CAEXObject obj, AMLConceptAttributes config) {
		setObj(obj);
		setConfig(config);
	}
	
	
	/**
	 * @return the obj
	 */
	public CAEXObject getObj() {
		return caexObj;
	}
	/**
	 * @param obj the obj to set
	 */
	public void setObj(CAEXObject obj) {
		this.caexObj = obj;
	}
	
	
	/**
	 * @return the config
	 */
	public AMLConceptAttributes getConfig() {
		return config;
	}
	/**
	 * @param config the config to set
	 */
	public void setConfig(AMLConceptAttributes config) {
		this.config = config;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof AMLConceptModel))
	        return false;
	    if (obj == this)
	        return true;
	    return this.config.equals( ((AMLConceptModel) obj).config)
	    		&& this.caexObj.equals( ((AMLConceptModel) obj).caexObj);
	}
	
	public String toString() {
		String s = "";
				
		if(this.caexObj instanceof InternalElementType) {
			s += "IE [" + this.config.getMinCardinality() + ", " + this.config.getMaxCardinality() + "]: ";
			InternalElementType ie = (InternalElementType) caexObj;
			if(ie.getName() != null && config.identifiedByName)
				s += ie.getName() + ", ";
			if(ie.getID() != null && config.identifiedById)
				s += ie.getID() + ", ";						
			if(ie.getRoleRequirements() != null) {
				String path = ie.getRoleRequirements().getRefBaseRoleClassPath();
				String role = path.substring(path.lastIndexOf("/")+1);
				s += role + ", ";
			}				
		}
			
		else if(this.caexObj instanceof ExternalInterfaceType) {
			s += "EI [" + this.config.getMinCardinality() + ", " + this.config.getMaxCardinality() + "]: ";
			ExternalInterfaceType ei = (ExternalInterfaceType) caexObj;
			if(ei.getName() != null && config.identifiedByName)
				s += ei.getName() + ", ";
			if(ei.getID() != null && config.identifiedById)
				s += ei.getID() + ", ";						
			if(ei.getRefBaseClassPath() != null) {
				String path = ei.getRefBaseClassPath();
				String ic = path.substring(path.lastIndexOf("/")+1);
				s += ic + ", ";
			}
		}
		
		else if(this.caexObj instanceof AttributeType) {
			s += "Attribute [" + this.config.getMinCardinality() + ", " + this.config.getMaxCardinality() + "]: ";
			AttributeType attr = (AttributeType) caexObj;
			if(attr.getName() != null)
				s += attr.getName() + ", ";	
			
			if(attr.getValue() != null)
				s += AMLHelperFunctions.fromAMLAnyType(attr.getValue()) + ", ";
			
			if(attr.getConstraint() != null && !attr.getConstraint().isEmpty()) {
				NominalScaledTypeType nst = attr.getConstraint().get(0).getNominalScaledType();
				OrdinalScaledTypeType ost = attr.getConstraint().get(0).getOrdinalScaledType();
				
				if(nst != null)
				{
					s += " [";
					for(AnyType anytype : nst.getRequiredValue()) {
						s += AMLHelperFunctions.fromAMLAnyType(anytype) + ",";
					}
					s = s.substring(0, s.length()-1) + "], ";
				}
				
				if(ost != null) {
					if(ost.getRequiredMinValue() != null) {
						String min = AMLHelperFunctions.fromAMLAnyType(ost.getRequiredMinValue());
						if(min != "") {
							s += ">= " + min + ", ";
						}
					}
					
					if(ost.getRequiredMaxValue() != null) {
						String max = AMLHelperFunctions.fromAMLAnyType(ost.getRequiredMaxValue());
						if(max != "") {
							s += "<= " + max + ", ";
						}
					}
				}
			}
		}
		
		else
			s += "CAEX:" + this.caexObj.getName() + ", ";
		
		if(this.config.isPrimary())
			s += "primary, ";
		
		if(this.config.isNegated())
			s+= "negated";
		else
			s = s.substring(0, s.length()-2);
		
		return s;
	}
	
	private void overwriteConfig (AttributeType configAttr) {
		if(configAttr.getName().equals(AMLConceptAttributes.CONFIG)) {
			for(AttributeType sub : configAttr.getAttribute()) {
				if(sub.getName().equals(AMLConceptAttributes.CONFIG_ID))
					sub.setValue(AMLHelperFunctions.toAMLAnyType(this.config.isIdentifiedById()));				
				else if(sub.getName().equals(AMLConceptAttributes.CONFIG_MAX))
					sub.setValue(AMLHelperFunctions.toAMLAnyType(this.config.getMaxCardinality()));
				else if(sub.getName().equals(AMLConceptAttributes.CONFIG_MIN))
					sub.setValue(AMLHelperFunctions.toAMLAnyType(this.config.getMinCardinality()));
				else if(sub.getName().equals(AMLConceptAttributes.CONFIG_NAME))
					sub.setValue(AMLHelperFunctions.toAMLAnyType(this.config.isIdentifiedByName()));
				else if(sub.getName().equals(AMLConceptAttributes.CONFIG_NEGATED))
					sub.setValue(AMLHelperFunctions.toAMLAnyType(this.config.isNegated()));
				else if(sub.getName().equals(AMLConceptAttributes.CONFIG_PRIMARY))
					sub.setValue(AMLHelperFunctions.toAMLAnyType(this.config.isPrimary()));
				else
					System.err.println("AMLConceptModel.overwriteConfig: the config attribute [" + sub.getName() + "] undefined for AML concept models!");
			}
		}
	}
	
	/**
	 * serialize the AML concept model to a caex object that has the config parameters as its attributes explicitly
	 * @return the caex object representing the AML concept model
	 */
	public CAEXObject toCAEXObject () {
			
		boolean configured = false;
		AttributeType amlConf = config.toAMLAttribute();
		
		if (caexObj instanceof ExternalInterfaceType) {
			
			ExternalInterfaceType ei = (ExternalInterfaceType) caexObj;
			
			// if already configured: change the values to this one
			for(AttributeType attr : ei.getAttribute()) {
				if(attr.getName().equals("queryConfig")) {
					overwriteConfig(attr);
					configured = true;
				}
			}
			
			if(!configured)
				ei.getAttribute().add(amlConf);
			
			return ei;
		}
		
		else if (caexObj instanceof AttributeType) {
			
			AttributeType attr = (AttributeType) caexObj;
			
			// if already configured
			for(AttributeType sub : attr.getAttribute()) {
				if(sub.getName().equals("queryConfig")) {
					overwriteConfig(sub);
					configured = true;
				}
			}
			
			if(!configured)
				attr.getAttribute().add(amlConf);
			
			return attr;
		}
		
		else if(caexObj instanceof InterfaceClassType) {
			
			InterfaceClassType ic = (InterfaceClassType) caexObj;
			
			// if already configured
			for(AttributeType attr : ic.getAttribute()) {
				if(attr.getName().equals("queryConfig")) {
					overwriteConfig(attr);
					configured = true;
				}
			}
			
			if(!configured)
				ic.getAttribute().add(amlConf);	
			
			return ic;
		}
		
		else if (caexObj instanceof RoleClassType) {
			
			RoleClassType rc = (RoleClassType) caexObj;
			
			// if already configured
			for(AttributeType attr : rc.getAttribute()) {
				if(attr.getName().equals("queryConfig")) {
					overwriteConfig(attr);
					configured = true;
				}
			}
			
			if(!configured)
				rc.getAttribute().add(amlConf);
			
			return rc;
		}
		
		else if (caexObj instanceof InternalElementType) {
			
			InternalElementType ie = (InternalElementType) caexObj;
			
			// if already configured
			for(AttributeType attr : ie.getAttribute()) {
				if(attr.getName().equals("queryConfig")) {
					overwriteConfig(attr);
					configured = true;
				}
			}
			
			if(!configured)
				ie.getAttribute().add(amlConf);
			
			return ie;
		}
		
		else if (caexObj instanceof SystemUnitClassType) {			
			SystemUnitClassType suc = (SystemUnitClassType) caexObj;
			
			// if already configured
			for(AttributeType attr : suc.getAttribute()) {
				if(attr.getName().equals("queryConfig")) {
					overwriteConfig(attr);
					configured = true;
				}
			}
			
			if(!configured)
				suc.getAttribute().add(amlConf);
			
			return suc;			
		}		
		
		else
			return null;
	}
	
	
}
