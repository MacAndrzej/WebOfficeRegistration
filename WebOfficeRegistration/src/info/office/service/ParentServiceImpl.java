package info.office.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.office.dao.ParentDAO;
import info.office.entity.Parent;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentDAO parentDAO;
	
	@Override
	@Transactional
	public List<Parent> getParents() {
		
		return parentDAO.getParents();
	}

	@Override
	@Transactional
	public void saveParent(Parent theParent) {
		
		parentDAO.saveParent(theParent);
	}

	@Override
	@Transactional
	public Parent getParent(long theId) {
		
		return parentDAO.getParent(theId);
	}

	@Override
	@Transactional
	public void deleteParent(long theId) {
		
		parentDAO.deleteParent(theId);
		
	}
	
	

}
