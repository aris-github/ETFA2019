/**
 * 
 */
package translation.complex;

import java.util.Set;


import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLClassExpressionVisitorEx;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNaryDataRange;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.vocab.OWLFacet;

import CAEX215.AttributeType;
import CAEX215.AttributeValueRequirementType;
import CAEX215.CAEX215Factory;
import CAEX215.CAEXObject;
import CAEX215.ExternalInterfaceType;
import CAEX215.InternalElementType;
import CAEX215.NominalScaledTypeType;
import CAEX215.OrdinalScaledTypeType;
import CAEX215.RoleRequirementsType;
import CAEX215.util.AMLHelperFunctions;
import concept.model.AMLConceptConfig;
import concept.model.GenericAMLConceptModel;
import constants.AMLClassIRIs;
import constants.AMLObjectPropertyIRIs;
import utils.OWLExpressionUtils;

/**
 * @author aris
 * converts an OWLClassExpression to an AbstractAMLConceptModel<OWLAMLConceptConfig>
 * - atomic: ignore
 * - restriction: 
 * 		- if filler unexpandable: caex object with content (Class reference), config
 * 		- if filler expandable: caex object with no content, config. The substructure of the caex object will be added later (recursive here or iterative outside?)
 * 
 * TODO: OWL is not able to describe link constraint?
 * 
 * care:
 * - inverse role
 * - nested attribute: in OWL, we flatten them by "a_a1_a11"
 * - for root with unexpandable expression, we need additional handling: we also want to distinguish between RC, SRC, IE, EI, Attr
 * - only root node is returned
 * - transitive role 
 */
public class OWL2AMLConverter implements OWLClassExpressionVisitorEx<GenericAMLConceptModel<AMLConceptConfig>>{
	
	private static CAEX215Factory caexFactory = CAEX215Factory.eINSTANCE;
	
	public static CAEXObject getCAEXObjectSimple(String caexType) {
		// the caex type is given by the flag of the root
		CAEXObject caexObj = null;
		
		if(caexType.equals(AMLClassIRIs.INTERNAL_ELEMENT.toString())) {
			caexObj = caexFactory.createInternalElementType();
		}
		
		else if(caexType.equals(AMLClassIRIs.EXTERNAL_INTERFACE.toString())) {
			caexObj = caexFactory.createExternalInterfaceType();
		}
		
		else if(caexType.equals(AMLClassIRIs.ATTRIBUTE.toString())) {
			caexObj = caexFactory.createAttributeType();
		}
		
		else if(caexType.equals(AMLClassIRIs.SYSTEMUNIT_CLASS.toString())) {
			caexObj = caexFactory.createSystemUnitClassType();
		}
		
		else if(caexType.equals(AMLClassIRIs.ROLE_CLASS.toString())) {
			caexObj = caexFactory.createRoleClassType();
		}
		
		else if(caexType.equals(AMLClassIRIs.INTERFACE_CLASS.toString())) {
			caexObj = caexFactory.createInterfaceClassType();
		}
		
		else
			caexObj = caexFactory.createCAEXObject();
		
		return caexObj;
	}
		
	
	public static CAEXObject getCAEXObjectSimple (IRI caexType) {
		return getCAEXObjectSimple(caexType.toString());
	}
	
	private CAEXObject getCAEXObjectSimple(OWLObjectPropertyExpression ope) {
		String propertyName = OWLExpressionUtils.getAMLPropertyName(ope);
		if(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT.toString().contains(propertyName)) 
		{
			return getCAEXObjectSimple(AMLClassIRIs.INTERNAL_ELEMENT);
		}
		else if(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE.toString().contains(propertyName))
		{
			return getCAEXObjectSimple(AMLClassIRIs.EXTERNAL_INTERFACE);
		}
		else if(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF.toString().contains(propertyName)) {
			//TODO
			return null;
		}
		else if(AMLObjectPropertyIRIs.IS_EXTERNAL_INTERFACE_OF.toString().contains(propertyName)) {
			//TODO
			return null;
		}
		else {
			// shall not happen, since we have only the above four object properties
			return null;
		}
	}
	
	private AttributeType getAMLAttribute (OWLDataPropertyExpression propertyExpr) {
		
		AttributeType attr = caexFactory.createAttributeType();
		attr.setName(OWLExpressionUtils.getAMLAttributeName(propertyExpr));
		return attr;
				
//		OWLDataProperty property = propertyExpr.getDataPropertiesInSignature().iterator().next();
//		String[] names = AttributeHandler.deserializeIRItoArray(property.getIRI());
//		
//		AttributeType attr = caexFactory.createAttributeType();
//		
//		if(names.length >= 1) {
////			attr.setName(OWLExpressionUtils.getAMLAttributeName(propertyExpr));
//			attr.setName(names[0]);
//		}
//		
//		for(int i = 1; i < names.length; i++) {
//			AttributeType subAttr = caexFactory.createAttributeType();
//			subAttr.setName(names[i]);
//			attr.getAttribute().add(subAttr);
//		}				
//		
//		return attr;
	}
	
	// we do not have this as an Visitor, since it needs to know the property
	@SuppressWarnings("deprecation")
	private AttributeType getCAEXObject (OWLDataPropertyExpression property, OWLDataRange filler) {
		AttributeType attr = getAMLAttribute(property);
		
		if(filler instanceof OWLDatatypeRestriction) {
			OWLDatatype datatype = ((OWLDatatypeRestriction) filler).getDatatype();
			Set<OWLFacetRestriction> facetRestrictions = ((OWLDatatypeRestriction) filler).getFacetRestrictions();
			
			// TODO: we assume that the datatype is built-in
			attr.setAttributeDataType(datatype.getBuiltInDatatype().toString());
			
			for(OWLFacetRestriction fr : facetRestrictions) {
				OWLLiteral value = fr.getFacetValue();
				OWLFacet facet = fr.getFacet();
				
				AttributeValueRequirementType req = caexFactory.createAttributeValueRequirementType();
				OrdinalScaledTypeType ost = caexFactory.createOrdinalScaledTypeType();
				
				// set the attribute value requirement
				// we do not differentiate between (>=, >) and (<=, <)
				// TODO: INCLUSIVE is what AML provides now. EXCLUSIVE is in fact a "!=" or counting: count(attr.value=x) = 0.
				if(facet.equals(OWLFacet.MAX_EXCLUSIVE)) {					
					ost.setRequiredMaxValue(AMLHelperFunctions.toAMLAnyType(value.getLiteral()));					
				}				
				else if(facet.equals(OWLFacet.MAX_INCLUSIVE)) {
					ost.setRequiredMaxValue(AMLHelperFunctions.toAMLAnyType(value.getLiteral()));
				}
				else if(facet.equals(OWLFacet.MIN_EXCLUSIVE)) {
					ost.setRequiredMinValue(AMLHelperFunctions.toAMLAnyType(value.getLiteral()));
				}
				else if(facet.equals(OWLFacet.MIN_INCLUSIVE)) {
					ost.setRequiredMinValue(AMLHelperFunctions.toAMLAnyType(value.getLiteral()));				
				}	
				req.setOrdinalScaledType(ost);
				attr.getConstraint().add(req);
			}
			
			return attr;
		}
		
		if(filler instanceof OWLDataOneOf) {
			// will not happen: DL-Learner does not produce enumeration of data values, i.e. r one of {1,2,3}
			OWLDataOneOf doo = (OWLDataOneOf) filler;
			Set<OWLLiteral> values = doo.getValues();
			if(values.size() == 1)
				attr.setValue(AMLHelperFunctions.toAMLAnyType(values.iterator().next().getLiteral()));			
			else {
				AttributeValueRequirementType req = caexFactory.createAttributeValueRequirementType();
				NominalScaledTypeType nst = caexFactory.createNominalScaledTypeType();
				for(OWLLiteral value : values) {
					nst.getRequiredValue().add(AMLHelperFunctions.toAMLAnyType(value.getLiteral()));
				}
				req.setNominalScaledType(nst);
				attr.getConstraint().add(req);
			}
			
			return attr;
		}
		
		if(filler instanceof OWLDataComplementOf) {
			// will not happen: DL-Learner does not produce negation of data range, i.e. r some not Double (>30 and 50)

			OWLDataComplementOf complement = (OWLDataComplementOf) filler;
			attr = (AttributeType) getCAEXObject(property, complement.getDataRange());
			
			return attr;
		}
		
		if(filler instanceof OWLDataIntersectionOf) {
			// will not happen: DL-Learner does not produce conjunction of data range, i.e. r some Double (>30 and <50)
		}					
		
		if(filler instanceof OWLDatatype) {
			// will not happen: DL-Learner does not produce simple pure data type, i.e. r some Double
		}
		
		if(filler instanceof OWLDataUnionOf) {
			// will not happen: DL-Learner does not produce disjunctions of data type, i.e. r some Double (>30 or <10)
		}
		
		if(filler instanceof OWLNaryDataRange) {
			// will not happen: DL-Learner does not produce nary data range
		}
		
		// if caex object does not exist, then nothing returned;
		return attr;		
	}
	
	private AttributeType getCAEXObject (OWLDataPropertyExpression property, OWLLiteral filler) {
		// If the property is for a nested AML attribute, we get the top level one
		AttributeType attr = getAMLAttribute(property);
		String value = filler.getLiteral().toString();
		
		// the value shall be set to the bot level attribute from the hierarchy
		attr.setValue(AMLHelperFunctions.toAMLAnyType(value));	
		return attr;
	}	
	
	
	private CAEXObject getCAEXObject (OWLObjectPropertyExpression property, OWLClassExpression filler) {
		
		CAEXObject caex = getCAEXObjectSimple(property);
		
		// if caex object exists
		if(caex != null) {
			// modify the caex object only if the filler is not owl:Thing - which requires no class reference
			if(!filler.isOWLThing()) {
				// if the filler is not expandable: complete the concept template with class reference
				// changed to: if the filler is simple, then complete the concept template with class reference
//				if(!OWLExpressionUtils.isExpandable(filler)) {
				if(filler.isClassExpressionLiteral()) {
					String ref = OWLExpressionUtils.getAMLClassName(filler);
					if(caex instanceof InternalElementType) {
						RoleRequirementsType rr = caexFactory.createRoleRequirementsType();
						// TODO: care about class path
						rr.setRefBaseRoleClassPath(ref);
						((InternalElementType) caex).setRoleRequirements(rr);
					}
					else if(caex instanceof ExternalInterfaceType) {
						// TODO: care bout class path
						((ExternalInterfaceType) caex).setRefBaseClassPath(ref);
					}
				}
				else {
					// if the filler is expandable, we complete the concept template by visiting its children, i.e. its filler
					// we can not do it here, since if the filler is a conjunction, then it procudes a set of AMLConceptModels, which we can not do within the visitor
					// instead, we do it in the AMLConceptTree.toAMLQuery
//					return null;
				}		
			}			
		}
		
		// if caex object does not exist, then nothing returned;
		return caex;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLClass ce) {
		// atomic concepts do not need handling directly
		// they are converted to class references in their parents in the owl tree
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectIntersectionOf ce) {
		// conjunctions are only place holders in the owl tree
		// they do not need any handling
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectUnionOf ce) {
		// disjunctions can not happen in the owl tree: OWLTree generation will separate disjunctions into several trees
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectComplementOf ce) {
		// negated concepts are not handled directly
		// they are converted to class references with corresponding configs in their parents in the owl tree
		// general negations can not happen in the owl tree: DL-Learner does not produce them
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectSomeValuesFrom ce) {
		OWLObjectPropertyExpression property = ce.getProperty();
		OWLClassExpression filler = ce.getFiller();
		
		CAEXObject caex = getCAEXObject(property, filler);
		AMLConceptConfig config = new AMLConceptConfig();
		
		// if caex object exists, i.e. the filler is atomic
		if(caex != null) {			
			// if the filler is a negation
			// config.min = 1 (default)
			// config.max = -1 (default)
			// config.negated = true
			if(filler instanceof OWLObjectComplementOf) {
				config.setNegated(true);
			}
			// if the filler is an atomic, keep config to be default
			
			return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);		
		}
		
		// if caex object does not exist, then nothing returned;
		return null;		
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectAllValuesFrom ce) {
		OWLObjectPropertyExpression property = ce.getProperty();
		OWLClassExpression filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);

		AMLConceptConfig config = new AMLConceptConfig();
		// since it is an universal quantification, the concept model is a counting function with
		// config.min = 0
		// config.max = 0
		config.setMinCardinality(0);
		config.setMaxCardinality(0);
		
		// if caex object exists, i.e. the filler is atomic
		if(caex != null) {			
			
			// the NNF could produce union in the filler
			if(filler instanceof OWLObjectUnionOf) {
				config.setNegated(false);
			}
			
			// if the filler is a negation, i.e. (r only (not E))
			// config.negated = false (it can only be things that are not E, so the number of E shall be 0)
			else if(filler instanceof OWLObjectComplementOf) {
				config.setNegated(false);			
			}
			// if the filler is an atomic, i.e. (r only E)
			// config.negated = true (it can only be things that are E, so the number of not E shall be 0)
			else if(filler.isClassExpressionLiteral()){
				config.setNegated(true);
			}
			
			return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);
		}
		
		// if caex object does not exist, then nothing returned;
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectHasValue ce) {
		
		OWLObjectPropertyExpression property = ce.getProperty();
		OWLIndividual filler = ce.getFiller();
		CAEXObject caex = getCAEXObjectSimple(property);
		
		if(caex != null) {
			//TODO: we need to work with ID and IRI, now we directly use the IRI as the ID
			caex.setID(OWLExpressionUtils.getAMLId(filler));
			
			// build a config to the object
			AMLConceptConfig config = new AMLConceptConfig();
			// since object has value: we need exactly this object by ID
			config.setIdentifiedById(true);
			
			// add a child node to the current node
			return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);
		}
		
		// if caex object does not exist, then nothing returned;
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectMinCardinality ce) {
		
		OWLObjectPropertyExpression property = ce.getProperty();
		OWLClassExpression filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);
		AMLConceptConfig config = new AMLConceptConfig();
		
		// if caex object exists, i.e. the filler is atomic
		if(caex != null) {
			
			// set the cardinality
			config.setMinCardinality(ce.getCardinality());
			
			// if the filler is a negation
			// config.min = 1 (default)
			// config.max = -1 (default)
			// config.negated = true
			if(filler instanceof OWLObjectComplementOf) {
				config.setNegated(true);
			}
			// if the filler is an atomic, keep config to be default
			
			return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);		
		}
		
		// if caex object does not exist, then nothing returned;
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectExactCardinality ce) {
		
		OWLObjectPropertyExpression property = ce.getProperty();
		OWLClassExpression filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);
		AMLConceptConfig config = new AMLConceptConfig();
		
		// if caex object exists, i.e. the filler is atomic
		if(caex != null) {
			// set the cardinality
			config.setMaxCardinality(ce.getCardinality());
			config.setMinCardinality(ce.getCardinality());
			
			// if the filler is a negation
			// config.min = 1 (default)
			// config.max = -1 (default)
			// config.negated = true
			if(filler instanceof OWLObjectComplementOf) {
				config.setNegated(true);
			}
			// if the filler is an atomic, keep config to be default
			
			return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);		
		}
		
		// if caex object does not exist, then nothing returned;
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectMaxCardinality ce) {
		OWLObjectPropertyExpression property = ce.getProperty();
		OWLClassExpression filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);
		AMLConceptConfig config = new AMLConceptConfig();
		
		// if caex object exists, i.e. the filler is atomic
		if(caex != null) {
			// set the cardinality
			config.setMaxCardinality(ce.getCardinality());
			
			// if the filler is a negation
			// config.min = 1 (default)
			// config.max = -1 (default)
			// config.negated = true
			if(filler instanceof OWLObjectComplementOf) {
				config.setNegated(true);
			}
			// if the filler is an atomic, keep config to be default
			
			return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);		
		}
		
		// if caex object does not exist, then nothing returned;
		return null;			
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectHasSelf ce) {
		// TODO Auto-generated method stub
		// do not happen: DL-Learner does not produce this
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLObjectOneOf ce) {
		// TODO Auto-generated method stub
		// do not happen: DL-Learner does not produce this
		// if it does happen: we need several trees for this, since it is basically a disjunction
		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLDataSomeValuesFrom ce) {
		OWLDataPropertyExpression property = ce.getProperty();
		OWLDataRange filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);
		
		AMLConceptConfig config = new AMLConceptConfig();
		config.setIdentifiedByName(true);
		if(filler instanceof OWLDataComplementOf)
			config.setNegated(true);
		
		return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLDataAllValuesFrom ce) {

		// do not happen: DL-Learner does not produce this, i.e. r only Double (>50)
		OWLDataPropertyExpression property = ce.getProperty();
		OWLDataRange filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);
		
		AMLConceptConfig config = new AMLConceptConfig();
		config.setIdentifiedByName(true);
		if(filler instanceof OWLDataComplementOf)
			config.setNegated(true);
		
		return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);
//		return null;
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLDataHasValue ce) {

		OWLDataPropertyExpression property = ce.getProperty();
		OWLLiteral filler = ce.getFiller();
		
		// if the data property was for a nested attribute, we get the flattened one here
		CAEXObject caex = getCAEXObject(property, filler);
			
		AMLConceptConfig config = new AMLConceptConfig();
		config.setIdentifiedByName(true);
		
		return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);		
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLDataMinCardinality ce) {
		OWLDataPropertyExpression property = ce.getProperty();
		OWLDataRange filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);
		
		AMLConceptConfig config = new AMLConceptConfig();
		config.setIdentifiedByName(true);
		config.setMinCardinality(ce.getCardinality());
		
		if(filler instanceof OWLDataComplementOf)
			config.setNegated(true);
		
		return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);		
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLDataExactCardinality ce) {
		OWLDataPropertyExpression property = ce.getProperty();
		OWLDataRange filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);
		
		AMLConceptConfig config = new AMLConceptConfig();
		config.setIdentifiedByName(true);
		config.setMinCardinality(ce.getCardinality());
		config.setMaxCardinality(ce.getCardinality());
		
		if(filler instanceof OWLDataComplementOf)
			config.setNegated(true);
		
		return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);
	}

	@Override
	public GenericAMLConceptModel<AMLConceptConfig> visit(OWLDataMaxCardinality ce) {
		OWLDataPropertyExpression property = ce.getProperty();
		OWLDataRange filler = ce.getFiller();
		CAEXObject caex = getCAEXObject(property, filler);
		
		AMLConceptConfig config = new AMLConceptConfig();
		config.setIdentifiedByName(true);
		config.setMaxCardinality(ce.getCardinality());
		
		if(filler instanceof OWLDataComplementOf)
			config.setNegated(true);
		
		return new GenericAMLConceptModel<AMLConceptConfig>(caex, config);
	}

}
