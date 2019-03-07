/**
 */
package CAEX215.impl;

import CAEX215.CAEX215Package;
import CAEX215.InternalElementType;
import CAEX215.MappingType;
import CAEX215.RoleRequirementsType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.InternalElementTypeImpl#getRoleRequirements <em>Role Requirements</em>}</li>
 *   <li>{@link CAEX215.impl.InternalElementTypeImpl#getMappingObject <em>Mapping Object</em>}</li>
 *   <li>{@link CAEX215.impl.InternalElementTypeImpl#getRefBaseSystemUnitPath <em>Ref Base System Unit Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalElementTypeImpl extends SystemUnitClassTypeImpl implements InternalElementType {
	/**
	 * The cached value of the '{@link #getRoleRequirements() <em>Role Requirements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleRequirements()
	 * @generated
	 * @ordered
	 */
	protected RoleRequirementsType roleRequirements;

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
	 * The default value of the '{@link #getRefBaseSystemUnitPath() <em>Ref Base System Unit Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefBaseSystemUnitPath()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_BASE_SYSTEM_UNIT_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefBaseSystemUnitPath() <em>Ref Base System Unit Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefBaseSystemUnitPath()
	 * @generated
	 * @ordered
	 */
	protected String refBaseSystemUnitPath = REF_BASE_SYSTEM_UNIT_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.INTERNAL_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleRequirementsType getRoleRequirements() {
		return roleRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoleRequirements(RoleRequirementsType newRoleRequirements, NotificationChain msgs) {
		RoleRequirementsType oldRoleRequirements = roleRequirements;
		roleRequirements = newRoleRequirements;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS, oldRoleRequirements, newRoleRequirements);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleRequirements(RoleRequirementsType newRoleRequirements) {
		if (newRoleRequirements != roleRequirements) {
			NotificationChain msgs = null;
			if (roleRequirements != null)
				msgs = ((InternalEObject)roleRequirements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS, null, msgs);
			if (newRoleRequirements != null)
				msgs = ((InternalEObject)newRoleRequirements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS, null, msgs);
			msgs = basicSetRoleRequirements(newRoleRequirements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS, newRoleRequirements, newRoleRequirements));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT, oldMappingObject, newMappingObject);
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
				msgs = ((InternalEObject)mappingObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT, null, msgs);
			if (newMappingObject != null)
				msgs = ((InternalEObject)newMappingObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT, null, msgs);
			msgs = basicSetMappingObject(newMappingObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT, newMappingObject, newMappingObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefBaseSystemUnitPath() {
		return refBaseSystemUnitPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefBaseSystemUnitPath(String newRefBaseSystemUnitPath) {
		String oldRefBaseSystemUnitPath = refBaseSystemUnitPath;
		refBaseSystemUnitPath = newRefBaseSystemUnitPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.INTERNAL_ELEMENT_TYPE__REF_BASE_SYSTEM_UNIT_PATH, oldRefBaseSystemUnitPath, refBaseSystemUnitPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS:
				return basicSetRoleRequirements(null, msgs);
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT:
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
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS:
				return getRoleRequirements();
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT:
				return getMappingObject();
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__REF_BASE_SYSTEM_UNIT_PATH:
				return getRefBaseSystemUnitPath();
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
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS:
				setRoleRequirements((RoleRequirementsType)newValue);
				return;
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT:
				setMappingObject((MappingType)newValue);
				return;
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__REF_BASE_SYSTEM_UNIT_PATH:
				setRefBaseSystemUnitPath((String)newValue);
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
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS:
				setRoleRequirements((RoleRequirementsType)null);
				return;
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT:
				setMappingObject((MappingType)null);
				return;
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__REF_BASE_SYSTEM_UNIT_PATH:
				setRefBaseSystemUnitPath(REF_BASE_SYSTEM_UNIT_PATH_EDEFAULT);
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
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__ROLE_REQUIREMENTS:
				return roleRequirements != null;
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__MAPPING_OBJECT:
				return mappingObject != null;
			case CAEX215Package.INTERNAL_ELEMENT_TYPE__REF_BASE_SYSTEM_UNIT_PATH:
				return REF_BASE_SYSTEM_UNIT_PATH_EDEFAULT == null ? refBaseSystemUnitPath != null : !REF_BASE_SYSTEM_UNIT_PATH_EDEFAULT.equals(refBaseSystemUnitPath);
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
		result.append(" (refBaseSystemUnitPath: ");
		result.append(refBaseSystemUnitPath);
		result.append(')');
		return result.toString();
	}

} //InternalElementTypeImpl
