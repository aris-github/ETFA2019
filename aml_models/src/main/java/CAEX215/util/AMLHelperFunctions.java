/**
 * 
 */
package CAEX215.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import CAEX215.AttributeType;
import CAEX215.CAEXFileType;
import CAEX215.ExternalInterfaceType;
import CAEX215.InstanceHierarchyType;
import CAEX215.InternalElementType;
import CAEX215.InternalLinkType;
import CAEX215.SystemUnitClassLibType;
import CAEX215.SystemUnitClassType;
import CAEX215.SystemUnitFamilyType;

/**
 * @author Yingbing Hua, yingbing.hua@kit.edu
 *
 */
public class AMLHelperFunctions {
	
	// Somehow works but no idea why...
	public static AnyType toAMLAnyType (String value) {	
			
		ResourceSet resourceSet = new ResourceSetImpl();
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(resourceSet.getPackageRegistry());
		AnyType anytype = XMLTypeFactory.eINSTANCE.createAnyType();
//		EStructuralFeature mixedFeature = extendedMetaData.getMixedFeature(anytype.eClass());
		EStructuralFeature valueAttribute = extendedMetaData.demandFeature(null, "stringValue", false);
//		EList<String> valueList = new BasicEList<String>(); 
//		valueList.add(value);
//		anytype.eSet(mixedFeature, valueList);
		anytype.eSet(valueAttribute, value);

		return anytype;
	}
	
	public static AnyType toAMLAnyType (Object value) {
		return toAMLAnyType(String.valueOf(value));
	}
	
	public static AttributeType overwriteAttribute (AttributeType attr, Object value) {
		attr.setValue(toAMLAnyType(value));
		return attr;
	}
	
	public static String fromAMLAnyType(AnyType anyType) {
		if(anyType != null && anyType.getAnyAttribute().size() > 0) {
			if(anyType.getAnyAttribute().getValue(0) != null) {
				return (String) anyType.getAnyAttribute().getValue(0);					
			}
		}
		if(anyType != null && anyType.getMixed().size() > 0) {
			if(anyType.getMixed().getValue(0) != null) {
				return (String) anyType.getMixed().getValue(0);					
			}
		}
		return null;
	}
	
//	public static String getAMLAnyTypeValue(AnyType anyType) {
//		if(anyType != null && anyType.getMixed().size() > 0) {
//			if(anyType.getMixed().getValue(0) != null) {
//				return (String) anyType.getMixed().getValue(0);					
//			}
//		}
//		return null;
//	}
	
	public static String getAMLAttributeValue(AttributeType attribute) {
//		if(attribute.getValue() != null) {
//			if(attribute.getValue().getMixed().size() > 0) {
//				if(attribute.getValue().getMixed().getValue(0) != null) {
//					return (String) attribute.getValue().getMixed().getValue(0);					
//				}
//			}
//		}
//		
//		return null;
		return fromAMLAnyType(attribute.getValue());
	}
	
	public static Double getAMLAttributeValueDouble(AttributeType attribute) {		
		
		String sValue = getAMLAttributeValue(attribute);
		if(sValue != null)
			return Double.parseDouble(sValue);
		else
			return Double.NaN;
	}
	
	public static Integer getAMLAttributeValueInteger(AttributeType attribute) {
		
		String sValue = getAMLAttributeValue(attribute);
		if(sValue != null)
			return Integer.parseInt(sValue);
		else
			return null;
	}
	
	public static Boolean getAMLAttributeValueBoolean(AttributeType attribute) {
		
		String sValue = getAMLAttributeValue(attribute);
		if(sValue != null)
			return Boolean.parseBoolean(sValue);
		else
			return null;
	}
	
	public static ExternalInterfaceType getEIById(String id, CAEXFileType aml) {
		for(SystemUnitClassLibType sucl : aml.getSystemUnitClassLib()) {
			for(SystemUnitFamilyType suf : sucl.getSystemUnitClass()) {
				ExternalInterfaceType ei = getEIFromSUC(id, suf);
				if(ei != null) {
					return ei;
				}
			}
		}
		
		for(InstanceHierarchyType ih : aml.getInstanceHierarchy()) {
			for(InternalElementType ie : ih.getInternalElement()) {
				ExternalInterfaceType ei = getEIFromIE(id, ie);
				if(ei != null) {					
					return ei;
				}
			}
		}
		return null;
	}
	
	
	private static ExternalInterfaceType getEIFromIE(String id, InternalElementType ie) {
		boolean found = false;
		for(ExternalInterfaceType candidate : ie.getExternalInterface()) {
			if(candidate.getID().equals(id)) {
				found = true;
				return candidate;
			} 
		}
		
		if(!found) {
			for(InternalElementType child : ie.getInternalElement()) {
				ExternalInterfaceType candidate = getEIFromIE(id, child);
				if(candidate != null)
					return candidate;
			}
		}
		
		return null;
	}
	
	
	private static ExternalInterfaceType getEIFromSUC(String id, SystemUnitFamilyType suf) {
		
		boolean found = false;
		for(ExternalInterfaceType candidate : suf.getExternalInterface()) {
			if(candidate.getID().equals(id)) {
				found = true;
				return candidate;
			} 
		}
		
		if(!found) {
			for(SystemUnitFamilyType child : suf.getSystemUnitClass()) {
				ExternalInterfaceType candidate = getEIFromSUC(id, child);
				if(candidate != null)
					return candidate;
			}		
		}		
		return null;
	}
	
	
	public static SystemUnitClassType getParentOfEI(ExternalInterfaceType ei, CAEXFileType aml) {
		for(SystemUnitClassLibType sucl : aml.getSystemUnitClassLib()) {
			for(SystemUnitFamilyType suf : sucl.getSystemUnitClass()) {
				SystemUnitClassType parent = getParentOfEIFromSUC(ei, suf);
				if(parent != null) {
					return parent;
				}
			}
		}
		
		for(InstanceHierarchyType ih : aml.getInstanceHierarchy()) {
			for(InternalElementType ie : ih.getInternalElement()) {
				SystemUnitClassType parent = getParentOfEIFromIE(ei, ie);
				if(parent != null) {
					return parent;
				}
			}
		}
		return null;
	}
	
	private static SystemUnitClassType getParentOfEIFromIE(ExternalInterfaceType ei, InternalElementType ie) {
		boolean found = false;
		
		for(ExternalInterfaceType candidate : ie.getExternalInterface()) {
			if(ei.getID().equals(candidate.getID())) {
				found = true;
				return ie;
			}
		}
		
		if(!found) {
			for(InternalElementType child : ie.getInternalElement()) {
				SystemUnitClassType parent = getParentOfEIFromIE(ei, child);
				if(parent != null)
					return parent;
			}
		}
		
		return null;
	}
	
	private static SystemUnitClassType getParentOfEIFromSUC(ExternalInterfaceType ei, SystemUnitFamilyType suf) {
		
		boolean found = false;
		for(ExternalInterfaceType candidate : suf.getExternalInterface()) {
			if(ei.getID().equals(candidate.getID())) {
				found = true;
				return suf;
			}				
		}
		
		if(!found) {
			for(SystemUnitFamilyType child : suf.getSystemUnitClass()) {
				SystemUnitClassType parent = getParentOfEIFromSUC(ei, child);
				if(parent != null)
					return parent;
			}			
		}		
		
		return null;
	}
	
	
	public static List<InternalLinkType> getAllLinks(CAEXFileType aml) {
		List<InternalLinkType> links = new ArrayList<InternalLinkType>();
		for(SystemUnitClassLibType sucl : aml.getSystemUnitClassLib()) {
			for(SystemUnitFamilyType suf : sucl.getSystemUnitClass()) {
				links.addAll(getAllLinksFromSUC(suf));
			}
		}
		
		for(InstanceHierarchyType ih : aml.getInstanceHierarchy()) {
			for(InternalElementType ie : ih.getInternalElement())
				links.addAll(getAllLinksFromIE(ie));
		}		
		return links;
	}
	
	private static List<InternalLinkType> getAllLinksFromIE(InternalElementType ie) {
		List<InternalLinkType> links = new ArrayList<InternalLinkType>();
		for(InternalLinkType il : ie.getInternalLink())
			links.add(il);
		for(InternalElementType child : ie.getInternalElement())
			links.addAll(getAllLinksFromIE(child));
		return links;
	}
	
	
	private static List<InternalLinkType> getAllLinksFromSUC(SystemUnitFamilyType suf) {
		List<InternalLinkType> links = new ArrayList<InternalLinkType>();
		for(InternalLinkType il : suf.getInternalLink())
			links.add(il);
		for(InternalElementType ie : suf.getInternalElement())
			links.addAll(ie.getInternalLink());
		for(SystemUnitFamilyType child : suf.getSystemUnitClass())
			links.addAll(getAllLinksFromSUC(child));		
		return links;
	}	
	
	public static InternalElementType getIEByID(String id, CAEXFileType aml) {
		for(SystemUnitClassLibType sucl : aml.getSystemUnitClassLib()) {
			for(SystemUnitFamilyType suf : sucl.getSystemUnitClass()) {
				InternalElementType ie = getIEFromSUCByID(id, suf);
				if(ie != null)
					return ie;
			}
		}
		
		for(InstanceHierarchyType ih : aml.getInstanceHierarchy()) {
			for(InternalElementType ie : ih.getInternalElement()) {
				InternalElementType candidate = getIEFromIEByID(id, ie);
				if(candidate != null)
					return candidate;
			}
		}
		
		return null;
	}
	
	private static InternalElementType getIEFromIEByID(String id, InternalElementType ie) {
		if(ie.getID().equals(id)){
			return ie;
		}
		
		for(InternalElementType child : ie.getInternalElement()) {
			InternalElementType candidate = getIEFromIEByID(id, child);
			if(candidate != null)
				return candidate;
		}
		
		return null;
	}
	
	private static InternalElementType getIEFromSUCByID(String id, SystemUnitFamilyType suf) {
		for(InternalElementType ie : suf.getInternalElement()) {
			if(ie.getID().equals(id)){
				return ie;
			}
		}
		
		for(SystemUnitFamilyType child : suf.getSystemUnitClass()) {
			InternalElementType ie = getIEFromSUCByID(id, child);
			if(ie != null)
				return ie;
		}
			
		
		return null;
	}
}
