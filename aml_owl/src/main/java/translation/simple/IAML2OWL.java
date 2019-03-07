package translation.simple;
/**
 * 
 */


import org.semanticweb.owlapi.model.OWLOntology;

import CAEX215.CAEXFileType;

/**
 * @author hua
 * This interface transforms AML to RDF triples
 */
public interface IAML2OWL {
	
	public boolean verifiyAML(CAEXFileType aml);
	
	public OWLOntology transformAML2OWL(CAEXFileType aml);
	
	
}
