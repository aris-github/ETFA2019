/**
 */
package CAEX215.impl;

import CAEX215.AttributeNameMappingType;
import CAEX215.CAEX215Package;
import CAEX215.InterfaceNameMappingType;
import CAEX215.MappingType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.MappingTypeImpl#getAttributeNameMapping <em>Attribute Name Mapping</em>}</li>
 *   <li>{@link CAEX215.impl.MappingTypeImpl#getInterfaceNameMapping <em>Interface Name Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingTypeImpl extends CAEXBasicObjectImpl implements MappingType {
	/**
	 * The cached value of the '{@link #getAttributeNameMapping() <em>Attribute Name Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeNameMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeNameMappingType> attributeNameMapping;

	/**
	 * The cached value of the '{@link #getInterfaceNameMapping() <em>Interface Name Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceNameMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceNameMappingType> interfaceNameMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.MAPPING_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeNameMappingType> getAttributeNameMapping() {
		if (attributeNameMapping == null) {
			attributeNameMapping = new EObjectContainmentEList<AttributeNameMappingType>(AttributeNameMappingType.class, this, CAEX215Package.MAPPING_TYPE__ATTRIBUTE_NAME_MAPPING);
		}
		return attributeNameMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceNameMappingType> getInterfaceNameMapping() {
		if (interfaceNameMapping == null) {
			interfaceNameMapping = new EObjectContainmentEList<InterfaceNameMappingType>(InterfaceNameMappingType.class, this, CAEX215Package.MAPPING_TYPE__INTERFACE_NAME_MAPPING);
		}
		return interfaceNameMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.MAPPING_TYPE__ATTRIBUTE_NAME_MAPPING:
				return ((InternalEList<?>)getAttributeNameMapping()).basicRemove(otherEnd, msgs);
			case CAEX215Package.MAPPING_TYPE__INTERFACE_NAME_MAPPING:
				return ((InternalEList<?>)getInterfaceNameMapping()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CAEX215Package.MAPPING_TYPE__ATTRIBUTE_NAME_MAPPING:
				return getAttributeNameMapping();
			case CAEX215Package.MAPPING_TYPE__INTERFACE_NAME_MAPPING:
				return getInterfaceNameMapping();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CAEX215Package.MAPPING_TYPE__ATTRIBUTE_NAME_MAPPING:
				getAttributeNameMapping().clear();
				getAttributeNameMapping().addAll((Collection<? extends AttributeNameMappingType>)newValue);
				return;
			case CAEX215Package.MAPPING_TYPE__INTERFACE_NAME_MAPPING:
				getInterfaceNameMapping().clear();
				getInterfaceNameMapping().addAll((Collection<? extends InterfaceNameMappingType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CAEX215Package.MAPPING_TYPE__ATTRIBUTE_NAME_MAPPING:
				getAttributeNameMapping().clear();
				return;
			case CAEX215Package.MAPPING_TYPE__INTERFACE_NAME_MAPPING:
				getInterfaceNameMapping().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CAEX215Package.MAPPING_TYPE__ATTRIBUTE_NAME_MAPPING:
				return attributeNameMapping != null && !attributeNameMapping.isEmpty();
			case CAEX215Package.MAPPING_TYPE__INTERFACE_NAME_MAPPING:
				return interfaceNameMapping != null && !interfaceNameMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingTypeImpl
