package proj.meditrac.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import proj.meditrac.core.ConfigurationManager;
import proj.meditrac.core.enums.Configuration;
import proj.meditrac.core.enums.DatabaseTable;

final public class Metadata {

	private Metadata() {
	};

	private static Connection conn;

	private static ConfigurationManager config = ConfigurationManager.getInstance();

	/*
	 * Database connection check
	 */
	public static boolean isDBConnected() {
		boolean flag = true;
		try {
			// Class.forName(config.getProperty(Configuration.CONN_DRIVER));
			// conn = DriverManager.getConnection(
			// config.getProperty(Configuration.CONN_URL),
			// config.getProperty(Configuration.CONN_USER),
			// config.getProperty(Configuration.CONN_PASSWORD)

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys_meditrac", "root", "root");
			if (conn == null)
				flag = false;
			else
				createDb();
		} catch (Exception ex) {
			flag = false;
		}

		return flag;
	}

	/*
	 * Check database
	 */
	public static boolean databaseExists() throws SQLException {
		boolean flag = false;
		if (conn == null) {
			isDBConnected();
		}

		List<String> databases = new ArrayList<String>();
		ResultSet rs = conn.createStatement().executeQuery("SHOW DATABASES");
		while (rs.next())
			databases.add(rs.getString(1).toUpperCase());

		for (String db : databases) {
			if (db.equals(config.getProperty(Configuration.DATABASE_NAME))) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	/*
	 * Auto create database
	 */
	public static void createDb() {
		if (conn == null) {
			isDBConnected();
		}

		String dbSQL = "CREATE SCHEMA IF NOT EXISTS " + config.getProperty(Configuration.DATABASE_NAME);
		try {
			conn.createStatement().execute(dbSQL);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Database integrity check
	 */
	public static boolean checkSchemaIntegrity() {
		if (conn == null) {
			isDBConnected();
		}

		boolean flag = true;
		DatabaseMetaData databaseMetaData;
		Set<String> tableNames = new TreeSet<String>();
		for (DatabaseTable d : DatabaseTable.values())
			tableNames.add(d.getTableName().toUpperCase());

		try {
			databaseMetaData = conn.getMetaData();
			String[] metaTable = { "TABLE" };
			ResultSet rsTables = databaseMetaData.getTables(null, null, null, metaTable);
			if (rsTables.next()) {
				if (!tableNames.contains(rsTables.getString(3).toUpperCase())) {
					flag = false;
				}
			} else
				flag = false;
		} catch (SQLException ex) {
			flag = false;
		}

		return flag;
	}

}
