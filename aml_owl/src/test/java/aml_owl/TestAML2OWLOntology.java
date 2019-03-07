package aml_owl;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.ecore.EPackage;
import org.semanticweb.owlapi.formats.RDFXMLDocumentFormatFactory;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import CAEX215.CAEX215Package;
import CAEX215.CAEXFileType;
import constants.Consts;
import importer.AMLImporter;
import parser.AMLParser;
import translation.simple.AML2OWLOntology;

public class TestAML2OWLOntology {

	/**
	 * @param args
	 * @throws OWLOntologyStorageException 
	 * @throws OWLOntologyCreationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws DatatypeConfigurationException 
	 * @throws DOMException 
	 */
	public static void main(String[] args) throws OWLOntologyStorageException, OWLOntologyCreationException, IOException, ParserConfigurationException, SAXException, DOMException, DatatypeConfigurationException {
		
		String amlName = "clean";
		if(args.length != 0) {
//			System.out.println("Not enough command line arguments: need the AML file name");
//			System.exit(0);
			amlName = args[0];
		}	    		
				
		String amlPath = "";
		JFileChooser jfc = new JFileChooser("src/test/resources/iiwa.aml");
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			amlName = jfc.getSelectedFile().getName();
			amlPath = jfc.getSelectedFile().getParent();
			System.out.println(amlPath);
			System.out.println("selected config file: " + amlName);
		}		
		
		// parse the aml file
		System.out.println("=============== Loading AML file from file system ================\n");	
//		AMLParser parser = new AMLParser(Consts.resources + "/aml/" + amlName);		
		AMLParser parser = new AMLParser(amlPath + "/" + amlName);		
		EPackage modelPackage = CAEX215Package.eINSTANCE;
		
		// import the aml file 
		AMLImporter importer = new AMLImporter(modelPackage);		
		CAEXFileType aml = (CAEXFileType) importer.doImport(parser.getDoc(), false);

		// initialize the transformer
//		TransformAML2OWL tr = new TransformAML2OWL(path + "/standards/aml.owl");
		AML2OWLOntology tr = new AML2OWLOntology(null);
		        
        // create the target ontology
        tr.createOnt(IRI.create(Consts.importer_pref));
        
        // add the data property for semantic annotation to CAEX types - changed to native RDF property: rdfs:comment
//        OWLDataProperty hasAMLSemantic = tr.factory.getOWLDataProperty(AMLDataPropertyIRIs.HAS_AML_SEMANTIC); //hasAttributeValue
//        OWLDeclarationAxiom ax_hasAMLSemantic = tr.factory.getOWLDeclarationAxiom(hasAMLSemantic);
//        AddAxiom addAxiom_hasAMLSemantic = new AddAxiom(tr.output, ax_hasAMLSemantic);
//        tr.manager.applyChange(addAxiom_hasAMLSemantic);
        
        // traverse the aml file and apply transformation
        tr.transformAML2OWL(aml);        
        
        // save the transformed ontology to disk
        RDFXMLDocumentFormatFactory factory = new RDFXMLDocumentFormatFactory();
//        tr.save(tr.new_ont, factory.createFormat(), Consts.dir + "/../../resources/output/test.owl");
//        tr.save(tr.output_ont, factory.createFormat(), Consts.resources + "/output/aml.owl");
        tr.save(tr.output_ont, factory.createFormat(), amlPath + "/aml.owl");

      
        
//        File iosb_file = new File("/Users/aris/Desktop/iosb/ContosoTopologyDescription.json");
//        JSONObject obj = new JSONObject(new String(Files.readAllBytes(Paths.get("/Users/aris/Desktop/iosb/ContosoTopologyDescription.json"))));
//        List<Object> factories = ((JSONArray) obj.get("Factories")).toList();
//        for(int i = 0; i < factories.size(); i++) {
//        		JSONObject
//        }

        
//        URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
//        try (InputStream is = url.openStream();
//        JsonReader rdr = Json.createReader(is)) {        
//	        JsonObject obj = rdr.readObject();
//	        JsonArray results = obj.getJsonArray("data");
//	        for (JsonObject result : results.getValuesAs(JsonObject.class)) {
//	        		System.out.print(result.getJsonObject("from").getString("name"));
//	        		System.out.print(": ");
//	        		System.out.println(result.getString("message", ""));
//	        		System.out.println("-----------");
//	       }
//       }
	}
}
