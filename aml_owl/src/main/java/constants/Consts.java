/**
 * 
 */
package constants;

/**
 * @author hua
 *
 */
public final class Consts {

	public static final String aml_pref = "http://www.ipr.kit.edu/aml_ontology#";
	public static final String om_pref = "http://www.wurvoc.org/vocabularies/om-1.8/";
	public static final String importer_pref = "http://www.ipr.kit.edu/aml_importer#";
	public static final String test_pref = "http://www.ipr.kit.edu/aml_importer/test#";
	public static final String dir = System.getProperty("user.dir");
	public static final String resources = Consts.dir + "/../resources";
	
//	public static final String home_ubuntu = "/home/hua/workspace/ipr_gitlab/aml_import";
//	public static final String home_mac = "/Users/aris/Documents/repositories/ipr/aml_import";
	
//	public static final String resource_ubuntu = home_ubuntu + "/resources";
//	public static final String resource_mac = home_mac + "/resources";
	
	/**
	   The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	*/
	private Consts(){
		//this prevents even the native class from 
		//calling this ctor as well :
		throw new AssertionError();
	}
}
