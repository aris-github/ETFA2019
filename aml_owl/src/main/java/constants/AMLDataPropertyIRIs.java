/**
 * 
 */
package constants;

import org.semanticweb.owlapi.model.IRI;

/**
 * @author hua
 *
 */
public final class AMLDataPropertyIRIs {
	

	public static final IRI HAS_ALIAS = IRI.create(Consts.aml_pref + "alias");
	
	public static final IRI HAS_ATTRIBTUE_DATA_TYPE = IRI.create(Consts.aml_pref + "attributeDataType");
	
	public static final IRI HAS_AUTHOR_NAME = IRI.create(Consts.aml_pref + "authorName");
	
	public static final IRI HAS_CHANGE_MODE = IRI.create(Consts.aml_pref + "changeMode");
	
	public static final IRI HAS_COMMENT = IRI.create(Consts.aml_pref + "comment");
	
	public static final IRI HAS_CORRESPONDING_ATTRIBUTE_PATH = IRI.create(Consts.aml_pref + "correspondingAttributePath");
	
	public static final IRI HAS_DEFAULT_VALUE = IRI.create(Consts.aml_pref + "defaultValue");
	
	public static final IRI HAS_FILE_NAME = IRI.create(Consts.aml_pref + "fileName");
	
	public static final IRI HAS_ID = IRI.create(Consts.aml_pref + "iD");
	
	public static final IRI HAS_INTERFCE_LIB_PATH = IRI.create(Consts.aml_pref + "interfaceLibPath");
	
	public static final IRI HAS_INTERFACE_PATH = IRI.create(Consts.aml_pref + "interfacePath");
	
	public static final IRI HAS_NAME = IRI.create(Consts.aml_pref + "name");
	
	public static final IRI HAS_NEW_VERSION = IRI.create(Consts.aml_pref + "newVersion");
	
	public static final IRI HAS_OLD_VERSION = IRI.create(Consts.aml_pref + "oldVersion");
	
	public static final IRI HAS_PATH = IRI.create(Consts.aml_pref + "path");
	
	public static final IRI HAS_REF_BASE_CLASS_PATH = IRI.create(Consts.aml_pref + "refBaseClassPath");
	
	public static final IRI HAS_REF_BASE_ROLE_CLASS_PATH = IRI.create(Consts.aml_pref + "refBaseRoleClassPath");
	
	public static final IRI HAS_REF_ROLE_CLASS_PATH = IRI.create(Consts.aml_pref + "refRoleClassPath");
	
	public static final IRI HAS_REQUIRED_MAX_VALUE = IRI.create(Consts.aml_pref + "requiredMaxValue");
	
	public static final IRI HAS_REQUIRED_MIN_VALUE = IRI.create(Consts.aml_pref + "requiredMinValue");
	
	public static final IRI HAS_REQUIRED_VALUE = IRI.create(Consts.aml_pref + "requiredValue");
	
	public static final IRI HAS_REQUIREMENTS = IRI.create(Consts.aml_pref + "requirements");
	
	public static final IRI HAS_REVISION_DATE = IRI.create(Consts.aml_pref + "revisionDate");
	
	public static final IRI HAS_ROLE_ATTRIBUTE_NAME = IRI.create(Consts.aml_pref + "roleAttributeName");
	
	public static final IRI HAS_ROLE_INTERFACE_NAME = IRI.create(Consts.aml_pref + "roleInterfaceName");
	
	public static final IRI HAS_ROLE_LIB_PATH = IRI.create(Consts.aml_pref + "roleLibPath");
	
	public static final IRI HAS_ROLE_PATH = IRI.create(Consts.aml_pref + "rolePath");
	
	public static final IRI HAS_SCHEMA_VERSION = IRI.create(Consts.aml_pref + "schemaVersion");
	
	public static final IRI HAS_SUC_LIB_PATH = IRI.create(Consts.aml_pref + "sucLibPath");
	
	public static final IRI HAS_SUC_PATH = IRI.create(Consts.aml_pref + "sucPath");
	
	public static final IRI HAS_SYSTEMUNIT_ATTRIBUTE_NAME = IRI.create(Consts.aml_pref + "systemUnitAttributeName");
	
	public static final IRI HAS_SYSTEMUNIT_INTERFACE_NAME = IRI.create(Consts.aml_pref + "systemUnitInterfaceName");
	
	public static final IRI HAS_UNIT = IRI.create(Consts.aml_pref + "unit");
	
	public static final IRI HAS_VALUE = IRI.create(Consts.aml_pref + "hasValue");
	
	// moved this to AMLAnnotationProperty since we do not want this to be used by reasoner
//	public static final IRI HAS_AML_SEMANTIC = IRI.create(Consts.importer_pref + "has_amlSemantic");
	
	
//	// for aml_handmade
//	public static final IRI HAS_EXTERNAL_REFERENCE_ALIAS = IRI.create(Consts.aml_pref + "hasExternalReferenceAlias");
//	
//	public static final IRI HAS_EXTERNAL_REFERENCE_PATH = IRI.create(Consts.aml_pref + "hasExternalReferencePath");
//	
//	public static final IRI HAS_AML_VERSION = IRI.create(Consts.aml_pref + "hasAMLVersion");
//	
////	-- redudant -- 
////	public static final IRI HAS_ATTRIBTUE_NAME = Consts.aml_pref + "hasAttributeName";
//	
//	public static final IRI HAS_ATTRIBUTE_VALUE = IRI.create(Consts.aml_pref + "hasAttributeValue");
//	
//	public static final IRI HAS_ATTRIBUTE_DATATYPE = IRI.create(Consts.aml_pref + "hasAttributeDataType");
//
//	public static final IRI HAS_ATTRIBUTE_DESCRIPTION = IRI.create(Consts.aml_pref + "hasDescription");
//	
//	public static final IRI HAS_NAME = IRI.create(Consts.aml_pref + "hasName");
//	
//	public static final IRI HAS_NAME_ATTRIBUTE = IRI.create(Consts.aml_pref + "hasNameAttribute");
//	
//	public static final IRI HAS_NAME_FILE = IRI.create(Consts.aml_pref + "hasNameFile");
//	
//	public static final IRI HAS_NAME_IC = IRI.create(Consts.aml_pref + "hasNameIC");
//	
//	public static final IRI HAS_NAME_IE = IRI.create(Consts.aml_pref + "hasNameIE");
//	
//	public static final IRI HAS_NAME_IH = IRI.create(Consts.aml_pref + "hasNameIH");
//	
//	public static final IRI HAS_NAME_RC = IRI.create(Consts.aml_pref + "hasNameRC");
//	
//	public static final IRI HAS_NAME_SUC = IRI.create(Consts.aml_pref + "hasNameSUC");
//	
//	public static final IRI HAS_REF_BASE_ROLE_CLASS_PATH = IRI.create(Consts.aml_pref + "hasRefBaseRoleClassPath");
//	
//	public static final IRI HAS_SCHEMA_VERSION = IRI.create(Consts.aml_pref + "hasSchemaVersion");
//	
//	public static final IRI HAS_VERSION = IRI.create(Consts.aml_pref + "hasVersion");
//	
//	public static final IRI HAS_VERSION_SUC = IRI.create(Consts.aml_pref + "hasVersionSUC");
//	
//	public static final IRI HAS_VERSION_RCL = IRI.create(Consts.aml_pref + "hasVersionRCL");
//	
//	public static final IRI HAS_VERSION_ICL = IRI.create(Consts.aml_pref + "hasVersionICL");
//	
//	public static final IRI HAS_REF_BASE_CLASS_PATH = IRI.create(Consts.aml_pref + "hasRefBaseClassPath");
//	
//	public static final IRI HAS_REF_BASE_CLASS_PATH_IC = IRI.create(Consts.aml_pref + "hasRefBaseClassPathIC");
//	
//	public static final IRI HAS_REF_BASE_CLASS_PATH_RC = IRI.create(Consts.aml_pref + "hasRefBaseClassPathRC");
//	
//	public static final IRI HAS_REF_BASE_CLASS_PATH_SUC = IRI.create(Consts.aml_pref + "hasRefBaseClassPathSUC");
//		
//	public static final IRI HAS_REF_BASE_SU_PATH = IRI.create(Consts.aml_pref + "hasRefBaseSystemUnitPath");
//	
//	public static final IRI HAS_REF_BASE_RC_PATH = IRI.create(Consts.aml_pref + "hasRefRoleClassPath");
//	
//	// eClass relevant
//	
//	public static final IRI ECLASS_CLASSIFICATION_CLASS = IRI.create(Consts.aml_pref + "hasClassificationClass");
//	
//	public static final IRI ECLASS_IRDI = IRI.create(Consts.aml_pref + "hasIRDIeClass");
//	
//	public static final IRI ECLASS_VERSION = IRI.create(Consts.aml_pref + "hasVersionEClass");
//	
//	public static final IRI HAS_REF_SEMANTIC_ATTRIBUTE = IRI.create(Consts.aml_pref + "refSemanticAttribute");
		
	
	
	
	
	/**
	   The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	*/
	private AMLDataPropertyIRIs(){
		//this prevents even the native class from 
		//calling this ctor as well :
		throw new AssertionError();
	}


}
