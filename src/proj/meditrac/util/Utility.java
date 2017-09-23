package proj.meditrac.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;

import proj.meditrac.core.enums.MemberType;

public final class Utility {

	private Utility(){};
	
	public static String encrypt(final String message){
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(message.getBytes());
			byte[] digest = messageDigest.digest();
			return new BigInteger(1,digest).toString(16);
		} catch(NoSuchAlgorithmException ex){
			return null;
		}
	}
	
	public static String escapeHTML(String message){
		return StringEscapeUtils.escapeHtml(message);
	}
	
	public static String escapeSQL(String message){
		return StringEscapeUtils.escapeSql(message);
	}
	
	public static String escapeUserData(String message){
		return escapeHTML(escapeSQL(message));
	}
	
	public static String randomAlphanumeric(int count){
		return RandomStringUtils.randomAlphanumeric(count);
	}
	
	/*
	 * Application specific utility methods
	 */
	public static String generateMemberId(MemberType m){		
		StringBuilder s = new StringBuilder();
		switch(m){
			case ADMINISTRATOR:
				
				break;
			case HOSPITAL:
				
				break;
			case DOCTOR:
				
				break;
			case PATIENT:
				
				break;
		}
		return s.toString();
	}
	
}
