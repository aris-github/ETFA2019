/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Unit Class Lib Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.SystemUnitClassLibType#getSystemUnitClass <em>System Unit Class</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getSystemUnitClassLibType()
 * @model extendedMetaData="name='SystemUnitClassLib_._type' kind='elementOnly'"
 * @generated
 */
public interface SystemUnitClassLibType extends CAEXObject {
	/**
	 * Returns the value of the '<em><b>System Unit Class</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.SystemUnitFamilyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Shall be used for SystemUnitClass definition, provides definition of a class of a SystemUnitClass type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>System Unit Class</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getSystemUnitClassLibType_SystemUnitClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SystemUnitClass' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SystemUnitFamilyType> getSystemUnitClass();

} // SystemUnitClassLibType
