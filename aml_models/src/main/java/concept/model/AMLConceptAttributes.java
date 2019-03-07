package concept.model;

import CAEX215.AttributeType;

public class AMLConceptAttributes extends BasicAMLConceptAttributes{
	
	// whether the class reference or the value range of an AML concept model shall be negated
	// this is the negation in logic sense
	// this is useful to express negated concepts or data ranges
	// it is NOT considered as "not existing" - which is modeled as min=max=0
	private boolean negated = false;
	
	public static final String CONFIG_NEGATED = "negated"; 	

	
	public AMLConceptAttributes() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the negated
	 */
	public boolean isNegated() {
		return negated;
	}

	/**
	 * @param negated the negated to set
	 */
	public void setNegated(boolean negated) {
		this.negated = negated;
	}
	
	
	public boolean equals(Object obj) {
		
		return super.equals(obj) 
				&& this.negated == ((AMLConceptAttributes) obj).negated;
	}
	
	public boolean equalsWithoutCardinality(Object obj) {
		
		return super.equalsWithoutCardinality(obj)
				&& this.negated == ((AMLConceptAttributes) obj).negated;
	}
	
	public AttributeType toAMLAttribute () {
		AttributeType amlConf = super.toAMLAttribute();		
		amlConf.getAttribute().add(toAMLAttribute("negated", negated));
		
		return amlConf;
		
	}

}
