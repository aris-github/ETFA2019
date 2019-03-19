package concept.util;

public class EILinkRefSide {
	
	public enum EndpointType {QUERY, DATA, EMPTY, INVALID};

	private String refSide;
	private String parentId;
	private String eiName;
	private EndpointType type;
	
	public EILinkRefSide (String refSide) {
		this.refSide = refSide;
		this.parse();
	}
	
	public EILinkRefSide (String parentId, String eiName) {
		this.parentId = parentId;
		this.eiName = eiName;
		
		this.refSide = "[" + parentId + "]:[" + eiName + "]"; 
	}
	
	public String getRefSide () {
		return this.refSide;
	}
	
	public String getIEId () {
		return parentId;
	}
	
	public String getEIName () {
		return eiName;
	}
	
	public void parse () {
		
		if(refSide == null) {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": empty ref side");
			this.type = EndpointType.EMPTY;
			return;
		}
		
		if(refSide.isEmpty()) {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": empty ref side");
			this.type = EndpointType.EMPTY;
			return;
		}
		
		String[] tokens = refSide.split(":");
		
		if(tokens.length != 2) {
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			System.err.println(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() + ": unexpected ref side [" + refSide + "]");
			this.type = EndpointType.INVALID;
		}

		parentId = tokens[0].substring(1, tokens[0].length()-1);
		eiName = tokens[1].substring(1, tokens[1].length()-1);		
	}
	
	public String toString () {
		return this.refSide;
	}
	
	public EndpointType getType () {
		return this.type;
	}
	
	public void setType (EndpointType type) {
		this.type = type;
	}
}
