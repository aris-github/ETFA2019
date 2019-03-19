package concept.model;

import CAEX215.AttributeType;
import CAEX215.CAEX215Factory;
import CAEX215.util.AMLHelperFunctions;

/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 * This class contains the basic configuration parameters of an AML concept model
 */
public class BasicAMLConceptConfig implements IAMLConceptConfig{
	
	// whether this object is the primary object that the concept is describing
	private boolean primary = false; 	
	
	// whether the UUID of this object acts as a requirement in the concept
	private boolean identifiedById = false;
	
	// whether the UUID of this object acts as a requirement in the concept
	private boolean identifiedByName = false;
	
	// how many time the pattern of this object shall appear
	// if min=max=0, then the underlying pattern shall never appear
	private int minCardinality = 1; //default is at least one such pattern
	private int maxCardinality = -1; //default is unbounded such patterns	
	
	public BasicAMLConceptConfig() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the returned
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * @param returned the returned to set
	 */
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	/**
	 * @return the identifiedById
	 */
	public boolean isIdentifiedById() {
		return identifiedById;
	}		
	

	/**
	 * @param identified the identified to set
	 */
	public void setIdentifiedById(boolean identified) {
		this.identifiedById = identified;
	}
	
	
	/**
	 * @return the identifiedByName
	 */
	public boolean isIdentifiedByName() {
		return identifiedByName;
	}


	/**
	 * @param identifiedByName the identifiedByName to set
	 */
	public void setIdentifiedByName(boolean identifiedByName) {
		this.identifiedByName = identifiedByName;
	}

	/**
	 * @return the minCardinality
	 */
	public int getMinCardinality() {
		return minCardinality;
	}


	/**
	 * @param minCardinality the minCardinality to set
	 */
	public void setMinCardinality(int minCardinality) {
		this.minCardinality = minCardinality;
	}


	/**
	 * @return the maxCardinality
	 */
	public int getMaxCardinality() {
		return maxCardinality;
	}


	/**
	 * @param maxCardinality the maxCardinality to set
	 */
	public void setMaxCardinality(int maxCardinality) {
		this.maxCardinality = maxCardinality;
	}


	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof BasicAMLConceptConfig))
	        return false;
	    if (obj == this)
	        return true;
	    return this.identifiedById == ((BasicAMLConceptConfig) obj).identifiedById
	    		&& this.primary == ((BasicAMLConceptConfig) obj).primary
	    		&& this.minCardinality == ((BasicAMLConceptConfig) obj).minCardinality
			&& this.maxCardinality == ((BasicAMLConceptConfig) obj).maxCardinality
	    		&& this.identifiedByName == ((BasicAMLConceptConfig) obj).identifiedByName;
	}
	
	public boolean canBeFusedWith(IAMLConceptConfig other) {
		if (other == null) return false;
	    if (!(other instanceof BasicAMLConceptConfig))
	        return false;
	    if (other == this)
	        return true;
	    return this.identifiedById == ((BasicAMLConceptConfig) other).identifiedById
//	    		&& this.primary == ((BasicAMLConceptConfig) other).primary
	    		&& this.identifiedByName == ((BasicAMLConceptConfig) other).identifiedByName;
	}
	
	protected AttributeType toCAEXAttribute(String name, boolean value) {
		
		AttributeType attr = CAEX215Factory.eINSTANCE.createAttributeType();
		attr.setName(name);		
		attr.setValue(AMLHelperFunctions.toAMLAnyType(Boolean.toString(value)));		
		attr.setAttributeDataType("xs:boolean");		
		return attr;
	}
	
	protected AttributeType toCAEXAttribute(String name, int value) {
		
		AttributeType attr = CAEX215Factory.eINSTANCE.createAttributeType();
		attr.setName(name);
		attr.setValue(AMLHelperFunctions.toAMLAnyType(Integer.toString(value)));
		attr.setAttributeDataType("xs:");		
		return attr;
	}
	
	@Override
	public AttributeType toCAEXAttribute() {
		AttributeType amlConf = CAEX215Factory.eINSTANCE.createAttributeType();
		amlConf.setName("queryConfig");		
		amlConf.getAttribute().add(toCAEXAttribute("primary", primary));
		amlConf.getAttribute().add(toCAEXAttribute("minCardinality", minCardinality));
		amlConf.getAttribute().add(toCAEXAttribute("maxCardinality", maxCardinality));
		amlConf.getAttribute().add(toCAEXAttribute("identifiedById", identifiedById));
		amlConf.getAttribute().add(toCAEXAttribute("identifiedByName", identifiedByName));				
		return amlConf;
	}

	@Override
	public void fromCAEXAttribute(AttributeType attr) {

		for(AttributeType child : attr.getAttribute()) {
			if(child.getName().equalsIgnoreCase(BasicAMLConceptConfig.CONFIG_PRIMARY)) {
				Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
				if(b!=null)
					primary = b;				
			}
			else if(child.getName().equalsIgnoreCase(BasicAMLConceptConfig.CONFIG_ID)) {
				Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
				if(b!=null)
					identifiedById = b;				
			}
			else if(child.getName().equalsIgnoreCase(BasicAMLConceptConfig.CONFIG_NAME)) {
				Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
				if(b!=null)
					identifiedByName = b;				
			}
			else if(child.getName().equalsIgnoreCase(BasicAMLConceptConfig.CONFIG_MAX)) {
				Integer b = AMLHelperFunctions.getAMLAttributeValueInteger(child);
				if(b != null)
					maxCardinality = b;
			}
			else if(child.getName().equalsIgnoreCase(BasicAMLConceptConfig.CONFIG_MIN)) {
				Integer b = AMLHelperFunctions.getAMLAttributeValueInteger(child);
				if(b != null)
					minCardinality = b;
			}
//			else
//				System.err.println("unknown query config parameter [" + child.getName() + "]!");
		}
		
		if(maxCardinality < minCardinality && maxCardinality != -1) {
			System.err.println("maximum cardinliaty (" + maxCardinality + ") smaller than the minimum cardinality (" + minCardinality + ")");
			System.err.println(" - changing cardinilities to -1 (unbounded)");
			maxCardinality = -1;
			minCardinality = -1;	
		}
		
		if(maxCardinality < -1) {
			System.err.println("maximum cardinliaty (" + maxCardinality + ") <-1");
			System.err.println(" - same as -1, set it to -1");
			maxCardinality = -1;
		}
		
		if(minCardinality < -1) {
			System.err.println("minimum cardinliaty (" + minCardinality + ") <0");
			System.err.println("same as 0, set it to 0");
			minCardinality = 0;
		}
	}
	
	
	@Override
	public String toString() {
		String s = "";
		
		// cardinality
		s += "[" + minCardinality + ", " + maxCardinality + "]: ";
		
		if(isPrimary())
			s += "primary, ";
		
		return s;		
	}
}
