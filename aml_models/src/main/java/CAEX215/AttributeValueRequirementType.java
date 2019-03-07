/**
 */
package CAEX215;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Requirement Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines base structures for definition of value requirements of an attribute.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.AttributeValueRequirementType#getOrdinalScaledType <em>Ordinal Scaled Type</em>}</li>
 *   <li>{@link CAEX215.AttributeValueRequirementType#getNominalScaledType <em>Nominal Scaled Type</em>}</li>
 *   <li>{@link CAEX215.AttributeValueRequirementType#getUnknownType <em>Unknown Type</em>}</li>
 *   <li>{@link CAEX215.AttributeValueRequirementType#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getAttributeValueRequirementType()
 * @model extendedMetaData="name='AttributeValueRequirementType' kind='elementOnly'"
 * @generated
 */
public interface AttributeValueRequirementType extends CAEXBasicObject {
	/**
	 * Returns the value of the '<em><b>Ordinal Scaled Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element of to define constraints of ordinal scaled attribute values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ordinal Scaled Type</em>' containment reference.
	 * @see #setOrdinalScaledType(OrdinalScaledTypeType)
	 * @see CAEX215.CAEX215Package#getAttributeValueRequirementType_OrdinalScaledType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='OrdinalScaledType' namespace='##targetNamespace'"
	 * @generated
	 */
	OrdinalScaledTypeType getOrdinalScaledType();

	/**
	 * Sets the value of the '{@link CAEX215.AttributeValueRequirementType#getOrdinalScaledType <em>Ordinal Scaled Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordinal Scaled Type</em>' containment reference.
	 * @see #getOrdinalScaledType()
	 * @generated
	 */
	void setOrdinalScaledType(OrdinalScaledTypeType value);

	/**
	 * Returns the value of the '<em><b>Nominal Scaled Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element of to define constraints of nominal scaled attribute values.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nominal Scaled Type</em>' containment reference.
	 * @see #setNominalScaledType(NominalScaledTypeType)
	 * @see CAEX215.CAEX215Package#getAttributeValueRequirementType_NominalScaledType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='NominalScaledType' namespace='##targetNamespace'"
	 * @generated
	 */
	NominalScaledTypeType getNominalScaledType();

	/**
	 * Sets the value of the '{@link CAEX215.AttributeValueRequirementType#getNominalScaledType <em>Nominal Scaled Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Scaled Type</em>' containment reference.
	 * @see #getNominalScaledType()
	 * @generated
	 */
	void setNominalScaledType(NominalScaledTypeType value);

	/**
	 * Returns the value of the '<em><b>Unknown Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element to define constraints for attribute values of an unknown scale type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unknown Type</em>' containment reference.
	 * @see #setUnknownType(UnknownTypeType)
	 * @see CAEX215.CAEX215Package#getAttributeValueRequirementType_UnknownType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='UnknownType' namespace='##targetNamespace'"
	 * @generated
	 */
	UnknownTypeType getUnknownType();

	/**
	 * Sets the value of the '{@link CAEX215.AttributeValueRequirementType#getUnknownType <em>Unknown Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unknown Type</em>' containment reference.
	 * @see #getUnknownType()
	 * @generated
	 */
	void setUnknownType(UnknownTypeType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the name of the contraint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see CAEX215.CAEX215Package#getAttributeValueRequirementType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link CAEX215.AttributeValueRequirementType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // AttributeValueRequirementType
