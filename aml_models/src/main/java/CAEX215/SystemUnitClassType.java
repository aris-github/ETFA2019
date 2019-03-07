/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Unit Class Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines base structures for a SystemUnit class definition.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.SystemUnitClassType#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link CAEX215.SystemUnitClassType#getExternalInterface <em>External Interface</em>}</li>
 *   <li>{@link CAEX215.SystemUnitClassType#getInternalElement <em>Internal Element</em>}</li>
 *   <li>{@link CAEX215.SystemUnitClassType#getSupportedRoleClass <em>Supported Role Class</em>}</li>
 *   <li>{@link CAEX215.SystemUnitClassType#getInternalLink <em>Internal Link</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getSystemUnitClassType()
 * @model extendedMetaData="name='SystemUnitClassType' kind='elementOnly'"
 * @generated
 */
public interface SystemUnitClassType extends CAEXObject {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.AttributeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Characterizes properties of the SystemUnitClass.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getSystemUnitClassType_Attribute()
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
	 * @see CAEX215.CAEX215Package#getSystemUnitClassType_ExternalInterface()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ExternalInterface' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ExternalInterfaceType> getExternalInterface();

	/**
	 * Returns the value of the '<em><b>Internal Element</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.InternalElementType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Shall be used in order to define nested objects inside of a SystemUnitClass or another InternalElement. Allows description of the internal structure of an CAEX object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Internal Element</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getSystemUnitClassType_InternalElement()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InternalElement' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InternalElementType> getInternalElement();

	/**
	 * Returns the value of the '<em><b>Supported Role Class</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.SupportedRoleClassType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Allows the association to a RoleClass which this SystemUnitClass can play. A SystemUnitClass may reference multiple roles.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Supported Role Class</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getSystemUnitClassType_SupportedRoleClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SupportedRoleClass' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SupportedRoleClassType> getSupportedRoleClass();

	/**
	 * Returns the value of the '<em><b>Internal Link</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.InternalLinkType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Shall be used in order to define the relationships between internal interfaces of InternalElements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Internal Link</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getSystemUnitClassType_InternalLink()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InternalLink' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InternalLinkType> getInternalLink();

} // SystemUnitClassType
