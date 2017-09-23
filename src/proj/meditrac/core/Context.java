package proj.meditrac.core;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import proj.meditrac.core.enums.SessionParams;
import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;
import proj.meditrac.db.Persistence;
import proj.meditrac.entities.Member;

public class Context {
	
	private HttpSession session;
	
	public Context(HttpSession session){
		this.session = session;
	}
	
	public Context getContext(){
		return this;
	}
	
	public HttpSession getSession(){
		return this.session;
	}
	
	public void destroy(){
		this.session = null;
	}
	
	public Member getCurrentMember() throws ConnectException, SchemaException{
		Session s = Persistence.getSessionFactory().openSession();
		Member m = (Member) s.get(Member.class,this.session.getAttribute(SessionParams.MEMBER_ID.getParamName()).toString());
		s.close();
		return m;
	}
	
}
