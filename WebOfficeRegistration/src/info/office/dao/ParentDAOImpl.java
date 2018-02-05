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
	public List<Parent> getParents() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Parent> theQuery = currentSession.createQuery("FROM Parent ORDER BY surname", Parent.class);

		List<Parent> parents = theQuery.getResultList();

		return parents;
	}

	@Override
	public void saveParent(Parent theParent) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theParent);
		
	}

	@Override
	public Parent getParent(long theId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Parent theParent=currentSession.get(Parent.class, theId); 
		
		return theParent;
	}

	@Override
	public void deleteParent(long theId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Parent theParent=new Parent();
		
		theParent=currentSession.get(Parent.class,theId);
		
		currentSession.delete(theParent);
		
	}

}
