/**
 */
package CAEX215;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordinal Scaled Type Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.OrdinalScaledTypeType#getRequiredMaxValue <em>Required Max Value</em>}</li>
 *   <li>{@link CAEX215.OrdinalScaledTypeType#getRequiredValue <em>Required Value</em>}</li>
 *   <li>{@link CAEX215.OrdinalScaledTypeType#getRequiredMinValue <em>Required Min Value</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getOrdinalScaledTypeType()
 * @model extendedMetaData="name='OrdinalScaledType_._type' kind='elementOnly'"
 * @generated
 */
public interface OrdinalScaledTypeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Required Max Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element to define a maximum value of an attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required Max Value</em>' containment reference.
	 * @see #setRequiredMaxValue(AnyType)
	 * @see CAEX215.CAEX215Package#getOrdinalScaledTypeType_RequiredMaxValue()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RequiredMaxValue' namespace='##targetNamespace'"
	 * @generated
	 */
	AnyType getRequiredMaxValue();

	/**
	 * Sets the value of the '{@link CAEX215.OrdinalScaledTypeType#getRequiredMaxValue <em>Required Max Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Max Value</em>' containment reference.
	 * @see #getRequiredMaxValue()
	 * @generated
	 */
	void setRequiredMaxValue(AnyType value);

	/**
	 * Returns the value of the '<em><b>Required Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element to define a required value of an attribute. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required Value</em>' containment reference.
	 * @see #setRequiredValue(AnyType)
	 * @see CAEX215.CAEX215Package#getOrdinalScaledTypeType_RequiredValue()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RequiredValue' namespace='##targetNamespace'"
	 * @generated
	 */
	AnyType getRequiredValue();

	/**
	 * Sets the value of the '{@link CAEX215.OrdinalScaledTypeType#getRequiredValue <em>Required Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Value</em>' containment reference.
	 * @see #getRequiredValue()
	 * @generated
	 */
	void setRequiredValue(AnyType value);

	/**
	 * Returns the value of the '<em><b>Required Min Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element to define a minimum value of an attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required Min Value</em>' containment reference.
	 * @see #setRequiredMinValue(AnyType)
	 * @see CAEX215.CAEX215Package#getOrdinalScaledTypeType_RequiredMinValue()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RequiredMinValue' namespace='##targetNamespace'"
	 * @generated
	 */
	AnyType getRequiredMinValue();

	/**
	 * Sets the value of the '{@link CAEX215.OrdinalScaledTypeType#getRequiredMinValue <em>Required Min Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Min Value</em>' containment reference.
	 * @see #getRequiredMinValue()
	 * @generated
	 */
	void setRequiredMinValue(AnyType value);

} // OrdinalScaledTypeType
