package proj.meditrac.core.enums;

public enum DatabaseTable {

	/*
	 * Define all table names as enum fields here.
	 */
	SYSTEM_MEMBERS("SYSTEM_MEMBERS",
		"CREATE TABLE SYSTEM_MEMBERS (SYS_ID VARCHAR(12) NOT NULL PRIMARY KEY, PASS_ENC VARCHAR(32) NOT NULL, USER_GROUP ENUM('ADMINISTRATOR','HOSPITAL','DOCTOR','PATIENT') NOT NULL, IS_ACTIVE ENUM('ACTIVE','NOT_ACTIVE') NOT NULL, CREATED_AT DATETIME NOT NULL, LAST_LOGIN DATETIME);"
	);
	
	
	/*
	 * The table name property to reference the tables
	 */
	private final String tableName;
	
	private final String SQL;
	
	/*
	 * Constructor
	 */
	DatabaseTable(String tableName,String SQL){
		this.tableName = tableName;
		this.SQL = SQL;
	}
	
	/*
	 * Getter 
	 * @return String
	 */
	public String getTableName(){
		return this.tableName;
	}
	
	public String getTableSQL(){
		return this.SQL;
	}

}

