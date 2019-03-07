package aml_owl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import org.dllearner.core.StringRenderer;
import org.semanticweb.owlapi.dlsyntax.renderer.DLSyntaxObjectRenderer;
import org.semanticweb.owlapi.io.OWLObjectRenderer;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.vocab.OWLFacet;

import concept.model.AMLConceptModel;
import concept.tree.GenericTreeNode;
import constants.AMLClassIRIs;
import constants.AMLObjectPropertyIRIs;
import translation.complex.AML2OWLConverter;
import translation.complex.AMLConceptTree;
import tree.AMLConceptModelTree;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

public class ETFAForwardTranslationDemo {

	static OWLDataFactory dataFactory = new OWLDataFactoryImpl();
	private static OWLObjectRenderer renderer = new DLSyntaxObjectRenderer();

	// classes
	static OWLClass A = dataFactory.getOWLClass(IRI.create("A"));
	static OWLClass B = dataFactory.getOWLClass(IRI.create("B"));
	static OWLClass C = dataFactory.getOWLClass(IRI.create("C"));
	static OWLClass D = dataFactory.getOWLClass(IRI.create("D"));
	static OWLClass E = dataFactory.getOWLClass(IRI.create("E"));
	static OWLClass Robot = dataFactory.getOWLClass(IRI.create("Robot"));
	static OWLClass Controller = dataFactory.getOWLClass(IRI.create("Controller"));
	static OWLClass Joint = dataFactory.getOWLClass(IRI.create("Joint"));
	static OWLClass Motor = dataFactory.getOWLClass(IRI.create("Motor"));

	// properties
	static OWLObjectProperty hasIE = dataFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT);
	static OWLObjectProperty isIE = dataFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF);
	static OWLDataProperty price = dataFactory.getOWLDataProperty(IRI.create("has_price"));
	static OWLDataProperty weight = dataFactory.getOWLDataProperty(IRI.create("has_weight"));
	static OWLDataProperty axis = dataFactory.getOWLDataProperty(IRI.create("has_axis"));
	static OWLDataProperty vel = dataFactory.getOWLDataProperty(IRI.create("has_vel"));

	// <=30
	static OWLDataRange doubleLe30 = dataFactory.getOWLDatatypeRestriction(dataFactory.getDoubleOWLDatatype(), OWLFacet.MAX_INCLUSIVE, dataFactory.getOWLLiteral(30));				
	// <=10
	static OWLDataRange doubleLe10 = dataFactory.getOWLDatatypeRestriction(dataFactory.getDoubleOWLDatatype(), OWLFacet.MAX_INCLUSIVE, dataFactory.getOWLLiteral(10));
	// >=10
	static OWLDataRange doubleGr10 = dataFactory.getOWLDatatypeRestriction(dataFactory.getDoubleOWLDatatype(), OWLFacet.MIN_INCLUSIVE, dataFactory.getOWLLiteral(10));

	static OWLClassExpression hasPrice = dataFactory.getOWLDataSomeValuesFrom(price, doubleLe30);
	static OWLClassExpression hasWeight = dataFactory.getOWLDataSomeValuesFrom(weight, doubleLe10);
	static OWLClassExpression hasVel = dataFactory.getOWLDataSomeValuesFrom(vel, doubleGr10);

	static OWLClassExpression hasController = dataFactory.getOWLObjectSomeValuesFrom(hasIE, dataFactory.getOWLObjectIntersectionOf(Controller, hasWeight));		
	static OWLClassExpression hasAxis = dataFactory.getOWLDataHasValue(axis, dataFactory.getOWLLiteral(6));
	static OWLClassExpression hasMotor = dataFactory.getOWLObjectSomeValuesFrom(hasIE, dataFactory.getOWLObjectIntersectionOf(Motor, hasVel));				
	static OWLClassExpression hasJoint = dataFactory.getOWLObjectSomeValuesFrom(hasIE, dataFactory.getOWLObjectIntersectionOf(Joint, hasMotor));		
	static OWLClassExpression hasRobot = dataFactory.getOWLObjectIntersectionOf(Robot, hasAxis, hasJoint);		
	static OWLClassExpression hasRobot2 = dataFactory.getOWLObjectUnionOf(hasPrice, hasController, hasRobot);

	// (A or B) and (C or D)
	static OWLClassExpression abcd = dataFactory.getOWLObjectIntersectionOf(dataFactory.getOWLObjectUnionOf(A,B), dataFactory.getOWLObjectUnionOf(C,D));		
	// (A or B) and C
	static OWLClassExpression abc = dataFactory.getOWLObjectIntersectionOf(dataFactory.getOWLObjectUnionOf(A,B), C);
	// (A and b) or (C and D)		
	static OWLClassExpression abcd2 = dataFactory.getOWLObjectUnionOf(dataFactory.getOWLObjectIntersectionOf(A,B), dataFactory.getOWLObjectIntersectionOf(C,D));
	// (A or B)
	static OWLClassExpression ab = dataFactory.getOWLObjectUnionOf(A,B);
	// (B and C)
	static OWLClassExpression bc = dataFactory.getOWLObjectIntersectionOf(B,C);
	// (A and D)		
	static OWLClassExpression ad = dataFactory.getOWLObjectIntersectionOf(A, D);
	static OWLClassExpression ieA = dataFactory.getOWLObjectSomeValuesFrom(hasIE, A);

	// isIEOf some (hasRobot2)
	static OWLClassExpression inv1 = dataFactory.getOWLObjectSomeValuesFrom(isIE, hasRobot2);
	// isIEOf some (inv1)
	static OWLClassExpression inv2 = dataFactory.getOWLObjectSomeValuesFrom(isIE, inv1);
	static OWLClassExpression inv3 = dataFactory.getOWLObjectIntersectionOf(inv1, A);

	static OWLClassExpression inv4 = dataFactory.getOWLObjectSomeValuesFrom(isIE, A);
	static OWLClassExpression inv41 = dataFactory.getOWLObjectSomeValuesFrom(isIE, B);
	static OWLClassExpression inv42 = dataFactory.getOWLObjectSomeValuesFrom(isIE, dataFactory.getOWLObjectUnionOf(inv4, inv41));
	static OWLClassExpression inv5 = dataFactory.getOWLObjectSomeValuesFrom(isIE, dataFactory.getOWLObjectIntersectionOf(inv4, B));
	static OWLClassExpression inv6 = dataFactory.getOWLObjectSomeValuesFrom(isIE, hasVel);
	static OWLClassExpression inv7 = dataFactory.getOWLObjectIntersectionOf(A, dataFactory.getOWLObjectSomeValuesFrom(isIE, dataFactory.getOWLObjectIntersectionOf(B, hasPrice)));
	static OWLClassExpression inv8 = dataFactory.getOWLObjectIntersectionOf(A, dataFactory.getOWLObjectSomeValuesFrom(isIE, dataFactory.getOWLObjectIntersectionOf(B, dataFactory.getOWLObjectIntersectionOf(hasPrice, hasVel))));
	static OWLClassExpression inv9 = dataFactory.getOWLObjectSomeValuesFrom(isIE, dataFactory.getOWLObjectIntersectionOf(A, hasVel));
	static OWLClassExpression inv10 = dataFactory.getOWLObjectSomeValuesFrom(isIE, inv6);
	static OWLClassExpression inv11 = dataFactory.getOWLObjectSomeValuesFrom(isIE, inv8);

	static OWLClassExpression AandPrice = dataFactory.getOWLObjectIntersectionOf(A, hasPrice);

	// This example is bad since it produces a negated attribute
	//			OWLClassExpression notRobotandhasPrice = dataFactory.getOWLObjectComplementOf(dataFactory.getOWLObjectIntersectionOf(Robot, hasPrice));

	// This example is bad since it produces a negated attribute
	//			OWLClassExpression notRobotandhasController = dataFactory.getOWLObjectComplementOf(dataFactory.getOWLObjectIntersectionOf(Robot, hasController));

	static OWLClassExpression notRobotandhasController = dataFactory.getOWLObjectComplementOf(dataFactory.getOWLObjectIntersectionOf(Robot, dataFactory.getOWLObjectSomeValuesFrom(hasIE, Controller)));

	// This example is bad since it produces a negated attribute
	static OWLClassExpression nothasPrice = dataFactory.getOWLObjectComplementOf(hasPrice);

	static OWLClassExpression allIEnotController = dataFactory.getOWLObjectAllValuesFrom(hasIE, dataFactory.getOWLObjectComplementOf(Controller));
	static OWLClassExpression allIEonlyController = dataFactory.getOWLObjectAllValuesFrom(hasIE, Controller);
	static OWLClassExpression someIEnotController = dataFactory.getOWLObjectSomeValuesFrom(hasIE, dataFactory.getOWLObjectComplementOf(Controller));
	static OWLClassExpression notController = dataFactory.getOWLObjectComplementOf(Controller);	


	static OWLObjectProperty HAS_IE = dataFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_INTERNAL_ELEMENT);
	static OWLObjectProperty HAS_EI = dataFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE);
	static OWLObjectProperty IS_IE = dataFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.IS_INTERNAL_ELEMENT_OF);
	static OWLObjectProperty IS_EI = dataFactory.getOWLObjectProperty(AMLObjectPropertyIRIs.HAS_EXTERNAL_INTERFACE);
	static OWLClassExpression IOCONTROLLER = dataFactory.getOWLClass(IRI.create("IOController"));
	static OWLClassExpression IOINTERFACE = dataFactory.getOWLClass(IRI.create("IOInterface"));
	static OWLClassExpression NOT_IOCONTROLLER = dataFactory.getOWLObjectComplementOf(IOCONTROLLER);
	static OWLDataProperty MANUFACTURER = dataFactory.getOWLDataProperty(IRI.create("has_manufacturer"));
	static OWLLiteral KUKA = dataFactory.getOWLLiteral("KUKA");	

	static OWLClassExpression ETFA_A = dataFactory.getOWLObjectIntersectionOf(
			Robot, 
			dataFactory.getOWLObjectComplementOf(
					dataFactory.getOWLObjectSomeValuesFrom(HAS_IE, NOT_IOCONTROLLER))); 
	static OWLClassExpression ETFA_B = dataFactory.getOWLObjectSomeValuesFrom(IS_IE, dataFactory.getOWLObjectIntersectionOf(
			Robot,
			dataFactory.getOWLDataHasValue(MANUFACTURER, KUKA)));
	static OWLClassExpression ETFA_C = dataFactory.getOWLObjectIntersectionOf(Robot, dataFactory.getOWLObjectSomeValuesFrom(HAS_IE, dataFactory.getOWLObjectIntersectionOf(
			IOCONTROLLER,
			dataFactory.getOWLObjectMinCardinality(3, HAS_EI, IOINTERFACE))));
	static OWLClassExpression ETFA_D = dataFactory.getOWLObjectIntersectionOf(IOINTERFACE, dataFactory.getOWLObjectSomeValuesFrom(IS_EI, dataFactory.getOWLObjectMinCardinality(3, HAS_EI, IOINTERFACE)));

	private List<OWLClassExpression> etfa = new ArrayList<OWLClassExpression>(); 

	public ETFAForwardTranslationDemo() {
		etfa.add(ETFA_A);
		etfa.add(ETFA_B);
		etfa.add(ETFA_C);
		etfa.add(ETFA_D);
		etfa.add(notRobotandhasController);
	}

	public List<OWLClassExpression> getETFAClasses () {
		return this.etfa;
	}


	public List<AMLConceptTree> toAMLConceptTrees (OWLClassExpression ce) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AMLConceptTree tree = new AMLConceptTree(ce);
		tree.getRoot().data.setCaexType(AMLClassIRIs.INTERNAL_ELEMENT);
		tree.getRoot().data.setPrimary(true);
		// expand the initial tree to remove disjunctions
		Set<AMLConceptTree> expandedTrees = tree.expand();
		int i = 1;
		// for each disjunction operand
		List<AMLConceptTree> trees = new ArrayList<AMLConceptTree>();
		for(AMLConceptTree expanded : expandedTrees) {		

			System.out.println("\n1.1. The AND-tree [" + i + "] \n");
			System.out.println(expanded.toStringWithIndent(3));

			AMLConceptTree noInverse = expanded.removeInverseRole();			
			System.out.println("\n1.2. removed inverse roles [" +  i +  "] \n");
			System.out.println(noInverse.toStringWithIndent(3));

			trees.add(noInverse);
		}

		return trees;
	}


	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {						

		ETFAForwardTranslationDemo tester = new ETFAForwardTranslationDemo();

		String className = "";
		for(int i = 0; i < tester.getETFAClasses().size(); i++) {
			
			if(i==0)
				className = "ETFA_A";
			else if(i==1)
				className = "ETFA_B";
			else if(i==2)
				className = "ETFA_C";
			else if(i==3)
				className = "ETFA_D";
			else if(i==4)
				className = "ETFA_E";
			
			System.out.print("====================================== " + className + " ======================================\n");
			
			System.out.println("1. First, we show the result (AML Concept Model) of the forward translation of the class " + className + "\n");
			System.out.println("original owl class:\n\n\t " + renderer.render(tester.getETFAClasses().get(i)) + "\n");
			System.out.println("negation normal form (NNF):\n\n\t " + renderer.render(tester.getETFAClasses().get(i).getNNF()));

			// ======================= STEP 1: OWL -> AML Concept Trees======================= //			
			List<AMLConceptTree> trees = tester.toAMLConceptTrees(tester.getETFAClasses().get(i));

			Set<OWLClassExpression> union = new HashSet<OWLClassExpression>(); 
			int j = 1;
			OWLClassExpression reproduced = null;
			for(AMLConceptTree tree : trees) {

				// ======================= STEP 2: AML Concept Tree -> AMLQuery model ======================= //
				System.out.println("\n1.3. The generated AML concept model [" +  j +  "]\n");
				GenericTreeNode<AMLConceptModel> query = AMLConceptTree.toAMLConceptModelTreeNode(tree.getRoot());
				AMLConceptModelTree queryTree = new AMLConceptModelTree(query);
				System.out.println(query.toStringWithIndent(3));

				System.out.println("\n1.4. the cleaned (fused) AML concept model [" +  j +  "]\n");
				AMLConceptModelTree.fuse(queryTree.getRoot());
				System.out.println(query.toStringWithIndent(3));

				// ======================= STEP 2: AML Query Model -> OWL ======================= //
				
				AML2OWLConverter aml2owl = new AML2OWLConverter();
				OWLClassExpression ce2 = aml2owl.toOWLClassExpression(query);
				OWLClassExpression ce3 = aml2owl.cleanse(ce2);
				reproduced = ce3;
				union.add(ce3);								
				
				if(trees.size() == 1) {
					System.out.println("\n2. Then, we show the reproduced OWL class expression using backward translation\n");
					System.out.println(" - generated owl class:\n\n\t " + renderer.render(ce2) + "\n");
					System.out.println(" - simplified owl class:\n\n\t " + renderer.render(ce3) + "\n");
				}

				// for testing the equivalence, we need to build an ontology and use the reasoner.getEquivalentClasses
				
				j++;
			}
			
			if(union.size() > 1) {
				System.out.println("\n2. Then, we show the reproduced OWL class expression using backward translation\n");
				System.out.println("   Since we have several AML concept trees generated, we compute an OWL class for each of them:\n");
				
				int k = 1;
				for(OWLClassExpression ce : union) {
					System.out.println("    - OWL class of the AML concept tree [" + k + "]:\n\n\t " + renderer.render(ce) + "\n");
					k++;
				}		
			
				reproduced = dataFactory.getOWLObjectUnionOf(union);
				System.out.println("   Then we combine each of the OWL classes as a union: \n\n\t" + renderer.render(reproduced) + "\n");
			}
			
						
			System.out.println("   It shall be clear that the following OWL class expressiones are equivalent:\n");
			System.out.println("    - the original OWL class (C) in NNF:\n\n\t " + renderer.render(tester.getETFAClasses().get(i).getNNF()) + "\n");
			System.out.println("    - the reproduced OWL class as backward_translation(forward_translation(C)):\n\n\t " + renderer.render(reproduced) + "\n");			
		}
	}
}
