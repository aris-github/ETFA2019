/**
 */
package CAEX215;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unknown Type Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.UnknownTypeType#getRequirements <em>Requirements</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getUnknownTypeType()
 * @model extendedMetaData="name='UnknownType_._type' kind='elementOnly'"
 * @generated
 */
public interface UnknownTypeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines informative requirements as a constraint for an attribute value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Requirements</em>' attribute.
	 * @see #setRequirements(String)
	 * @see CAEX215.CAEX215Package#getUnknownTypeType_Requirements()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Requirements' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRequirements();

	/**
	 * Sets the value of the '{@link CAEX215.UnknownTypeType#getRequirements <em>Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirements</em>' attribute.
	 * @see #getRequirements()
	 * @generated
	 */
	void setRequirements(String value);

} // UnknownTypeType
