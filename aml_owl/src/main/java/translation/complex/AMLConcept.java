/**
 * 
 */
package translation.complex;

import org.semanticweb.owlapi.dlsyntax.renderer.DLSyntaxObjectRenderer;
//import org.dllearner.core.StringRenderer;
//import org.dllearner.utilities.owl.OWLClassExpressionUtils;
import org.semanticweb.owlapi.io.OWLObjectRenderer;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

/**
 * @author aris
 * A class contains the information about an AML class description
 */
public class AMLConcept {
	
//	private static OWLObjectRenderer render = StringRenderer.getRenderer();
	private static OWLObjectRenderer render = new DLSyntaxObjectRenderer();
	
	// the owl class expression
	private OWLClassExpression expression;
	
	// whether this AML concept is primary: i.e. learned
	private boolean isPrimary = false;

	// the caex type of the AML concept
	private IRI caexType;	
	
	public AMLConcept() {}
	
	public AMLConcept(OWLClassExpression ce) {
		this.expression = ce;
	}
	
	public AMLConcept(OWLClassExpression ce, IRI caexType, boolean returned) {
		this(ce);
		this.caexType = caexType;
		this.isPrimary = returned;
	}
	
	public AMLConcept(AMLConcept other) {
//		this();
//		this.expression = OWLClassExpressionUtils.clone(other.expression);
		this.expression = other.expression;
		if(other.caexType != null)
			this.caexType = IRI.create(other.caexType.toString());
		this.isPrimary = new Boolean(other.isPrimary);
	}

	/**
	 * @return the expression
	 */
	public OWLClassExpression getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(OWLClassExpression expression) {
		this.expression = expression;
	}

	/**
	 * @return the returned
	 */
	public boolean isPrimary() {
		return isPrimary;
	}

	/**
	 * @param returned the returned to set
	 */
	public void setPrimary(boolean returned) {
		this.isPrimary = returned;
	}

	/**
	 * @return the caexType
	 */
	public IRI getCaexType() {
		return caexType;
	}

	/**
	 * @param caexType the caexType to set
	 */
	public void setCaexType(IRI caexType) {
		this.caexType = caexType;
	}
	
	
	public String toString() {
		
		if(this.expression == null) {
			System.err.println("AMLConcept.toString: no owl class expression set!");
			return "";
		}
		
		if(this.caexType != null)
			return render.render(this.expression) + " : " + this.caexType.getShortForm().toString() + "," + this.isPrimary;
		else
			return render.render(this.expression);
	}
	
	
}
