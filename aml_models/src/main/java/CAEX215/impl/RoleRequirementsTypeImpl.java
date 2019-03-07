/**
 */
package CAEX215.impl;

import CAEX215.AttributeType;
import CAEX215.CAEX215Package;
import CAEX215.ExternalInterfaceType;
import CAEX215.RoleRequirementsType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Requirements Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.RoleRequirementsTypeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link CAEX215.impl.RoleRequirementsTypeImpl#getExternalInterface <em>External Interface</em>}</li>
 *   <li>{@link CAEX215.impl.RoleRequirementsTypeImpl#getRefBaseRoleClassPath <em>Ref Base Role Class Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleRequirementsTypeImpl extends CAEXBasicObjectImpl implements RoleRequirementsType {
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeType> attribute;

	/**
	 * The cached value of the '{@link #getExternalInterface() <em>External Interface</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalInterface()
	 * @generated
	 * @ordered
	 */
	protected EList<ExternalInterfaceType> externalInterface;

	/**
	 * The default value of the '{@link #getRefBaseRoleClassPath() <em>Ref Base Role Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefBaseRoleClassPath()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_BASE_ROLE_CLASS_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefBaseRoleClassPath() <em>Ref Base Role Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefBaseRoleClassPath()
	 * @generated
	 * @ordered
	 */
	protected String refBaseRoleClassPath = REF_BASE_ROLE_CLASS_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleRequirementsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.ROLE_REQUIREMENTS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeType> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentEList<AttributeType>(AttributeType.class, this, CAEX215Package.ROLE_REQUIREMENTS_TYPE__ATTRIBUTE);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalInterfaceType> getExternalInterface() {
		if (externalInterface == null) {
			externalInterface = new EObjectContainmentEList<ExternalInterfaceType>(ExternalInterfaceType.class, this, CAEX215Package.ROLE_REQUIREMENTS_TYPE__EXTERNAL_INTERFACE);
		}
		return externalInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefBaseRoleClassPath() {
		return refBaseRoleClassPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefBaseRoleClassPath(String newRefBaseRoleClassPath) {
		String oldRefBaseRoleClassPath = refBaseRoleClassPath;
		refBaseRoleClassPath = newRefBaseRoleClassPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ROLE_REQUIREMENTS_TYPE__REF_BASE_ROLE_CLASS_PATH, oldRefBaseRoleClassPath, refBaseRoleClassPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__EXTERNAL_INTERFACE:
				return ((InternalEList<?>)getExternalInterface()).basicRemove(otherEnd, msgs);
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
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__ATTRIBUTE:
				return getAttribute();
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__EXTERNAL_INTERFACE:
				return getExternalInterface();
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__REF_BASE_ROLE_CLASS_PATH:
				return getRefBaseRoleClassPath();
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
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends AttributeType>)newValue);
				return;
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__EXTERNAL_INTERFACE:
				getExternalInterface().clear();
				getExternalInterface().addAll((Collection<? extends ExternalInterfaceType>)newValue);
				return;
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__REF_BASE_ROLE_CLASS_PATH:
				setRefBaseRoleClassPath((String)newValue);
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
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__ATTRIBUTE:
				getAttribute().clear();
				return;
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__EXTERNAL_INTERFACE:
				getExternalInterface().clear();
				return;
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__REF_BASE_ROLE_CLASS_PATH:
				setRefBaseRoleClassPath(REF_BASE_ROLE_CLASS_PATH_EDEFAULT);
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
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__EXTERNAL_INTERFACE:
				return externalInterface != null && !externalInterface.isEmpty();
			case CAEX215Package.ROLE_REQUIREMENTS_TYPE__REF_BASE_ROLE_CLASS_PATH:
				return REF_BASE_ROLE_CLASS_PATH_EDEFAULT == null ? refBaseRoleClassPath != null : !REF_BASE_ROLE_CLASS_PATH_EDEFAULT.equals(refBaseRoleClassPath);
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
		result.append(" (refBaseRoleClassPath: ");
		result.append(refBaseRoleClassPath);
		result.append(')');
		return result.toString();
	}

} //RoleRequirementsTypeImpl
