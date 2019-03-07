/**
 */
package CAEX215.impl;

import CAEX215.AttributeType;
import CAEX215.AttributeValueRequirementType;
import CAEX215.CAEX215Package;
import CAEX215.RefSemanticType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.AttributeTypeImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeTypeImpl#getRefSemantic <em>Ref Semantic</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeTypeImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeTypeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeTypeImpl#getAttributeDataType <em>Attribute Data Type</em>}</li>
 *   <li>{@link CAEX215.impl.AttributeTypeImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeTypeImpl extends CAEXObjectImpl implements AttributeType {
	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected AnyType defaultValue;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected AnyType value;

	/**
	 * The cached value of the '{@link #getRefSemantic() <em>Ref Semantic</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefSemantic()
	 * @generated
	 * @ordered
	 */
	protected EList<RefSemanticType> refSemantic;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueRequirementType> constraint;

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
	 * The default value of the '{@link #getAttributeDataType() <em>Attribute Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeDataType()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_DATA_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeDataType() <em>Attribute Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeDataType()
	 * @generated
	 * @ordered
	 */
	protected String attributeDataType = ATTRIBUTE_DATA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected String unit = UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.ATTRIBUTE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyType getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultValue(AnyType newDefaultValue, NotificationChain msgs) {
		AnyType oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(AnyType newDefaultValue) {
		if (newDefaultValue != defaultValue) {
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject)defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject)newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyType getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(AnyType newValue, NotificationChain msgs) {
		AnyType oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_TYPE__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(AnyType newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_TYPE__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.ATTRIBUTE_TYPE__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_TYPE__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RefSemanticType> getRefSemantic() {
		if (refSemantic == null) {
			refSemantic = new EObjectContainmentEList<RefSemanticType>(RefSemanticType.class, this, CAEX215Package.ATTRIBUTE_TYPE__REF_SEMANTIC);
		}
		return refSemantic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValueRequirementType> getConstraint() {
		if (constraint == null) {
			constraint = new EObjectContainmentEList<AttributeValueRequirementType>(AttributeValueRequirementType.class, this, CAEX215Package.ATTRIBUTE_TYPE__CONSTRAINT);
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeType> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentEList<AttributeType>(AttributeType.class, this, CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeDataType() {
		return attributeDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeDataType(String newAttributeDataType) {
		String oldAttributeDataType = attributeDataType;
		attributeDataType = newAttributeDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE_DATA_TYPE, oldAttributeDataType, attributeDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(String newUnit) {
		String oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.ATTRIBUTE_TYPE__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE:
				return basicSetDefaultValue(null, msgs);
			case CAEX215Package.ATTRIBUTE_TYPE__VALUE:
				return basicSetValue(null, msgs);
			case CAEX215Package.ATTRIBUTE_TYPE__REF_SEMANTIC:
				return ((InternalEList<?>)getRefSemantic()).basicRemove(otherEnd, msgs);
			case CAEX215Package.ATTRIBUTE_TYPE__CONSTRAINT:
				return ((InternalEList<?>)getConstraint()).basicRemove(otherEnd, msgs);
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE:
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
			case CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case CAEX215Package.ATTRIBUTE_TYPE__VALUE:
				return getValue();
			case CAEX215Package.ATTRIBUTE_TYPE__REF_SEMANTIC:
				return getRefSemantic();
			case CAEX215Package.ATTRIBUTE_TYPE__CONSTRAINT:
				return getConstraint();
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE:
				return getAttribute();
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE_DATA_TYPE:
				return getAttributeDataType();
			case CAEX215Package.ATTRIBUTE_TYPE__UNIT:
				return getUnit();
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
			case CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE:
				setDefaultValue((AnyType)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__VALUE:
				setValue((AnyType)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__REF_SEMANTIC:
				getRefSemantic().clear();
				getRefSemantic().addAll((Collection<? extends RefSemanticType>)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection<? extends AttributeValueRequirementType>)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends AttributeType>)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE_DATA_TYPE:
				setAttributeDataType((String)newValue);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__UNIT:
				setUnit((String)newValue);
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
			case CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE:
				setDefaultValue((AnyType)null);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__VALUE:
				setValue((AnyType)null);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__REF_SEMANTIC:
				getRefSemantic().clear();
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__CONSTRAINT:
				getConstraint().clear();
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE:
				getAttribute().clear();
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE_DATA_TYPE:
				setAttributeDataType(ATTRIBUTE_DATA_TYPE_EDEFAULT);
				return;
			case CAEX215Package.ATTRIBUTE_TYPE__UNIT:
				setUnit(UNIT_EDEFAULT);
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
			case CAEX215Package.ATTRIBUTE_TYPE__DEFAULT_VALUE:
				return defaultValue != null;
			case CAEX215Package.ATTRIBUTE_TYPE__VALUE:
				return value != null;
			case CAEX215Package.ATTRIBUTE_TYPE__REF_SEMANTIC:
				return refSemantic != null && !refSemantic.isEmpty();
			case CAEX215Package.ATTRIBUTE_TYPE__CONSTRAINT:
				return constraint != null && !constraint.isEmpty();
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case CAEX215Package.ATTRIBUTE_TYPE__ATTRIBUTE_DATA_TYPE:
				return ATTRIBUTE_DATA_TYPE_EDEFAULT == null ? attributeDataType != null : !ATTRIBUTE_DATA_TYPE_EDEFAULT.equals(attributeDataType);
			case CAEX215Package.ATTRIBUTE_TYPE__UNIT:
				return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT.equals(unit);
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
		result.append(" (attributeDataType: ");
		result.append(attributeDataType);
		result.append(", unit: ");
		result.append(unit);
		result.append(')');
		return result.toString();
	}
	
	// extended for easy use
	// TODO: move it to an utility class
	public String getStringValue() {
		if(this.getValue() != null) {
			if(this.getValue().getMixed().size() > 0) {
				if(this.getValue().getMixed().getValue(0) != null) {
					return (String) this.getValue().getMixed().getValue(0);					
				}
			}
		}
		
		return null;
	}
	
	// extended for easy use
	// TODO: move it to an utility class
	public List<AttributeType> getAllAttributes() {
		// TODO Auto-generated method stub
		List<AttributeType> subAttrs = new ArrayList<AttributeType>();
		
		if(this.getAttribute().size() == 0){
			subAttrs.add(this);
			return subAttrs;
		}
		
		for(AttributeType sub : this.getAttribute()) {
//			sub.setName(this.getName() + "_" + sub.getName());
			AttributeTypeImpl newSub = new AttributeTypeImpl();
			newSub.additionalInformation = sub.getAdditionalInformation();
			newSub.attribute = sub.getAttribute();
			newSub.attributeDataType = sub.getAttributeDataType();
			newSub.changeMode = sub.getChangeMode();
			newSub.constraint = sub.getConstraint();
			newSub.copyright = sub.getCopyright();
			newSub.defaultValue = sub.getDefaultValue();
			newSub.description = sub.getDescription();
			newSub.iD = sub.getID();
			newSub.refSemantic = sub.getRefSemantic();
			newSub.revision = sub.getRevision();
			newSub.unit = sub.getUnit();
			newSub.value = sub.getValue();
			newSub.version = sub.getVersion();
			newSub.name = this.getName() + "_" + sub.getName();
//			System.out.println("sub name: " + sub.getName());
			subAttrs.addAll(newSub.getAllAttributes());
		}		
		return subAttrs;				
	}

} //AttributeTypeImpl
