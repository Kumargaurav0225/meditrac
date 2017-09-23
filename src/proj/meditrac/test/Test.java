package proj.meditrac.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;
import proj.meditrac.db.Persistence;
import proj.meditrac.entities.Doctor;

public class Test {
	
	
	public static void main(String[] args) throws ConnectException, SchemaException {
		
		Session sess=Persistence.getSessionFactory().openSession();
		String hqlQuery = "select d from Doctor as d join d.hospital as h where h.insertionId=102";

		Query query = sess.createQuery(hqlQuery);
		List list = query.list();

		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			Doctor doctor = (Doctor) iterator.next();
		
			System.out.println(doctor.getdoctorName());
		}
//		Criteria c = s.createCriteria(doctor.class);
//		Criterion cn = Restrictions.eq("verified","TRUE");
//		c.add(cn);
//		List<doctor> verifieddoctors = c.list();
//		for(doctor h : verifieddoctors)
//			System.out.println(h.getInsertionId() + " - " + h.getHosName());
//		
//		s.close();
		Persistence.close();
	}
	
	
}
