package proj.meditrac.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.meditrac.core.Template;
import proj.meditrac.util.Utility;

public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 5584148473206106547L;

	public IndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Utility.checkCookie(request)){
			response.sendRedirect("/MediTrac/dashboard");
		} else {
			if(Utility.checkParams(request, new String[]{"login_attempt"})){
				if(request.getParameter("login_attempt").equals("fail")){
					Map<String,Object> attributes = new HashMap<String,Object>();
					attributes.put("login_error", "1");
					Template.dispatch(request, response, "login.jsp", attributes);
				} else {
					Template.dispatch(request, response, "login.jsp", null);
				}
			} else {
				Template.dispatch(request, response, "login.jsp", null);
			}
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	
}
