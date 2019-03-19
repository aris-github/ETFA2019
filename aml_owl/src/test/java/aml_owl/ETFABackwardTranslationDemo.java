package aml_owl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.semanticweb.owlapi.dlsyntax.renderer.DLSyntaxObjectRenderer;
import org.semanticweb.owlapi.io.OWLObjectRenderer;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import CAEX215.CAEXFileType;
import CAEX215.InternalElementType;
import concept.model.GenericAMLConceptModel;
import concept.model.AMLConceptConfig;
import concept.tree.GenericTreeNode;
import concept.util.GenericAMLConceptModelUtils;
import constants.AMLClassIRIs;
import importer.AMLImporter;
import parser.AMLParser;
import translation.complex.AML2OWLConverter;
import translation.complex.AMLConceptTree;

public class ETFABackwardTranslationDemo{
	
	private static AMLImporter importer;		
	private static OWLObjectRenderer renderer = new DLSyntaxObjectRenderer();
	private AML2OWLConverter converter = new AML2OWLConverter();

	public ETFABackwardTranslationDemo() throws NoSuchMethodException, SecurityException, IllegalAccessException,
	IllegalArgumentException, InvocationTargetException, MalformedURLException, ClassNotFoundException,
	InstantiationException, NoSuchFieldException {
		importer = new AMLImporter("CAEX215");
		// TODO Auto-generated constructor stub
	}
	
	public List<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>> readModels (String conceptModelFile) throws NoSuchMethodException, SecurityException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException, NoSuchFieldException,
	ParserConfigurationException, SAXException, IOException, DOMException, DatatypeConfigurationException {

		AMLParser parser = new AMLParser(conceptModelFile);
		Document caex = parser.getDoc();		
		CAEXFileType aml = (CAEXFileType) importer.doImport(caex, false);	
//		AMLConceptModelTreeParser conceptParser = new AMLConceptModelTreeParser();

		List<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>> trees = new ArrayList<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>>();
		GenericAMLConceptModelUtils interpreter = new GenericAMLConceptModelUtils();
		for(InternalElementType obj : aml.getInstanceHierarchy().get(0).getInternalElement()) {

			if(obj.getName().contains("Q")) {
				GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> root = interpreter.parse(obj, AMLConceptConfig.class);
				trees.add(root);
			}					
		}

		return trees;
	}

	public List<AMLConceptTree> toAMLConceptTrees (OWLClassExpression ce, IRI caexType) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AMLConceptTree tree = new AMLConceptTree(ce);

		// here, we either have the caex type from the annotation of the class being read from the ontology
		// or we set it manually if the class is generated from a backward translation
		tree.getRoot().data.setCaexType(caexType);
		tree.getRoot().data.setPrimary(true);
		// expand the initial tree to remove disjunctions
		Set<AMLConceptTree> expandedTrees = tree.expand();
		int i = 1;
		// for each disjunction operand
		List<AMLConceptTree> trees = new ArrayList<AMLConceptTree>();
		for(AMLConceptTree expanded : expandedTrees) {		

			System.out.println("\n 2.1. The AND-tree [" + i + "] \n");
			System.out.println(expanded.toStringWithIndent(3));

			AMLConceptTree noInverse = expanded.removeInverseRole();

			System.out.println("\n 2.2. removed inverse roles [" +  i +  "] \n");			 
			System.out.println(noInverse.toStringWithIndent(3));
			
			
			trees.add(noInverse);
		}

		return trees;
	}


	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException, 
	NoSuchFieldException, ParserConfigurationException, SAXException, IOException, DOMException, DatatypeConfigurationException {

		// TODO Auto-generated method stub
		String acmfile = "src/test/resources/concepts.aml";
		
		ETFABackwardTranslationDemo tester = new ETFABackwardTranslationDemo();
		List<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>> acms = tester.readModels(acmfile);

		for(GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> acm : acms) {
			if(acm.getRoot().data.getObj().getName().contains("Q")) {
				// ======================= STEP 1: AML -> AMLQuery model ======================= //
				System.out.println("\n============================================================" + acm.getRoot().data.getObj().getName() + "============================================================");				
				System.out.println("\n1. First, we show the result (OWL Class) of the backward translation from AML to OWL");				
				System.out.println("\n1.1. The AML concept model read from the file:");

				System.out.println(acm.toStringWithIndent(3));

				Set<GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>>> primaries = GenericAMLConceptModelUtils.getPrimaryObjs(acm);
				if(primaries.size() != 1) {
					System.out.println("\ncannot transform this AMLQuery model to DL: need exactly one primary (returned) object!");
					continue;
				}

				GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> primary = primaries.iterator().next();

				// ======================= STEP 2: AMLQuery model -> OWL ======================= //
				System.out.println("\n1.2. The generated OWL Class Expression\n");

				OWLClassExpression ce = tester.converter.toOWLClassExpression(acm.getRoot());

				System.out.println("   " + renderer.render(ce));

				System.out.println("\n2. Then, we show the reproduced AML concept models using forward translation");

				// ======================= STEP 3: OWL -> AML Concept Trees======================= //
				List<AMLConceptTree> trees = tester.toAMLConceptTrees(ce, AMLClassIRIs.getAMLClassIRI(primary.data.getObj()));
				int i = 1;
				for(AMLConceptTree tree : trees) {

					// ======================= STEP 4: AML Concept Tree -> AMLQuery model ======================= //
					System.out.println("\n2.3. Reproduced AML concept model [" +  i +  "]");

					GenericTreeNode<GenericAMLConceptModel<AMLConceptConfig>> acmReproduced = AMLConceptTree.toAMLConceptModelTreeNode(tree.getRoot());

					System.out.println(acmReproduced.toStringWithIndent(3));

					// the fusion is necessary since OWL class expressions and their AML concept trees split nested attributes and cardinalities into several expressions
					// - the attribute frame.(x, y) will become two data properties has_frame_x and has_frame_y, which need to be fused to one CAEX attribute
					// - the min and max cardinality of one object will become two cardinality restrictions 
					System.out.println("\n2.4. cleaned (fused) AML concept model [" +  i +  "]");

					GenericAMLConceptModelUtils.fuse(acmReproduced.getRoot());

					System.out.println(acmReproduced.toStringWithIndent(3));

					System.out.println("\n It shall be clear that the following AML concept models are equivalent:\n");
					System.out.println(" - the original AML concept model (M) read from the file: \n\n" + acm.toStringWithIndent(3) + "\n");
					System.out.println(" - the reproduced AML concept model as forward_translation(backward_translation(M)):\n\n" + acmReproduced.toStringWithIndent(3) + "\n");					 							
					i++;
				}
			}			
		}

	}

}
