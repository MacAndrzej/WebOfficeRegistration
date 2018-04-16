package info.office.service;

import java.util.ArrayList;
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

		List<Parent> parents = new ArrayList<>();
		System.out.println("UWAGA !!!!"+parentDAO.findAll().toString());
		for (Parent p : parentDAO.findAll()) {
			parents.add(p);
		}

		return parents;
	}

	@Override
	@Transactional
	public void saveParent(Parent theParent) {
		parentDAO.save(theParent);
		
	}

	@Override
	@Transactional
	public Parent getParent(long theId) {
		
		return parentDAO.findById(theId).orElse(null);
	}

	@Override
	@Transactional
	public void deleteParent(long theId) {
		parentDAO.deleteById(theId);
		
	}

	@Override
	@Transactional
	public Parent findByName(String username) {
		return parentDAO.findByName(username);
	}


}
