# aml_owl

Translators for AML->OWL and OWL->AML.

* For manipulating AML models, it uses the EMF models of CAEX 2.15 in aml_models.
* For manipulating OWL models, it uses the OWLAPI.

## constants

This package constants being used for the translations.

## utils

This package contains Utility functions for model translations.

## translation.simple

This package contains the simple backward translation from AML->OWL
* AML RC, IC, SUC -> OWL class
* AML IE, EI -> OWL individuals
* AML Attribute -> OWL data properties
* AML object relation -> OWL object properties

## translation.complex

This package contains the complex forward and backward translation for (`AML Concept Model` <-> `OWL complex classes`)

* The forward translation takes an `OWL complex class`, transform it into the `AML Concept Tree`, and generate `AML Concept Models` from them
* The backward translation takes an `AML Concept Model`, translate it to an `OWL Complex Class`

## Test programs

There are three test programs for this project:

* TestAML2OWLOntology: generates an OWL ontology from an AML document using translation.simple
* ETFABackwardTranslationDemo: shows the **backward translation** from `AML Concept Models (M)` to `OWL Complex Classes (C)`. 
	* Also shows the reproduction of `AML Concept Models` using `forward_translation(backward_translation(M)) = M`
	* The input `AML Concept Models` are read from the AML file `concepts.aml` 
* ETFAForwardTranslationDemo: shows the **forward translation** from `OWL Complex Classes (C)` to `AML Concept Models (M)`.  
	* Also shows the reproduction of `OWL Complex Classes (C)` using `backward_translation(forward_translation(C)) = C`
	* The input `OWL complex classes` are defined in the program as constants: `ETFA_A, ETFA_B, ETFA_C, ETFA_D, ETFA_E`
	


 