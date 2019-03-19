package concept.model;

import CAEX215.AttributeType;

public interface IAMLConceptConfig {

	public AttributeType toCAEXAttribute ();
	
	public void fromCAEXAttribute (AttributeType attr);
	
	public boolean canBeFusedWith (IAMLConceptConfig other);
	
	// top level AML attribute reserved for concept objects
	// if this attribute is not found - default
	public static final String CONFIG = "queryConfig";
	public static final String CONFIG_PRIMARY = "primary"; 	 
	public static final String CONFIG_ID = "identifiedById";	
	public static final String CONFIG_NAME = "identifiedByName"; 	
	public static final String CONFIG_MIN = "minCardinality";
	public static final String CONFIG_MAX = "maxCardinality";
	
//	public static final String QUERY_CONFIG_DESCENDANT = "descendant";
}
