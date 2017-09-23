package proj.meditrac.core.enums;

public enum Configuration {

	CONN_DRIVER("conn_driver","com.mysql.jdbc.Driver"),
	
	CONN_URL("conn_url","jdbc:mysql://localhost:3306/"),
	
	DATABASE_NAME("database_name","SYS_MEDITRAC"),
	
	HIBERNATE_DIALECT("hibernate_dialect","org.hibernate.dialect.MySQLDialect"),
	
	HIBERNATE_MAPPING("hibernate_mapping","Mapping.hbm.xml"),
	
	CONN_USER("conn_user","root"),

	CONN_PASSWORD("conn_password",""),
		
	HBM2DDL("hbm2ddl.auto","update"),
	
	SHOW_SQL("show_sql","true"),
	
	AUTO_CREATE_SCHEMA("auto_create_schema","false"),
	
	LOG_FILE("log_file","system_log.log"),
	
	SMTP_AUTH("smtp_auth","true"),
	
	SMTP_STARTTLS_ENABLE("smtp_starttls_enable","false"),
	
	SMTP_HOST("smtp_host","smtp.gmail.com"),
	
	SMTP_PORT("smtp_port","587"),
	
	EMAIL_ID("email_id","meditrac.responder@gmail.com"),
	
	EMAIL_PASSWORD("email_password","meditrac.project"),
	
	TEMPLATE_DIR("template_dir","WEB-INF/jsp/");
	
	private String propName;
	private String defaultProp;
	
	Configuration(String propName,String defaultProp){
		this.propName = propName;
		this.defaultProp = defaultProp;
	}
	
	public String getPropName(){
		return this.propName;
	}
	
	public String getDefault(){
		return this.defaultProp;
	}
}
