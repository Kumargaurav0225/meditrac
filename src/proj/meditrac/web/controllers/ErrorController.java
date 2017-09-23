package proj.meditrac.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorController extends HttpServlet {

	private static final long serialVersionUID = 1631885690579095528L;

	private static final String _404 = "RES_NOT_FOUND";
	private static final String _500 = "APP_ERROR";
	
    public ErrorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getParameter("type")){
			case _404:
				request.getRequestDispatcher("WEB-INF/jsp/errors/404.jsp").forward(request, response);
				break;
			case _500:
				request.getRequestDispatcher("WEB-INF/jsp/errors/500.jsp").forward(request, response);
				break;
			default:
				request.getRequestDispatcher("WEB-INF/jsp/errors/404.jsp").forward(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
