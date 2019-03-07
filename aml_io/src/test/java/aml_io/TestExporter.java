package aml_io;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import CAEX215.CAEXFileType;
import exporter.AMLExporter;
import importer.AMLImporter;
import parser.AMLParser;

public class TestExporter {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
		ClassNotFoundException, InstantiationException, NoSuchFieldException, ParserConfigurationException, SAXException, IOException, DOMException, DatatypeConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		System.out.println("=============== Loading AML file from file system ================");
		AMLImporter importer = new AMLImporter("CAEX215");
		AMLParser parser = new AMLParser("./src/test/resources/test.aml"); 
		Document doc = parser.getDoc();		
		CAEXFileType caex = (CAEXFileType) importer.doImport(doc, false);
 		System.out.println("Loaded AML file");
 		
 		System.out.println("=============== Writing AML file to file system ================");
		AMLExporter exporter = new AMLExporter(caex);
		exporter.write("./src/test/resources/testOut.aml");
 		System.out.println("saved AML file");
	}

}
