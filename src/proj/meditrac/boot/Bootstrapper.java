package proj.meditrac.boot;

public class Bootstrapper {
	
	/*
	 * Singleton Implemented
	 */
	private Bootstrapper(){}
	
	private static Bootstrapper instance = new Bootstrapper();
	
	public static Bootstrapper getInstance(){
		return instance;
	}
	
	
	
}
