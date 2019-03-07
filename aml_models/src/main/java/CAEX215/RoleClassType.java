/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Class Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Shall be used for RoleClass definition, provides base structures for a role class definition.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.RoleClassType#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link CAEX215.RoleClassType#getExternalInterface <em>External Interface</em>}</li>
 *   <li>{@link CAEX215.RoleClassType#getRefBaseClassPath <em>Ref Base Class Path</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getRoleClassType()
 * @model extendedMetaData="name='RoleClassType' kind='elementOnly'"
 * @generated
 */
public interface RoleClassType extends CAEXObject {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.AttributeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Characterizes properties of the RoleClass.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getRoleClassType_Attribute()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Attribute' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AttributeType> getAttribute();

	/**
	 * Returns the value of the '<em><b>External Interface</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.ExternalInterfaceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description of an external interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>External Interface</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getRoleClassType_ExternalInterface()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ExternalInterface' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ExternalInterfaceType> getExternalInterface();

	/**
	 * Returns the value of the '<em><b>Ref Base Class Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Stores the reference of a class to its base class. References contain the full path to the refered class object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref Base Class Path</em>' attribute.
	 * @see #setRefBaseClassPath(String)
	 * @see CAEX215.CAEX215Package#getRoleClassType_RefBaseClassPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='RefBaseClassPath' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRefBaseClassPath();

	/**
	 * Sets the value of the '{@link CAEX215.RoleClassType#getRefBaseClassPath <em>Ref Base Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Base Class Path</em>' attribute.
	 * @see #getRefBaseClassPath()
	 * @generated
	 */
	void setRefBaseClassPath(String value);

} // RoleClassType
