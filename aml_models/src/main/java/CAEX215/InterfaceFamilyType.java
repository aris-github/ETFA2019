/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Family Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines base structures for a hierarchical InterfaceClass tree. The hierarchical structure of an interface library has organizational character only.  
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.InterfaceFamilyType#getInterfaceClass <em>Interface Class</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getInterfaceFamilyType()
 * @model extendedMetaData="name='InterfaceFamilyType' kind='elementOnly'"
 * @generated
 */
public interface InterfaceFamilyType extends InterfaceClassType {
	/**
	 * Returns the value of the '<em><b>Interface Class</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.InterfaceFamilyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element that allows definition of child InterfaceClasses within the class hierarchy. The parent child relation between two InterfaceClasses has no semantic.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface Class</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getInterfaceFamilyType_InterfaceClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InterfaceClass' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InterfaceFamilyType> getInterfaceClass();

} // InterfaceFamilyType
