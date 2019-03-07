package translation.simple;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import CAEX215.CAEXObject;

public abstract class AMLEntityHandler {

//	protected CAEXBasicObject aml_entity;
	
	protected OWLOntologyManager manager;
	protected String ns;
		
	/**
	 * Convert the AML entity to an OWL Entity
	 * RC -> Class
	 * IC -> Class
	 * SUC -> Individual
	 * Attribute -> data property with attribtue value
	 * EI -> object property
	 * IE -> Individual 
	 * @return
	 */
	public abstract OWLEntity cvt2Owl(CAEXObject obj, OWLOntology ont);
	
	/**
	 * Add the converted AML entity (CAEX object) to the ontology referencing to the given OWL entity
	 * E.g. add an IE to SUC in OWL
	 * @param owl_entity
	 */
	public abstract void add2Owl(CAEXObject obj, OWLEntity entity, OWLOntology ont);
	
	public abstract IRI createIRI(CAEXObject obj);
	
}
