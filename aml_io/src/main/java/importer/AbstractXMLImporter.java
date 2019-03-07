package importer;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class AbstractXMLImporter {

	private final XMLTypePackage xmlPackage = XMLTypePackage.eINSTANCE;
	private final XMLTypeFactory xmlFactory = XMLTypeFactory.eINSTANCE;
	
	/**
	 * Import a given XML object hierarchy
	 * @param doc The XML object hierarchy
	 * @return The root objects of the Java object hierarchy
	 * @throws DatatypeConfigurationException 
	 * @throws DOMException 
	 * @throws IOException 
	 */
	public EObject doImport(Document doc, boolean verbose) throws DOMException, DatatypeConfigurationException {
		EPackage modelPackage = getModelPackage();
		Node root = doc.getDocumentElement();
		EClassifier rootObjClassifier = Utils.getEClassifierByName(modelPackage, root.getNodeName());
		if (rootObjClassifier == null || !(rootObjClassifier instanceof EClass)) {
			throw new RuntimeException("Cannot find model equivalent to root element " + root.getNodeName());
		}
		EObject rootObj = modelPackage.getEFactoryInstance().create((EClass)rootObjClassifier);
		recursiveImport(root, rootObj, verbose);
		return rootObj;
	}
	
	/**
	 * Get a String representation of the model this importer instance was instantiated with.
	 */
	public String getModelStructure() {
		StringBuilder modelStruct = new StringBuilder("");
		for (Iterator<EClassifier> iter = getModelPackage().getEClassifiers().iterator(); iter.hasNext(); ) {
			EClassifier classifier = (EClassifier) iter.next();
			modelStruct.append(classifier.getName() + "\n  ");
			if (classifier instanceof EClass) {
				EClass eClass = (EClass) classifier;
				for (Iterator<EAttribute> ai = eClass.getEAttributes().iterator(); ai.hasNext(); ) {
					EAttribute attribute = (EAttribute) ai.next();
					modelStruct.append("[A]" + attribute.getName() + " ");
				}
				if (!eClass.getEAttributes().isEmpty() && !eClass.getEReferences().isEmpty()) {
					modelStruct.append("\n  ");
				}
				for (Iterator<EReference> ri = eClass.getEReferences().iterator(); ri.hasNext(); ) {
					EReference reference = (EReference) ri.next();
					modelStruct.append("[R]" + reference.getName() + " ");
				}
			} else if (classifier instanceof EEnum) {
				EEnum eEnum = (EEnum) classifier;
				for (Iterator<EEnumLiteral> ei = eEnum.getELiterals().iterator(); ei.hasNext(); ) {
					EEnumLiteral literal = (EEnumLiteral) ei.next();
					modelStruct.append("[E]" + literal.getName() + " ");
				}
			} else if (classifier instanceof EDataType) {
				EDataType eDataType = (EDataType) classifier;
				modelStruct.append("[D]" + eDataType.getInstanceClassName());
			}
			modelStruct.append("\n");
		}
		return modelStruct.toString();
	}
	
	/**
	 * Get a String representation of an EObject.
	 * @param object The object to print
	 * @return A string representation of the object
	 */
	public String eObjectToString(EObject object) {
		StringBuilder objectString = new StringBuilder("");
		objectString = eObjectToString(object, 0, objectString);
		return objectString.toString();
	}
		
	protected abstract EPackage getModelPackage(); 
	
	protected abstract void addEEnumAttribute(EObject object, EAttribute attribute, String literalString);
	
	/* The object corresponds to the current node */
	private void recursiveImport(Node node, EObject object, boolean verbose) throws DOMException, DatatypeConfigurationException {
		if(verbose)
			System.out.println("Processing [" + node.getNodeName() + "]");
		if (object instanceof AnyType) {
			NamedNodeMap attributes = node.getAttributes();
			for (int i = 0; i < attributes.getLength(); i++) {
				Node nodeAttribute = attributes.item(i);
				Entry entry = FeatureMapUtil.createRawEntry(xmlPackage.getAnyType_AnyAttribute(), nodeAttribute.getNodeName() + "=" + nodeAttribute.getNodeValue());
				((FeatureMap)object.eGet(xmlPackage.getAnyType_AnyAttribute())).add(entry);
				if(verbose)
					System.out.println("Added attribute [" + nodeAttribute.getNodeName() + "] to AnyAttribute FeatureMap of [" + node.getNodeName() + "]");
			}
			NodeList children = node.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node childNode = children.item(i);
				switch (childNode.getNodeType()) {
				case Node.ELEMENT_NODE:
					AnyType childObj = xmlFactory.createAnyType();
					recursiveImport(childNode, childObj, verbose);
					ResourceSet resourceSet = new ResourceSetImpl();
					final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(resourceSet.getPackageRegistry());
					EStructuralFeature newFeature = extendedMetaData.demandFeature(childNode.getNamespaceURI(), childNode.getNodeName(), true);
					((FeatureMap) object.eGet(xmlPackage.getAnyType_Any())).add(newFeature, childObj);
					if(verbose)
						System.out.println("Added [" + childNode.getNodeName() + "] to AnyType FeatureMap of [" + node.getNodeName() + "]");
					break;
				case Node.TEXT_NODE:
					if (childNode.getNodeValue().trim().length() != 0) {
						FeatureMapUtil.addText(((AnyType)object).getMixed(), childNode.getNodeValue());
						if(verbose)
							System.out.println("Added text value [" + childNode.getNodeValue() + "] to [" + node.getNodeName() + "]");
					}
					break;
				}
			}
			return;
		}
		// Set attributes
		NamedNodeMap attributes = node.getAttributes();
		for (int j = 0; j < attributes.getLength(); j++) {
			Node nodeAttribute = attributes.item(j);
			for (EAttribute attribute : object.eClass().getEAllAttributes()) {
				if (attribute.getName().toLowerCase().equals(nodeAttribute.getNodeName().toLowerCase())) {
					if (attribute.getEAttributeType() instanceof EEnum) {
						addEEnumAttribute(object, attribute, nodeAttribute.getNodeValue());
					} else {
						// This only works if attribute is of simple type
						object.eSet(attribute, nodeAttribute.getNodeValue());
					}
					if(verbose)
						System.out.println("Set attribute [" + attribute.getName() + "] of [" + node.getNodeName() + "] to [" + nodeAttribute.getNodeValue() + "]");
					break;
				}
			}
		}
		// Fill child object references
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node childNode = children.item(i);
			switch (childNode.getNodeType()) {
			case Node.ELEMENT_NODE:
				for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
					if (feature.getName().toLowerCase().equals(childNode.getNodeName().toLowerCase())) {
						if (feature instanceof EReference) {
							EReference reference = (EReference) feature;
							EClass type = Utils.getInstantiableEClass(reference.getEReferenceType());
							if (type != null && reference.isChangeable()) {
								if (reference.isMany()) {
									EList list = (EList)object.eGet(reference);
									EObject obj = EcoreUtil.create(type);
									if(verbose)
										System.out.println("Set many-valued reference [" + childNode.getNodeName() + "] in [" + node.getNodeName() + "]");
									recursiveImport(childNode, obj, verbose);
									list.add(obj);
									break;
								} else {
									EObject obj = EcoreUtil.create(type);
									if(verbose)
										System.out.println("Set single-valued reference [" + childNode.getNodeName() + "] in [" + node.getNodeName() + "]");
									recursiveImport(childNode, obj, verbose);
									object.eSet(reference, obj);
									break;
								}
							}
							break;
						}
						else if (feature instanceof EAttribute) {
							EAttribute attr = (EAttribute) feature;
							/* No recursion here; attributes are dead ends --> simple type */
							Node grandchildNode = childNode.getFirstChild();
							EClassifier type = attr.getEType();
							if (type.getName().equals("DateTime")) {
								XMLGregorianCalendar dt = DatatypeFactory.newInstance().newXMLGregorianCalendar(grandchildNode.getNodeValue());
								object.eSet(attr, dt);
							} else {
								object.eSet(attr, grandchildNode.getNodeValue());
							}
							if(verbose)
								System.out.println("Set attribute [" + attr.getName() + "] of [" + node.getNodeName() + "] to [" + grandchildNode.getNodeValue() + "]");
							break;
						}
					}
				}
				break;
			case Node.ATTRIBUTE_NODE:
				if(verbose)
					System.err.println("Attribute node!");
				break;
			case Node.TEXT_NODE:
				if (childNode.getNodeValue().trim().length() == 0) {
				} else {
					try {
						EClass eClass = object.eClass();
						boolean found = false;
						for (EStructuralFeature feature : eClass.getEStructuralFeatures()) {
							if (feature.getName().equals("value")) {
								found = true;
								object.eSet(feature, childNode.getNodeValue());
								if(verbose)
									System.out.println("Set attribute 'value' of [" + node.getNodeName() + "] to [" + childNode.getNodeValue() + "]");
								break;
							}
						}
						if (!found) {
							if(verbose)
								System.err.println("Could not set " + childNode.getNodeValue() + " on " + node.getNodeName() + " of type " + eClass.getName());
						}
					} catch (IllegalArgumentException | DOMException e) {
						if(verbose)
							System.err.println("Attribute 'value' could not be set/get on object of type " + object.getClass().getName() + ", no such method");
					}
				}
				break;
			}
		}
		// If I can't find the corresponding model element, ignore this DOM node
		if(verbose)
			System.out.println("Done with " + node.getNodeName());
	}
	
	/* Recursive method to build a String representation of an EObject instance */
	private StringBuilder eObjectToString(EObject object, int indentationLevel, StringBuilder sb) {
		if (object.getClass() == EObjectImpl.class) return sb;
		String indent = "";
		String preIndent = "";
		for (int i = 0; i < indentationLevel + 1; i++) {
			indent += " ";
			if (i < indentationLevel) preIndent += " ";
		}
		EClass eClass = object.eClass();
		sb.append(preIndent + eClass.getName() + "\n");
		for (EAttribute attr : eClass.getEAllAttributes()) {
			if (object.eGet(attr) != null) {
				sb.append(indent + attr.getName() + ": " + object.eGet(attr) + "\n");
			}
		}
		for (EReference ref : eClass.getEAllReferences()) {
			if (object.eGet(ref) == null) continue;
			if (ref.isMany()) {
				EList list = (EList)object.eGet(ref);
				if (!list.isEmpty()) {
					sb.append(indent + ref.getName() + "[" + list.size() + "]\n");
					for (Object obj : list) {
						sb = eObjectToString((EObject)obj, indentationLevel + 1, sb);
					}
				}
			} else {
				sb.append(indent + ref.getName() + "\n");
				sb = eObjectToString((EObject)(object.eGet(ref)), indentationLevel + 1, sb);
			}
		}
		return sb;
	}
}
