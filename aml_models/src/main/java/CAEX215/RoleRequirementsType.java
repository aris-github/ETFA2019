/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Requirements Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.RoleRequirementsType#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link CAEX215.RoleRequirementsType#getExternalInterface <em>External Interface</em>}</li>
 *   <li>{@link CAEX215.RoleRequirementsType#getRefBaseRoleClassPath <em>Ref Base Role Class Path</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getRoleRequirementsType()
 * @model extendedMetaData="name='RoleRequirements_._type' kind='elementOnly'"
 * @generated
 */
public interface RoleRequirementsType extends CAEXBasicObject {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.AttributeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Characterizes properties of the RoleRequirements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getRoleRequirementsType_Attribute()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Attribute' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AttributeType> getAttribute();

	/**
	 * Returns the value of the '<em><b>External Interface</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.ExternalInterfaceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Interface</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Interface</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getRoleRequirementsType_ExternalInterface()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ExternalInterface' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ExternalInterfaceType> getExternalInterface();

	/**
	 * Returns the value of the '<em><b>Ref Base Role Class Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Base Role Class Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Base Role Class Path</em>' attribute.
	 * @see #setRefBaseRoleClassPath(String)
	 * @see CAEX215.CAEX215Package#getRoleRequirementsType_RefBaseRoleClassPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RefBaseRoleClassPath' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRefBaseRoleClassPath();

	/**
	 * Sets the value of the '{@link CAEX215.RoleRequirementsType#getRefBaseRoleClassPath <em>Ref Base Role Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Base Role Class Path</em>' attribute.
	 * @see #getRefBaseRoleClassPath()
	 * @generated
	 */
	void setRefBaseRoleClassPath(String value);

} // RoleRequirementsType
