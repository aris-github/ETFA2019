package translation.simple;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntology;

public abstract class AMLClassHandler extends AMLEntityHandler{
	
	@SuppressWarnings("deprecation")
	@Override
	public OWLEntity cvt2Owl(CAEX215.CAEXObject obj, OWLOntology ont) {
		// TODO Auto-generated method stub						
		String name = ns + obj.getName();
		for(OWLClass owlClass : ont.getClassesInSignature()) {
			if(owlClass.getIRI().toString().equals(name)) {
				return owlClass;
			}
		}
		OWLClass cl_ic = this.manager.getOWLDataFactory().getOWLClass(IRI.create(name));
		
//		String className = name;		
		// check if there is already an AML class with the same name
//		int i = 1;
//		while(manager.getOWLDataFactory().getOWLClass(IRI.create(className)) != null)
//		{
//			className = name + "_" +  Integer.toString(i);
//			i++;
//		}									
//		OWLClass cl_ic = this.manager.getOWLDataFactory().getOWLClass(IRI.create(className));
		return cl_ic;		
	}

}
