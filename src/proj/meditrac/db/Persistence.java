package proj.meditrac.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import proj.meditrac.core.ConfigurationManager;
import proj.meditrac.core.enums.DatabaseTable;
import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;

public class Persistence {

	private Persistence(){};
	
	private static ConfigurationManager cm = ConfigurationManager.getInstance();
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	
	static {
		if(Metadata.isDBConnected()){
			configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", cm.getProperty(proj.meditrac.core.enums.Configuration.CONN_DRIVER));
			configuration.setProperty("hibernate.connection.url", cm.getProperty(proj.meditrac.core.enums.Configuration.CONN_URL));
			configuration.setProperty("hibernate.connection.username", cm.getProperty(proj.meditrac.core.enums.Configuration.CONN_USER));
			configuration.setProperty("hibernate.connection.password", cm.getProperty(proj.meditrac.core.enums.Configuration.CONN_PASSWORD));
			configuration.setProperty("hibernate.dialect", cm.getProperty(proj.meditrac.core.enums.Configuration.HIBERNATE_DIALECT));
			configuration.setProperty("hibernate.hbm2ddl.auto", cm.getProperty(proj.meditrac.core.enums.Configuration.HBM2DDL));
			configuration.setProperty("hibernate.show_sql", cm.getProperty(proj.meditrac.core.enums.Configuration.SHOW_SQL));
			
			configuration.addResource(cm.getProperty(proj.meditrac.core.enums.Configuration.HIBERNATE_MAPPING));
			sessionFactory = configuration.buildSessionFactory();
		}
	}

	public static void init() throws ConnectException, SchemaException{
		getSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() throws ConnectException, SchemaException {
		if(sessionFactory == null && !Metadata.isDBConnected()){
			throw new ConnectException("Connection to the data layer could not be established.");
		} else if(sessionFactory != null && !Metadata.checkSchemaIntegrity()){
			if(ConfigurationManager.getInstance().getProperty(proj.meditrac.core.enums.Configuration.AUTO_CREATE_SCHEMA).equalsIgnoreCase("true")){
				System.out.println("AUTO CREATING SCHEMA");
				initPersistenceLayer(sessionFactory);
			} else {
				close();
				throw new SchemaException("Please check if the database schema has been configured.");
			}
		}
		return sessionFactory;
	}
	
	public static void close(){
		if(sessionFactory != null)
			sessionFactory.close();
	}
	
	
	private static void initPersistenceLayer(SessionFactory sf) throws ConnectException, SchemaException {
		Session session = sf.openSession();
		for(DatabaseTable table : DatabaseTable.values()){
			Transaction tx = session.beginTransaction();
			session.createSQLQuery(table.getTableSQL()).executeUpdate();
			tx.commit();			
			System.out.println("CREATED TABLE - " + table.getTableName());
		}
		session.close();
	}
	
}
