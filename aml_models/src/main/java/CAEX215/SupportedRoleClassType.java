/**
 */
package CAEX215;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supported Role Class Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.SupportedRoleClassType#getMappingObject <em>Mapping Object</em>}</li>
 *   <li>{@link CAEX215.SupportedRoleClassType#getRefRoleClassPath <em>Ref Role Class Path</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getSupportedRoleClassType()
 * @model extendedMetaData="name='SupportedRoleClass_._type' kind='elementOnly'"
 * @generated
 */
public interface SupportedRoleClassType extends CAEXBasicObject {
	/**
	 * Returns the value of the '<em><b>Mapping Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Object</em>' containment reference.
	 * @see #setMappingObject(MappingType)
	 * @see CAEX215.CAEX215Package#getSupportedRoleClassType_MappingObject()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MappingObject' namespace='##targetNamespace'"
	 * @generated
	 */
	MappingType getMappingObject();

	/**
	 * Sets the value of the '{@link CAEX215.SupportedRoleClassType#getMappingObject <em>Mapping Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Object</em>' containment reference.
	 * @see #getMappingObject()
	 * @generated
	 */
	void setMappingObject(MappingType value);

	/**
	 * Returns the value of the '<em><b>Ref Role Class Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Role Class Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Role Class Path</em>' attribute.
	 * @see #setRefRoleClassPath(String)
	 * @see CAEX215.CAEX215Package#getSupportedRoleClassType_RefRoleClassPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='RefRoleClassPath' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRefRoleClassPath();

	/**
	 * Sets the value of the '{@link CAEX215.SupportedRoleClassType#getRefRoleClassPath <em>Ref Role Class Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Role Class Path</em>' attribute.
	 * @see #getRefRoleClassPath()
	 * @generated
	 */
	void setRefRoleClassPath(String value);

} // SupportedRoleClassType
