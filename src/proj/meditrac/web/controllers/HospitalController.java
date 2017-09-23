package proj.meditrac.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;
import proj.meditrac.db.Persistence;
import proj.meditrac.entities.Doctor;
import proj.meditrac.entities.Hospital;
import proj.meditrac.util.Utility;

@WebServlet("/HospitalController")
public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String hospitalname,hospital_licence,doe,email,city,district,state,specialities,tel;
       
    public HospitalController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action").trim();
		if(action.equals("details")){
			request.getRequestDispatcher("WEB-INF/jsp/partials/_showHospitalDetails.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action").trim();
		if(action.equals("register"))
		{
			addHospital(request,response);
		}
		else if(action.equals("delete"))
		{
			try {
				deleteDoctor(request);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConnectException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SchemaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("searchDoctor"))
		{
			
		}
		
		

	}
	private void addHospital(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		hospitalname=Utility.escapeUserData(request.getParameter("hospitalname"));
		hospital_licence=Utility.escapeUserData(request.getParameter("hospital_licence"));
		doe=Utility.escapeUserData(request.getParameter("doe"));
		email=Utility.escapeUserData(request.getParameter("email"));
		tel=Utility.escapeUserData(request.getParameter("tel"));
		city=Utility.escapeUserData(request.getParameter("city"));
		district=Utility.escapeUserData(request.getParameter("district"));
		state=Utility.escapeUserData(request.getParameter("state"));
		specialities=Utility.escapeUserData(request.getParameter("specialities"));
		String zip=Utility.escapeUserData(request.getParameter("zip"));
		
		Hospital hospital=new Hospital();
		hospital.setInsertionId("106");
		hospital.setHosName(hospitalname);
		hospital.setHosCode(hospital_licence);
		hospital.setState(state);
		hospital.setCity(city);
		hospital.setDistrict(district);
		hospital.setZip(zip);
		hospital.setSpecialities(specialities);
		hospital.setDate(doe);
		hospital.setEmail(email);
		hospital.setTelephone(tel);
		hospital.setBlacklisted(Hospital.Blacklisted.FALSE);
		hospital.setVerified(Hospital.Verified.FALSE);
		Session s;
		try {
			s = Persistence.getSessionFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(hospital);
			tx.commit();
		} catch (HibernateException | ConnectException | SchemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deleteDoctor(HttpServletRequest request) throws HibernateException, ConnectException, SchemaException
	{
		String dID=Utility.escapeUserData(request.getParameter("id"));
		Session sess=Persistence.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		Doctor doctor=(Doctor)sess.get(Doctor.class, dID);
		sess.delete(doctor);
		sess.flush();
		tx.commit();
	}

}
