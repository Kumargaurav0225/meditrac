package proj.meditrac.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.meditrac.core.Template;
import proj.meditrac.core.enums.SessionParams;
import proj.meditrac.entities.Member;
import proj.meditrac.util.Utility;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

	private static final long serialVersionUID = -1414027817178792830L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = null;
		if(Utility.checkParams(request, new String[]{"action"})){
			action = Utility.escapeUserData(request.getParameter("action"));
			if(action.equals("logout")){
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("/MediTrac");
			}
		} else {
			Member m = (Member)request.getSession().getAttribute(SessionParams.MEMBER.getParamName());
			Template.dispatch(request, response, "partials/_" + m.getGroup().toLowerCase() + "Dashboard.jsp", null);
		}
		
	}
}
