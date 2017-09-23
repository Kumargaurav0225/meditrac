package proj.meditrac.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import proj.meditrac.db.Metadata;

public final class Manager {

	private final Date serverStartTime;
	
	private Manager(){
		serverStartTime = new Date();
	};
	
	private static Manager instance;
	
	private static List<Exception> exceptions = new ArrayList<Exception>();
	
	static {
		instance = new Manager();
	}
	
	public static Manager getInstance(){
		return instance;
	}
	
	public Date getServerStartTime(){
		return this.serverStartTime;
	}
	
	public static boolean isMeditracIntact(){
		return Metadata.isDBConnected();
	}
	
	public void addException(Exception ex){
		exceptions.add(ex);
	}
	
	public int getExceptionCount(){
		return exceptions.size();
	}
	
	public List<Exception> getExceptions(){
		return exceptions;
	}
	
	public List<String> getExceptionMessages(){
		List<String> messages = new ArrayList<String>();
		for(Exception e : exceptions)
			messages.add(e.getCause() + " : " + e.getMessage());
		return messages;
	}
	
}
