package info.office.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.office.dao.ChildDAO;
import info.office.entity.Child;
import info.office.exception.IdNotFoundException;

@Service
public class ChildServiceImpl implements ChildService {

	@Autowired
	private ChildDAO childDAO;

	@Override
	@Transactional
	public List<Child> getChildren() {
		return childDAO.findAll();
	}

	@Override
	@Transactional
	public void saveChild(Child theChild) {
		childDAO.save(theChild);
	}

	@Override
	@Transactional
	public Child getChild(Long theId) throws IdNotFoundException {
		Optional<Child> childOptional=childDAO.findById(theId);
		if (!childOptional.isPresent()) {
			throw new IdNotFoundException();
		}
		return childOptional.get();
	}

	@Override
	@Transactional
	public void deleteChild(Long theId) {
		childDAO.deleteById(theId);
	}

	@Override
	public Child findByParent_id(Long theId) {
		return childDAO.findByParent_id(theId);
	}

}
