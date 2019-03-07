/**
 * 
 */
package constants;

import org.semanticweb.owlapi.model.IRI;

import CAEX215.AttributeType;
import CAEX215.CAEXObject;
import CAEX215.ExternalInterfaceType;
import CAEX215.InterfaceClassType;
import CAEX215.InternalElementType;
import CAEX215.RoleClassType;
import CAEX215.SystemUnitClassType;

/**
 * @author hua
 * This class contains IRI definitions of the AML ontology, which serves as vocabulary for the AML2RDF transformation
 */
public final class AMLClassIRIs {
	
	/**
	 * CAEX Basic objects
	 */
	
	public static final IRI CAEX_FILE = IRI.create(Consts.aml_pref + "CAEXFile");
	
	public static final IRI REVISION = IRI.create(Consts.aml_pref + "Revision");
	
	public static final IRI EXTERNAL_REFERENCE = IRI.create(Consts.aml_pref + "ExternalReference");		
	
	public static final IRI ATTRIBUTE_VALUE_REQUIREMENT = IRI.create(Consts.aml_pref + "AttributeValueRequirement");
	
	public static final IRI REFSEMANTIC = IRI.create(Consts.aml_pref + "RefSemantic");
	
	public static final IRI ROLE_REQUIREMENTS = IRI.create(Consts.aml_pref + "RoleRequirements");
	
	public static final IRI SUPPORTED_ROLE_CLAS = IRI.create(Consts.aml_pref + "SupportedRoleClass");
	
	// mappings
	
	public static final IRI MAPPING = IRI.create(Consts.aml_pref + "Mapping");
	
	public static final IRI ATTRIBUTE_NAME_MAPPING = IRI.create(Consts.aml_pref + "AttributeNameMapping");
	
	public static final IRI INTERFACE_NAME_MAPPING = IRI.create(Consts.aml_pref + "InterfaceNameMapping");
	
	
	// CAEX Objects
	
	public static final IRI ATTRIBUTE = IRI.create(Consts.aml_pref + "Attribute");
	
	public static final IRI INSTANCE_HIERARCHY = IRI.create(Consts.aml_pref + "InstanceHiearchy");
	
	public static final IRI INTERFACE_CLASS_LIB = IRI.create(Consts.aml_pref + "InterfaceClassLib");
	
	public static final IRI INTERFACE_CLASS = IRI.create(Consts.aml_pref + "InterfaceClass");	
	
	public static final IRI EXTERNAL_INTERFACE = IRI.create(Consts.aml_pref + "ExternalInterface");
	
	public static final IRI INTERFACE_FAMILY = IRI.create(Consts.aml_pref + "InterfaceFamily");	
	
	public static final IRI INTERNAL_LINK = IRI.create(Consts.aml_pref + "InternalLink");
	
	public static final IRI ROLE_CLASS_LIB = IRI.create(Consts.aml_pref + "RoleClassLib");
	
	public static final IRI ROLE_CLASS = IRI.create(Consts.aml_pref + "RoleClass");
	
	public static final IRI ROLE_FAMILY = IRI.create(Consts.aml_pref + "RoleFamily");
	
	public static final IRI SYSTEMUNIT_CLASS_LIB = IRI.create(Consts.aml_pref + "SystemUnitClassLib");
	
	public static final IRI SYSTEMUNIT_CLASS = IRI.create(Consts.aml_pref + "SystemUnitClass");
	
	public static final IRI SYSTEMUNIT_FAMILY = IRI.create(Consts.aml_pref + "SystemUnitFamily");
	
	public static final IRI INTERNAL_ELEMENT = IRI.create(Consts.aml_pref + "InternalElement");
	
	public static final IRI CAEX_OBJECT = IRI.create(Consts.aml_pref + "CAEXObject");
	
	/**
	 * Additional vocabularies 
	 */

	public static final IRI COPYRIGHT = IRI.create(Consts.aml_pref + "Copyright");
	
	public static final IRI DESCRIPTION = IRI.create(Consts.aml_pref + "Description");
	
	public static final IRI DOCUMENT_ROOT = IRI.create(Consts.aml_pref + "DocumentRoot");
	
	public static final IRI NOMINAL_SCALED = IRI.create(Consts.aml_pref + "NominalScaled");
	
	public static final IRI ORDINAL_SCALED = IRI.create(Consts.aml_pref + "OrdinalScaled");
	
	public static final IRI UNKNOWN_TYPE = IRI.create(Consts.aml_pref + "UnknownType");
	
	public static final IRI VERSION = IRI.create(Consts.aml_pref + "Version");
	
//	public static final IRI ATTRIBUTE = IRI.create(Consts.aml_pref + "Attribute");
	
	
		
	
//	public static final IRI ADDITIONAL_INFORMATION = IRI.create(Consts.aml_pref + "AdditionalInformation");
	
//	public static final IRI EXTERNAL_STANDARD = IRI.create(Consts.aml_pref + "ExternalStandard");
	
//	public static final IRI ECLASS_SPECIFICAITON = IRI.create(Consts.aml_pref + "eClassSpecification");		
	
//	public static final IRI MEASURE = IRI.create(Consts.om_pref + "Measure");
	
//	public static final IRI UNIT_OF_MEASURE = IRI.create(Consts.om_pref + "Unit_of_measure");
		
	/**
	   The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	*/
	private AMLClassIRIs(){
		//this prevents even the native class from 
		//calling this ctor as well :
		throw new AssertionError();
	}
	
	public static IRI getAMLClassIRI (CAEXObject obj) {
		if(obj instanceof InternalElementType)
			return AMLClassIRIs.INTERNAL_ELEMENT;
		else if (obj instanceof ExternalInterfaceType)
			return AMLClassIRIs.EXTERNAL_INTERFACE;
		else if (obj instanceof AttributeType)
			return AMLClassIRIs.ATTRIBUTE;
		else if (obj instanceof RoleClassType)
			return AMLClassIRIs.ROLE_CLASS;
		else if (obj instanceof InterfaceClassType)
			return AMLClassIRIs.INTERFACE_CLASS;
		else if (obj instanceof SystemUnitClassType)
			return AMLClassIRIs.SYSTEMUNIT_CLASS;		
		else 
			return null;		
	} 
	

}
