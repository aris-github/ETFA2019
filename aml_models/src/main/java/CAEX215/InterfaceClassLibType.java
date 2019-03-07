/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Class Lib Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.InterfaceClassLibType#getInterfaceClass <em>Interface Class</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getInterfaceClassLibType()
 * @model extendedMetaData="name='InterfaceClassLib_._type' kind='elementOnly'"
 * @generated
 */
public interface InterfaceClassLibType extends CAEXObject {
	/**
	 * Returns the value of the '<em><b>Interface Class</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.InterfaceFamilyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Class definition for interfaces.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface Class</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getInterfaceClassLibType_InterfaceClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InterfaceClass' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InterfaceFamilyType> getInterfaceClass();

} // InterfaceClassLibType
