package proj.meditrac.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;
import proj.meditrac.db.Persistence;
import proj.meditrac.entities.Doctor;
import proj.meditrac.util.Utility;

/**
 * Servlet implementation class DoctorController
 */
@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String doctorName,gender,specialisation,experience,dob,email,city,district,state,phone,ptc;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action").trim();
		if(action.equals("show"))
		{
			request.getRequestDispatcher("WEB-INF/jsp/partials/_hospitalShowDoctor.jsp").forward(request, response);
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String action=request.getParameter("action").trim();
		if(action.equals("registerDoctor"))
		{
			registerDoctor(request);
		}
	}
	
	private void registerDoctor(HttpServletRequest request)
	{
		doctorName=Utility.escapeUserData(request.getParameter("doctorName"));
		gender=Utility.escapeUserData(request.getParameter("gender"));
		specialisation=Utility.escapeUserData(request.getParameter("Specialisation"));
		experience=Utility.escapeUserData(request.getParameter("experience"));
		dob=Utility.escapeUserData(request.getParameter("dob"));
		email=Utility.escapeUserData(request.getParameter("email"));
		phone=Utility.escapeUserData(request.getParameter("phone"));
		city=Utility.escapeUserData(request.getParameter("city"));
		district=Utility.escapeUserData(request.getParameter("district"));
		state=Utility.escapeUserData(request.getParameter("state"));
		ptc=Utility.escapeUserData(request.getParameter("ptc"));

		Doctor doctor=new Doctor();
		doctor.setdID("101");
		doctor.setdoctorName(doctorName);
		doctor.setSpecialisation(specialisation);
		doctor.setDistrict(district);
		doctor.setState(state);
		doctor.setCity(city);
		doctor.setDob(dob);
		doctor.setEmail(email);
		doctor.setExperience(experience);
		doctor.setGender(gender);
		doctor.setPhone(phone);
		doctor.setPtc(ptc);
		Session s;
		try {
			s = Persistence.getSessionFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(doctor);
			tx.commit();
			s.close();
		} catch (HibernateException | ConnectException | SchemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
