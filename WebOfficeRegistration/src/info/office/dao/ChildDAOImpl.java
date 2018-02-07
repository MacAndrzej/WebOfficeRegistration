package info.office.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.office.entity.Child;

@Repository
public class ChildDAOImpl implements ChildDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Child> getChildren() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Child> theQuery = currentSession.createQuery("FROM Child ORDER BY surname", Child.class);

		List<Child> children = theQuery.getResultList();

		return children;
	}

	@Override
	public void saveChild(Child theChild) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theChild);

	}

	@Override
	public Child getChild(long theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Child theChild = currentSession.get(Child.class, theId);

		return theChild;
	}

	@Override
	public void deleteChild(long theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Child theChild = currentSession.get(Child.class, theId);

		currentSession.delete(theChild);

	}

}
