package proj.meditrac.core.enums;

public enum SessionParams {

	MEMBER("member"),
	ERROR("error");
	
	final private String paramName;
	
	SessionParams(String paramName){
		this.paramName = paramName;
	}
	
	public String getParamName(){
		return this.paramName;
	}
	
}

