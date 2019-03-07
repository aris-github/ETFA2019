/**
 */
package CAEX215;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Hierarchy Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CAEX215.InstanceHierarchyType#getInternalElement <em>Internal Element</em>}</li>
 * </ul>
 *
 * @see CAEX215.CAEX215Package#getInstanceHierarchyType()
 * @model extendedMetaData="name='InstanceHierarchy_._type' kind='elementOnly'"
 * @generated
 */
public interface InstanceHierarchyType extends CAEXObject {
	/**
	 * Returns the value of the '<em><b>Internal Element</b></em>' containment reference list.
	 * The list contents are of type {@link CAEX215.InternalElementType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Shall be used in order to define nested objects inside of a SystemUnitClass or another InternalElement. Allows description of the internal structure of an CAEX object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Internal Element</em>' containment reference list.
	 * @see CAEX215.CAEX215Package#getInstanceHierarchyType_InternalElement()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='InternalElement' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InternalElementType> getInternalElement();

} // InstanceHierarchyType
