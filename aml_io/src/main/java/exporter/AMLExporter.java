/**
 * 
 */
package exporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.ecore.xml.type.AnyType;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import CAEX215.AttributeType;
import CAEX215.AttributeValueRequirementType;
import CAEX215.CAEXFileType;
import CAEX215.DescriptionType;
import CAEX215.ExternalInterfaceType;
import CAEX215.InstanceHierarchyType;
import CAEX215.InterfaceClassLibType;
import CAEX215.InterfaceFamilyType;
import CAEX215.InternalElementType;
import CAEX215.NominalScaledTypeType;
import CAEX215.OrdinalScaledTypeType;
import CAEX215.RoleClassLibType;
import CAEX215.RoleFamilyType;
import CAEX215.RoleRequirementsType;
import CAEX215.SupportedRoleClassType;
import CAEX215.SystemUnitClassLibType;
import CAEX215.SystemUnitFamilyType;
import CAEX215.VersionType;


/**
 * @author aris
 * Export an AML document 
 */
public class AMLExporter {
	
	private CAEXFileType caex;
	private Document doc;
	
	// indices for unnamed caex objects
	int attrIdx = 0, rcIdx = 0, icIdx = 0, sucIdx = 0, ieIdx = 0, eiIdx = 0;
	
	public AMLExporter(CAEXFileType caex) throws ParserConfigurationException {
		// TODO Auto-generated constructor stub
		this.caex = caex;
		
		DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
		doc = xmlBuilder.newDocument();
	}
	
	private String fromAMLAnyType(AnyType anyType) {
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
	
	private Element getDescriptionNode (DescriptionType desc) {
		Element descNode = doc.createElement("Description");
		descNode.setTextContent(desc.getValue());
		return descNode;
	}
	
	private Element getVersionNode (VersionType version) {
		Element versionNode = doc.createElement("Version");
		versionNode.setTextContent(version.getValue());
		return versionNode;
	}
	
	private Element getAttributeNode (AttributeType attr) {
		Element attrNode = doc.createElement("Attribute");
		
		if(attr.getName() == null || attr.getName() == "") {
			String name = "Attribute" + (attrIdx+1);
			attrNode.setAttribute("Mame", name);
		}else
			attrNode.setAttribute("Name", attr.getName());
		
		// data type
		if(attr.getAttributeDataType() != null)
			attrNode.setAttribute("AttributeDataType", attr.getAttributeDataType());
		
		// unit
		if(attr.getUnit() != null)
			attrNode.setAttribute("Unit", attr.getUnit());
		
		// description
		if(attr.getDescription() != null) 
			attrNode.appendChild(getDescriptionNode(attr.getDescription()));
		
		// value
		if(attr.getValue() != null) {
			Element valueNode = doc.createElement("Value");
			valueNode.setTextContent(attr.getStringValue());
			attrNode.appendChild(valueNode);
		}
		
		// default
		if(attr.getDefaultValue() != null) {
			Element defaultValueNode = doc.createElement("DefaultValue");
			defaultValueNode.setTextContent(fromAMLAnyType(attr.getDefaultValue()));
			attrNode.appendChild(defaultValueNode);
		}
		
		// constraint
		for(AttributeValueRequirementType constraint : attr.getConstraint()) {
			Element constraintNode = doc.createElement("Constraint");
			if(constraint.getName() != null)
				constraintNode.setAttribute("Name", constraint.getName());
			
			if(constraint.getName().equals("xRequiredValue"))
				System.out.println();
			
			if(constraint.getNominalScaledType() != null) {
				NominalScaledTypeType nst = constraint.getNominalScaledType();
				Element nstNode = doc.createElement("NominalScaledType");
				for(AnyType anytype : nst.getRequiredValue()) {
					Element valueNode = doc.createElement("RequiredValue");
					valueNode.setTextContent(fromAMLAnyType(anytype));
					constraintNode.appendChild(valueNode);
				}
				constraintNode.appendChild(nstNode);				
			}
			
			if(constraint.getOrdinalScaledType() != null) {
				OrdinalScaledTypeType ost = constraint.getOrdinalScaledType();
				Element ostNode = doc.createElement("OrdinalScaledType");
				
				Element maxNode = doc.createElement("RequiredMaxValue");
				maxNode.setTextContent(fromAMLAnyType(ost.getRequiredMaxValue()));
				ostNode.appendChild(maxNode);
				
				Element valueNode = doc.createElement("RequiredValue");
				valueNode.setTextContent(fromAMLAnyType(ost.getRequiredValue()));
				ostNode.appendChild(valueNode);
				
				Element minNode = doc.createElement("RequiredMinValue");
				minNode.setTextContent(fromAMLAnyType(ost.getRequiredMinValue()));
				ostNode.appendChild(minNode);
				
				constraintNode.appendChild(ostNode);
			}
			
			attrNode.appendChild(constraintNode);
		}
		
		// sub attr
		for(AttributeType sub : attr.getAttribute()) {
			Element subNode = getAttributeNode(sub);
			attrNode.appendChild(subNode);
		}		
		
		return attrNode;
	}
	
	private Element getICNode (InterfaceFamilyType ic) {
		Element icNode = doc.createElement("InterfaceClass");
		
		if(ic.getName() == null || ic.getName() == "") {
			String name = "InterfaceClass" + (icIdx+1);
			icNode.setAttribute("Name", name);
		}else
			icNode.setAttribute("Name", ic.getName());		
		
		// path
		if(ic.getRefBaseClassPath() != null)
			icNode.setAttribute("RefBaseClassPath", ic.getRefBaseClassPath());
		
		// attr
		for(AttributeType attr : ic.getAttribute()) {
			icNode.appendChild(getAttributeNode(attr));
		}
		
		// sub ic
		for(InterfaceFamilyType sub : ic.getInterfaceClass()) {
			icNode.appendChild(getICNode(sub));
		}
		
		return icNode;
	}
	
	private Element getRCNode (RoleFamilyType rc) {
		Element rcNode = doc.createElement("RoleClass");
		if(rc.getName() == null || rc.getName() == "") {
			String name = "RoleClass" + (rcIdx+1);
			rcNode.setAttribute("Name", name);
		}else
			rcNode.setAttribute("Name", rc.getName());
		
		// path
		if(rc.getRefBaseClassPath() != null)
			rcNode.setAttribute("RefBaseClassPath", rc.getRefBaseClassPath());
		
		// attr
		for(AttributeType attr : rc.getAttribute()) {
			rcNode.appendChild(getAttributeNode(attr));
		}
		
		// sub ic
		for(RoleFamilyType sub : rc.getRoleClass()) {
			rcNode.appendChild(getRCNode(sub));
		}
		
		return rcNode;
	}
	
	private Element getEINode (ExternalInterfaceType ei) {
		Element eiNode = doc.createElement("ExternalInterface");
		if(ei.getName() == null || ei.getName() == "") {
			String name = "ExternalInterface" + (eiIdx+1);
			eiNode.setAttribute("Name", name);
		}else
			eiNode.setAttribute("Name", ei.getName());
		
		// path
		if(ei.getRefBaseClassPath() != null)
			eiNode.setAttribute("RefBaseClassPath", ei.getRefBaseClassPath());
		
		// id
		if(ei.getID() != null && ei.getID() != "")
			eiNode.setAttribute("ID", ei.getID());
		else {
			eiNode.setAttribute("ID", UUID.randomUUID().toString());
		}
			
		
		// attr
		for(AttributeType attr : ei.getAttribute()) {
			eiNode.appendChild(getAttributeNode(attr));
		}
		
		return eiNode;
	}
	
	private Element getSRCNode (SupportedRoleClassType src) {
		Element srcNode = doc.createElement("SupporedRoleClass");
		srcNode.setAttribute("RefRoleClassPath", src.getRefRoleClassPath());
		return srcNode;		
	}
	
	private Element getRRNode (RoleRequirementsType rr) {
		Element rrNode = doc.createElement("RoleRequirements");
		rrNode.setAttribute("RefBaseRoleClassPath", rr.getRefBaseRoleClassPath());
		
		for(AttributeType attr : rr.getAttribute()) {
			rrNode.appendChild(getAttributeNode(attr));
		}
		
		for(ExternalInterfaceType ei : rr.getExternalInterface()) {
			rrNode.appendChild(getEINode(ei));			
		}
		
		return rrNode;
	}
	
	private Element getIENode (InternalElementType ie) {
		Element ieNode = doc.createElement("InternalElement");
		if(ie.getName() == null || ie.getName() == "") {
			String name = "InternalElement" + (ieIdx+1);
			ieNode.setAttribute("Name", name);
		}else
			ieNode.setAttribute("Name", ie.getName());
		
		// path
		if(ie.getRefBaseSystemUnitPath() != null)
			ieNode.setAttribute("RefBaseSystemUnitPath", ie.getRefBaseSystemUnitPath());
		
		// id
		if(ie.getID() != null && ie.getID() != "")
			ieNode.setAttribute("ID", ie.getID());
		else
			ieNode.setAttribute("ID", UUID.randomUUID().toString());
		
		// attr
		for(AttributeType attr : ie.getAttribute()) {
			ieNode.appendChild(getAttributeNode(attr));
		}
		
		// ei
		for(ExternalInterfaceType ei : ie.getExternalInterface()) {
			ieNode.appendChild(getEINode(ei));
		}
		
		// src
		for(SupportedRoleClassType src : ie.getSupportedRoleClass()) {
			ieNode.appendChild(getSRCNode(src));
		}
		
		// rr
		if(ie.getRoleRequirements() != null)
			ieNode.appendChild(getRRNode(ie.getRoleRequirements()));				
		
		// TODO: link
		
		// sub ie
		for(InternalElementType sub : ie.getInternalElement()) {
			ieNode.appendChild(getIENode(sub));
		}
		
		return ieNode;
	}
	
	
	private Element getSUCNode (SystemUnitFamilyType suc) {
		Element sucNode = doc.createElement("SystemUnitClass");
		if(suc.getName() == null || suc.getName() == "") {
			String name = "SystemUnitClass" + (sucIdx+1);
			sucNode.setAttribute("Name", name);
		}else
			sucNode.setAttribute("Name", suc.getName());
		
		// path
		if(suc.getRefBaseClassPath() != null)
			sucNode.setAttribute("RefBaseClassPath", suc.getRefBaseClassPath());
		
		// attr
		for(AttributeType attr : suc.getAttribute()) {
			sucNode.appendChild(getAttributeNode(attr));
		}
		
		// ei
		for(ExternalInterfaceType ei : suc.getExternalInterface()) {
			sucNode.appendChild(getEINode(ei));
		}
		
		// src
		for(SupportedRoleClassType src : suc.getSupportedRoleClass()) {
			sucNode.appendChild(getSRCNode(src));
		}
		
		// ie
		for(InternalElementType ie : suc.getInternalElement()) {
			sucNode.appendChild(getIENode(ie));
		}
		
		// sub suc
		for(SystemUnitFamilyType sub : suc.getSystemUnitClass()) {
			sucNode.appendChild(getSUCNode(sub));
		}
		
		return sucNode;
	}
	
	public void write(String filename) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {	
		// root
		Element root = doc.createElement("CAEXFile");
		Attr file = doc.createAttribute("FileName");
		file.setValue(filename.substring(filename.lastIndexOf("/")+1));
		root.setAttributeNode(file);
		Attr version = doc.createAttribute("SchemaVersion");
		version.setValue("2.15");
		root.setAttributeNode(version);
		root.setAttributeNS(
				  "http://www.w3.org/2001/XMLSchema-instance", // value
				  "xsi:noNamespaceSchemaLocation",
				  "CAEX_ClassModel_V2.15.xsd"
		);
		
		// writer header
		Element infoNode = doc.createElement("AdditionalInformation");
		Element writerNode = doc.createElement("WriterHeader");
		
		Element nameNode = doc.createElement("WriterName");
		nameNode.setTextContent("AML Exporter");
		writerNode.appendChild(nameNode);
		
		Element idNode = doc.createElement("WriterID");
		idNode.setTextContent("916578CA-FE0D-474E-A4FC-9E1719892369");
		writerNode.appendChild(idNode);
		
		Element vendorNode = doc.createElement("WriterVendor");
		vendorNode.setTextContent("ipr.kit.edu");
		writerNode.appendChild(vendorNode);
		
		Element urlNode = doc.createElement("WriterVendorURL");
		urlNode.setTextContent("www.ipr.kit.edu");
		writerNode.appendChild(urlNode);
		
		Element vNode = doc.createElement("WriterVersion");
		vNode.setTextContent("0.0.1");
		writerNode.appendChild(vNode);
		
		Element rNode = doc.createElement("WriterRelease");
		rNode.setTextContent("0.0.1");
		writerNode.appendChild(rNode);
		
		Element dNode = doc.createElement("LastWritingDateTime");
		dNode.setTextContent(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
		writerNode.appendChild(dNode);
		
		Element tNode = doc.createElement("WriterProjectTitle");
		tNode.setTextContent("AML Framework");
		writerNode.appendChild(tNode);
		
		Element pidNode = doc.createElement("WriterProjectID");
		pidNode.setTextContent("unspecified");
		writerNode.appendChild(pidNode);
		
		infoNode.appendChild(writerNode);
		root.appendChild(infoNode);
		
		// aml version 
		Element infoNode2 = doc.createElement("AdditionalInformation");
		infoNode2.setAttribute("AutomationMLVersion", "2.0");
		root.appendChild(infoNode2);
		
		
		// ICL
		for(InterfaceClassLibType icl : caex.getInterfaceClassLib()) {
			Element iclNode = doc.createElement("InterfaceClassLib");
			iclNode.setAttribute("Name", icl.getName());
			
			// description
			if(icl.getDescription() != null)
				iclNode.appendChild(getDescriptionNode(icl.getDescription()));
			
			// version
			if(icl.getVersion() != null)
				iclNode.appendChild(getVersionNode(icl.getVersion()));
			
			// ic
			for(InterfaceFamilyType ic : icl.getInterfaceClass()) {
				iclNode.appendChild(getICNode(ic));				
			}
			
			root.appendChild(iclNode);
		}
		
		// RCL
		for(RoleClassLibType rcl : caex.getRoleClassLib()) {
			Element rclNode = doc.createElement("RoleClassLib");
			rclNode.setAttribute("Name", rcl.getName());
			
			// description
			if(rcl.getDescription() != null)
				rclNode.appendChild(getDescriptionNode(rcl.getDescription()));
			
			// version
			if(rcl.getVersion() != null)
				rclNode.appendChild(getVersionNode(rcl.getVersion()));
			
			// rc
			for(RoleFamilyType rc : rcl.getRoleClass()) {
				rclNode.appendChild(getRCNode(rc));				
			}
			
			root.appendChild(rclNode);
		}
		
		// SUCL
		for(SystemUnitClassLibType sucl : caex.getSystemUnitClassLib()) {
			Element suclNode = doc.createElement("SystemUnitClassLib");
			suclNode.setAttribute("Name", sucl.getName());
			
			// description
			if(sucl.getDescription() != null)
				suclNode.appendChild(getDescriptionNode(sucl.getDescription()));
			
			// version
			if(sucl.getVersion() != null)
				suclNode.appendChild(getVersionNode(sucl.getVersion()));
			
			// suc
			for(SystemUnitFamilyType suc : sucl.getSystemUnitClass()) {
				suclNode.appendChild(getSUCNode(suc));
			}
			
			root.appendChild(suclNode);
		}
		
		// IH
		for(InstanceHierarchyType ih : caex.getInstanceHierarchy()) {
			
			Element ihNode = doc.createElement("InstanceHierarchy");
			ihNode.setAttribute("Name", ih.getName());
			
			if(ih.getDescription() != null)
				ihNode.appendChild(getDescriptionNode(ih.getDescription()));
			
			if(ih.getVersion() != null)
				ihNode.appendChild(getVersionNode(ih.getVersion()));
			
			for(InternalElementType ie : ih.getInternalElement()) {
				ihNode.appendChild(getIENode(ie));
			}
			
			root.appendChild(ihNode);
		}
										
		doc.appendChild(root);
		
		write(doc, filename);
	}
	
	public void write (Document doc, String filename) throws TransformerFactoryConfigurationError, TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        
		Result output = new StreamResult(new File(filename));
		Source input = new DOMSource(doc);
		
		transformer.transform(input, output);
	}
}
