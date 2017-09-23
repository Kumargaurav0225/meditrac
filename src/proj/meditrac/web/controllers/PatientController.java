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
import proj.meditrac.entities.Patient;
import proj.meditrac.util.Utility;

/**
 * Servlet implementation class PatientController
 */
@WebServlet("/PatientController")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String patientName,gender,dob,email,city,district,state,complication,pId;
	private String phone,ptc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action").trim();
		
		patientName=Utility.escapeUserData(request.getParameter("patientName"));
		gender=request.getParameter("gender");
		dob=Utility.escapeUserData(request.getParameter("dob"));
		email=Utility.escapeUserData(request.getParameter("email"));
		phone=Utility.escapeUserData(request.getParameter("phone"));
		city=Utility.escapeUserData(request.getParameter("city"));
		district=Utility.escapeUserData(request.getParameter("district"));
		state=Utility.escapeUserData(request.getParameter("state"));
		pId=Utility.escapeUserData(request.getParameter("pId"));
		complication=Utility.escapeUserData(request.getParameter("complication"));
		ptc=Utility.escapeUserData(request.getParameter("ptc"));

		Patient patient=new Patient();
		patient.setpId("101");
		patient.setPatientName(patientName);
		patient.setCity("city");
		patient.setComplication(complication);
		patient.setDistrict(district);
		patient.setDob(dob);
		patient.setEmail(email);
		patient.setGender(gender);
		patient.setPhone(phone);
		patient.setPtc(ptc);
		patient.setState(state);
		//patientName,gender,dob,email,city,district,state,complication,phone,ptc
		Session s;
		try {
			s = Persistence.getSessionFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(patient);
			tx.commit();
			s.close();
		} catch (HibernateException | ConnectException | SchemaException e) {			
			System.out.println("***************Error in Connection*********************");
			e.printStackTrace();
		}
	}

}
