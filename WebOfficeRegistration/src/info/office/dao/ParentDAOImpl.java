package info.office.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import info.office.entity.Parent;

@Repository
public class ParentDAOImpl implements ParentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Parent> getParents() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Parent> theQuery = currentSession.createQuery("from Parent", Parent.class);

		List<Parent> parents = theQuery.getResultList();

		return parents;
	}

}
