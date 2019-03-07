package aml_io;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import CAEX215.CAEXFileType;
import importer.AMLImporter;
import parser.AMLParser;

public class TestImporter {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException, NoSuchFieldException, ParserConfigurationException, SAXException, IOException, DOMException, DatatypeConfigurationException {
		if (args.length < 1) {
			throw new IllegalArgumentException("Command-line argument 'filename' required.");
		}
		
		System.out.println("=============== Loading AML file from file system ================");
		AMLImporter importer = new AMLImporter("CAEX215");
		AMLParser parser = new AMLParser(args[0]); 
		Document doc = parser.getDoc();		
		CAEXFileType amlFile = (CAEXFileType) importer.doImport(doc, false);
 		System.out.println("Loaded AML file: " + args[0]);
		
		// print debug information with example of iiwa
//		importer.print_iiwa(amlFile);
		
		
		/* Could also implement something like this: 
		importer.getAll(obj, edu.kit.aml.model.caex.CAEXClassModelV215New.InterfaceClassType.class);
		*/
	}

}
