package proj.meditrac.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.meditrac.core.Authenticator;
import proj.meditrac.core.enums.SessionParams;
import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;
import proj.meditrac.entities.Member;
import proj.meditrac.util.Utility;

@WebServlet("/AccountsController/*")
public class AccountsController extends HttpServlet {
	
	private static final long serialVersionUID = 5231115719252886041L;

	public AccountsController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqURI = request.getRequestURI();
		HttpSession session = request.getSession();
		if(reqURI.equals("/MediTrac/AccountsController/Authenticate")){
			
			if(Utility.checkParams(request, new String[]{"mem_id","mem_pass"})){
				long memberId = 0;
				if(Utility.isNumber(Utility.escapeUserData(request.getParameter("mem_id")))){
					memberId = Long.parseLong(Utility.escapeUserData(request.getParameter("mem_id")));
					String memberPass = Utility.escapeUserData(request.getParameter("mem_pass"));
					try {
						Member member = Authenticator.authenticate(memberId, memberPass);
						if(member != null){
							session.setAttribute("error", null);
							session.setAttribute(SessionParams.MEMBER.getParamName(), member);
							response.sendRedirect("/MediTrac/dashboard");
						} else {
							session.setAttribute("error", "LOGIN_ERROR");
							response.sendRedirect("/MediTrac/?login_attempt=fail");
						}
					} catch (ConnectException | SchemaException e) {
						e.printStackTrace();
					}
				} else {
					session.setAttribute("error", "LOGIN_ERROR");
					response.sendRedirect("/MediTrac/?login_attempt=fail");
				}
			} else {
				session.setAttribute("error", "LOGIN_ERROR");
				response.sendRedirect("/MediTrac/?login_attempt=fail");
			}
			
		} else if(reqURI.equals("/MediTrac/AccountsController/Register")){
			
		}
	}
	
	/*
	 * Redirection for GET requests
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/MediTrac/");
	}
}
