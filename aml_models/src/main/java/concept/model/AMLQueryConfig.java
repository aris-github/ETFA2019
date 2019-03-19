/**
 * 
 */
package concept.model;

import java.util.HashSet;
import java.util.Set;

import CAEX215.AttributeType;
import CAEX215.util.AMLHelperFunctions;
import concept.util.EILinkRefSide;

/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 * This class contains the configuration parameters of a query model using only AutomationML/CAEX concepts
 */
public class AMLQueryConfig extends BasicAMLConceptConfig{
	
	// whether this object shall be handled as a transitive closure
	// that means, this object is not necessarily a direct child of its parent, but can also be any node in the descendant of its ancestor
	private boolean transitive = false;
		
	// whether this object is a descendant of its parent
	// by default, it is not a descendant but the direct child of its parent
	private boolean descendant = false;
	
	private Set<EILinkRefSide> linkConstraints = new HashSet<EILinkRefSide>();
	
	public static final String CONFIG_TRANSITIVE = "transitive";
	public static final String CONFIG_DESCENDANT = "descendant";
	
	public AMLQueryConfig() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the transitive
	 */
	public boolean isTransitive() {
		return transitive;
	}

	/**
	 * @return the linkConstraints
	 */
	public Set<EILinkRefSide> getLinkConstraints() {
		return linkConstraints;
	}

	/**
	 * @param linkConstraints the linkConstraints to set
	 */
	public void setLinkConstraints(Set<EILinkRefSide> linkConstraints) {
		this.linkConstraints = linkConstraints;
	}

	/**
	 * @param transitive the transitive to set
	 */
	public void setTransitive(boolean transitive) {
		this.transitive = transitive;
	}

	/**
	 * @return the descendant
	 */
	public boolean isDescendant() {
		return descendant;
	}


	/**
	 * @param descendant the descendant to set
	 */
	public void setDescendant(boolean descendant) {
		this.descendant = descendant;
	}


	@Override
	public boolean equals(Object obj) {
		return super.equals(obj)
				&& this.transitive == ((AMLQueryConfig) obj).transitive
				&& this.descendant == ((AMLQueryConfig) obj).descendant;
	}

	@Override
	public boolean canBeFusedWith(IAMLConceptConfig other) {
		
		return super.canBeFusedWith(other)
				&& this.transitive == ((AMLQueryConfig) other).transitive
				&& this.descendant == ((AMLQueryConfig) other).descendant;
	}
	
	@Override
	public AttributeType toCAEXAttribute () {
		AttributeType amlConf = super.toCAEXAttribute();		
		amlConf.getAttribute().add(toCAEXAttribute("transitive", transitive));
		amlConf.getAttribute().add(toCAEXAttribute("descendant", descendant));
		return amlConf;
	}
	
	@Override
	public void fromCAEXAttribute(AttributeType attr) {
		// TODO Auto-generated method stub
		super.fromCAEXAttribute(attr);
		
		for(AttributeType child : attr.getAttribute()) {
			if(child.getName().equalsIgnoreCase(AMLQueryConfig.CONFIG_TRANSITIVE)) {
				Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
				if(b!=null)
					transitive = b;				
			}
			if(child.getName().equalsIgnoreCase(AMLQueryConfig.CONFIG_DESCENDANT)) {
				Boolean b = AMLHelperFunctions.getAMLAttributeValueBoolean(child);
				if(b!=null)
					descendant = b;				
			}
		}
	}
	
	@Override
	public String toString () {
		String s = super.toString();
		
		if(transitive)
			s += "transitive, ";
		
		if(descendant)
			s += "descendant, ";
		
		return s;
	}
}
