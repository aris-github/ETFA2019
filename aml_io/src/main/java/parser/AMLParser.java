package parser;

import parser.Utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder; 
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * An AML parser that turns an AML file into an XML object hierarchy.
 * @author Benjamin Alt
 */
public class AMLParser {

	private Document doc;
	
	
	public AMLParser(File file) throws ParserConfigurationException, SAXException, IOException {
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
	    doc = documentBuilder.parse(file);
	}
	
	/**
	 * Constructs a new AMLParser for the file 
	 * @param filename
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public AMLParser(String filename) throws ParserConfigurationException, SAXException, IOException {
//	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//	    DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
//	    doc = documentBuilder.parse(new File(filename));
		this(new File(filename));
	}
	

	
	/**
	 * Get the XML document tree
	 * @return The XML document tree
	 */
	public Document getDoc() {
		return doc;
	}
	
	/**
	 * Test client: Reads in AML file and prints the resulting document tree.
	 * @param args Command-line arguments (aml filename expected)
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws TransformerException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		if (args.length < 1) {
			throw new IllegalArgumentException("Command-line argument 'filename' required.");
		}
		AMLParser parser = new AMLParser(args[0]); 
		Document doc = parser.getDoc();
		Utils.printDocument(doc, System.out);
	}
}
