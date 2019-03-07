/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CAEX File Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.CAEXFileType#getExternalReference <em>External Reference</em>}</li>
 *   <li>{@link CAEX215.CAEXFileType#getInstanceHierarchy <em>Instance Hierarchy</em>}</li>
 *   <li>{@link CAEX215.CAEXFileType#getInterfaceClassLib <em>Interface Class Lib</em>}</li>
 *   <li>{@link CAEX215.CAEXFileType#getRoleClassLib <em>Role Class Lib</em>}</li>
 *   <li>{@link CAEX215.CAEXFileType#getSystemUnitClassLib <em>System Unit Class Lib</em>}</li>
 *   <li>{@link CAEX215.CAEXFileType#getFileName <em>File Name</em>}</li>
 *   <li>{@link CAEX215.CAEXFileType#getSchemaVersion <em>Schema Version</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getCAEXFileType()
 * @model extendedMetaData="name='CAEXFile_._type' kind='elementOnly'"
 * @generated
 */
public interface CAEXFileType extends CAEXBasicObject {
	/**
	 * Returns the value of the '<em><b>External Reference</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.ExternalReferenceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Container element for the alias definition of external CAEX files.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>External Reference</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getCAEXFileType_ExternalReference()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ExternalReference' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ExternalReferenceType> getExternalReference();

	/**
	 * Returns the value of the '<em><b>Instance Hierarchy</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.InstanceHierarchyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Root element for a system hierarchy of object instances.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance Hierarchy</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getCAEXFileType_InstanceHierarchy()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InstanceHierarchy' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InstanceHierarchyType> getInstanceHierarchy();

	/**
	 * Returns the value of the '<em><b>Interface Class Lib</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.InterfaceClassLibType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Container element for a hierarchy of InterfaceClass definitions. It shall contain any interface class definitions. CAEX supports multiple interface libraries..
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface Class Lib</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getCAEXFileType_InterfaceClassLib()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InterfaceClassLib' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InterfaceClassLibType> getInterfaceClassLib();

	/**
	 * Returns the value of the '<em><b>Role Class Lib</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.RoleClassLibType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Container element for a hierarchy of RoleClass definitions. It shall contain any RoleClass definitions. CAEX supports multiple role libraries.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Role Class Lib</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getCAEXFileType_RoleClassLib()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RoleClassLib' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RoleClassLibType> getRoleClassLib();

	/**
	 * Returns the value of the '<em><b>System Unit Class Lib</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.SystemUnitClassLibType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Container element for a hierarchy of SystemUnitClass definitions. It shall contain any SystemunitClass definitions. CAEX supports multiple SystemUnitClass libraries.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>System Unit Class Lib</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getCAEXFileType_SystemUnitClassLib()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SystemUnitClassLib' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SystemUnitClassLibType> getSystemUnitClassLib();

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the name of the CAEX file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see CAEX215.CAEX215Package#getCAEXFileType_FileName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='FileName' namespace='##targetNamespace'"
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link CAEX215.CAEXFileType#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Schema Version</b></em>' attribute.
	 * The default value is <code>"2.15"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the version of the schema. Each CAEX document must specify which CAEX version it requires. The version number of a CAEX document must fit to the version number specified in the CAEX schema file. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Schema Version</em>' attribute.
	 * @see #isSetSchemaVersion()
	 * @see #unsetSchemaVersion()
	 * @see #setSchemaVersion(String)
	 * @see CAEX215.CAEX215Package#getCAEXFileType_SchemaVersion()
	 * @model default="2.15" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='SchemaVersion' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSchemaVersion();

	/**
	 * Sets the value of the '{@link CAEX215.CAEXFileType#getSchemaVersion <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema Version</em>' attribute.
	 * @see #isSetSchemaVersion()
	 * @see #unsetSchemaVersion()
	 * @see #getSchemaVersion()
	 * @generated
	 */
	void setSchemaVersion(String value);

	/**
	 * Unsets the value of the '{@link CAEX215.CAEXFileType#getSchemaVersion <em>Schema Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSchemaVersion()
	 * @see #getSchemaVersion()
	 * @see #setSchemaVersion(String)
	 * @generated
	 */
	void unsetSchemaVersion();

	/**
	 * Returns whether the value of the '{@link CAEX215.CAEXFileType#getSchemaVersion <em>Schema Version</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Schema Version</em>' attribute is set.
	 * @see #unsetSchemaVersion()
	 * @see #getSchemaVersion()
	 * @see #setSchemaVersion(String)
	 * @generated
	 */
	boolean isSetSchemaVersion();

} // CAEXFileType
