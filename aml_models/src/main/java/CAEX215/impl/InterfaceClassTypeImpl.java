/**
 */
package CAEX215.impl;

import CAEX215.AttributeType;
import CAEX215.CAEX215Package;
import CAEX215.InterfaceClassType;

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
 * An implementation of the model object '<em><b>Interface Class Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.InterfaceClassTypeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link CAEX215.impl.InterfaceClassTypeImpl#getRefBaseClassPath <em>Ref Base Class Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceClassTypeImpl extends CAEXObjectImpl implements InterfaceClassType {
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
	 * The default value of the '{@link #getRefBaseClassPath() <em>Ref Base Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefBaseClassPath()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_BASE_CLASS_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefBaseClassPath() <em>Ref Base Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefBaseClassPath()
	 * @generated
	 * @ordered
	 */
	protected String refBaseClassPath = REF_BASE_CLASS_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceClassTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.INTERFACE_CLASS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeType> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentEList<AttributeType>(AttributeType.class, this, CAEX215Package.INTERFACE_CLASS_TYPE__ATTRIBUTE);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefBaseClassPath() {
		return refBaseClassPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefBaseClassPath(String newRefBaseClassPath) {
		String oldRefBaseClassPath = refBaseClassPath;
		refBaseClassPath = newRefBaseClassPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.INTERFACE_CLASS_TYPE__REF_BASE_CLASS_PATH, oldRefBaseClassPath, refBaseClassPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.INTERFACE_CLASS_TYPE__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
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
			case CAEX215Package.INTERFACE_CLASS_TYPE__ATTRIBUTE:
				return getAttribute();
			case CAEX215Package.INTERFACE_CLASS_TYPE__REF_BASE_CLASS_PATH:
				return getRefBaseClassPath();
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
			case CAEX215Package.INTERFACE_CLASS_TYPE__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends AttributeType>)newValue);
				return;
			case CAEX215Package.INTERFACE_CLASS_TYPE__REF_BASE_CLASS_PATH:
				setRefBaseClassPath((String)newValue);
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
			case CAEX215Package.INTERFACE_CLASS_TYPE__ATTRIBUTE:
				getAttribute().clear();
				return;
			case CAEX215Package.INTERFACE_CLASS_TYPE__REF_BASE_CLASS_PATH:
				setRefBaseClassPath(REF_BASE_CLASS_PATH_EDEFAULT);
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
			case CAEX215Package.INTERFACE_CLASS_TYPE__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case CAEX215Package.INTERFACE_CLASS_TYPE__REF_BASE_CLASS_PATH:
				return REF_BASE_CLASS_PATH_EDEFAULT == null ? refBaseClassPath != null : !REF_BASE_CLASS_PATH_EDEFAULT.equals(refBaseClassPath);
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
		result.append(" (refBaseClassPath: ");
		result.append(refBaseClassPath);
		result.append(')');
		return result.toString();
	}

} //InterfaceClassTypeImpl
