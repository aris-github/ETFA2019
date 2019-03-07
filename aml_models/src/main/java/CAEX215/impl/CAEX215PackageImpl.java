/**
 */
package CAEX215.impl;

import CAEX215.AttributeNameMappingType;
import CAEX215.AttributeType;
import CAEX215.AttributeValueRequirementType;
import CAEX215.CAEX215Factory;
import CAEX215.CAEX215Package;
import CAEX215.CAEXBasicObject;
import CAEX215.CAEXFileType;
import CAEX215.CAEXObject;
import CAEX215.ChangeMode;
import CAEX215.CopyrightType;
import CAEX215.DescriptionType;
import CAEX215.DocumentRoot;
import CAEX215.ExternalInterfaceType;
import CAEX215.ExternalReferenceType;
import CAEX215.InstanceHierarchyType;
import CAEX215.InterfaceClassLibType;
import CAEX215.InterfaceClassType;
import CAEX215.InterfaceFamilyType;
import CAEX215.InterfaceNameMappingType;
import CAEX215.InternalElementType;
import CAEX215.InternalLinkType;
import CAEX215.MappingType;
import CAEX215.NominalScaledTypeType;
import CAEX215.OrdinalScaledTypeType;
import CAEX215.RefSemanticType;
import CAEX215.RevisionType;
import CAEX215.RoleClassLibType;
import CAEX215.RoleClassType;
import CAEX215.RoleFamilyType;
import CAEX215.RoleRequirementsType;
import CAEX215.SupportedRoleClassType;
import CAEX215.SystemUnitClassLibType;
import CAEX215.SystemUnitClassType;
import CAEX215.SystemUnitFamilyType;
import CAEX215.UnknownTypeType;
import CAEX215.VersionType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CAEX215PackageImpl extends EPackageImpl implements CAEX215Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeNameMappingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueRequirementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caexBasicObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caexFileTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caexObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copyrightTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalInterfaceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalReferenceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceHierarchyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceClassLibTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceClassTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceFamilyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceNameMappingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalLinkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nominalScaledTypeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ordinalScaledTypeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass refSemanticTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleClassLibTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleClassTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleFamilyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleRequirementsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supportedRoleClassTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemUnitClassLibTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemUnitClassTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemUnitFamilyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownTypeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum changeModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType attributeDataTypeTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType changeModeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see CAEX215.CAEX215Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CAEX215PackageImpl() {
		super(eNS_URI, CAEX215Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CAEX215Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CAEX215Package init() {
		if (isInited) return (CAEX215Package)EPackage.Registry.INSTANCE.getEPackage(CAEX215Package.eNS_URI);

		// Obtain or create and register package
		CAEX215PackageImpl theCAEX215Package = (CAEX215PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CAEX215PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CAEX215PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCAEX215Package.createPackageContents();

		// Initialize created meta-data
		theCAEX215Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCAEX215Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CAEX215Package.eNS_URI, theCAEX215Package);
		return theCAEX215Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeNameMappingType() {
		return attributeNameMappingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeNameMappingType_RoleAttributeName() {
		return (EAttribute)attributeNameMappingTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeNameMappingType_SystemUnitAttributeName() {
		return (EAttribute)attributeNameMappingTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeType() {
		return attributeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeType_DefaultValue() {
		return (EReference)attributeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeType_Value() {
		return (EReference)attributeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeType_RefSemantic() {
		return (EReference)attributeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeType_Constraint() {
		return (EReference)attributeTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeType_Attribute() {
		return (EReference)attributeTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeType_AttributeDataType() {
		return (EAttribute)attributeTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeType_Unit() {
		return (EAttribute)attributeTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueRequirementType() {
		return attributeValueRequirementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeValueRequirementType_OrdinalScaledType() {
		return (EReference)attributeValueRequirementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeValueRequirementType_NominalScaledType() {
		return (EReference)attributeValueRequirementTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeValueRequirementType_UnknownType() {
		return (EReference)attributeValueRequirementTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeValueRequirementType_Name() {
		return (EAttribute)attributeValueRequirementTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCAEXBasicObject() {
		return caexBasicObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXBasicObject_Description() {
		return (EReference)caexBasicObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXBasicObject_Version() {
		return (EReference)caexBasicObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXBasicObject_Copyright() {
		return (EReference)caexBasicObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXBasicObject_AdditionalInformation() {
		return (EReference)caexBasicObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCAEXBasicObject_ChangeMode() {
		return (EAttribute)caexBasicObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXBasicObject_Revision() {
		return (EReference)caexBasicObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCAEXFileType() {
		return caexFileTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXFileType_ExternalReference() {
		return (EReference)caexFileTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXFileType_InstanceHierarchy() {
		return (EReference)caexFileTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXFileType_InterfaceClassLib() {
		return (EReference)caexFileTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXFileType_RoleClassLib() {
		return (EReference)caexFileTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCAEXFileType_SystemUnitClassLib() {
		return (EReference)caexFileTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCAEXFileType_FileName() {
		return (EAttribute)caexFileTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCAEXFileType_SchemaVersion() {
		return (EAttribute)caexFileTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCAEXObject() {
		return caexObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCAEXObject_ID() {
		return (EAttribute)caexObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCAEXObject_Name() {
		return (EAttribute)caexObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopyrightType() {
		return copyrightTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopyrightType_Value() {
		return (EAttribute)copyrightTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopyrightType_ChangeMode() {
		return (EAttribute)copyrightTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionType() {
		return descriptionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptionType_Value() {
		return (EAttribute)descriptionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptionType_ChangeMode() {
		return (EAttribute)descriptionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CAEXFile() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalInterfaceType() {
		return externalInterfaceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalReferenceType() {
		return externalReferenceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalReferenceType_Alias() {
		return (EAttribute)externalReferenceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalReferenceType_Path() {
		return (EAttribute)externalReferenceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceHierarchyType() {
		return instanceHierarchyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceHierarchyType_InternalElement() {
		return (EReference)instanceHierarchyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceClassLibType() {
		return interfaceClassLibTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceClassLibType_InterfaceClass() {
		return (EReference)interfaceClassLibTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceClassType() {
		return interfaceClassTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceClassType_Attribute() {
		return (EReference)interfaceClassTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceClassType_RefBaseClassPath() {
		return (EAttribute)interfaceClassTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceFamilyType() {
		return interfaceFamilyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceFamilyType_InterfaceClass() {
		return (EReference)interfaceFamilyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceNameMappingType() {
		return interfaceNameMappingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceNameMappingType_RoleInterfaceName() {
		return (EAttribute)interfaceNameMappingTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceNameMappingType_SystemUnitInterfaceName() {
		return (EAttribute)interfaceNameMappingTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalElementType() {
		return internalElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalElementType_RoleRequirements() {
		return (EReference)internalElementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalElementType_MappingObject() {
		return (EReference)internalElementTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalElementType_RefBaseSystemUnitPath() {
		return (EAttribute)internalElementTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalLinkType() {
		return internalLinkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalLinkType_RefPartnerSideA() {
		return (EAttribute)internalLinkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalLinkType_RefPartnerSideB() {
		return (EAttribute)internalLinkTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingType() {
		return mappingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_AttributeNameMapping() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_InterfaceNameMapping() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNominalScaledTypeType() {
		return nominalScaledTypeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNominalScaledTypeType_RequiredValue() {
		return (EReference)nominalScaledTypeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrdinalScaledTypeType() {
		return ordinalScaledTypeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrdinalScaledTypeType_RequiredMaxValue() {
		return (EReference)ordinalScaledTypeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrdinalScaledTypeType_RequiredValue() {
		return (EReference)ordinalScaledTypeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrdinalScaledTypeType_RequiredMinValue() {
		return (EReference)ordinalScaledTypeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRefSemanticType() {
		return refSemanticTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRefSemanticType_CorrespondingAttributePath() {
		return (EAttribute)refSemanticTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleClassLibType() {
		return roleClassLibTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleClassLibType_RoleClass() {
		return (EReference)roleClassLibTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleClassType() {
		return roleClassTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleClassType_Attribute() {
		return (EReference)roleClassTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleClassType_ExternalInterface() {
		return (EReference)roleClassTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoleClassType_RefBaseClassPath() {
		return (EAttribute)roleClassTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleFamilyType() {
		return roleFamilyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleFamilyType_RoleClass() {
		return (EReference)roleFamilyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleRequirementsType() {
		return roleRequirementsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleRequirementsType_Attribute() {
		return (EReference)roleRequirementsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleRequirementsType_ExternalInterface() {
		return (EReference)roleRequirementsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoleRequirementsType_RefBaseRoleClassPath() {
		return (EAttribute)roleRequirementsTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupportedRoleClassType() {
		return supportedRoleClassTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSupportedRoleClassType_MappingObject() {
		return (EReference)supportedRoleClassTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSupportedRoleClassType_RefRoleClassPath() {
		return (EAttribute)supportedRoleClassTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemUnitClassLibType() {
		return systemUnitClassLibTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUnitClassLibType_SystemUnitClass() {
		return (EReference)systemUnitClassLibTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemUnitClassType() {
		return systemUnitClassTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUnitClassType_Attribute() {
		return (EReference)systemUnitClassTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUnitClassType_ExternalInterface() {
		return (EReference)systemUnitClassTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUnitClassType_InternalElement() {
		return (EReference)systemUnitClassTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUnitClassType_SupportedRoleClass() {
		return (EReference)systemUnitClassTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUnitClassType_InternalLink() {
		return (EReference)systemUnitClassTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemUnitFamilyType() {
		return systemUnitFamilyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemUnitFamilyType_SystemUnitClass() {
		return (EReference)systemUnitFamilyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemUnitFamilyType_RefBaseClassPath() {
		return (EAttribute)systemUnitFamilyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnknownTypeType() {
		return unknownTypeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnknownTypeType_Requirements() {
		return (EAttribute)unknownTypeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionType() {
		return versionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionType_Value() {
		return (EAttribute)versionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionType_ChangeMode() {
		return (EAttribute)versionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionType() {
		return revisionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionType_RevisionDate() {
		return (EAttribute)revisionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionType_OldVersion() {
		return (EAttribute)revisionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionType_NewVersion() {
		return (EAttribute)revisionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionType_AuthorName() {
		return (EAttribute)revisionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionType_Comment() {
		return (EAttribute)revisionTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getChangeMode() {
		return changeModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAttributeDataTypeType() {
		return attributeDataTypeTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getChangeModeObject() {
		return changeModeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAEX215Factory getCAEX215Factory() {
		return (CAEX215Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		attributeNameMappingTypeEClass = createEClass(ATTRIBUTE_NAME_MAPPING_TYPE);
		createEAttribute(attributeNameMappingTypeEClass, ATTRIBUTE_NAME_MAPPING_TYPE__ROLE_ATTRIBUTE_NAME);
		createEAttribute(attributeNameMappingTypeEClass, ATTRIBUTE_NAME_MAPPING_TYPE__SYSTEM_UNIT_ATTRIBUTE_NAME);

		attributeTypeEClass = createEClass(ATTRIBUTE_TYPE);
		createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__DEFAULT_VALUE);
		createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__VALUE);
		createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__REF_SEMANTIC);
		createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__CONSTRAINT);
		createEReference(attributeTypeEClass, ATTRIBUTE_TYPE__ATTRIBUTE);
		createEAttribute(attributeTypeEClass, ATTRIBUTE_TYPE__ATTRIBUTE_DATA_TYPE);
		createEAttribute(attributeTypeEClass, ATTRIBUTE_TYPE__UNIT);

		attributeValueRequirementTypeEClass = createEClass(ATTRIBUTE_VALUE_REQUIREMENT_TYPE);
		createEReference(attributeValueRequirementTypeEClass, ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE);
		createEReference(attributeValueRequirementTypeEClass, ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE);
		createEReference(attributeValueRequirementTypeEClass, ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE);
		createEAttribute(attributeValueRequirementTypeEClass, ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NAME);

		caexBasicObjectEClass = createEClass(CAEX_BASIC_OBJECT);
		createEReference(caexBasicObjectEClass, CAEX_BASIC_OBJECT__DESCRIPTION);
		createEReference(caexBasicObjectEClass, CAEX_BASIC_OBJECT__VERSION);
		createEReference(caexBasicObjectEClass, CAEX_BASIC_OBJECT__COPYRIGHT);
		createEReference(caexBasicObjectEClass, CAEX_BASIC_OBJECT__ADDITIONAL_INFORMATION);
		createEAttribute(caexBasicObjectEClass, CAEX_BASIC_OBJECT__CHANGE_MODE);
		createEReference(caexBasicObjectEClass, CAEX_BASIC_OBJECT__REVISION);

		caexFileTypeEClass = createEClass(CAEX_FILE_TYPE);
		createEReference(caexFileTypeEClass, CAEX_FILE_TYPE__EXTERNAL_REFERENCE);
		createEReference(caexFileTypeEClass, CAEX_FILE_TYPE__INSTANCE_HIERARCHY);
		createEReference(caexFileTypeEClass, CAEX_FILE_TYPE__INTERFACE_CLASS_LIB);
		createEReference(caexFileTypeEClass, CAEX_FILE_TYPE__ROLE_CLASS_LIB);
		createEReference(caexFileTypeEClass, CAEX_FILE_TYPE__SYSTEM_UNIT_CLASS_LIB);
		createEAttribute(caexFileTypeEClass, CAEX_FILE_TYPE__FILE_NAME);
		createEAttribute(caexFileTypeEClass, CAEX_FILE_TYPE__SCHEMA_VERSION);

		caexObjectEClass = createEClass(CAEX_OBJECT);
		createEAttribute(caexObjectEClass, CAEX_OBJECT__ID);
		createEAttribute(caexObjectEClass, CAEX_OBJECT__NAME);

		copyrightTypeEClass = createEClass(COPYRIGHT_TYPE);
		createEAttribute(copyrightTypeEClass, COPYRIGHT_TYPE__VALUE);
		createEAttribute(copyrightTypeEClass, COPYRIGHT_TYPE__CHANGE_MODE);

		descriptionTypeEClass = createEClass(DESCRIPTION_TYPE);
		createEAttribute(descriptionTypeEClass, DESCRIPTION_TYPE__VALUE);
		createEAttribute(descriptionTypeEClass, DESCRIPTION_TYPE__CHANGE_MODE);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CAEX_FILE);

		externalInterfaceTypeEClass = createEClass(EXTERNAL_INTERFACE_TYPE);

		externalReferenceTypeEClass = createEClass(EXTERNAL_REFERENCE_TYPE);
		createEAttribute(externalReferenceTypeEClass, EXTERNAL_REFERENCE_TYPE__ALIAS);
		createEAttribute(externalReferenceTypeEClass, EXTERNAL_REFERENCE_TYPE__PATH);

		instanceHierarchyTypeEClass = createEClass(INSTANCE_HIERARCHY_TYPE);
		createEReference(instanceHierarchyTypeEClass, INSTANCE_HIERARCHY_TYPE__INTERNAL_ELEMENT);

		interfaceClassLibTypeEClass = createEClass(INTERFACE_CLASS_LIB_TYPE);
		createEReference(interfaceClassLibTypeEClass, INTERFACE_CLASS_LIB_TYPE__INTERFACE_CLASS);

		interfaceClassTypeEClass = createEClass(INTERFACE_CLASS_TYPE);
		createEReference(interfaceClassTypeEClass, INTERFACE_CLASS_TYPE__ATTRIBUTE);
		createEAttribute(interfaceClassTypeEClass, INTERFACE_CLASS_TYPE__REF_BASE_CLASS_PATH);

		interfaceFamilyTypeEClass = createEClass(INTERFACE_FAMILY_TYPE);
		createEReference(interfaceFamilyTypeEClass, INTERFACE_FAMILY_TYPE__INTERFACE_CLASS);

		interfaceNameMappingTypeEClass = createEClass(INTERFACE_NAME_MAPPING_TYPE);
		createEAttribute(interfaceNameMappingTypeEClass, INTERFACE_NAME_MAPPING_TYPE__ROLE_INTERFACE_NAME);
		createEAttribute(interfaceNameMappingTypeEClass, INTERFACE_NAME_MAPPING_TYPE__SYSTEM_UNIT_INTERFACE_NAME);

		internalElementTypeEClass = createEClass(INTERNAL_ELEMENT_TYPE);
		createEReference(internalElementTypeEClass, INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS);
		createEReference(internalElementTypeEClass, INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT);
		createEAttribute(internalElementTypeEClass, INTERNAL_ELEMENT_TYPE__REF_BASE_SYSTEM_UNIT_PATH);

		internalLinkTypeEClass = createEClass(INTERNAL_LINK_TYPE);
		createEAttribute(internalLinkTypeEClass, INTERNAL_LINK_TYPE__REF_PARTNER_SIDE_A);
		createEAttribute(internalLinkTypeEClass, INTERNAL_LINK_TYPE__REF_PARTNER_SIDE_B);

		mappingTypeEClass = createEClass(MAPPING_TYPE);
		createEReference(mappingTypeEClass, MAPPING_TYPE__ATTRIBUTE_NAME_MAPPING);
		createEReference(mappingTypeEClass, MAPPING_TYPE__INTERFACE_NAME_MAPPING);

		nominalScaledTypeTypeEClass = createEClass(NOMINAL_SCALED_TYPE_TYPE);
		createEReference(nominalScaledTypeTypeEClass, NOMINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE);

		ordinalScaledTypeTypeEClass = createEClass(ORDINAL_SCALED_TYPE_TYPE);
		createEReference(ordinalScaledTypeTypeEClass, ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE);
		createEReference(ordinalScaledTypeTypeEClass, ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE);
		createEReference(ordinalScaledTypeTypeEClass, ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE);

		refSemanticTypeEClass = createEClass(REF_SEMANTIC_TYPE);
		createEAttribute(refSemanticTypeEClass, REF_SEMANTIC_TYPE__CORRESPONDING_ATTRIBUTE_PATH);

		roleClassLibTypeEClass = createEClass(ROLE_CLASS_LIB_TYPE);
		createEReference(roleClassLibTypeEClass, ROLE_CLASS_LIB_TYPE__ROLE_CLASS);

		roleClassTypeEClass = createEClass(ROLE_CLASS_TYPE);
		createEReference(roleClassTypeEClass, ROLE_CLASS_TYPE__ATTRIBUTE);
		createEReference(roleClassTypeEClass, ROLE_CLASS_TYPE__EXTERNAL_INTERFACE);
		createEAttribute(roleClassTypeEClass, ROLE_CLASS_TYPE__REF_BASE_CLASS_PATH);

		roleFamilyTypeEClass = createEClass(ROLE_FAMILY_TYPE);
		createEReference(roleFamilyTypeEClass, ROLE_FAMILY_TYPE__ROLE_CLASS);

		roleRequirementsTypeEClass = createEClass(ROLE_REQUIREMENTS_TYPE);
		createEReference(roleRequirementsTypeEClass, ROLE_REQUIREMENTS_TYPE__ATTRIBUTE);
		createEReference(roleRequirementsTypeEClass, ROLE_REQUIREMENTS_TYPE__EXTERNAL_INTERFACE);
		createEAttribute(roleRequirementsTypeEClass, ROLE_REQUIREMENTS_TYPE__REF_BASE_ROLE_CLASS_PATH);

		supportedRoleClassTypeEClass = createEClass(SUPPORTED_ROLE_CLASS_TYPE);
		createEReference(supportedRoleClassTypeEClass, SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT);
		createEAttribute(supportedRoleClassTypeEClass, SUPPORTED_ROLE_CLASS_TYPE__REF_ROLE_CLASS_PATH);

		systemUnitClassLibTypeEClass = createEClass(SYSTEM_UNIT_CLASS_LIB_TYPE);
		createEReference(systemUnitClassLibTypeEClass, SYSTEM_UNIT_CLASS_LIB_TYPE__SYSTEM_UNIT_CLASS);

		systemUnitClassTypeEClass = createEClass(SYSTEM_UNIT_CLASS_TYPE);
		createEReference(systemUnitClassTypeEClass, SYSTEM_UNIT_CLASS_TYPE__ATTRIBUTE);
		createEReference(systemUnitClassTypeEClass, SYSTEM_UNIT_CLASS_TYPE__EXTERNAL_INTERFACE);
		createEReference(systemUnitClassTypeEClass, SYSTEM_UNIT_CLASS_TYPE__INTERNAL_ELEMENT);
		createEReference(systemUnitClassTypeEClass, SYSTEM_UNIT_CLASS_TYPE__SUPPORTED_ROLE_CLASS);
		createEReference(systemUnitClassTypeEClass, SYSTEM_UNIT_CLASS_TYPE__INTERNAL_LINK);

		systemUnitFamilyTypeEClass = createEClass(SYSTEM_UNIT_FAMILY_TYPE);
		createEReference(systemUnitFamilyTypeEClass, SYSTEM_UNIT_FAMILY_TYPE__SYSTEM_UNIT_CLASS);
		createEAttribute(systemUnitFamilyTypeEClass, SYSTEM_UNIT_FAMILY_TYPE__REF_BASE_CLASS_PATH);

		unknownTypeTypeEClass = createEClass(UNKNOWN_TYPE_TYPE);
		createEAttribute(unknownTypeTypeEClass, UNKNOWN_TYPE_TYPE__REQUIREMENTS);

		versionTypeEClass = createEClass(VERSION_TYPE);
		createEAttribute(versionTypeEClass, VERSION_TYPE__VALUE);
		createEAttribute(versionTypeEClass, VERSION_TYPE__CHANGE_MODE);

		revisionTypeEClass = createEClass(REVISION_TYPE);
		createEAttribute(revisionTypeEClass, REVISION_TYPE__REVISION_DATE);
		createEAttribute(revisionTypeEClass, REVISION_TYPE__OLD_VERSION);
		createEAttribute(revisionTypeEClass, REVISION_TYPE__NEW_VERSION);
		createEAttribute(revisionTypeEClass, REVISION_TYPE__AUTHOR_NAME);
		createEAttribute(revisionTypeEClass, REVISION_TYPE__COMMENT);

		// Create enums
		changeModeEEnum = createEEnum(CHANGE_MODE);

		// Create data types
		attributeDataTypeTypeEDataType = createEDataType(ATTRIBUTE_DATA_TYPE_TYPE);
		changeModeObjectEDataType = createEDataType(CHANGE_MODE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		attributeNameMappingTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		attributeTypeEClass.getESuperTypes().add(this.getCAEXObject());
		attributeValueRequirementTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		caexFileTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		caexObjectEClass.getESuperTypes().add(this.getCAEXBasicObject());
		externalInterfaceTypeEClass.getESuperTypes().add(this.getInterfaceClassType());
		externalReferenceTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		instanceHierarchyTypeEClass.getESuperTypes().add(this.getCAEXObject());
		interfaceClassLibTypeEClass.getESuperTypes().add(this.getCAEXObject());
		interfaceClassTypeEClass.getESuperTypes().add(this.getCAEXObject());
		interfaceFamilyTypeEClass.getESuperTypes().add(this.getInterfaceClassType());
		interfaceNameMappingTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		internalElementTypeEClass.getESuperTypes().add(this.getSystemUnitClassType());
		internalLinkTypeEClass.getESuperTypes().add(this.getCAEXObject());
		mappingTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		refSemanticTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		roleClassLibTypeEClass.getESuperTypes().add(this.getCAEXObject());
		roleClassTypeEClass.getESuperTypes().add(this.getCAEXObject());
		roleFamilyTypeEClass.getESuperTypes().add(this.getRoleClassType());
		roleRequirementsTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		supportedRoleClassTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());
		systemUnitClassLibTypeEClass.getESuperTypes().add(this.getCAEXObject());
		systemUnitClassTypeEClass.getESuperTypes().add(this.getCAEXObject());
		systemUnitFamilyTypeEClass.getESuperTypes().add(this.getSystemUnitClassType());
		revisionTypeEClass.getESuperTypes().add(this.getCAEXBasicObject());

		// Initialize classes, features, and operations; add parameters
		initEClass(attributeNameMappingTypeEClass, AttributeNameMappingType.class, "AttributeNameMappingType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeNameMappingType_RoleAttributeName(), theXMLTypePackage.getString(), "roleAttributeName", null, 1, 1, AttributeNameMappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeNameMappingType_SystemUnitAttributeName(), theXMLTypePackage.getString(), "systemUnitAttributeName", null, 1, 1, AttributeNameMappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeTypeEClass, AttributeType.class, "AttributeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeType_DefaultValue(), theXMLTypePackage.getAnyType(), null, "defaultValue", null, 0, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeType_Value(), theXMLTypePackage.getAnyType(), null, "value", null, 0, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeType_RefSemantic(), this.getRefSemanticType(), null, "refSemantic", null, 0, -1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeType_Constraint(), this.getAttributeValueRequirementType(), null, "constraint", null, 0, -1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeType_AttributeDataType(), this.getAttributeDataTypeType(), "attributeDataType", null, 0, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeType_Unit(), theXMLTypePackage.getString(), "unit", null, 0, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeValueRequirementTypeEClass, AttributeValueRequirementType.class, "AttributeValueRequirementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeValueRequirementType_OrdinalScaledType(), this.getOrdinalScaledTypeType(), null, "ordinalScaledType", null, 0, 1, AttributeValueRequirementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeValueRequirementType_NominalScaledType(), this.getNominalScaledTypeType(), null, "nominalScaledType", null, 0, 1, AttributeValueRequirementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeValueRequirementType_UnknownType(), this.getUnknownTypeType(), null, "unknownType", null, 0, 1, AttributeValueRequirementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeValueRequirementType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, AttributeValueRequirementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caexBasicObjectEClass, CAEXBasicObject.class, "CAEXBasicObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCAEXBasicObject_Description(), this.getDescriptionType(), null, "description", null, 0, 1, CAEXBasicObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAEXBasicObject_Version(), this.getVersionType(), null, "version", null, 0, 1, CAEXBasicObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAEXBasicObject_Copyright(), this.getCopyrightType(), null, "copyright", null, 0, 1, CAEXBasicObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAEXBasicObject_AdditionalInformation(), theXMLTypePackage.getAnyType(), null, "additionalInformation", null, 0, -1, CAEXBasicObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCAEXBasicObject_ChangeMode(), this.getChangeMode(), "changeMode", "state", 0, 1, CAEXBasicObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAEXBasicObject_Revision(), this.getRevisionType(), null, "revision", null, 0, -1, CAEXBasicObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caexFileTypeEClass, CAEXFileType.class, "CAEXFileType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCAEXFileType_ExternalReference(), this.getExternalReferenceType(), null, "externalReference", null, 0, -1, CAEXFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAEXFileType_InstanceHierarchy(), this.getInstanceHierarchyType(), null, "instanceHierarchy", null, 0, -1, CAEXFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAEXFileType_InterfaceClassLib(), this.getInterfaceClassLibType(), null, "interfaceClassLib", null, 0, -1, CAEXFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAEXFileType_RoleClassLib(), this.getRoleClassLibType(), null, "roleClassLib", null, 0, -1, CAEXFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAEXFileType_SystemUnitClassLib(), this.getSystemUnitClassLibType(), null, "systemUnitClassLib", null, 0, -1, CAEXFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCAEXFileType_FileName(), theXMLTypePackage.getString(), "fileName", null, 1, 1, CAEXFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCAEXFileType_SchemaVersion(), theXMLTypePackage.getString(), "schemaVersion", "2.15", 1, 1, CAEXFileType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caexObjectEClass, CAEXObject.class, "CAEXObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCAEXObject_ID(), theXMLTypePackage.getString(), "iD", null, 0, 1, CAEXObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCAEXObject_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, CAEXObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(copyrightTypeEClass, CopyrightType.class, "CopyrightType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCopyrightType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, CopyrightType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyrightType_ChangeMode(), this.getChangeMode(), "changeMode", "state", 0, 1, CopyrightType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionTypeEClass, DescriptionType.class, "DescriptionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptionType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, DescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDescriptionType_ChangeMode(), this.getChangeMode(), "changeMode", "state", 0, 1, DescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CAEXFile(), this.getCAEXFileType(), null, "cAEXFile", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(externalInterfaceTypeEClass, ExternalInterfaceType.class, "ExternalInterfaceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalReferenceTypeEClass, ExternalReferenceType.class, "ExternalReferenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalReferenceType_Alias(), theXMLTypePackage.getString(), "alias", null, 1, 1, ExternalReferenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExternalReferenceType_Path(), theXMLTypePackage.getString(), "path", null, 1, 1, ExternalReferenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instanceHierarchyTypeEClass, InstanceHierarchyType.class, "InstanceHierarchyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceHierarchyType_InternalElement(), this.getInternalElementType(), null, "internalElement", null, 0, -1, InstanceHierarchyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceClassLibTypeEClass, InterfaceClassLibType.class, "InterfaceClassLibType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceClassLibType_InterfaceClass(), this.getInterfaceFamilyType(), null, "interfaceClass", null, 0, -1, InterfaceClassLibType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceClassTypeEClass, InterfaceClassType.class, "InterfaceClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceClassType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, InterfaceClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceClassType_RefBaseClassPath(), theXMLTypePackage.getString(), "refBaseClassPath", null, 0, 1, InterfaceClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceFamilyTypeEClass, InterfaceFamilyType.class, "InterfaceFamilyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceFamilyType_InterfaceClass(), this.getInterfaceFamilyType(), null, "interfaceClass", null, 0, -1, InterfaceFamilyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceNameMappingTypeEClass, InterfaceNameMappingType.class, "InterfaceNameMappingType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterfaceNameMappingType_RoleInterfaceName(), theXMLTypePackage.getString(), "roleInterfaceName", null, 1, 1, InterfaceNameMappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceNameMappingType_SystemUnitInterfaceName(), theXMLTypePackage.getString(), "systemUnitInterfaceName", null, 1, 1, InterfaceNameMappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalElementTypeEClass, InternalElementType.class, "InternalElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalElementType_RoleRequirements(), this.getRoleRequirementsType(), null, "roleRequirements", null, 0, 1, InternalElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInternalElementType_MappingObject(), this.getMappingType(), null, "mappingObject", null, 0, 1, InternalElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInternalElementType_RefBaseSystemUnitPath(), theXMLTypePackage.getString(), "refBaseSystemUnitPath", null, 0, 1, InternalElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalLinkTypeEClass, InternalLinkType.class, "InternalLinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInternalLinkType_RefPartnerSideA(), theXMLTypePackage.getString(), "refPartnerSideA", null, 0, 1, InternalLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInternalLinkType_RefPartnerSideB(), theXMLTypePackage.getString(), "refPartnerSideB", null, 0, 1, InternalLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingTypeEClass, MappingType.class, "MappingType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingType_AttributeNameMapping(), this.getAttributeNameMappingType(), null, "attributeNameMapping", null, 0, -1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingType_InterfaceNameMapping(), this.getInterfaceNameMappingType(), null, "interfaceNameMapping", null, 0, -1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nominalScaledTypeTypeEClass, NominalScaledTypeType.class, "NominalScaledTypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNominalScaledTypeType_RequiredValue(), theXMLTypePackage.getAnyType(), null, "requiredValue", null, 0, -1, NominalScaledTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ordinalScaledTypeTypeEClass, OrdinalScaledTypeType.class, "OrdinalScaledTypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrdinalScaledTypeType_RequiredMaxValue(), theXMLTypePackage.getAnyType(), null, "requiredMaxValue", null, 0, 1, OrdinalScaledTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrdinalScaledTypeType_RequiredValue(), theXMLTypePackage.getAnyType(), null, "requiredValue", null, 0, 1, OrdinalScaledTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrdinalScaledTypeType_RequiredMinValue(), theXMLTypePackage.getAnyType(), null, "requiredMinValue", null, 0, 1, OrdinalScaledTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(refSemanticTypeEClass, RefSemanticType.class, "RefSemanticType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRefSemanticType_CorrespondingAttributePath(), theXMLTypePackage.getString(), "correspondingAttributePath", null, 1, 1, RefSemanticType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleClassLibTypeEClass, RoleClassLibType.class, "RoleClassLibType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleClassLibType_RoleClass(), this.getRoleFamilyType(), null, "roleClass", null, 0, -1, RoleClassLibType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleClassTypeEClass, RoleClassType.class, "RoleClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleClassType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, RoleClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleClassType_ExternalInterface(), this.getExternalInterfaceType(), null, "externalInterface", null, 0, -1, RoleClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoleClassType_RefBaseClassPath(), theXMLTypePackage.getString(), "refBaseClassPath", null, 0, 1, RoleClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleFamilyTypeEClass, RoleFamilyType.class, "RoleFamilyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleFamilyType_RoleClass(), this.getRoleFamilyType(), null, "roleClass", null, 0, -1, RoleFamilyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleRequirementsTypeEClass, RoleRequirementsType.class, "RoleRequirementsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleRequirementsType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, RoleRequirementsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoleRequirementsType_ExternalInterface(), this.getExternalInterfaceType(), null, "externalInterface", null, 0, -1, RoleRequirementsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoleRequirementsType_RefBaseRoleClassPath(), theXMLTypePackage.getString(), "refBaseRoleClassPath", null, 0, 1, RoleRequirementsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supportedRoleClassTypeEClass, SupportedRoleClassType.class, "SupportedRoleClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSupportedRoleClassType_MappingObject(), this.getMappingType(), null, "mappingObject", null, 0, 1, SupportedRoleClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSupportedRoleClassType_RefRoleClassPath(), theXMLTypePackage.getString(), "refRoleClassPath", null, 1, 1, SupportedRoleClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemUnitClassLibTypeEClass, SystemUnitClassLibType.class, "SystemUnitClassLibType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemUnitClassLibType_SystemUnitClass(), this.getSystemUnitFamilyType(), null, "systemUnitClass", null, 0, -1, SystemUnitClassLibType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemUnitClassTypeEClass, SystemUnitClassType.class, "SystemUnitClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemUnitClassType_Attribute(), this.getAttributeType(), null, "attribute", null, 0, -1, SystemUnitClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemUnitClassType_ExternalInterface(), this.getExternalInterfaceType(), null, "externalInterface", null, 0, -1, SystemUnitClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemUnitClassType_InternalElement(), this.getInternalElementType(), null, "internalElement", null, 0, -1, SystemUnitClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemUnitClassType_SupportedRoleClass(), this.getSupportedRoleClassType(), null, "supportedRoleClass", null, 0, -1, SystemUnitClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemUnitClassType_InternalLink(), this.getInternalLinkType(), null, "internalLink", null, 0, -1, SystemUnitClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemUnitFamilyTypeEClass, SystemUnitFamilyType.class, "SystemUnitFamilyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemUnitFamilyType_SystemUnitClass(), this.getSystemUnitFamilyType(), null, "systemUnitClass", null, 0, -1, SystemUnitFamilyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemUnitFamilyType_RefBaseClassPath(), theXMLTypePackage.getString(), "refBaseClassPath", null, 0, 1, SystemUnitFamilyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unknownTypeTypeEClass, UnknownTypeType.class, "UnknownTypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnknownTypeType_Requirements(), theXMLTypePackage.getString(), "requirements", null, 0, 1, UnknownTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionTypeEClass, VersionType.class, "VersionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, VersionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionType_ChangeMode(), this.getChangeMode(), "changeMode", "state", 0, 1, VersionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revisionTypeEClass, RevisionType.class, "RevisionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRevisionType_RevisionDate(), theXMLTypePackage.getDateTime(), "revisionDate", null, 1, 1, RevisionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevisionType_OldVersion(), theXMLTypePackage.getString(), "oldVersion", "", 0, 1, RevisionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevisionType_NewVersion(), theXMLTypePackage.getString(), "newVersion", "", 0, 1, RevisionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevisionType_AuthorName(), theXMLTypePackage.getString(), "authorName", null, 1, 1, RevisionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevisionType_Comment(), theXMLTypePackage.getString(), "comment", null, 0, 1, RevisionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(changeModeEEnum, ChangeMode.class, "ChangeMode");
		addEEnumLiteral(changeModeEEnum, ChangeMode.STATE);
		addEEnumLiteral(changeModeEEnum, ChangeMode.CREATE);
		addEEnumLiteral(changeModeEEnum, ChangeMode.DELETE);
		addEEnumLiteral(changeModeEEnum, ChangeMode.CHANGE);

		// Initialize data types
		initEDataType(attributeDataTypeTypeEDataType, String.class, "AttributeDataTypeType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(changeModeObjectEDataType, ChangeMode.class, "ChangeModeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "qualified", "false"
		   });	
		addAnnotation
		  (attributeDataTypeTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "AttributeDataType_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });	
		addAnnotation
		  (attributeNameMappingTypeEClass, 
		   source, 
		   new String[] {
			 "name", "AttributeNameMapping_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getAttributeNameMappingType_RoleAttributeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RoleAttributeName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeNameMappingType_SystemUnitAttributeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SystemUnitAttributeName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (attributeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "AttributeType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getAttributeType_DefaultValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DefaultValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeType_Value(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Value",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeType_RefSemantic(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RefSemantic",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeType_Constraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Constraint",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeType_Attribute(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Attribute",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeType_AttributeDataType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "AttributeDataType",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeType_Unit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Unit",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (attributeValueRequirementTypeEClass, 
		   source, 
		   new String[] {
			 "name", "AttributeValueRequirementType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getAttributeValueRequirementType_OrdinalScaledType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "OrdinalScaledType",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeValueRequirementType_NominalScaledType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NominalScaledType",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeValueRequirementType_UnknownType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "UnknownType",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getAttributeValueRequirementType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (caexBasicObjectEClass, 
		   source, 
		   new String[] {
			 "name", "CAEXBasicObject",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getCAEXBasicObject_Description(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Description",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXBasicObject_Version(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Version",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXBasicObject_Copyright(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Copyright",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXBasicObject_AdditionalInformation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AdditionalInformation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXBasicObject_ChangeMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ChangeMode",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (caexFileTypeEClass, 
		   source, 
		   new String[] {
			 "name", "CAEXFile_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getCAEXFileType_ExternalReference(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExternalReference",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXFileType_InstanceHierarchy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InstanceHierarchy",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXFileType_InterfaceClassLib(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InterfaceClassLib",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXFileType_RoleClassLib(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RoleClassLib",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXFileType_SystemUnitClassLib(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SystemUnitClassLib",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXFileType_FileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "FileName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXFileType_SchemaVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SchemaVersion",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (caexObjectEClass, 
		   source, 
		   new String[] {
			 "name", "CAEXObject",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getCAEXObject_ID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ID",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getCAEXObject_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (changeModeEEnum, 
		   source, 
		   new String[] {
			 "name", "ChangeMode"
		   });	
		addAnnotation
		  (changeModeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ChangeMode:Object",
			 "baseType", "ChangeMode"
		   });	
		addAnnotation
		  (copyrightTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Copyright_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getCopyrightType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getCopyrightType_ChangeMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ChangeMode",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (descriptionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Description_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getDescriptionType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getDescriptionType_ChangeMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ChangeMode",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });	
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });	
		addAnnotation
		  (getDocumentRoot_CAEXFile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CAEXFile",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (externalInterfaceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ExternalInterface_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (externalReferenceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ExternalReference_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getExternalReferenceType_Alias(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Alias",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getExternalReferenceType_Path(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Path",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (instanceHierarchyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InstanceHierarchy_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInstanceHierarchyType_InternalElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InternalElement",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (interfaceClassLibTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceClassLib_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInterfaceClassLibType_InterfaceClass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InterfaceClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (interfaceClassTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceClassType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInterfaceClassType_Attribute(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Attribute",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getInterfaceClassType_RefBaseClassPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefBaseClassPath",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (interfaceFamilyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceFamilyType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInterfaceFamilyType_InterfaceClass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InterfaceClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (interfaceNameMappingTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InterfaceNameMapping_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInterfaceNameMappingType_RoleInterfaceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RoleInterfaceName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getInterfaceNameMappingType_SystemUnitInterfaceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SystemUnitInterfaceName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (internalElementTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InternalElementType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInternalElementType_RoleRequirements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RoleRequirements",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getInternalElementType_MappingObject(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MappingObject",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getInternalElementType_RefBaseSystemUnitPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefBaseSystemUnitPath",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (internalLinkTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InternalLink_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getInternalLinkType_RefPartnerSideA(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefPartnerSideA",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getInternalLinkType_RefPartnerSideB(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefPartnerSideB",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (mappingTypeEClass, 
		   source, 
		   new String[] {
			 "name", "MappingType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getMappingType_AttributeNameMapping(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AttributeNameMapping",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMappingType_InterfaceNameMapping(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InterfaceNameMapping",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (nominalScaledTypeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "NominalScaledType_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getNominalScaledTypeType_RequiredValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequiredValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (ordinalScaledTypeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "OrdinalScaledType_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getOrdinalScaledTypeType_RequiredMaxValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequiredMaxValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getOrdinalScaledTypeType_RequiredValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequiredValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getOrdinalScaledTypeType_RequiredMinValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RequiredMinValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (refSemanticTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RefSemantic_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRefSemanticType_CorrespondingAttributePath(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "CorrespondingAttributePath",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (roleClassLibTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RoleClassLib_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRoleClassLibType_RoleClass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RoleClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (roleClassTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RoleClassType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRoleClassType_Attribute(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Attribute",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRoleClassType_ExternalInterface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExternalInterface",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRoleClassType_RefBaseClassPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefBaseClassPath",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (roleFamilyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RoleFamilyType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRoleFamilyType_RoleClass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RoleClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (roleRequirementsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RoleRequirements_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRoleRequirementsType_Attribute(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Attribute",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRoleRequirementsType_ExternalInterface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExternalInterface",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRoleRequirementsType_RefBaseRoleClassPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefBaseRoleClassPath",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (supportedRoleClassTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SupportedRoleClass_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSupportedRoleClassType_MappingObject(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MappingObject",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSupportedRoleClassType_RefRoleClassPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefRoleClassPath",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (systemUnitClassLibTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SystemUnitClassLib_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSystemUnitClassLibType_SystemUnitClass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SystemUnitClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (systemUnitClassTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SystemUnitClassType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSystemUnitClassType_Attribute(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Attribute",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSystemUnitClassType_ExternalInterface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExternalInterface",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSystemUnitClassType_InternalElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InternalElement",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSystemUnitClassType_SupportedRoleClass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SupportedRoleClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSystemUnitClassType_InternalLink(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "InternalLink",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (systemUnitFamilyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SystemUnitFamilyType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSystemUnitFamilyType_SystemUnitClass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SystemUnitClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSystemUnitFamilyType_RefBaseClassPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefBaseClassPath",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (unknownTypeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "UnknownType_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getUnknownTypeType_Requirements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Requirements",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (versionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Version_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getVersionType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getVersionType_ChangeMode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ChangeMode",
			 "namespace", "##targetNamespace"
		   });
	}

} //CAEX215PackageImpl
