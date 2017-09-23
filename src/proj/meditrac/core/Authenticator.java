package proj.meditrac.core;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import proj.meditrac.core.exceptions.ConnectException;
import proj.meditrac.core.exceptions.SchemaException;
import proj.meditrac.db.Persistence;
import proj.meditrac.entities.Member;
import proj.meditrac.util.Utility;

public final class Authenticator {

	private Authenticator(){};
	
	public static Member authenticate(long id, String pass) throws ConnectException, SchemaException{
		Session session = Persistence.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Member.class);

		Criterion idCriterion = Restrictions.eq("id", id);
		Criterion passCriterion = Restrictions.eq("password", Utility.encrypt(pass));
		Criterion activeCriterion = Restrictions.eq("active", Member.Active.ACTIVE);

		criteria.add(idCriterion).add(passCriterion).add(activeCriterion);
		Member m = (Member) criteria.uniqueResult();
		session.close();
		return m;
	}
	
}
