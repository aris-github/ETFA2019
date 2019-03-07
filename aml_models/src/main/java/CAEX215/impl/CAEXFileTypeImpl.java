/**
 */
package CAEX215.impl;

import CAEX215.CAEX215Package;
import CAEX215.CAEXFileType;
import CAEX215.ExternalReferenceType;
import CAEX215.InstanceHierarchyType;
import CAEX215.InterfaceClassLibType;
import CAEX215.RoleClassLibType;
import CAEX215.SystemUnitClassLibType;

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
 * An implementation of the model object '<em><b>CAEX File Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.CAEXFileTypeImpl#getExternalReference <em>External Reference</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXFileTypeImpl#getInstanceHierarchy <em>Instance Hierarchy</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXFileTypeImpl#getInterfaceClassLib <em>Interface Class Lib</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXFileTypeImpl#getRoleClassLib <em>Role Class Lib</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXFileTypeImpl#getSystemUnitClassLib <em>System Unit Class Lib</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXFileTypeImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXFileTypeImpl#getSchemaVersion <em>Schema Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CAEXFileTypeImpl extends CAEXBasicObjectImpl implements CAEXFileType {
	/**
	 * The cached value of the '{@link #getExternalReference() <em>External Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalReference()
	 * @generated
	 * @ordered
	 */
	protected EList<ExternalReferenceType> externalReference;

	/**
	 * The cached value of the '{@link #getInstanceHierarchy() <em>Instance Hierarchy</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceHierarchy()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceHierarchyType> instanceHierarchy;

	/**
	 * The cached value of the '{@link #getInterfaceClassLib() <em>Interface Class Lib</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceClassLib()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceClassLibType> interfaceClassLib;

	/**
	 * The cached value of the '{@link #getRoleClassLib() <em>Role Class Lib</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleClassLib()
	 * @generated
	 * @ordered
	 */
	protected EList<RoleClassLibType> roleClassLib;

	/**
	 * The cached value of the '{@link #getSystemUnitClassLib() <em>System Unit Class Lib</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemUnitClassLib()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemUnitClassLibType> systemUnitClassLib;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEMA_VERSION_EDEFAULT = "2.15";

	/**
	 * The cached value of the '{@link #getSchemaVersion() <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaVersion()
	 * @generated
	 * @ordered
	 */
	protected String schemaVersion = SCHEMA_VERSION_EDEFAULT;

	/**
	 * This is true if the Schema Version attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean schemaVersionESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CAEXFileTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.CAEX_FILE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalReferenceType> getExternalReference() {
		if (externalReference == null) {
			externalReference = new EObjectContainmentEList<ExternalReferenceType>(ExternalReferenceType.class, this, CAEX215Package.CAEX_FILE_TYPE__EXTERNAL_REFERENCE);
		}
		return externalReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstanceHierarchyType> getInstanceHierarchy() {
		if (instanceHierarchy == null) {
			instanceHierarchy = new EObjectContainmentEList<InstanceHierarchyType>(InstanceHierarchyType.class, this, CAEX215Package.CAEX_FILE_TYPE__INSTANCE_HIERARCHY);
		}
		return instanceHierarchy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceClassLibType> getInterfaceClassLib() {
		if (interfaceClassLib == null) {
			interfaceClassLib = new EObjectContainmentEList<InterfaceClassLibType>(InterfaceClassLibType.class, this, CAEX215Package.CAEX_FILE_TYPE__INTERFACE_CLASS_LIB);
		}
		return interfaceClassLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RoleClassLibType> getRoleClassLib() {
		if (roleClassLib == null) {
			roleClassLib = new EObjectContainmentEList<RoleClassLibType>(RoleClassLibType.class, this, CAEX215Package.CAEX_FILE_TYPE__ROLE_CLASS_LIB);
		}
		return roleClassLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemUnitClassLibType> getSystemUnitClassLib() {
		if (systemUnitClassLib == null) {
			systemUnitClassLib = new EObjectContainmentEList<SystemUnitClassLibType>(SystemUnitClassLibType.class, this, CAEX215Package.CAEX_FILE_TYPE__SYSTEM_UNIT_CLASS_LIB);
		}
		return systemUnitClassLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_FILE_TYPE__FILE_NAME, oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchemaVersion() {
		return schemaVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchemaVersion(String newSchemaVersion) {
		String oldSchemaVersion = schemaVersion;
		schemaVersion = newSchemaVersion;
		boolean oldSchemaVersionESet = schemaVersionESet;
		schemaVersionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_FILE_TYPE__SCHEMA_VERSION, oldSchemaVersion, schemaVersion, !oldSchemaVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSchemaVersion() {
		String oldSchemaVersion = schemaVersion;
		boolean oldSchemaVersionESet = schemaVersionESet;
		schemaVersion = SCHEMA_VERSION_EDEFAULT;
		schemaVersionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CAEX215Package.CAEX_FILE_TYPE__SCHEMA_VERSION, oldSchemaVersion, SCHEMA_VERSION_EDEFAULT, oldSchemaVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSchemaVersion() {
		return schemaVersionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.CAEX_FILE_TYPE__EXTERNAL_REFERENCE:
				return ((InternalEList<?>)getExternalReference()).basicRemove(otherEnd, msgs);
			case CAEX215Package.CAEX_FILE_TYPE__INSTANCE_HIERARCHY:
				return ((InternalEList<?>)getInstanceHierarchy()).basicRemove(otherEnd, msgs);
			case CAEX215Package.CAEX_FILE_TYPE__INTERFACE_CLASS_LIB:
				return ((InternalEList<?>)getInterfaceClassLib()).basicRemove(otherEnd, msgs);
			case CAEX215Package.CAEX_FILE_TYPE__ROLE_CLASS_LIB:
				return ((InternalEList<?>)getRoleClassLib()).basicRemove(otherEnd, msgs);
			case CAEX215Package.CAEX_FILE_TYPE__SYSTEM_UNIT_CLASS_LIB:
				return ((InternalEList<?>)getSystemUnitClassLib()).basicRemove(otherEnd, msgs);
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
			case CAEX215Package.CAEX_FILE_TYPE__EXTERNAL_REFERENCE:
				return getExternalReference();
			case CAEX215Package.CAEX_FILE_TYPE__INSTANCE_HIERARCHY:
				return getInstanceHierarchy();
			case CAEX215Package.CAEX_FILE_TYPE__INTERFACE_CLASS_LIB:
				return getInterfaceClassLib();
			case CAEX215Package.CAEX_FILE_TYPE__ROLE_CLASS_LIB:
				return getRoleClassLib();
			case CAEX215Package.CAEX_FILE_TYPE__SYSTEM_UNIT_CLASS_LIB:
				return getSystemUnitClassLib();
			case CAEX215Package.CAEX_FILE_TYPE__FILE_NAME:
				return getFileName();
			case CAEX215Package.CAEX_FILE_TYPE__SCHEMA_VERSION:
				return getSchemaVersion();
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
			case CAEX215Package.CAEX_FILE_TYPE__EXTERNAL_REFERENCE:
				getExternalReference().clear();
				getExternalReference().addAll((Collection<? extends ExternalReferenceType>)newValue);
				return;
			case CAEX215Package.CAEX_FILE_TYPE__INSTANCE_HIERARCHY:
				getInstanceHierarchy().clear();
				getInstanceHierarchy().addAll((Collection<? extends InstanceHierarchyType>)newValue);
				return;
			case CAEX215Package.CAEX_FILE_TYPE__INTERFACE_CLASS_LIB:
				getInterfaceClassLib().clear();
				getInterfaceClassLib().addAll((Collection<? extends InterfaceClassLibType>)newValue);
				return;
			case CAEX215Package.CAEX_FILE_TYPE__ROLE_CLASS_LIB:
				getRoleClassLib().clear();
				getRoleClassLib().addAll((Collection<? extends RoleClassLibType>)newValue);
				return;
			case CAEX215Package.CAEX_FILE_TYPE__SYSTEM_UNIT_CLASS_LIB:
				getSystemUnitClassLib().clear();
				getSystemUnitClassLib().addAll((Collection<? extends SystemUnitClassLibType>)newValue);
				return;
			case CAEX215Package.CAEX_FILE_TYPE__FILE_NAME:
				setFileName((String)newValue);
				return;
			case CAEX215Package.CAEX_FILE_TYPE__SCHEMA_VERSION:
				setSchemaVersion((String)newValue);
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
			case CAEX215Package.CAEX_FILE_TYPE__EXTERNAL_REFERENCE:
				getExternalReference().clear();
				return;
			case CAEX215Package.CAEX_FILE_TYPE__INSTANCE_HIERARCHY:
				getInstanceHierarchy().clear();
				return;
			case CAEX215Package.CAEX_FILE_TYPE__INTERFACE_CLASS_LIB:
				getInterfaceClassLib().clear();
				return;
			case CAEX215Package.CAEX_FILE_TYPE__ROLE_CLASS_LIB:
				getRoleClassLib().clear();
				return;
			case CAEX215Package.CAEX_FILE_TYPE__SYSTEM_UNIT_CLASS_LIB:
				getSystemUnitClassLib().clear();
				return;
			case CAEX215Package.CAEX_FILE_TYPE__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case CAEX215Package.CAEX_FILE_TYPE__SCHEMA_VERSION:
				unsetSchemaVersion();
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
			case CAEX215Package.CAEX_FILE_TYPE__EXTERNAL_REFERENCE:
				return externalReference != null && !externalReference.isEmpty();
			case CAEX215Package.CAEX_FILE_TYPE__INSTANCE_HIERARCHY:
				return instanceHierarchy != null && !instanceHierarchy.isEmpty();
			case CAEX215Package.CAEX_FILE_TYPE__INTERFACE_CLASS_LIB:
				return interfaceClassLib != null && !interfaceClassLib.isEmpty();
			case CAEX215Package.CAEX_FILE_TYPE__ROLE_CLASS_LIB:
				return roleClassLib != null && !roleClassLib.isEmpty();
			case CAEX215Package.CAEX_FILE_TYPE__SYSTEM_UNIT_CLASS_LIB:
				return systemUnitClassLib != null && !systemUnitClassLib.isEmpty();
			case CAEX215Package.CAEX_FILE_TYPE__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case CAEX215Package.CAEX_FILE_TYPE__SCHEMA_VERSION:
				return isSetSchemaVersion();
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
		result.append(" (fileName: ");
		result.append(fileName);
		result.append(", schemaVersion: ");
		if (schemaVersionESet) result.append(schemaVersion); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CAEXFileTypeImpl
