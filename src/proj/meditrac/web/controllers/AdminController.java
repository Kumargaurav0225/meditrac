package proj.meditrac.web.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;
import proj.meditrac.db.Persistence;
import proj.meditrac.entities.Hospital;
import proj.meditrac.entities.Member;
import proj.meditrac.util.Utility;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String state,hosName,hosCode,city,district,date,telephone,email,specialities;/*[]=new String[100];*/
    private String zip;
    //private Date date=new Date();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action").trim();
		if(action.equals("add")){
			try {
				addHospital( request, response);
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
		else if(action.equals("verify")){
			try {
				verify(request);
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
		else if(action.equals("delete"))
		{
			try {
				delete(request);
			} catch (HibernateException | ConnectException | SchemaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("blacklist"))
		{
			try {
				blacklist(request);
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
		else if(action.equals("unBlacklist"))
		{
			try {
				unBlacklist(request);
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
		else if(action.equals("search"))
		{
			String searchBy=request.getParameter("searchType");
			try
			{
			switch(searchBy)
			{
			case "hosName":
				searchByName(request,response);
				break;
			case "specialities":
				searchBySpecialities(request,response);
				break;
			case "hosCode":searchByLicence(request,response);
				break;
			case "telephone":searchByTelephone(request,response);
				break;
			case "state":searchByState(request,response);
				break;
			case "city":searchByCity(request,response);
				break;
			case "zip":searchByZip(request,response);
				break;
			case "email":searchByEmail(request,response);
				break;
			case "district":searchByDistrict(request,response);
				break;
			default:response.getWriter().println("Keyword you have given does not match.");
				break;
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @throws SchemaException 
	 * @throws ConnectException 
	 * @throws HibernateException 
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void searchByName(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where lower(h.hosName) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/*
	 * 
	 */
	
	private void searchByLicence(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where lower(h.hosCode) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);

	}
	private void searchByTelephone(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where (h.telephone) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);

	}
	
	private void searchByState(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where lower(h.state) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);

	}
	
	private void searchByCity(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where lower(h.city) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);

	}
	
	private void searchByZip(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where lower(h.zip) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);

	}
	
	private void searchByEmail(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where lower(h.email) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);

	}
	
	private void searchBySpecialities(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where lower(h.specialities) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);

	}
	
	private void searchByDistrict(HttpServletRequest request,HttpServletResponse response) throws HibernateException, ConnectException, SchemaException, ServletException, IOException
	{
		String hql="from Hospital h where lower(h.district) like ('%"+request.getParameter("query").toLowerCase()+"%')";
		Session sess=Persistence.getSessionFactory().openSession();
		Query q=sess.createQuery(hql);
		List<Hospital> list=q.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/partials/_adminSearchHospital.jsp").forward(request, response);

	}
	
	private void addHospital(HttpServletRequest request, HttpServletResponse response) throws HibernateException, ConnectException, SchemaException
	{
		Session sess=Persistence.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		hosName=Utility.escapeUserData(request.getParameter("hosName"));
		hosCode=Utility.escapeUserData(request.getParameter("hosCode"));
		//specialities[]=Utility.escapeUserData(request.getParameter("specialities").split(","));
		specialities=Utility.escapeUserData(request.getParameter("specialities"));
		district=Utility.escapeUserData(request.getParameter("district"));
		state=Utility.escapeUserData(request.getParameter("state"));
		zip=Utility.escapeUserData(request.getParameter("zip"));
		date=Utility.escapeUserData(request.getParameter("doe"));
		telephone=Utility.escapeUserData("telephone");
		city=Utility.escapeUserData(request.getParameter("city"));
		email=Utility.escapeUserData("email");
		Hospital h=new Hospital();
		h.setInsertionId("106");
		
		h.setCity(city);
		h.setDate(date);
		h.setDistrict(district);
		h.setEmail(email);
		h.setHosCode(hosCode);
		h.setHosName(hosName);
		h.setSpecialities(specialities);
		h.setState(state);
		h.setTelephone(telephone);
		h.setBlacklisted(Hospital.Blacklisted.FALSE);
		h.setVerified(Hospital.Verified.FALSE);
		h.setZip(zip);
		
		sess.save(h);
		tx.commit();
	}
	
	private void verify(HttpServletRequest req) throws HibernateException, ConnectException, SchemaException{
		String hosId = Utility.escapeUserData(req.getParameter("hosId"));
		Session sess=Persistence.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		String password=Utility.randomAlphanumeric(6);
		Member m=new Member();
		m.setId(hosId);
		m.setPassword(password);
		m.setGroup(Member.Group.HOSPITAL);
		m.setCreatedAt(new Date());
		m.setActive(Member.Active.ACTIVE);
		sess.save(m);
		String hqlQuery = "update Hospital h set h.verified='TRUE' where insertionId='"+hosId+"'";

		if(sess.createQuery(hqlQuery).executeUpdate() > 0)
		{
			System.out.println("UPDATED");
		}

		tx.commit();
	}

	private void delete(HttpServletRequest request) throws HibernateException, ConnectException, SchemaException
	{
		String hosId=Utility.escapeUserData(request.getParameter("hosId"));
		Session sess=Persistence.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		//Member member = (Member) sess.get(Member.class, hosId);
		Hospital hospital=(Hospital)sess.get(Hospital.class, hosId);
		//sess.delete(member);
		sess.delete(hospital);
		tx.commit();
	}
	
	private void blacklist(HttpServletRequest request) throws HibernateException, ConnectException, SchemaException
	{
		String hosId=Utility.escapeUserData(request.getParameter("hosId"));
		Session sess=Persistence.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		String hql="update Member m set m.active='NOT_ACTIVE' where id='"+hosId+"'";
		String hqlh="update Hospital h set h.blacklisted='TRUE' where id='"+hosId+"'";
		if(sess.createQuery(hql).executeUpdate() > 0)
		{
			System.out.println("BlackListed");
		}
		if(sess.createQuery(hqlh).executeUpdate() > 0)
		{
			System.out.println("BlackListed");
		}
		tx.commit();
	}
	
	private void unBlacklist(HttpServletRequest request) throws HibernateException, ConnectException, SchemaException
	{
		String hosId=Utility.escapeUserData(request.getParameter("hosId"));
		Session sess=Persistence.getSessionFactory().openSession();
		Transaction tx=sess.beginTransaction();
		String hql="update Member m set m.active='ACTIVE' where id='"+hosId+"'";
		String hqlh="update Hospital h set h.blacklisted='FALSE' where id='"+hosId+"'";
		if(sess.createQuery(hql).executeUpdate() > 0)
		{
			System.out.println("UnBlackListed");
		}
		if(sess.createQuery(hqlh).executeUpdate() > 0)
		{
			System.out.println("UnBlackListed");
		}
		tx.commit();
	}
	
}
