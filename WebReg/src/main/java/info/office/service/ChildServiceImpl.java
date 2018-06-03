package info.office.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.office.dao.ChildDAO;
import info.office.entity.Child;

@Service
public class ChildServiceImpl implements ChildService {

	@Autowired
	private ChildDAO childDAO;

	@Override
	@Transactional
	public List<Child> getChildren() {

		List<Child> children = new ArrayList<>();
		
		for (Child c : childDAO.findAll()) {
			children.add(c);
		}
		
		
		return children;
	}

	@Override
	@Transactional
	public Child saveChild(Child theChild) {
		return childDAO.save(theChild);
	}

	@Override
	@Transactional
	public Child getChild(Long theId) {
		
		return childDAO.findById(theId).orElse(null);
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
