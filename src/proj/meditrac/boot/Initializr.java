package proj.meditrac.boot;

import javax.servlet.http.HttpServlet;

/*
 * Initialization servlet, loaded on server startup.
 */
public class Initializr extends HttpServlet {

	private Bootstrapper bootstrap;
	
	public Initializr(){
		bootstrap = Bootstrapper.getInstance();
		
	}
	
}
