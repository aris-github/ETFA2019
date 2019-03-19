package concept.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import CAEX215.CAEXFileType;
import CAEX215.ExternalInterfaceType;
import CAEX215.InternalElementType;
import CAEX215.InternalLinkType;
import CAEX215.SystemUnitClassType;
import CAEX215.util.AMLHelperFunctions;
import concept.util.EILinkRefSide.EndpointType;

public class AMLLinkCollector {

	private static CAEXFileType caex;
	private static Set<InternalLinkType> uniqueLinks = new HashSet<InternalLinkType>();
	private static boolean initialized;
	
	public AMLLinkCollector(CAEXFileType caex) {
		AMLLinkCollector.caex = caex;		
		initialized = false;
	}
	
	public void init () {
		if(uniqueLinks.isEmpty()) {
			List<InternalLinkType> links = AMLHelperFunctions.getAllLinks(caex);			
			uniqueLinks.add(links.get(0));
			
			// add one link to the allLinks set if it is not contained in the set 
			for(int i = 1; i < links.size(); i++) {
				if(!containsLink(links.get(i))) {
					uniqueLinks.add(links.get(i));
				}
			}
		}
		
		initialized = true;
	}
	
	public static Set<EILinkRefSide> getPartnersOfEI (ExternalInterfaceType ei){
		
		if(!initialized) {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": AMLLinkCollector not initialized yet!");
			return null;
		}
		
		Set<EILinkRefSide> partners = new HashSet<EILinkRefSide>();
		
		SystemUnitClassType suc = AMLHelperFunctions.getParentOfEI(ei, caex);
		if(suc == null)
			return partners;
		
		else{
			EILinkRefSide self = new EILinkRefSide(suc.getID(), ei.getName());		
			return getPartnersOfEI(self);	
		}
	}
	
	public static Set<EILinkRefSide> getPartnersOfEI (String refside){
		if(!initialized) {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": AMLLinkCollector not initialized yet!");
			return null;
		}
		
		EILinkRefSide self = new EILinkRefSide(refside);
		return getPartnersOfEI(self);
	}	
	
	/**
	 * get all partner end points of the given end point
	 * @param self
	 * @return
	 */
	public static Set<EILinkRefSide> getPartnersOfEI (EILinkRefSide self) {
		if(!initialized) {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": AMLLinkCollector not initialized yet!");
			return null;
		}
					
		Set<EILinkRefSide> partners = new HashSet<EILinkRefSide>();
		Set<InternalLinkType> links = getLinksOfEI(self.getIEId(), self.getEIName());		
		if(links != null) {
			for(InternalLinkType link : links) {
				EILinkRefSide partner = new EILinkRefSide(getRefPartner(self.getRefSide(), link));
				
				// If the partner is empty (invalid), the type is already set to EMPTY (INVALID)
				if(partner.getType() == null) {
					
					// if the partner can be found in the query file (caex), then QUERY, otherwise DATA
					if(getEIIdFromFile(partner, caex) == null)
						partner.setType(EndpointType.DATA);
					else
						partner.setType(EndpointType.QUERY);
				}
				partners.add(partner);
			}
		}
		
		return partners;
	}
	
	/**
	 * get the internal links that contain the given EI as an end point
	 * @param ei
	 * @return
	 */
	public static Set<InternalLinkType> getLinksOfEI (ExternalInterfaceType ei) {
		
		if(AMLLinkCollector.uniqueLinks.isEmpty())
			return null;
		
		SystemUnitClassType parent = AMLHelperFunctions.getParentOfEI(ei, caex);
		return getLinksOfEI(parent.getName(), ei.getID());
	}
	
	/**
	 * get the internal links that contain the given EI as an end point
	 * @param parentId id of the parent of EI
	 * @param eiName name of the EI  
	 * @return
	 */
	public static Set<InternalLinkType> getLinksOfEI (String parentId, String eiName){
		
		if(AMLLinkCollector.uniqueLinks.isEmpty())
			return null;
		
		Set<InternalLinkType> ret = new HashSet<InternalLinkType>();		
		for(InternalLinkType il : uniqueLinks) {
			if(il.getRefPartnerSideA().contains(eiName) && il.getRefPartnerSideA().contains(parentId))
				ret.add(il);
			if(il.getRefPartnerSideB().contains(eiName) && il.getRefPartnerSideB().contains(parentId))
				ret.add(il);
		}
		
		return ret;
	}
	
	/**
	 * Two internal links are equivalent if they have same end points, disregarding sequence
	 * @param linkOne
	 * @param linkTwo
	 * @return
	 */
	private boolean isLinkEquivalent (InternalLinkType linkOne, InternalLinkType linkTwo) {
		
		String oneA = linkOne.getRefPartnerSideA();
		String oneB = linkOne.getRefPartnerSideB();
		String twoA = linkTwo.getRefPartnerSideA();
		String twoB = linkTwo.getRefPartnerSideB();
		
		return (oneA.equals(twoA) && oneB.equals(twoB)) || (oneA.equals(twoB) && oneB.equals(twoA));
	}
	
	/**
	 * whether the collected links set contains the given link
	 * @param link
	 * @return
	 */
	private boolean containsLink (InternalLinkType link) {
		for(InternalLinkType il : uniqueLinks) {
			if(isLinkEquivalent(il, link))
				return true;
		}
		
		return false;
	}
	
	/**
	 * get the ref side description (partner) of a ref side description (self) in a link
	 * @param refside
	 * @param link
	 * @return
	 */
	private static String getRefPartner (String refside, InternalLinkType link) {
		if(link.getRefPartnerSideA().equals(refside))
			return link.getRefPartnerSideB();
		
		if(link.getRefPartnerSideB().equals(refside))
			return link.getRefPartnerSideA();
		
		return null;
	}
	
	public static ExternalInterfaceType getEI (EILinkRefSide ei) {
		return getEIFromFile(ei, caex);
	}
	
	/**
	 * get the ID of an EI (represented by the given EILinkRefSide) from the given file
	 * @param caexFile
	 * @return
	 */
	private static String getEIIdFromFile (EILinkRefSide ei, CAEXFileType caexFile) {
		if(getEIFromFile(ei, caexFile) == null) {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": can not find the EI [" + ei.getIEId() + ":" + ei.getEIName() + "]");			
			return null;
		}
		else {
			return getEIFromFile(ei, caexFile).getID();
		}		
	}
	
	/**
	 * get the EI (represented by the given EILinkRefSide) from the given file
	 * @param caexFile
	 * @return
	 */
	private static ExternalInterfaceType getEIFromFile (EILinkRefSide ei, CAEXFileType caexFile) {
		
		if(ei.getIEId() == null) {			
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": can not find the IE [" + ei.getIEId() + "]");			
			return null;
		}
			
		InternalElementType ie = AMLHelperFunctions.getIEByID(ei.getIEId(), caexFile);
		if(ie != null) {
			for(ExternalInterfaceType candidate : ie.getExternalInterface()) {
				if(candidate.getName().equals(ei.getEIName()))
					return candidate;
			}
		}else {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": can not find the EI [" + ei.getIEId() + ":" + ei.getEIName() + "]");
			return null;
		}	
		
		return null;
		
		
	}
}
