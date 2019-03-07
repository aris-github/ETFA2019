package importer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.net.MalformedURLException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import CAEX215.AttributeType;
import CAEX215.CAEXFileType;
import CAEX215.InternalElementType;
import CAEX215.SystemUnitClassLibType;
import CAEX215.SystemUnitFamilyType;
import parser.AMLParser;

public class AMLImporter extends AbstractXMLImporter {
	
	private EPackage modelPackage;
	
	/**
	 * Create a new AMLImporter from a given package location and name.
	 * @param packageName The name of the generated package (must be on classpath)
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws MalformedURLException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws NoSuchFieldException 
	 */
	public AMLImporter(String packageName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException, ClassNotFoundException, InstantiationException, NoSuchFieldException {
		modelPackage = loadModelPackage(packageName);
	}
	
	public AMLImporter(EPackage modelPackage) {
		this.modelPackage = modelPackage;
	}
	
	@Override
	protected EPackage getModelPackage() {
		return modelPackage;
	}
	
	@Override
	protected void addEEnumAttribute(EObject object, EAttribute attribute, String literalString) {
		Object attr = object.eGet(attribute);
		Class<?> attrClass = attr.getClass();
		try {
			Method literalGetter = attrClass.getMethod("get", String.class);
			Object literal = literalGetter.invoke(attr, literalString);
			object.eSet(attribute, literal);
		} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println("Couln't find method get for Enum Type " + attrClass.getName());
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private EPackage loadModelPackage(String packageName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException, ClassNotFoundException, InstantiationException, NoSuchFieldException {
	    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	    String[] splitName = packageName.split("\\.");
	    String classModelName = splitName[splitName.length - 1];
	    System.out.println("Trying to load package for model " + classModelName);
	    try {
	    	System.out.println("Loading class " + packageName + "." + classModelName + "Package...");
			Class<?> packageClass = classLoader.loadClass(packageName + "." + classModelName + "Package");
			Field instanceField = packageClass.getField("eINSTANCE");
			return (EPackage) instanceField.get(null);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		}
	}
}
