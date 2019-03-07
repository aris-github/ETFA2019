/**
 */
package CAEX215;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines base structures for attribute definitions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.AttributeType#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link CAEX215.AttributeType#getValue <em>Value</em>}</li>
 *   <li>{@link CAEX215.AttributeType#getRefSemantic <em>Ref Semantic</em>}</li>
 *   <li>{@link CAEX215.AttributeType#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link CAEX215.AttributeType#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link CAEX215.AttributeType#getAttributeDataType <em>Attribute Data Type</em>}</li>
 *   <li>{@link CAEX215.AttributeType#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getAttributeType()
 * @model extendedMetaData="name='AttributeType' kind='elementOnly'"
 * @generated
 */
public interface AttributeType extends CAEXObject {
	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A predefined default value for an attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(AnyType)
	 * @see CAEX215.CAEX215Package#getAttributeType_DefaultValue()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='DefaultValue' namespace='##targetNamespace'"
	 * @generated
	 */
	AnyType getDefaultValue();

	/**
	 * Sets the value of the '{@link CAEX215.AttributeType#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(AnyType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element describing the value of an attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(AnyType)
	 * @see CAEX215.CAEX215Package#getAttributeType_Value()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Value' namespace='##targetNamespace'"
	 * @generated
	 */
	AnyType getValue();

	/**
	 * Sets the value of the '{@link CAEX215.AttributeType#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(AnyType value);

	/**
	 * Returns the value of the '<em><b>Ref Semantic</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.RefSemanticType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reference to a definition of a defined attribute, e. g. to an attribute in a standardized library, this allows the semantic definition of the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref Semantic</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getAttributeType_RefSemantic()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='RefSemantic' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RefSemanticType> getRefSemantic();

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.AttributeValueRequirementType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element to restrict the range of validity of a defined attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getAttributeType_Constraint()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Constraint' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AttributeValueRequirementType> getConstraint();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.AttributeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Element that allows the description of nested attributes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getAttributeType_Attribute()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Attribute' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AttributeType> getAttribute();

	/**
	 * Returns the value of the '<em><b>Attribute Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the data type of the attribute using XML notation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute Data Type</em>' attribute.
	 * @see #setAttributeDataType(String)
	 * @see CAEX215.CAEX215Package#getAttributeType_AttributeDataType()
	 * @model dataType="CAEX215.AttributeDataTypeType"
	 *        extendedMetaData="kind='attribute' name='AttributeDataType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getAttributeDataType();

	/**
	 * Sets the value of the '{@link CAEX215.AttributeType#getAttributeDataType <em>Attribute Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Data Type</em>' attribute.
	 * @see #getAttributeDataType()
	 * @generated
	 */
	void setAttributeDataType(String value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the unit of the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see CAEX215.CAEX215Package#getAttributeType_Unit()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Unit' namespace='##targetNamespace'"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link CAEX215.AttributeType#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

	String getStringValue();

	List<AttributeType> getAllAttributes();

} // AttributeType
