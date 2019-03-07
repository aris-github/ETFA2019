/**
 */
package CAEX215.impl;

import CAEX215.AttributeValueRequirementType;
import CAEX215.CAEX215Package;
import CAEX215.NominalScaledTypeType;
import CAEX215.OrdinalScaledTypeType;
import CAEX215.UnknownTypeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Value Requirement Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.AttributeValueRequirementTypeImpl#getOrdinalScaledType <em>Ordinal Scaled Type</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeValueRequirementTypeImpl#getNominalScaledType <em>Nominal Scaled Type</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeValueRequirementTypeImpl#getUnknownType <em>Unknown Type</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeValueRequirementTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeValueRequirementTypeImpl extends CAEXBasicObjectImpl implements AttributeValueRequirementType {
	/**
	 * The cached value of the '{@link #getOrdinalScaledType() <em>Ordinal Scaled Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrdinalScaledType()
	 * @generated
	 * @ordered
	 */
	protected OrdinalScaledTypeType ordinalScaledType;

	/**
	 * The cached value of the '{@link #getNominalScaledType() <em>Nominal Scaled Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNominalScaledType()
	 * @generated
	 * @ordered
	 */
	protected NominalScaledTypeType nominalScaledType;

	/**
	 * The cached value of the '{@link #getUnknownType() <em>Unknown Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownType()
	 * @generated
	 * @ordered
	 */
	protected UnknownTypeType unknownType;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueRequirementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.ATTRIBUTE_VALUE_REQUIREMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrdinalScaledTypeType getOrdinalScaledType() {
		return ordinalScaledType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrdinalScaledType(OrdinalScaledTypeType newOrdinalScaledType, NotificationChain msgs) {
		OrdinalScaledTypeType oldOrdinalScaledType = ordinalScaledType;
		ordinalScaledType = newOrdinalScaledType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE, oldOrdinalScaledType, newOrdinalScaledType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrdinalScaledType(OrdinalScaledTypeType newOrdinalScaledType) {
		if (newOrdinalScaledType != ordinalScaledType) {
			NotificationChain msgs = null;
			if (ordinalScaledType != null)
				msgs = ((InternalEObject)ordinalScaledType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE, null, msgs);
			if (newOrdinalScaledType != null)
				msgs = ((InternalEObject)newOrdinalScaledType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE, null, msgs);
			msgs = basicSetOrdinalScaledType(newOrdinalScaledType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE, newOrdinalScaledType, newOrdinalScaledType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NominalScaledTypeType getNominalScaledType() {
		return nominalScaledType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNominalScaledType(NominalScaledTypeType newNominalScaledType, NotificationChain msgs) {
		NominalScaledTypeType oldNominalScaledType = nominalScaledType;
		nominalScaledType = newNominalScaledType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE, oldNominalScaledType, newNominalScaledType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalScaledType(NominalScaledTypeType newNominalScaledType) {
		if (newNominalScaledType != nominalScaledType) {
			NotificationChain msgs = null;
			if (nominalScaledType != null)
				msgs = ((InternalEObject)nominalScaledType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE, null, msgs);
			if (newNominalScaledType != null)
				msgs = ((InternalEObject)newNominalScaledType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE, null, msgs);
			msgs = basicSetNominalScaledType(newNominalScaledType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE, newNominalScaledType, newNominalScaledType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownTypeType getUnknownType() {
		return unknownType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnknownType(UnknownTypeType newUnknownType, NotificationChain msgs) {
		UnknownTypeType oldUnknownType = unknownType;
		unknownType = newUnknownType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE, oldUnknownType, newUnknownType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnknownType(UnknownTypeType newUnknownType) {
		if (newUnknownType != unknownType) {
			NotificationChain msgs = null;
			if (unknownType != null)
				msgs = ((InternalEObject)unknownType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE, null, msgs);
			if (newUnknownType != null)
				msgs = ((InternalEObject)newUnknownType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE, null, msgs);
			msgs = basicSetUnknownType(newUnknownType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE, newUnknownType, newUnknownType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE:
				return basicSetOrdinalScaledType(null, msgs);
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE:
				return basicSetNominalScaledType(null, msgs);
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE:
				return basicSetUnknownType(null, msgs);
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
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE:
				return getOrdinalScaledType();
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE:
				return getNominalScaledType();
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE:
				return getUnknownType();
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NAME:
				return getName();
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
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE:
				setOrdinalScaledType((OrdinalScaledTypeType)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE:
				setNominalScaledType((NominalScaledTypeType)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE:
				setUnknownType((UnknownTypeType)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NAME:
				setName((String)newValue);
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
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE:
				setOrdinalScaledType((OrdinalScaledTypeType)null);
				return;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE:
				setNominalScaledType((NominalScaledTypeType)null);
				return;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE:
				setUnknownType((UnknownTypeType)null);
				return;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NAME:
				setName(NAME_EDEFAULT);
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
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__ORDINAL_SCALED_TYPE:
				return ordinalScaledType != null;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NOMINAL_SCALED_TYPE:
				return nominalScaledType != null;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__UNKNOWN_TYPE:
				return unknownType != null;
			case CAEX215Package.ATTRIBUTE_VALUE_REQUIREMENT_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AttributeValueRequirementTypeImpl
