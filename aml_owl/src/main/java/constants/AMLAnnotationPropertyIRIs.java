/**
 * 
 */
package constants;

import org.semanticweb.owlapi.model.IRI;

/**
 * @author aris
 *
 */
public final class AMLAnnotationPropertyIRIs {

	public static final IRI IN_LIB = IRI.create(Consts.aml_pref + "inLib");
	
	public static final IRI HAS_AML_SEMANTIC = IRI.create(Consts.importer_pref + "has_amlSemantic");
}
