/**
 */
package CAEX215.impl;

import CAEX215.CAEX215Package;
import CAEX215.InterfaceClassLibType;
import CAEX215.InterfaceFamilyType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Class Lib Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.InterfaceClassLibTypeImpl#getInterfaceClass <em>Interface Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceClassLibTypeImpl extends CAEXObjectImpl implements InterfaceClassLibType {
	/**
	 * The cached value of the '{@link #getInterfaceClass() <em>Interface Class</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceClass()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceFamilyType> interfaceClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceClassLibTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.INTERFACE_CLASS_LIB_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceFamilyType> getInterfaceClass() {
		if (interfaceClass == null) {
			interfaceClass = new EObjectContainmentEList<InterfaceFamilyType>(InterfaceFamilyType.class, this, CAEX215Package.INTERFACE_CLASS_LIB_TYPE__INTERFACE_CLASS);
		}
		return interfaceClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.INTERFACE_CLASS_LIB_TYPE__INTERFACE_CLASS:
				return ((InternalEList<?>)getInterfaceClass()).basicRemove(otherEnd, msgs);
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
			case CAEX215Package.INTERFACE_CLASS_LIB_TYPE__INTERFACE_CLASS:
				return getInterfaceClass();
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
			case CAEX215Package.INTERFACE_CLASS_LIB_TYPE__INTERFACE_CLASS:
				getInterfaceClass().clear();
				getInterfaceClass().addAll((Collection<? extends InterfaceFamilyType>)newValue);
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
			case CAEX215Package.INTERFACE_CLASS_LIB_TYPE__INTERFACE_CLASS:
				getInterfaceClass().clear();
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
			case CAEX215Package.INTERFACE_CLASS_LIB_TYPE__INTERFACE_CLASS:
				return interfaceClass != null && !interfaceClass.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceClassLibTypeImpl
