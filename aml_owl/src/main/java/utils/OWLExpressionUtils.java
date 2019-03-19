/**
 * 
 */
package utils;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLProperty;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLQuantifiedObjectRestriction;
import org.semanticweb.owlapi.model.OWLRestriction;

import constants.AMLAnnotationPropertyIRIs;
import constants.AMLObjectPropertyIRIs;
import translation.simple.AttributeHandler;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 *
 */
public class OWLExpressionUtils{
	
	private static OWLDataFactory dataFactory = new OWLDataFactoryImpl();

	/**
	 * whether a class expression is expandbale
	 *  - conjunctive
	 *  - disjunctive
	 *  - filler is conjunctive or disjunctive
	 * @param ce
	 * @return
	 */
	public static boolean isExpandable(OWLClassExpression ce) {
		if(isConjunctive(ce) || isDisjunctive(ce) || isFillerExpandable(ce))
			return true;
		
		return false;
//		return isConjunctive(ce) || isDisjunctive(ce) || isRestriction(ce);
	}
	
	
	/**
	 * Whether the filler is expandable
	 *  - conjunctive
	 *  - disjunctive
	 *  - nested restriction
	 * @param ce
	 * @return
	 */
	public static boolean isFillerExpandable(OWLClassExpression ce) {
		
		if(ce instanceof OWLQuantifiedObjectRestriction) {
			if(((OWLQuantifiedObjectRestriction) ce).getFiller() instanceof OWLObjectIntersectionOf)
				return true;
			if(((OWLQuantifiedObjectRestriction) ce).getFiller() instanceof OWLObjectUnionOf)
				return true;
			if(((OWLQuantifiedObjectRestriction) ce).getFiller() instanceof OWLRestriction)
				return true;
		}
		return false;
	}
	
	/**
	 * whether an owl class expression is a restriction
	 * @param ce
	 * @return
	 */
	public static boolean isRestriction(OWLClassExpression ce) {
		return ce instanceof OWLRestriction;
	}
	
	/**
	 * whether an owl class expression is a conjunction
	 * @param ce
	 * @return
	 */
	public static boolean isConjunctive(OWLClassExpression ce) {
		return ce instanceof OWLObjectIntersectionOf;
	}
	
	/**
	 * whether an owl class expression is a disjunction 
	 * @param ce
	 * @return
	 */
	public static boolean isDisjunctive(OWLClassExpression ce) {
		return ce instanceof OWLObjectUnionOf;
	}
	
	/**
	 * get the role filler
	 * @param expr
	 * @return
	 */
	public static OWLClassExpression getRoleFiller(OWLClassExpression expr) {
		
		OWLClassExpression filler = null;
		
		if(expr instanceof OWLQuantifiedObjectRestriction) {
			OWLQuantifiedObjectRestriction res = (OWLQuantifiedObjectRestriction) expr;
			filler = res.getFiller();
		}
		
		return filler;
	}
	
	public static OWLPropertyExpression getRole(OWLClassExpression expr) {
		
		OWLPropertyExpression property = null;
		
		if(expr instanceof OWLQuantifiedObjectRestriction) {
			OWLQuantifiedObjectRestriction res = (OWLQuantifiedObjectRestriction) expr;
			property = res.getProperty();
		}
		
		return property;
	}
	
	@SuppressWarnings("deprecation")
	public static Set<OWLClassExpression> getAtomicConcepts (OWLObjectIntersectionOf intersection) {
		Set<OWLClassExpression> atomics = new HashSet<OWLClassExpression>();
		
		for(OWLClassExpression op : intersection.getOperands()) {
			if(op.isClassExpressionLiteral())
				atomics.add(op);
		}
		
		return atomics;
	}
	
	public static boolean containsAtomicConcept (OWLObjectIntersectionOf intersection) {
		return getAtomicConcepts(intersection).isEmpty();
	}
	
	@SuppressWarnings("deprecation")
	public static String getAMLPropertyName (OWLPropertyExpression property) {
		String name = null;
		int numObjProperties = property.getObjectPropertiesInSignature().size();
		int numDataProperties = property.getDataPropertiesInSignature().size();
		int numProperties = numObjProperties + numDataProperties;
		
		if(numProperties != 1) {
			System.err.println("OWLExpressionUtils.getAMLPropertyName: OWL property [" + property.toString() + "] has " + numDataProperties + " data properties" + "and " + numObjProperties + " object properties! Cannot parse it!");
			return null;
		}
		
		for(OWLProperty p : property.getObjectPropertiesInSignature()) {
			name = p.getIRI().toString();
		}
		
		for(OWLProperty p : property.getDataPropertiesInSignature()) {
			name = p.getIRI().toString();
		}
		
		return name;
	}
	
	@SuppressWarnings("deprecation")
	public static OWLClass getAMLClass (OWLClassExpression ce) {
		if(ce.isClassExpressionLiteral()) {
			OWLClass oc = ce.getClassesInSignature().iterator().next();
			return oc;
		}
		else {
			System.err.println("OWLExpressionUtils.getAMLClass: class expression " + ce.toString() + " is not atomic!");
			return null;
		}
	}
	
	public static String getAMLClassName (OWLClassExpression ce) {
		return getAMLClass(ce).getIRI().getShortForm();
	}		
	
	@SuppressWarnings("deprecation")
	public static String getAMLLibName (OWLClass c) {
		for(OWLAnnotationProperty ap : c.getAnnotationPropertiesInSignature()) {
			if(ap.getIRI().equals(AMLAnnotationPropertyIRIs.IN_LIB)) {
				return ap.getIRI().getShortForm();
			}
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String getAMLAttributeName (OWLDataPropertyExpression property) {
//		String fullname = getAMLPropertyName(property);
		
//		String name = fullname.replace(constants.Consts.aml_pref, "");
//		name = name.replace("has", "");
//		name = name.replace("_", "");
		
//		return name;
		IRI iri = property.getDataPropertiesInSignature().iterator().next().getIRI();
		return AttributeHandler.deserializeIRI(iri);
	}
		
	// get the IRI of an OWLIndividual
	@SuppressWarnings("deprecation")
	public static String getAMLId (OWLIndividual individual) {
		
//		String name = individual.getIndividualsInSignature().iterator().next().getIRI().getShortForm();
		for(OWLAnnotationProperty ap : individual.getAnnotationPropertiesInSignature()) {
			if(ap.getIRI().equals(AMLAnnotationPropertyIRIs.HAS_AML_SEMANTIC)) {
			}
		}
		
		return individual.getIndividualsInSignature().iterator().next().getIRI().toString();
	}
	
	public static boolean hasAMLInverseRoleAsProperty(OWLObjectPropertyExpression ope) {
		if(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF.toString().contains((getAMLPropertyName(ope))) ||
				AMLObjectPropertyIRIs.IS_EXTERNAL_INTERFACE_OF.toString().contains((getAMLPropertyName(ope)))){
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean hasAMLInverseRole(OWLClassExpression ce) {

		for(OWLClassExpression child : ce.getNestedClassExpressions()) {
			if(child instanceof OWLQuantifiedObjectRestriction) {
				if(hasAMLInverseRoleAsProperty(((OWLQuantifiedObjectRestriction) child).getProperty()))
					return true;
			}
		}
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public static Set<OWLClassExpression> getAllConjunctions (OWLObjectIntersectionOf conj) {
		Set<OWLClassExpression> operands = new HashSet<OWLClassExpression>();
		for(OWLClassExpression op : conj.getOperands()) {
			if(!(op instanceof OWLObjectIntersectionOf)) {
				operands.add(op);
			}
			else {
				operands.addAll(getAllConjunctions((OWLObjectIntersectionOf) op));
			}
		}
		
		return operands;
	}
	
	public static OWLObjectIntersectionOf flattenConjunction (OWLObjectIntersectionOf conj) {
		Set<OWLClassExpression> ops = getAllConjunctions(conj);
		return dataFactory.getOWLObjectIntersectionOf(ops);
	}
}
