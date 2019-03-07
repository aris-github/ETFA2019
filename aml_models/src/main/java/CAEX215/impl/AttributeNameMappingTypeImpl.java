/**
 */
package CAEX215.impl;

import CAEX215.AttributeNameMappingType;
import CAEX215.CAEX215Package;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Name Mapping Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.AttributeNameMappingTypeImpl#getRoleAttributeName <em>Role Attribute Name</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeNameMappingTypeImpl#getSystemUnitAttributeName <em>System Unit Attribute Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeNameMappingTypeImpl extends CAEXBasicObjectImpl implements AttributeNameMappingType {
	/**
	 * The default value of the '{@link #getRoleAttributeName() <em>Role Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRoleAttributeName() <em>Role Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String roleAttributeName = ROLE_ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemUnitAttributeName() <em>System Unit Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemUnitAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_UNIT_ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemUnitAttributeName() <em>System Unit Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemUnitAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String systemUnitAttributeName = SYSTEM_UNIT_ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeNameMappingTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.ATTRIBUTE_NAME_MAPPING_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRoleAttributeName() {
		return roleAttributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleAttributeName(String newRoleAttributeName) {
		String oldRoleAttributeName = roleAttributeName;
		roleAttributeName = newRoleAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__ROLE_ATTRIBUTE_NAME, oldRoleAttributeName, roleAttributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemUnitAttributeName() {
		return systemUnitAttributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemUnitAttributeName(String newSystemUnitAttributeName) {
		String oldSystemUnitAttributeName = systemUnitAttributeName;
		systemUnitAttributeName = newSystemUnitAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__SYSTEM_UNIT_ATTRIBUTE_NAME, oldSystemUnitAttributeName, systemUnitAttributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__ROLE_ATTRIBUTE_NAME:
				return getRoleAttributeName();
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__SYSTEM_UNIT_ATTRIBUTE_NAME:
				return getSystemUnitAttributeName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__ROLE_ATTRIBUTE_NAME:
				setRoleAttributeName((String)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__SYSTEM_UNIT_ATTRIBUTE_NAME:
				setSystemUnitAttributeName((String)newValue);
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
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__ROLE_ATTRIBUTE_NAME:
				setRoleAttributeName(ROLE_ATTRIBUTE_NAME_EDEFAULT);
				return;
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__SYSTEM_UNIT_ATTRIBUTE_NAME:
				setSystemUnitAttributeName(SYSTEM_UNIT_ATTRIBUTE_NAME_EDEFAULT);
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
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__ROLE_ATTRIBUTE_NAME:
				return ROLE_ATTRIBUTE_NAME_EDEFAULT == null ? roleAttributeName != null : !ROLE_ATTRIBUTE_NAME_EDEFAULT.equals(roleAttributeName);
			case CAEX215Package.ATTRIBUTE_NAME_MAPPING_TYPE__SYSTEM_UNIT_ATTRIBUTE_NAME:
				return SYSTEM_UNIT_ATTRIBUTE_NAME_EDEFAULT == null ? systemUnitAttributeName != null : !SYSTEM_UNIT_ATTRIBUTE_NAME_EDEFAULT.equals(systemUnitAttributeName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (roleAttributeName: ");
		result.append(roleAttributeName);
		result.append(", systemUnitAttributeName: ");
		result.append(systemUnitAttributeName);
		result.append(')');
		return result.toString();
	}

} //AttributeNameMappingTypeImpl
