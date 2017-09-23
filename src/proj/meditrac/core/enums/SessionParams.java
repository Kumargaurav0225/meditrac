package proj.meditrac.core.enums;

public enum SessionParams {

	MEMBER_ID("member_id");
	
	final private String paramName;
	
	SessionParams(String paramName){
		this.paramName = paramName;
	}
	
	public String getParamName(){
		return this.paramName;
	}
	
}

