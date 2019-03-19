package utils;

import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLClassExpressionVisitorEx;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;

import constants.AMLObjectPropertyIRIs;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

public class ConjunctionMinimizer implements OWLClassExpressionVisitorEx<OWLClassExpression>{

	private static OWLDataFactory owlFactory = new OWLDataFactoryImpl();
	
	@Override
	public OWLClassExpression visit(OWLClass ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@SuppressWarnings("deprecation")
	@Override
	public OWLClassExpression visit(OWLObjectIntersectionOf ce) {
		// TODO Auto-generated method stub
		Set<OWLClassExpression> normalOps = new HashSet<OWLClassExpression>();
		for(OWLClassExpression op : ((OWLObjectIntersectionOf) ce).getOperands()) {
			if(!op.equals(owlFactory.getOWLThing())) {
				normalOps.add(op.accept(this));
			}
		}
		
		if(normalOps.size() == 0)
			return owlFactory.getOWLThing();
		
		if(normalOps.size() == 1)
			return normalOps.iterator().next();
		
		else 
			return owlFactory.getOWLObjectIntersectionOf(normalOps);
	
	}

	@SuppressWarnings("deprecation")
	@Override
	public OWLClassExpression visit(OWLObjectUnionOf ce) {
		// TODO Auto-generated method stub
		Set<OWLClassExpression> normalOps = new HashSet<OWLClassExpression>();
		for(OWLClassExpression op : ce.getOperands()) {
			normalOps.add(op.accept(this));
		}
				
		return owlFactory.getOWLObjectUnionOf(normalOps);
	}

	@Override
	public OWLClassExpression visit(OWLObjectComplementOf ce) {
		// TODO Auto-generated method stub		
		return owlFactory.getOWLObjectComplementOf(ce.getOperand().accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectSomeValuesFrom ce) {
		// TODO Auto-generated method stub
		OWLClassExpression filler = ce.getFiller();
		
		OWLClassExpression newFiller = filler.accept(this);
		Set<OWLClassExpression> validFillers = new HashSet<OWLClassExpression>();
		if(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF.toString().contains(OWLExpressionUtils.getAMLPropertyName(ce.getProperty()))) {
			if(newFiller instanceof OWLObjectIntersectionOf) {
				for(OWLClassExpression op : ((OWLObjectIntersectionOf) newFiller).getOperands()) {
					if(op instanceof OWLObjectSomeValuesFrom) {
						String opRoleName = OWLExpressionUtils.getAMLPropertyName(((OWLObjectSomeValuesFrom) op).getProperty());
						if(!AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT.toString().contains(opRoleName) && ((OWLObjectSomeValuesFrom) op).getFiller().equals(owlFactory.getOWLThing()))
							validFillers.add(op);
					}else
						validFillers.add(op);
				}
			}
		}
		
		OWLClassExpression finalFiller = null;
		if(validFillers.size() > 1) {
			finalFiller = owlFactory.getOWLObjectIntersectionOf(validFillers);
		}else if(validFillers.size() == 1) {
			finalFiller = validFillers.iterator().next();
		}else if(validFillers.size() == 0) {
			finalFiller = newFiller;
		} 
			
		
		return owlFactory.getOWLObjectSomeValuesFrom(ce.getProperty(), finalFiller);
	}

	@Override
	public OWLClassExpression visit(OWLObjectAllValuesFrom ce) {
		// TODO Auto-generated method stub
		OWLClassExpression filler = ce.getFiller();					
		return owlFactory.getOWLObjectAllValuesFrom(ce.getProperty(), filler.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectHasValue ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLObjectMinCardinality ce) {
		// TODO Auto-generated method stub
		OWLClassExpression filler = ce.getFiller();		
		return owlFactory.getOWLObjectMinCardinality(ce.getCardinality(), ce.getProperty(), filler.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectExactCardinality ce) {
		// TODO Auto-generated method stub
		OWLClassExpression filler = ce.getFiller();		
		return owlFactory.getOWLObjectExactCardinality(ce.getCardinality(), ce.getProperty(), filler.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectMaxCardinality ce) {
		// TODO Auto-generated method stub
		OWLClassExpression filler = ce.getFiller();		
		return owlFactory.getOWLObjectMaxCardinality(ce.getCardinality(), ce.getProperty(), filler.accept(this));
	}

	@Override
	public OWLClassExpression visit(OWLObjectHasSelf ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLObjectOneOf ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataSomeValuesFrom ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataAllValuesFrom ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataHasValue ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataMinCardinality ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataExactCardinality ce) {
		// TODO Auto-generated method stub
		return ce;
	}

	@Override
	public OWLClassExpression visit(OWLDataMaxCardinality ce) {
		// TODO Auto-generated method stub
		return ce;
	}

}
