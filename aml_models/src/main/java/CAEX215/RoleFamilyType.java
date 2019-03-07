/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Family Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines base structures for a hierarchical RoleClass tree. The hierarchical structure of a role library has organizational character only. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.RoleFamilyType#getRoleClass <em>Role Class</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getRoleFamilyType()
 * @model extendedMetaData="name='RoleFamilyType' kind='elementOnly'"
 * @generated
 */
public interface RoleFamilyType extends RoleClassType {
	/**
	 * Returns the value of the '<em><b>Role Class</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.RoleFamilyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element that allows definition of child RoleClasses within the class hierarchy. The parent child relation between two RoleClasses has no semantic.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Role Class</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getRoleFamilyType_RoleClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RoleClass' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RoleFamilyType> getRoleClass();

} // RoleFamilyType
