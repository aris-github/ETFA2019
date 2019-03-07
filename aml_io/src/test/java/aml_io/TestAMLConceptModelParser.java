package aml_io;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import CAEX215.CAEX215Factory;
import CAEX215.CAEXFileType;
import CAEX215.InstanceHierarchyType;
import CAEX215.InternalElementType;
import concept.model.AMLConceptModel;
import concept.tree.GenericTreeNode;
import exporter.AMLExporter;
import importer.AMLImporter;
import parser.AMLParser;
import tree.AMLConceptModelTree;
import tree.AMLConceptModelTreeParser;

public class TestAMLConceptModelParser {

	private static AMLImporter importer;	
	
	public TestAMLConceptModelParser() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException, ClassNotFoundException, InstantiationException, NoSuchFieldException{
		importer = new AMLImporter("CAEX215");		
	}
	
	public List<AMLConceptModelTree> readModels (String conceptModelFile) throws NoSuchMethodException, SecurityException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException, NoSuchFieldException,
		ParserConfigurationException, SAXException, IOException, DOMException, DatatypeConfigurationException {
		
		AMLParser parser = new AMLParser(conceptModelFile);
		Document caex = parser.getDoc();		
		CAEXFileType aml = (CAEXFileType) importer.doImport(caex, false);	
		AMLConceptModelTreeParser conceptParser = new AMLConceptModelTreeParser();
		
		List<AMLConceptModelTree> trees = new ArrayList<AMLConceptModelTree>();
		for(InternalElementType obj : aml.getInstanceHierarchy().get(0).getInternalElement()) {
						
			if(obj.getName().contains("Q")) {
				GenericTreeNode<AMLConceptModel> root = conceptParser.parse(obj);
				AMLConceptModelTree tree = new AMLConceptModelTree(root);
				trees.add(tree);
			}					
		}
		
		return trees;
	}
	
	public List<InternalElementType> readIE (String sourceFile) throws ParserConfigurationException, SAXException, IOException, DOMException, DatatypeConfigurationException {
		
		AMLParser parser = new AMLParser(sourceFile);
		Document caex = parser.getDoc();	
		CAEXFileType aml = (CAEXFileType) importer.doImport(caex, false);			
		
		List<InternalElementType> roots = new ArrayList<InternalElementType>();
		for(InternalElementType obj : aml.getInstanceHierarchy().get(0).getInternalElement()) {
			
			if(obj.getName().contains("Q")) {				
				roots.add(obj);				
			}					
		}
		
		return roots;
	}
	
	public void write(String output, List<InternalElementType> roots) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		CAEXFileType amlTestWrite = CAEX215Factory.eINSTANCE.createCAEXFileType();
		InstanceHierarchyType test = CAEX215Factory.eINSTANCE.createInstanceHierarchyType();
		test.setName("testWrite");
		for(InternalElementType ie : roots) {
			test.getInternalElement().add(ie);
		}
		amlTestWrite.getInstanceHierarchy().add(test);
		AMLExporter exporter = new AMLExporter(amlTestWrite);
		exporter.write("src/test/resources/TestWriteConceptModels.aml");
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException, NoSuchFieldException, ParserConfigurationException, SAXException, IOException, DOMException, DatatypeConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		
		String modelFile = "src/test/resources/concepts.aml";
		
		TestAMLConceptModelParser tester = new TestAMLConceptModelParser();
		
		List<AMLConceptModelTree> trees = tester.readModels(modelFile);
		for(AMLConceptModelTree tree : trees) {
			System.out.println(tree.toString());
		}
		
//		String output = "src/test/resources/conceptTestWrite.aml";
//		List<InternalElementType> ies = tester.readIE(modelFile);
//		tester.write(output, ies);
//		
//		List<AMLConceptModelTree> trees2 = tester.readModels(output);
//		for(AMLConceptModelTree tree : trees2) {
//			System.out.println(tree.toString());
//		}
	}

}
