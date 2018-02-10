package info.office.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.office.entity.Visit;

@Repository
public class VisitDAOImpl implements VisitDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Visit> getVisits() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Visit> theQuery=currentSession.createQuery("FROM Visit ORDER BY termOfVisitPlanned", Visit.class);
		
		List<Visit> visits=theQuery.getResultList();

		return visits;
	}

}
