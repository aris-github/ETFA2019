# ETFA2019
Implementation of the bidirectional translation between AML and OWL for the ETFA 2019 paper **Interpreting OWL Complex Classes in AutomationML based on Bidirectional Translation**

There are three packages included:

* aml_models: this package contains Eclipse EMF models of the CAEX 2.15 XML schema and the implementation of AML concept models
* aml_io: this package contains reader and writer of AML models
* aml_owl: this package contains the implementation of the bidirectional translation between AML and OWL

## Install

You first need to download the latest version of the Eclipse Modeling Tools from [eclipse.org](http://www.eclipse.org/downloads/eclipse-packages/) to your Eclipse IDE.

Then import the projects and use Maven to compile each of them in following sequence:

1. aml_models
2. aml_io
3. aml_owl

## Run the tests

There are two test programs written for the ETFA paper

* `ETFAForwardTranslationDemo`
* `ETFABackwardTranslationDemo`

To test the results as published in the paper, find the test programs in Eclipse under `aml_owl/src/test/java/aml_owl/`, and run them as Java Applications

The results are directly printed out in the console.

If you are familiar with OWLApi and AML, you can also create own OWL complex classes or AML concept models for testing.
