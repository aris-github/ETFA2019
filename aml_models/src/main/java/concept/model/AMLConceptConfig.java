package concept.model;

import CAEX215.AttributeType;
import CAEX215.util.AMLHelperFunctions;

/**
 * The class for holding OWL configuration of AML Concept Models 
 * @author aris
 *
 */
public class AMLConceptConfig extends BasicAMLConceptConfig{
	// whether the class reference or the value range of an AML concept model shall be negated
	// this is the negation in logic sense
	// this is useful to express negated concepts or data ranges
	// it is NOT considered as "not existing" - which is modeled as min=max=0
	private boolean negated = false;
	
	public static final String CONFIG_NEGATED = "negated"; 	

	
	public AMLConceptConfig() {
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
	
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj) 
				&& this.negated == ((AMLConceptConfig) obj).negated;
	}
	
	@Override
	public boolean canBeFusedWith(IAMLConceptConfig other) {
		
		return super.canBeFusedWith(other)
				&& this.negated == ((AMLConceptConfig) other).negated;
	}
	
	@Override
	public AttributeType toCAEXAttribute () {
		AttributeType amlConf = super.toCAEXAttribute();		
		amlConf.getAttribute().add(toCAEXAttribute("negated", negated));		
		return amlConf;
	}
	
	@Override
	public void fromCAEXAttribute(AttributeType attr) {
		// TODO Auto-generated method stub
		super.fromCAEXAttribute(attr);
		
		for(AttributeType child : attr.getAttribute()) {
			if(child.getName().equalsIgnoreCase(AMLConceptConfig.CONFIG_NEGATED)) {
				Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
				if(b!=null)
					negated = b;				
			}
		}
	}
	
	@Override
	public String toString () {
		String s = super.toString();
		
		if(negated)
			s += "negated, ";
		
		return s;
	}

}
