/**
 */
package CAEX215.impl;

import CAEX215.CAEX215Package;
import CAEX215.CAEXBasicObject;
import CAEX215.ChangeMode;
import CAEX215.CopyrightType;
import CAEX215.DescriptionType;
import CAEX215.RevisionType;
import CAEX215.VersionType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CAEX Basic Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.impl.CAEXBasicObjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXBasicObjectImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXBasicObjectImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXBasicObjectImpl#getAdditionalInformation <em>Additional Information</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXBasicObjectImpl#getChangeMode <em>Change Mode</em>}</li>
 *   <li>{@link CAEX215.impl.CAEXBasicObjectImpl#getRevision <em>Revision</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CAEXBasicObjectImpl extends MinimalEObjectImpl.Container implements CAEXBasicObject {
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected DescriptionType description;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected VersionType version;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected CopyrightType copyright;

	/**
	 * The cached value of the '{@link #getAdditionalInformation() <em>Additional Information</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalInformation()
	 * @generated
	 * @ordered
	 */
	protected EList<AnyType> additionalInformation;

	/**
	 * The default value of the '{@link #getChangeMode() <em>Change Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeMode()
	 * @generated
	 * @ordered
	 */
	protected static final ChangeMode CHANGE_MODE_EDEFAULT = ChangeMode.STATE;

	/**
	 * The cached value of the '{@link #getChangeMode() <em>Change Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeMode()
	 * @generated
	 * @ordered
	 */
	protected ChangeMode changeMode = CHANGE_MODE_EDEFAULT;

	/**
	 * This is true if the Change Mode attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean changeModeESet;

	/**
	 * The cached value of the '{@link #getRevision() <em>Revision</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected EList<RevisionType> revision;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CAEXBasicObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CAEX215Package.Literals.CAEX_BASIC_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionType getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(DescriptionType newDescription, NotificationChain msgs) {
		DescriptionType oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(DescriptionType newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionType getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersion(VersionType newVersion, NotificationChain msgs) {
		VersionType oldVersion = version;
		version = newVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_BASIC_OBJECT__VERSION, oldVersion, newVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(VersionType newVersion) {
		if (newVersion != version) {
			NotificationChain msgs = null;
			if (version != null)
				msgs = ((InternalEObject)version).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.CAEX_BASIC_OBJECT__VERSION, null, msgs);
			if (newVersion != null)
				msgs = ((InternalEObject)newVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.CAEX_BASIC_OBJECT__VERSION, null, msgs);
			msgs = basicSetVersion(newVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_BASIC_OBJECT__VERSION, newVersion, newVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopyrightType getCopyright() {
		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCopyright(CopyrightType newCopyright, NotificationChain msgs) {
		CopyrightType oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT, oldCopyright, newCopyright);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopyright(CopyrightType newCopyright) {
		if (newCopyright != copyright) {
			NotificationChain msgs = null;
			if (copyright != null)
				msgs = ((InternalEObject)copyright).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT, null, msgs);
			if (newCopyright != null)
				msgs = ((InternalEObject)newCopyright).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT, null, msgs);
			msgs = basicSetCopyright(newCopyright, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT, newCopyright, newCopyright));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnyType> getAdditionalInformation() {
		if (additionalInformation == null) {
			additionalInformation = new EObjectContainmentEList<AnyType>(AnyType.class, this, CAEX215Package.CAEX_BASIC_OBJECT__ADDITIONAL_INFORMATION);
		}
		return additionalInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeMode getChangeMode() {
		return changeMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeMode(ChangeMode newChangeMode) {
		ChangeMode oldChangeMode = changeMode;
		changeMode = newChangeMode == null ? CHANGE_MODE_EDEFAULT : newChangeMode;
		boolean oldChangeModeESet = changeModeESet;
		changeModeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CAEX215Package.CAEX_BASIC_OBJECT__CHANGE_MODE, oldChangeMode, changeMode, !oldChangeModeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetChangeMode() {
		ChangeMode oldChangeMode = changeMode;
		boolean oldChangeModeESet = changeModeESet;
		changeMode = CHANGE_MODE_EDEFAULT;
		changeModeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CAEX215Package.CAEX_BASIC_OBJECT__CHANGE_MODE, oldChangeMode, CHANGE_MODE_EDEFAULT, oldChangeModeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetChangeMode() {
		return changeModeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RevisionType> getRevision() {
		if (revision == null) {
			revision = new EObjectContainmentEList<RevisionType>(RevisionType.class, this, CAEX215Package.CAEX_BASIC_OBJECT__REVISION);
		}
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case CAEX215Package.CAEX_BASIC_OBJECT__VERSION:
				return basicSetVersion(null, msgs);
			case CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT:
				return basicSetCopyright(null, msgs);
			case CAEX215Package.CAEX_BASIC_OBJECT__ADDITIONAL_INFORMATION:
				return ((InternalEList<?>)getAdditionalInformation()).basicRemove(otherEnd, msgs);
			case CAEX215Package.CAEX_BASIC_OBJECT__REVISION:
				return ((InternalEList<?>)getRevision()).basicRemove(otherEnd, msgs);
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
			case CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION:
				return getDescription();
			case CAEX215Package.CAEX_BASIC_OBJECT__VERSION:
				return getVersion();
			case CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT:
				return getCopyright();
			case CAEX215Package.CAEX_BASIC_OBJECT__ADDITIONAL_INFORMATION:
				return getAdditionalInformation();
			case CAEX215Package.CAEX_BASIC_OBJECT__CHANGE_MODE:
				return getChangeMode();
			case CAEX215Package.CAEX_BASIC_OBJECT__REVISION:
				return getRevision();
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
			case CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION:
				setDescription((DescriptionType)newValue);
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__VERSION:
				setVersion((VersionType)newValue);
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT:
				setCopyright((CopyrightType)newValue);
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__ADDITIONAL_INFORMATION:
				getAdditionalInformation().clear();
				getAdditionalInformation().addAll((Collection<? extends AnyType>)newValue);
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__CHANGE_MODE:
				setChangeMode((ChangeMode)newValue);
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__REVISION:
				getRevision().clear();
				getRevision().addAll((Collection<? extends RevisionType>)newValue);
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
			case CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION:
				setDescription((DescriptionType)null);
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__VERSION:
				setVersion((VersionType)null);
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT:
				setCopyright((CopyrightType)null);
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__ADDITIONAL_INFORMATION:
				getAdditionalInformation().clear();
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__CHANGE_MODE:
				unsetChangeMode();
				return;
			case CAEX215Package.CAEX_BASIC_OBJECT__REVISION:
				getRevision().clear();
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
			case CAEX215Package.CAEX_BASIC_OBJECT__DESCRIPTION:
				return description != null;
			case CAEX215Package.CAEX_BASIC_OBJECT__VERSION:
				return version != null;
			case CAEX215Package.CAEX_BASIC_OBJECT__COPYRIGHT:
				return copyright != null;
			case CAEX215Package.CAEX_BASIC_OBJECT__ADDITIONAL_INFORMATION:
				return additionalInformation != null && !additionalInformation.isEmpty();
			case CAEX215Package.CAEX_BASIC_OBJECT__CHANGE_MODE:
				return isSetChangeMode();
			case CAEX215Package.CAEX_BASIC_OBJECT__REVISION:
				return revision != null && !revision.isEmpty();
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
		result.append(" (changeMode: ");
		if (changeModeESet) result.append(changeMode); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //CAEXBasicObjectImpl
