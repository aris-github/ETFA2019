/**
 */
package CAEX215.impl;

import CAEX215.CAEX215Package;
import CAEX215.OrdinalScaledTypeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordinal Scaled Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.OrdinalScaledTypeTypeImpl#getRequiredMaxValue <em>Required Max Value</em>}</li>
 *   <li>{@link CAEX215.impl.OrdinalScaledTypeTypeImpl#getRequiredValue <em>Required Value</em>}</li>
 *   <li>{@link CAEX215.impl.OrdinalScaledTypeTypeImpl#getRequiredMinValue <em>Required Min Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrdinalScaledTypeTypeImpl extends MinimalEObjectImpl.Container implements OrdinalScaledTypeType {
	/**
	 * The cached value of the '{@link #getRequiredMaxValue() <em>Required Max Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredMaxValue()
	 * @generated
	 * @ordered
	 */
	protected AnyType requiredMaxValue;

	/**
	 * The cached value of the '{@link #getRequiredValue() <em>Required Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredValue()
	 * @generated
	 * @ordered
	 */
	protected AnyType requiredValue;

	/**
	 * The cached value of the '{@link #getRequiredMinValue() <em>Required Min Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredMinValue()
	 * @generated
	 * @ordered
	 */
	protected AnyType requiredMinValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrdinalScaledTypeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.ORDINAL_SCALED_TYPE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyType getRequiredMaxValue() {
		return requiredMaxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredMaxValue(AnyType newRequiredMaxValue, NotificationChain msgs) {
		AnyType oldRequiredMaxValue = requiredMaxValue;
		requiredMaxValue = newRequiredMaxValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE, oldRequiredMaxValue, newRequiredMaxValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredMaxValue(AnyType newRequiredMaxValue) {
		if (newRequiredMaxValue != requiredMaxValue) {
			NotificationChain msgs = null;
			if (requiredMaxValue != null)
				msgs = ((InternalEObject)requiredMaxValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE, null, msgs);
			if (newRequiredMaxValue != null)
				msgs = ((InternalEObject)newRequiredMaxValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE, null, msgs);
			msgs = basicSetRequiredMaxValue(newRequiredMaxValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE, newRequiredMaxValue, newRequiredMaxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyType getRequiredValue() {
		return requiredValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredValue(AnyType newRequiredValue, NotificationChain msgs) {
		AnyType oldRequiredValue = requiredValue;
		requiredValue = newRequiredValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE, oldRequiredValue, newRequiredValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredValue(AnyType newRequiredValue) {
		if (newRequiredValue != requiredValue) {
			NotificationChain msgs = null;
			if (requiredValue != null)
				msgs = ((InternalEObject)requiredValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE, null, msgs);
			if (newRequiredValue != null)
				msgs = ((InternalEObject)newRequiredValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE, null, msgs);
			msgs = basicSetRequiredValue(newRequiredValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE, newRequiredValue, newRequiredValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyType getRequiredMinValue() {
		return requiredMinValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredMinValue(AnyType newRequiredMinValue, NotificationChain msgs) {
		AnyType oldRequiredMinValue = requiredMinValue;
		requiredMinValue = newRequiredMinValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE, oldRequiredMinValue, newRequiredMinValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredMinValue(AnyType newRequiredMinValue) {
		if (newRequiredMinValue != requiredMinValue) {
			NotificationChain msgs = null;
			if (requiredMinValue != null)
				msgs = ((InternalEObject)requiredMinValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE, null, msgs);
			if (newRequiredMinValue != null)
				msgs = ((InternalEObject)newRequiredMinValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE, null, msgs);
			msgs = basicSetRequiredMinValue(newRequiredMinValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE, newRequiredMinValue, newRequiredMinValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE:
				return basicSetRequiredMaxValue(null, msgs);
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE:
				return basicSetRequiredValue(null, msgs);
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE:
				return basicSetRequiredMinValue(null, msgs);
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
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE:
				return getRequiredMaxValue();
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE:
				return getRequiredValue();
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE:
				return getRequiredMinValue();
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
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE:
				setRequiredMaxValue((AnyType)newValue);
				return;
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE:
				setRequiredValue((AnyType)newValue);
				return;
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE:
				setRequiredMinValue((AnyType)newValue);
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
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE:
				setRequiredMaxValue((AnyType)null);
				return;
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE:
				setRequiredValue((AnyType)null);
				return;
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE:
				setRequiredMinValue((AnyType)null);
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
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MAX_VALUE:
				return requiredMaxValue != null;
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_VALUE:
				return requiredValue != null;
			case CAEX215Package.ORDINAL_SCALED_TYPE_TYPE__REQUIRED_MIN_VALUE:
				return requiredMinValue != null;
		}
		return super.eIsSet(featureID);
	}

} //OrdinalScaledTypeTypeImpl
