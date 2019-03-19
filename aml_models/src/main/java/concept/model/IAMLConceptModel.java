package concept.model;

import CAEX215.CAEXObject;

public interface IAMLConceptModel {

//	public CAEXObject getObj ();
//	
//	public void setObj (CAEXObject obj);
//	
//	public IAMLConceptConfig getConfig ();
//	
//	public void setConfig (IAMLConceptConfig config);
	
	/**
	 * instantiate the AML concept model from a CAEX object which has the config parameters as CAEX attributes
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void fromConfiguredCAEXObj (CAEXObject obj);
	
	/**
	 * serialize the AML concept model to a caex object that has the config parameters as its attributes explicitly
	 * @return the caex object representing the AML concept model
	 */
	public CAEXObject toConfiguredCAEXObject();
}
