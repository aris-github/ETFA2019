package concept.model;


import java.util.ListIterator;

import org.eclipse.emf.ecore.xml.type.AnyType;

import CAEX215.AttributeType;
import CAEX215.CAEXObject;
import CAEX215.ExternalInterfaceType;
import CAEX215.InterfaceClassType;
import CAEX215.InterfaceFamilyType;
import CAEX215.InternalElementType;
import CAEX215.NominalScaledTypeType;
import CAEX215.OrdinalScaledTypeType;
import CAEX215.RoleClassType;
import CAEX215.RoleFamilyType;
import CAEX215.SystemUnitClassType;
import CAEX215.SystemUnitFamilyType;
import CAEX215.util.AMLHelperFunctions;

public class GenericAMLConceptModel<T extends IAMLConceptConfig> implements IAMLConceptModel{
	
	private CAEXObject obj;
	private T config;
	
//	public AbstractAMLConceptModel() {
//		// TODO Auto-generated constructor stub
//		
//	}
	
	public GenericAMLConceptModel(Class<T> type) throws InstantiationException, IllegalAccessException{
//		// TODO Auto-generated constructor stub
		this.config = type.newInstance();
	}
	
	public GenericAMLConceptModel(CAEXObject obj, T config) {
		this.obj = obj;
		this.config = config;
	}
	
	public CAEXObject getObj () {
		return this.obj;
	}
	
	public void setObj (CAEXObject obj) {
		this.obj = obj;
	}
	
	public IAMLConceptConfig getConfig () {
		return this.config;
	}
	
	public void setConfig (T config) {
		this.config = config;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof GenericAMLConceptModel))
	        return false;
	    if (obj == this)
	        return true;
	    return this.config.equals( ((GenericAMLConceptModel) obj).config)
	    		&& this.obj.equals( ((GenericAMLConceptModel) obj).obj);
	}
	
	private CAEXObject removeConfig (CAEXObject obj) {
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
	
	@Override
	public void fromConfiguredCAEXObj (CAEXObject obj) {		
		
		if(obj instanceof AttributeType) {
			AttributeType attr = (AttributeType) obj;
			// a CAEX attribute can be a concept model, only if it is not a config attribute itself 
			if(!attr.getName().equalsIgnoreCase(IAMLConceptConfig.CONFIG)) {
				// if the caex attribute is not a config attribute, then one of its sub attributes shall be the config attribute
				for(AttributeType sub : attr.getAttribute()) {
					if(sub.getName().equals(IAMLConceptConfig.CONFIG))
						this.config.fromCAEXAttribute(sub); 
				}
			}
		}

		else if(obj instanceof InterfaceClassType && !(obj instanceof InterfaceFamilyType) && !(obj instanceof ExternalInterfaceType)) {			
			InterfaceClassType ic = (InterfaceClassType) obj;
			for(AttributeType attr : ic.getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					this.config.fromCAEXAttribute(attr);
			}		
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
			for(AttributeType attr : ei.getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					this.config.fromCAEXAttribute(attr);
			}		
		}
		
		else if(obj instanceof RoleClassType && !(obj instanceof RoleFamilyType)) {
			RoleClassType rc = (RoleClassType) obj;												
			for(AttributeType attr : rc.getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					this.config.fromCAEXAttribute(attr);
			}		
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
			for(AttributeType attr : ie.getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					this.config.fromCAEXAttribute(attr);
			}		
		}		
		
		else if(obj instanceof SystemUnitClassType && !(obj instanceof SystemUnitFamilyType)) {
			SystemUnitClassType suc = (SystemUnitClassType) obj;			
			for(AttributeType attr : suc.getAttribute()) {
				if(attr.getName().equals(IAMLConceptConfig.CONFIG))
					this.config.fromCAEXAttribute(attr);
			}		
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
		}
		
		//remove the config attribute from the input caex object
		//this.obj = removeConfig(obj);
		this.obj = obj;
	}
	
	@Override
	public CAEXObject toConfiguredCAEXObject() {
		
		AttributeType amlConf = config.toCAEXAttribute();
		
		if (obj instanceof ExternalInterfaceType) {			
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;
			ei.getAttribute().add(amlConf);			
			return ei;
		}
		
		else if (obj instanceof AttributeType) {
			
			AttributeType attr = (AttributeType) obj;
			attr.getAttribute().add(amlConf);			
			return attr;
		}
		
		else if(obj instanceof InterfaceClassType) {
			
			InterfaceClassType ic = (InterfaceClassType) obj;
			ic.getAttribute().add(amlConf);				
			return ic;
		}
		
		else if (obj instanceof RoleClassType) {
			
			RoleClassType rc = (RoleClassType) obj;
			rc.getAttribute().add(amlConf);			
			return rc;
		}
		
		else if (obj instanceof InternalElementType) {
			
			InternalElementType ie = (InternalElementType) obj;
			ie.getAttribute().add(amlConf);			
			return ie;
		}
		
		else if (obj instanceof SystemUnitClassType) {			
			SystemUnitClassType suc = (SystemUnitClassType) obj;
			suc.getAttribute().add(amlConf);			
			return suc;			
		}		
		
		else
			return null;
	}
	

	public String toString () {
		
		String s = "";
		String configStr = this.config.toString();
		
		boolean id = false, name = false;
		if(config instanceof BasicAMLConceptConfig) {
			id = ((BasicAMLConceptConfig) config).isIdentifiedById();
			name = ((BasicAMLConceptConfig) config).isIdentifiedByName();	
		}
				
		if(this.obj instanceof InternalElementType) {
			s += "IE";
			InternalElementType ie = (InternalElementType) obj;
			
			String desc = "";
			if(ie.getRoleRequirements() != null) {
				String path = ie.getRoleRequirements().getRefBaseRoleClassPath();
				String role = path.substring(path.lastIndexOf("/")+1);
				desc += role + ", ";
			}
			
			if(name && ie.getName() != null)
				desc += ie.getName() + ", ";
				
			if(id && ie.getID() != null) 
				desc += ie.getID() + ", ";
			
			if(desc != "")
				s += "(" + desc.substring(0, desc.length()-2) + ")" + configStr;
			else
				s += configStr;
		}
			
		else if(this.obj instanceof ExternalInterfaceType) {
			s += "EI";
			ExternalInterfaceType ei = (ExternalInterfaceType) obj;
			
			String desc = "";
			if(name && ei.getName() != null)
				desc += ei.getName() + ", ";
			
			if(id && ei.getID() != null)
				desc += ei.getID() + ", ";
			
			if(ei.getRefBaseClassPath() != null) {
				String path = ei.getRefBaseClassPath();
				String ic = path.substring(path.lastIndexOf("/")+1);
				desc += ic + ", ";
			}
			
			if(desc != "")
				s += "(" + desc.substring(0, desc.length()-2) + ")" + configStr;
			else
				s += configStr;
		}
		
		else if(this.obj instanceof AttributeType) {
			s += "Attribute";
			
			AttributeType attr = (AttributeType) obj;
			if(attr.getName().equals("x"))
				System.out.println();
		
			String desc = "";
			// although we check the boolean flag "identifiedByName", it shall always be set to true for attribuets
			if(name && attr.getName() != null)	
				desc += attr.getName() + ", ";
			
			if(desc != "")
				s += "(" + desc.substring(0, desc.length()-2) + ")" + configStr;
			else
				s += configStr;
			
			if(attr.getValue() != null && AMLHelperFunctions.fromAMLAnyType(attr.getValue()) != "")
//				s = addTokenToPrint(s, AMLHelperFunctions.fromAMLAnyType(attr.getValue()));
				s += AMLHelperFunctions.fromAMLAnyType(attr.getValue()) + "; "; 
			
			if(attr.getConstraint() != null && !attr.getConstraint().isEmpty()) {
				NominalScaledTypeType nst = attr.getConstraint().get(0).getNominalScaledType();
				OrdinalScaledTypeType ost = attr.getConstraint().get(0).getOrdinalScaledType();
				
				if(nst != null)
				{
					s += "[";
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
				} //end ost
			}//end constraints
		}// end attribute		
		
		s = s.substring(0, s.length()-2);
		return s;
	}
}
