/**
 */
package CAEX215.impl;

import CAEX215.CAEX215Package;
import CAEX215.MappingType;
import CAEX215.SupportedRoleClassType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Supported Role Class Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.SupportedRoleClassTypeImpl#getMappingObject <em>Mapping Object</em>}</li>
 *   <li>{@link CAEX215.impl.SupportedRoleClassTypeImpl#getRefRoleClassPath <em>Ref Role Class Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SupportedRoleClassTypeImpl extends CAEXBasicObjectImpl implements SupportedRoleClassType {
	/**
	 * The cached value of the '{@link #getMappingObject() <em>Mapping Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingObject()
	 * @generated
	 * @ordered
	 */
	protected MappingType mappingObject;

	/**
	 * The default value of the '{@link #getRefRoleClassPath() <em>Ref Role Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefRoleClassPath()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_ROLE_CLASS_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefRoleClassPath() <em>Ref Role Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefRoleClassPath()
	 * @generated
	 * @ordered
	 */
	protected String refRoleClassPath = REF_ROLE_CLASS_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SupportedRoleClassTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.SUPPORTED_ROLE_CLASS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingType getMappingObject() {
		return mappingObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingObject(MappingType newMappingObject, NotificationChain msgs) {
		MappingType oldMappingObject = mappingObject;
		mappingObject = newMappingObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT, oldMappingObject, newMappingObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingObject(MappingType newMappingObject) {
		if (newMappingObject != mappingObject) {
			NotificationChain msgs = null;
			if (mappingObject != null)
				msgs = ((InternalEObject)mappingObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT, null, msgs);
			if (newMappingObject != null)
				msgs = ((InternalEObject)newMappingObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT, null, msgs);
			msgs = basicSetMappingObject(newMappingObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT, newMappingObject, newMappingObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefRoleClassPath() {
		return refRoleClassPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefRoleClassPath(String newRefRoleClassPath) {
		String oldRefRoleClassPath = refRoleClassPath;
		refRoleClassPath = newRefRoleClassPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__REF_ROLE_CLASS_PATH, oldRefRoleClassPath, refRoleClassPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT:
				return basicSetMappingObject(null, msgs);
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
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT:
				return getMappingObject();
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__REF_ROLE_CLASS_PATH:
				return getRefRoleClassPath();
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
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT:
				setMappingObject((MappingType)newValue);
				return;
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__REF_ROLE_CLASS_PATH:
				setRefRoleClassPath((String)newValue);
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
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT:
				setMappingObject((MappingType)null);
				return;
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__REF_ROLE_CLASS_PATH:
				setRefRoleClassPath(REF_ROLE_CLASS_PATH_EDEFAULT);
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
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__MAPPING_OBJECT:
				return mappingObject != null;
			case CAEX215Package.SUPPORTED_ROLE_CLASS_TYPE__REF_ROLE_CLASS_PATH:
				return REF_ROLE_CLASS_PATH_EDEFAULT == null ? refRoleClassPath != null : !REF_ROLE_CLASS_PATH_EDEFAULT.equals(refRoleClassPath);
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
		result.append(" (refRoleClassPath: ");
		result.append(refRoleClassPath);
		result.append(')');
		return result.toString();
	}

} //SupportedRoleClassTypeImpl
