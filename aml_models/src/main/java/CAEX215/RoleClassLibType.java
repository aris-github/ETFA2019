/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Class Lib Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.RoleClassLibType#getRoleClass <em>Role Class</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getRoleClassLibType()
 * @model extendedMetaData="name='RoleClassLib_._type' kind='elementOnly'"
 * @generated
 */
public interface RoleClassLibType extends CAEXObject {
	/**
	 * Returns the value of the '<em><b>Role Class</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.RoleFamilyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Definition of a class of a role type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Role Class</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getRoleClassLibType_RoleClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RoleClass' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RoleFamilyType> getRoleClass();

	RoleFamilyType getRoleClassByPath(String rc_path);

} // RoleClassLibType
