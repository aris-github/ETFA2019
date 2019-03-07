/**
 * 
 */
package concept.model;

import CAEX215.AttributeType;
import CAEX215.CAEX215Factory;
import CAEX215.util.AMLHelperFunctions;

/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 * This class contains the basic configuration parameters of an AML concept model
 */
public class BasicAMLConceptAttributes{
	
	// whether this object is the primary object that the concept is describing
	protected boolean primary = false; 	
	
	// whether the UUID of this object acts as a requirement in the concept
	protected boolean identifiedById = false;
	
	// whether the UUID of this object acts as a requirement in the concept
	protected boolean identifiedByName = false;
	
	// how many time the pattern of this object shall appear
	// if min=max=0, then the underlying pattern shall never appear
	protected int minCardinality = 1; //default is at least one such pattern
	protected int maxCardinality = -1; //default is unbounded such patterns	
	
	// public constants
	
	// top level AML attribute reserved for concept objects
	// if this attribute is not found - default set all config parameters to false
	public static final String CONFIG = "queryConfig";
	
	public static final String CONFIG_PRIMARY = "primary"; 	 
	public static final String CONFIG_ID = "identifiedById";	
	public static final String CONFIG_NAME = "identifiedByName"; 	
	public static final String CONFIG_MIN = "minCardinality";
	public static final String CONFIG_MAX = "maxCardinality";
	
//	public static final String QUERY_CONFIG_DESCENDANT = "descendant";
	
	public BasicAMLConceptAttributes() {
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
	    if (!(obj instanceof BasicAMLConceptAttributes))
	        return false;
	    if (obj == this)
	        return true;
	    return this.identifiedById == ((BasicAMLConceptAttributes) obj).identifiedById
//	    		&& this.negated == ((BasicAMLConceptAttributes) obj).negated
	    		&& this.primary == ((BasicAMLConceptAttributes) obj).primary
//	    		&& this.transitive == ((BasicAMLConceptAttributes) obj).transitive
	    		&& this.minCardinality == ((BasicAMLConceptAttributes) obj).minCardinality
			&& this.maxCardinality == ((BasicAMLConceptAttributes) obj).maxCardinality
//	    		&& this.count == ((AMLQueryConfig) obj).count
	    		&& this.identifiedByName == ((BasicAMLConceptAttributes) obj).identifiedByName;
	}
	
	public boolean equalsWithoutCardinality(Object obj) {
		if (obj == null) return false;
	    if (!(obj instanceof BasicAMLConceptAttributes))
	        return false;
	    if (obj == this)
	        return true;
	    return this.identifiedById == ((BasicAMLConceptAttributes) obj).identifiedById
//	    		&& this.negated == ((BasicAMLConceptAttributes) obj).negated
	    		&& this.primary == ((BasicAMLConceptAttributes) obj).primary
//	    		&& this.transitive == ((BasicAMLConceptAttributes) obj).transitive
	    		&& this.identifiedByName == ((BasicAMLConceptAttributes) obj).identifiedByName;
	}
	
	protected AttributeType toAMLAttribute(String name, boolean value) {
		
		AttributeType attr = CAEX215Factory.eINSTANCE.createAttributeType();
		attr.setName(name);		
		attr.setValue(AMLHelperFunctions.toAMLAnyType(Boolean.toString(value)));		
		attr.setAttributeDataType("xs:boolean");		
		return attr;
	}
	
	protected AttributeType toAMLAttribute(String name, int value) {
		
		AttributeType attr = CAEX215Factory.eINSTANCE.createAttributeType();
		attr.setName(name);
		attr.setValue(AMLHelperFunctions.toAMLAnyType(Integer.toString(value)));
		attr.setAttributeDataType("xs:");		
		return attr;
	}
	
	public AttributeType toAMLAttribute () {
		AttributeType amlConf = CAEX215Factory.eINSTANCE.createAttributeType();
		amlConf.setName("queryConfig");
		
		amlConf.getAttribute().add(toAMLAttribute("primary", primary));
//		amlConf.getAttribute().add(toAMLAttribute("negated", negated));
//		amlConf.getAttribute().add(toAMLAttribute("transitive", transitive));
		amlConf.getAttribute().add(toAMLAttribute("minCardinality", minCardinality));
		amlConf.getAttribute().add(toAMLAttribute("maxCardinality", maxCardinality));
		amlConf.getAttribute().add(toAMLAttribute("identifiedById", identifiedById));
		amlConf.getAttribute().add(toAMLAttribute("identifiedByName", identifiedByName));		
		
		return amlConf;
		
	}
}
