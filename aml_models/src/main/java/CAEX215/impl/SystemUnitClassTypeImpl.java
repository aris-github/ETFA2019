/**
 */
package CAEX215.impl;

import CAEX215.AttributeType;
import CAEX215.CAEX215Package;
import CAEX215.ExternalInterfaceType;
import CAEX215.InternalElementType;
import CAEX215.InternalLinkType;
import CAEX215.SupportedRoleClassType;
import CAEX215.SystemUnitClassType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Unit Class Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.SystemUnitClassTypeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link CAEX215.impl.SystemUnitClassTypeImpl#getExternalInterface <em>External Interface</em>}</li>
 *   <li>{@link CAEX215.impl.SystemUnitClassTypeImpl#getInternalElement <em>Internal Element</em>}</li>
 *   <li>{@link CAEX215.impl.SystemUnitClassTypeImpl#getSupportedRoleClass <em>Supported Role Class</em>}</li>
 *   <li>{@link CAEX215.impl.SystemUnitClassTypeImpl#getInternalLink <em>Internal Link</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemUnitClassTypeImpl extends CAEXObjectImpl implements SystemUnitClassType {
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
	 * The cached value of the '{@link #getInternalElement() <em>Internal Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalElement()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalElementType> internalElement;

	/**
	 * The cached value of the '{@link #getSupportedRoleClass() <em>Supported Role Class</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedRoleClass()
	 * @generated
	 * @ordered
	 */
	protected EList<SupportedRoleClassType> supportedRoleClass;

	/**
	 * The cached value of the '{@link #getInternalLink() <em>Internal Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalLink()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalLinkType> internalLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemUnitClassTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.SYSTEM_UNIT_CLASS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeType> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentEList<AttributeType>(AttributeType.class, this, CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__ATTRIBUTE);
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
			externalInterface = new EObjectContainmentEList<ExternalInterfaceType>(ExternalInterfaceType.class, this, CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__EXTERNAL_INTERFACE);
		}
		return externalInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalElementType> getInternalElement() {
		if (internalElement == null) {
			internalElement = new EObjectContainmentEList<InternalElementType>(InternalElementType.class, this, CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_ELEMENT);
		}
		return internalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupportedRoleClassType> getSupportedRoleClass() {
		if (supportedRoleClass == null) {
			supportedRoleClass = new EObjectContainmentEList<SupportedRoleClassType>(SupportedRoleClassType.class, this, CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__SUPPORTED_ROLE_CLASS);
		}
		return supportedRoleClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalLinkType> getInternalLink() {
		if (internalLink == null) {
			internalLink = new EObjectContainmentEList<InternalLinkType>(InternalLinkType.class, this, CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_LINK);
		}
		return internalLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__EXTERNAL_INTERFACE:
				return ((InternalEList<?>)getExternalInterface()).basicRemove(otherEnd, msgs);
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_ELEMENT:
				return ((InternalEList<?>)getInternalElement()).basicRemove(otherEnd, msgs);
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__SUPPORTED_ROLE_CLASS:
				return ((InternalEList<?>)getSupportedRoleClass()).basicRemove(otherEnd, msgs);
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_LINK:
				return ((InternalEList<?>)getInternalLink()).basicRemove(otherEnd, msgs);
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
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__ATTRIBUTE:
				return getAttribute();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__EXTERNAL_INTERFACE:
				return getExternalInterface();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_ELEMENT:
				return getInternalElement();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__SUPPORTED_ROLE_CLASS:
				return getSupportedRoleClass();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_LINK:
				return getInternalLink();
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
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends AttributeType>)newValue);
				return;
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__EXTERNAL_INTERFACE:
				getExternalInterface().clear();
				getExternalInterface().addAll((Collection<? extends ExternalInterfaceType>)newValue);
				return;
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_ELEMENT:
				getInternalElement().clear();
				getInternalElement().addAll((Collection<? extends InternalElementType>)newValue);
				return;
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__SUPPORTED_ROLE_CLASS:
				getSupportedRoleClass().clear();
				getSupportedRoleClass().addAll((Collection<? extends SupportedRoleClassType>)newValue);
				return;
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_LINK:
				getInternalLink().clear();
				getInternalLink().addAll((Collection<? extends InternalLinkType>)newValue);
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
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__ATTRIBUTE:
				getAttribute().clear();
				return;
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__EXTERNAL_INTERFACE:
				getExternalInterface().clear();
				return;
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_ELEMENT:
				getInternalElement().clear();
				return;
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__SUPPORTED_ROLE_CLASS:
				getSupportedRoleClass().clear();
				return;
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_LINK:
				getInternalLink().clear();
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
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__EXTERNAL_INTERFACE:
				return externalInterface != null && !externalInterface.isEmpty();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_ELEMENT:
				return internalElement != null && !internalElement.isEmpty();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__SUPPORTED_ROLE_CLASS:
				return supportedRoleClass != null && !supportedRoleClass.isEmpty();
			case CAEX215Package.SYSTEM_UNIT_CLASS_TYPE__INTERNAL_LINK:
				return internalLink != null && !internalLink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemUnitClassTypeImpl
