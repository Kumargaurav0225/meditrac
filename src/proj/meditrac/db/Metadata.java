package proj.meditrac.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import proj.meditrac.core.ConfigurationManager;
import proj.meditrac.core.enums.Configuration;
import proj.meditrac.core.enums.DatabaseTable;

final public class Metadata {
		
	private Metadata(){};
	
	private static Connection conn;
	
	private static ConfigurationManager config = ConfigurationManager.getInstance();
	
	/*
	 * Database connection check
	 */
	public static boolean isDBConnected(){
		boolean flag = true;
		try {
			Class.forName(config.getProperty(Configuration.CONN_DRIVER));
			conn = DriverManager.getConnection(
					config.getProperty(Configuration.CONN_URL),
					config.getProperty(Configuration.CONN_USER),
					config.getProperty(Configuration.CONN_PASSWORD)
			);
			if(conn == null)
				flag = false;
		} catch(Exception ex){
			flag = false;
		}
		
		return flag;
	}
	
	/*
	 * Database integrity check
	 */
	public static boolean checkSchemaIntegrity() {
		if(conn == null){
			isDBConnected();
		}
			
		boolean flag = true;
		DatabaseMetaData databaseMetaData;
		Set<String> tableNames = new TreeSet<String>();
		for(DatabaseTable d : DatabaseTable.values())
			tableNames.add(d.getTableName().toUpperCase());
		
		try {
			databaseMetaData = conn.getMetaData();
			String[] metaTable = {"TABLE"};
			ResultSet rsTables = databaseMetaData.getTables(null, null, null,metaTable);
			if(rsTables.next()){
				if(!tableNames.contains(rsTables.getString(3).toUpperCase())){
					flag = false;
				}
			} else
				flag = false;
		} catch(SQLException ex){
			flag = false;
		}
		
		return true;
	}
	
}
