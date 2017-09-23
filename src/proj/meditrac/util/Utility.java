package proj.meditrac.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;

import proj.meditrac.core.enums.SessionParams;

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
	public static long generateMemberId(){		
		return System.currentTimeMillis();
	}
	
	
	/*
	 * Check session
	 */
	public static boolean checkCookie(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.isNew())
			return false;
		
		if(session.getAttribute(SessionParams.MEMBER.getParamName()) != null)
			return true;
		else {
			session.invalidate();
			return false;
		}
	}
	
	/*
	 * Check request parameters
	 */
	public static boolean checkParams(HttpServletRequest request,String[] params){
		boolean flag = true;
		
		for(String param : params){
			if(request.getParameter(param) == null){
				flag = false;
				break;
			}
		}
			
		return flag;
	}
	
	/*
	 * Get param
	 */
	
	
	/*
	 * Is number
	 */
	public static boolean isNumber(String input){
		if(input.matches("[0-9]+"))
			return true;
		else
			return false;
	}
	
	/*
	 * Is email
	 */
	public static boolean isEmail(String input){
		//if(input.matches())
		return true;
	}
}
