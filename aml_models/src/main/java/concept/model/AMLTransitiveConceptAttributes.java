package concept.model;

import CAEX215.AttributeType;

public class AMLTransitiveConceptAttributes extends AMLConceptAttributes{
	
	// whether this object shall be handled as a transitive closure, 
	// i.e. all continuously appearing objects of the same pattern are in the concept 
	private boolean transitive = false;
	
	public static final String CONFIG_TRANSITIVE = "transitive";
	
	public AMLTransitiveConceptAttributes() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the transitive
	 */
	public boolean isTransitive() {
		return transitive;
	}

	/**
	 * @param transitive the transitive to set
	 */
	public void setTransitive(boolean transitive) {
		this.transitive = transitive;
	}
	
	public boolean equals(Object obj) {
		
		return super.equals(obj) 
				&& this.transitive == ((AMLTransitiveConceptAttributes) obj).transitive;
	}
	
	public boolean equalsWithoutCardinality(Object obj) {
		
		return super.equalsWithoutCardinality(obj)
				&& this.transitive == ((AMLTransitiveConceptAttributes) obj).transitive;
	}
	
	public AttributeType toAMLAttribute () {
		AttributeType amlConf = super.toAMLAttribute();		
		amlConf.getAttribute().add(toAMLAttribute("transitive", transitive));
		
		return amlConf;
		
	}

}
