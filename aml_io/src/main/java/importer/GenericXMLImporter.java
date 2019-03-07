package importer;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.common.util.URI;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import parser.AMLParser;

public class GenericXMLImporter extends AbstractXMLImporter {

	private EPackage modelPackage;
	
	/**
	 * Construct a new AMLImporter
	 * @param ecoreModelPath: Path to the .ecore model file 
	 */
	public GenericXMLImporter(String ecoreModelPath) {
		modelPackage = loadModelPackage(ecoreModelPath);
	}
	
	@Override
	protected EPackage getModelPackage() {
		return modelPackage;
	}
	
	@Override
	protected void addEEnumAttribute(EObject object, EAttribute attribute, String literalString) {
		EEnumLiteral attr = (EEnumLiteral)(object.eGet(attribute));
		EEnum eEnum = attr.getEEnum();
		EEnumLiteral l = eEnum.getEEnumLiteralByLiteral(literalString);
		object.eSet(attribute, l);		
	}
	
	/**
	 * Load an EMF model package from the path of its .ecore equivalent.
	 * @param ecoreModelPath Path to the ecore model
	 * @return The package (dynamic EMF) for creating the Java classes
	 */
	private EPackage loadModelPackage(String ecoreModelPath) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(ecoreModelPath);
		/* Ugly hack to register resource factory, see https://www.eclipse.org/forums/index.php/t/123514/ */
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap( ).put("ecore",
				new XMIResourceFactoryImpl() {
					public Resource createResource(URI uri)
						{
							XMIResource xmiResource = new XMIResourceImpl(uri);
							return xmiResource;
						}
					}
		);
		Resource resource = resourceSet.getResource(fileURI, true);
		return (EPackage)resource.getContents().get(0);
	}
	
	/**
	 * Test client: Reads in AML file and prints the resulting Java objects.
	 * @param args Command-line arguments (aml filename expected)
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws DatatypeConfigurationException 
	 * @throws DOMException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, DOMException, DatatypeConfigurationException {
		if (args.length < 1) {
			throw new IllegalArgumentException("Command-line argument 'filename' required.");
		}		//importer.printEObject(obj);

		AMLParser parser = new AMLParser(args[0]); 
		Document doc = parser.getDoc();
		GenericXMLImporter importer = new GenericXMLImporter("../aml_emf/model/CAEX215.ecore");
		EObject obj = importer.doImport(doc, false);
		System.out.println(importer.eObjectToString(obj));
	}
}
