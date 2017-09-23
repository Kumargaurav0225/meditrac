package proj.meditrac.boot;

import proj.meditrac.db.Metadata;


public class Bootstrapper {
	
	/*
	 * Singleton Implemented
	 */
	private Bootstrapper(){}
	
	private static Bootstrapper instance = new Bootstrapper();
	
	public static Bootstrapper getInstance(){
		return instance;
	}
	
	/*
	 * public instance methods
	 */
	public boolean applicationConfigured(){
		return Metadata.isDBConnected() && Metadata.checkSchemaIntegrity();
	}
	
	
}
