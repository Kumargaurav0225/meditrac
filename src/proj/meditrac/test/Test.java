package proj.meditrac.test;

import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;
import proj.meditrac.db.Persistence;
import proj.meditrac.entities.Member;

public class Test {
	
	
	public static void main(String[] args) throws ConnectException, SchemaException, SQLException {
		insertDefault();
	}
	
	@SuppressWarnings("unused")
	private static void insertDefault() throws ConnectException, SchemaException{
		Member m = new Member();
		m.setPassword("blackfly");
		m.setActive(Member.Active.ACTIVE);
		m.setGroup(Member.Group.PATIENT);
		m.setCreatedAt(new Date());
		Session s = Persistence.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		System.out.println(s.save(m));
		tx.commit();
		Persistence.close();
	}
}
