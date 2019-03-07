package importer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class Utils {
	public static EClassifier getEClassifierByName(EPackage ePackage, String name) {
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier.getName().equals(name + "Type") || classifier.getName().equals(name)) {
				return classifier;
			}
		}
		return null;
	}
	public static EClass getInstantiableEClass(EClass target) {
		if (!target.isAbstract()) return target;
		EList<EClassifier> classifiers = target.getEPackage().getEClassifiers();
		for (Object o : classifiers) {
			if (o instanceof EClass) {
				EClass eClass = (EClass) o;
				if (!eClass.isAbstract() && target.isSuperTypeOf(eClass)) {
					return eClass;
				}
			}
		}
		return null;
	}
}
