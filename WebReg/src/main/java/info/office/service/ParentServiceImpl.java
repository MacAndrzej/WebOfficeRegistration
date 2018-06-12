package info.office.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.office.dao.ParentDAO;
import info.office.entity.Parent;
import info.office.exception.IdNotFoundException;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentDAO parentDAO;

	@Override
	@Transactional
	public List<Parent> getParents() {
		List<Parent> parents = parentDAO.findAll();
		return parents;
	}

	@Override
	@Transactional
	public void saveParent(Parent theParent) {
		parentDAO.save(theParent);
	}

	@Override
	@Transactional
	public Parent getParent(long theId) throws IdNotFoundException {
		Optional<Parent> parentOptional=parentDAO.findById(theId);
		if(!parentOptional.isPresent()) {
			throw new IdNotFoundException();
		}
		return parentOptional.get();
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
