package proj.meditrac.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import proj.meditrac.db.Metadata;

public final class Manager {

	private Manager(){};
	
	private static Date serverUptime;
	
	private static List<Exception> exceptions = new ArrayList<Exception>();
	
	public static boolean isMeditracIntact(){
		return Metadata.isDBConnected() && Metadata.checkSchemaIntegrity();
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
