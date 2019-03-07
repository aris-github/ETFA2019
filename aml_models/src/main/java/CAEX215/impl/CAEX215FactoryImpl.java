/**
 */
package CAEX215.impl;

import CAEX215.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CAEX215FactoryImpl extends EFactoryImpl implements CAEX215Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CAEX215Factory init() {
		try {
			CAEX215Factory theCAEX215Factory = (CAEX215Factory)EPackage.Registry.INSTANCE.getEFactory(CAEX215Package.eNS_URI);
			if (theCAEX215Factory != null) {
				return theCAEX215Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CAEX215FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAEX215FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE: return createAttributeNameMappingType();
			case CAEX215Package.ATTRIBUTE_TYPE: return createAttributeType();
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE: return createAttributeValueRequirementType();
			case CAEX215Package.CAEX_BASIC_OBJECT: return createCAEXBasicObject();
			case CAEX215Package.CAEX_FILE_TYPE: return createCAEXFileType();
			case CAEX215Package.CAEX_OBJECT: return createCAEXObject();
			case CAEX215Package.COPYRIGHT_TYPE: return createCopyrightType();
			case CAEX215Package.DESCRIPTION_TYPE: return createDescriptionType();
			case CAEX215Package.DOCUMENT_ROOT: return createDocumentRoot();
			case CAEX215Package.EXTERNAL_INTERFACE_TYPE: return createExternalInterfaceType();
			case CAEX215Package.EXTERNAL_REFERENCE_TYPE: return createExternalReferenceType();
			case CAEX215Package.INSTANCE_HIERARCHY_TYPE: return createInstanceHierarchyType();
			case CAEX215Package.INTERFACE_CLASS_LIB_TYPE: return createInterfaceClassLibType();
			case CAEX215Package.INTERFACE_CLASS_TYPE: return createInterfaceClassType();
			case CAEX215Package.INTERFACE_FAMILY_TYPE: return createInterfaceFamilyType();
			case CAEX215Package.INTERFACE_NAME_MAPPING_TYPE: return createInterfaceNameMappingType();
			case CAEX215Package.INTERNAL_ELEMENT_TYPE: return createInternalElementType();
			case CAEX215Package.INTERNAL_LINK_TYPE: return createInternalLinkType();
			case CAEX215Package.MAPPING_TYPE: return createMappingType();
			case CAEX215Package.NOMINAL_SCALED_TYPE_TYPE: return createNominalScaledTypeType();
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE: return createOrdinalScaledTypeType();
			case CAEX215Package.REF_SEMANTIC_TYPE: return createRefSemanticType();
			case CAEX215Package.ROLE_CLASS_LIB_TYPE: return createRoleClassLibType();
			case CAEX215Package.ROLE_CLASS_TYPE: return createRoleClassType();
			case CAEX215Package.ROLE_FAMILY_TYPE: return createRoleFamilyType();
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE: return createRoleRequirementsType();
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE: return createSupportedRoleClassType();
			case CAEX215Package.SYSTEM_UNIT_CLASS_LIB_TYPE: return createSystemUnitClassLibType();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE: return createSystemUnitClassType();
			case CAEX215Package.SYSTEM_UNIT_FAMILY_TYPE: return createSystemUnitFamilyType();
			case CAEX215Package.UNKNOWN_TYPE_TYPE: return createUnknownTypeType();
			case CAEX215Package.VERSION_TYPE: return createVersionType();
			case CAEX215Package.REVISION_TYPE: return createRevisionType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CAEX215Package.CHANGE_MODE:
				return createChangeModeFromString(eDataType, initialValue);
			case CAEX215Package.ATTRIBUTE_DATA_TYPE_TYPE:
				return createAttributeDataTypeTypeFromString(eDataType, initialValue);
			case CAEX215Package.CHANGE_MODE_OBJECT:
				return createChangeModeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CAEX215Package.CHANGE_MODE:
				return convertChangeModeToString(eDataType, instanceValue);
			case CAEX215Package.ATTRIBUTE_DATA_TYPE_TYPE:
				return convertAttributeDataTypeTypeToString(eDataType, instanceValue);
			case CAEX215Package.CHANGE_MODE_OBJECT:
				return convertChangeModeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeNameMappingType createAttributeNameMappingType() {
		AttributeNameMappingTypeImpl attributeNameMappingType = new AttributeNameMappingTypeImpl();
		return attributeNameMappingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeType createAttributeType() {
		AttributeTypeImpl attributeType = new AttributeTypeImpl();
		return attributeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueRequirementType createAttributeValueRequirementType() {
		AttributeValueRequirementTypeImpl attributeValueRequirementType = new AttributeValueRequirementTypeImpl();
		return attributeValueRequirementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAEXBasicObject createCAEXBasicObject() {
		CAEXBasicObjectImpl caexBasicObject = new CAEXBasicObjectImpl();
		return caexBasicObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAEXFileType createCAEXFileType() {
		CAEXFileTypeImpl caexFileType = new CAEXFileTypeImpl();
		return caexFileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAEXObject createCAEXObject() {
		CAEXObjectImpl caexObject = new CAEXObjectImpl();
		return caexObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopyrightType createCopyrightType() {
		CopyrightTypeImpl copyrightType = new CopyrightTypeImpl();
		return copyrightType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionType createDescriptionType() {
		DescriptionTypeImpl descriptionType = new DescriptionTypeImpl();
		return descriptionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalInterfaceType createExternalInterfaceType() {
		ExternalInterfaceTypeImpl externalInterfaceType = new ExternalInterfaceTypeImpl();
		return externalInterfaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalReferenceType createExternalReferenceType() {
		ExternalReferenceTypeImpl externalReferenceType = new ExternalReferenceTypeImpl();
		return externalReferenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceHierarchyType createInstanceHierarchyType() {
		InstanceHierarchyTypeImpl instanceHierarchyType = new InstanceHierarchyTypeImpl();
		return instanceHierarchyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceClassLibType createInterfaceClassLibType() {
		InterfaceClassLibTypeImpl interfaceClassLibType = new InterfaceClassLibTypeImpl();
		return interfaceClassLibType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceClassType createInterfaceClassType() {
		InterfaceClassTypeImpl interfaceClassType = new InterfaceClassTypeImpl();
		return interfaceClassType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceFamilyType createInterfaceFamilyType() {
		InterfaceFamilyTypeImpl interfaceFamilyType = new InterfaceFamilyTypeImpl();
		return interfaceFamilyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceNameMappingType createInterfaceNameMappingType() {
		InterfaceNameMappingTypeImpl interfaceNameMappingType = new InterfaceNameMappingTypeImpl();
		return interfaceNameMappingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalElementType createInternalElementType() {
		InternalElementTypeImpl internalElementType = new InternalElementTypeImpl();
		return internalElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalLinkType createInternalLinkType() {
		InternalLinkTypeImpl internalLinkType = new InternalLinkTypeImpl();
		return internalLinkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingType createMappingType() {
		MappingTypeImpl mappingType = new MappingTypeImpl();
		return mappingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NominalScaledTypeType createNominalScaledTypeType() {
		NominalScaledTypeTypeImpl nominalScaledTypeType = new NominalScaledTypeTypeImpl();
		return nominalScaledTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdinalScaledTypeType createOrdinalScaledTypeType() {
		OrdinalScaledTypeTypeImpl ordinalScaledTypeType = new OrdinalScaledTypeTypeImpl();
		return ordinalScaledTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefSemanticType createRefSemanticType() {
		RefSemanticTypeImpl refSemanticType = new RefSemanticTypeImpl();
		return refSemanticType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleClassLibType createRoleClassLibType() {
		RoleClassLibTypeImpl roleClassLibType = new RoleClassLibTypeImpl();
		return roleClassLibType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleClassType createRoleClassType() {
		RoleClassTypeImpl roleClassType = new RoleClassTypeImpl();
		return roleClassType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleFamilyType createRoleFamilyType() {
		RoleFamilyTypeImpl roleFamilyType = new RoleFamilyTypeImpl();
		return roleFamilyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleRequirementsType createRoleRequirementsType() {
		RoleRequirementsTypeImpl roleRequirementsType = new RoleRequirementsTypeImpl();
		return roleRequirementsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportedRoleClassType createSupportedRoleClassType() {
		SupportedRoleClassTypeImpl supportedRoleClassType = new SupportedRoleClassTypeImpl();
		return supportedRoleClassType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemUnitClassLibType createSystemUnitClassLibType() {
		SystemUnitClassLibTypeImpl systemUnitClassLibType = new SystemUnitClassLibTypeImpl();
		return systemUnitClassLibType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemUnitClassType createSystemUnitClassType() {
		SystemUnitClassTypeImpl systemUnitClassType = new SystemUnitClassTypeImpl();
		return systemUnitClassType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemUnitFamilyType createSystemUnitFamilyType() {
		SystemUnitFamilyTypeImpl systemUnitFamilyType = new SystemUnitFamilyTypeImpl();
		return systemUnitFamilyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownTypeType createUnknownTypeType() {
		UnknownTypeTypeImpl unknownTypeType = new UnknownTypeTypeImpl();
		return unknownTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionType createVersionType() {
		VersionTypeImpl versionType = new VersionTypeImpl();
		return versionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RevisionType createRevisionType() {
		RevisionTypeImpl revisionType = new RevisionTypeImpl();
		return revisionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeMode createChangeModeFromString(EDataType eDataType, String initialValue) {
		ChangeMode result = ChangeMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertChangeModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createAttributeDataTypeTypeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttributeDataTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeMode createChangeModeObjectFromString(EDataType eDataType, String initialValue) {
		return createChangeModeFromString(CAEX215Package.Literals.CHANGE_MODE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertChangeModeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertChangeModeToString(CAEX215Package.Literals.CHANGE_MODE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAEX215Package getCAEX215Package() {
		return (CAEX215Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CAEX215Package getPackage() {
		return CAEX215Package.eINSTANCE;
	}

} //CAEX215FactoryImpl
