/**
 */
package CAEX215.util;

import CAEX215.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see CAEX215.CAEX215Package
 * @generated
 */
public class CAEX215AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CAEX215Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CAEX215AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CAEX215Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CAEX215Switch<Adapter> modelSwitch =
		new CAEX215Switch<Adapter>() {
			@Override
			public Adapter caseAttributeNameMappingType(AttributeNameMappingType object) {
				return createAttributeNameMappingTypeAdapter();
			}
			@Override
			public Adapter caseAttributeType(AttributeType object) {
				return createAttributeTypeAdapter();
			}
			@Override
			public Adapter caseAttributeValueRequirementType(AttributeValueRequirementType object) {
				return createAttributeValueRequirementTypeAdapter();
			}
			@Override
			public Adapter caseCAEXBasicObject(CAEXBasicObject object) {
				return createCAEXBasicObjectAdapter();
			}
			@Override
			public Adapter caseCAEXFileType(CAEXFileType object) {
				return createCAEXFileTypeAdapter();
			}
			@Override
			public Adapter caseCAEXObject(CAEXObject object) {
				return createCAEXObjectAdapter();
			}
			@Override
			public Adapter caseCopyrightType(CopyrightType object) {
				return createCopyrightTypeAdapter();
			}
			@Override
			public Adapter caseDescriptionType(DescriptionType object) {
				return createDescriptionTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseExternalInterfaceType(ExternalInterfaceType object) {
				return createExternalInterfaceTypeAdapter();
			}
			@Override
			public Adapter caseExternalReferenceType(ExternalReferenceType object) {
				return createExternalReferenceTypeAdapter();
			}
			@Override
			public Adapter caseInstanceHierarchyType(InstanceHierarchyType object) {
				return createInstanceHierarchyTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceClassLibType(InterfaceClassLibType object) {
				return createInterfaceClassLibTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceClassType(InterfaceClassType object) {
				return createInterfaceClassTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceFamilyType(InterfaceFamilyType object) {
				return createInterfaceFamilyTypeAdapter();
			}
			@Override
			public Adapter caseInterfaceNameMappingType(InterfaceNameMappingType object) {
				return createInterfaceNameMappingTypeAdapter();
			}
			@Override
			public Adapter caseInternalElementType(InternalElementType object) {
				return createInternalElementTypeAdapter();
			}
			@Override
			public Adapter caseInternalLinkType(InternalLinkType object) {
				return createInternalLinkTypeAdapter();
			}
			@Override
			public Adapter caseMappingType(MappingType object) {
				return createMappingTypeAdapter();
			}
			@Override
			public Adapter caseNominalScaledTypeType(NominalScaledTypeType object) {
				return createNominalScaledTypeTypeAdapter();
			}
			@Override
			public Adapter caseOrdinalScaledTypeType(OrdinalScaledTypeType object) {
				return createOrdinalScaledTypeTypeAdapter();
			}
			@Override
			public Adapter caseRefSemanticType(RefSemanticType object) {
				return createRefSemanticTypeAdapter();
			}
			@Override
			public Adapter caseRoleClassLibType(RoleClassLibType object) {
				return createRoleClassLibTypeAdapter();
			}
			@Override
			public Adapter caseRoleClassType(RoleClassType object) {
				return createRoleClassTypeAdapter();
			}
			@Override
			public Adapter caseRoleFamilyType(RoleFamilyType object) {
				return createRoleFamilyTypeAdapter();
			}
			@Override
			public Adapter caseRoleRequirementsType(RoleRequirementsType object) {
				return createRoleRequirementsTypeAdapter();
			}
			@Override
			public Adapter caseSupportedRoleClassType(SupportedRoleClassType object) {
				return createSupportedRoleClassTypeAdapter();
			}
			@Override
			public Adapter caseSystemUnitClassLibType(SystemUnitClassLibType object) {
				return createSystemUnitClassLibTypeAdapter();
			}
			@Override
			public Adapter caseSystemUnitClassType(SystemUnitClassType object) {
				return createSystemUnitClassTypeAdapter();
			}
			@Override
			public Adapter caseSystemUnitFamilyType(SystemUnitFamilyType object) {
				return createSystemUnitFamilyTypeAdapter();
			}
			@Override
			public Adapter caseUnknownTypeType(UnknownTypeType object) {
				return createUnknownTypeTypeAdapter();
			}
			@Override
			public Adapter caseVersionType(VersionType object) {
				return createVersionTypeAdapter();
			}
			@Override
			public Adapter caseRevisionType(RevisionType object) {
				return createRevisionTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.AttributeNameMappingType <em>Attribute Name Mapping Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.AttributeNameMappingType
	 * @generated
	 */
	public Adapter createAttributeNameMappingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.AttributeType <em>Attribute Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.AttributeType
	 * @generated
	 */
	public Adapter createAttributeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.AttributeValueRequirementType <em>Attribute Value Requirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.AttributeValueRequirementType
	 * @generated
	 */
	public Adapter createAttributeValueRequirementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.CAEXBasicObject <em>CAEX Basic Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.CAEXBasicObject
	 * @generated
	 */
	public Adapter createCAEXBasicObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.CAEXFileType <em>CAEX File Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.CAEXFileType
	 * @generated
	 */
	public Adapter createCAEXFileTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.CAEXObject <em>CAEX Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.CAEXObject
	 * @generated
	 */
	public Adapter createCAEXObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.CopyrightType <em>Copyright Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.CopyrightType
	 * @generated
	 */
	public Adapter createCopyrightTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.DescriptionType <em>Description Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.DescriptionType
	 * @generated
	 */
	public Adapter createDescriptionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.ExternalInterfaceType <em>External Interface Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.ExternalInterfaceType
	 * @generated
	 */
	public Adapter createExternalInterfaceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.ExternalReferenceType <em>External Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.ExternalReferenceType
	 * @generated
	 */
	public Adapter createExternalReferenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.InstanceHierarchyType <em>Instance Hierarchy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.InstanceHierarchyType
	 * @generated
	 */
	public Adapter createInstanceHierarchyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.InterfaceClassLibType <em>Interface Class Lib Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.InterfaceClassLibType
	 * @generated
	 */
	public Adapter createInterfaceClassLibTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.InterfaceClassType <em>Interface Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.InterfaceClassType
	 * @generated
	 */
	public Adapter createInterfaceClassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.InterfaceFamilyType <em>Interface Family Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.InterfaceFamilyType
	 * @generated
	 */
	public Adapter createInterfaceFamilyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.InterfaceNameMappingType <em>Interface Name Mapping Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.InterfaceNameMappingType
	 * @generated
	 */
	public Adapter createInterfaceNameMappingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.InternalElementType <em>Internal Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.InternalElementType
	 * @generated
	 */
	public Adapter createInternalElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.InternalLinkType <em>Internal Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.InternalLinkType
	 * @generated
	 */
	public Adapter createInternalLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.MappingType <em>Mapping Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.MappingType
	 * @generated
	 */
	public Adapter createMappingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.NominalScaledTypeType <em>Nominal Scaled Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.NominalScaledTypeType
	 * @generated
	 */
	public Adapter createNominalScaledTypeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.OrdinalScaledTypeType <em>Ordinal Scaled Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.OrdinalScaledTypeType
	 * @generated
	 */
	public Adapter createOrdinalScaledTypeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.RefSemanticType <em>Ref Semantic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.RefSemanticType
	 * @generated
	 */
	public Adapter createRefSemanticTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.RoleClassLibType <em>Role Class Lib Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.RoleClassLibType
	 * @generated
	 */
	public Adapter createRoleClassLibTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.RoleClassType <em>Role Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.RoleClassType
	 * @generated
	 */
	public Adapter createRoleClassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.RoleFamilyType <em>Role Family Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.RoleFamilyType
	 * @generated
	 */
	public Adapter createRoleFamilyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.RoleRequirementsType <em>Role Requirements Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.RoleRequirementsType
	 * @generated
	 */
	public Adapter createRoleRequirementsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.SupportedRoleClassType <em>Supported Role Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.SupportedRoleClassType
	 * @generated
	 */
	public Adapter createSupportedRoleClassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.SystemUnitClassLibType <em>System Unit Class Lib Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.SystemUnitClassLibType
	 * @generated
	 */
	public Adapter createSystemUnitClassLibTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.SystemUnitClassType <em>System Unit Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.SystemUnitClassType
	 * @generated
	 */
	public Adapter createSystemUnitClassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.SystemUnitFamilyType <em>System Unit Family Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.SystemUnitFamilyType
	 * @generated
	 */
	public Adapter createSystemUnitFamilyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.UnknownTypeType <em>Unknown Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.UnknownTypeType
	 * @generated
	 */
	public Adapter createUnknownTypeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.VersionType <em>Version Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.VersionType
	 * @generated
	 */
	public Adapter createVersionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link CAEX215.RevisionType <em>Revision Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see CAEX215.RevisionType
	 * @generated
	 */
	public Adapter createRevisionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CAEX215AdapterFactory
