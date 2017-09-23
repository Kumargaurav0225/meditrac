package proj.meditrac.core;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.meditrac.core.enums.Configuration;

abstract public class Template {
	
	public static void dispatch(HttpServletRequest request,HttpServletResponse response,String template,Map<String,Object> attributes) throws ServletException, IOException{
		ConfigurationManager cm = ConfigurationManager.getInstance();
		RequestDispatcher dispatcher = request.getRequestDispatcher(cm.getProperty(Configuration.TEMPLATE_DIR) + template);
		if(attributes != null){
			attributes.forEach((k,v) -> {
				request.setAttribute(k, v);
			});
		}
		
		dispatcher.forward(request, response);
	}
	
}
