package info.office.service;

import java.util.List;

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

		return childDAO.getChildren();
	}

	@Override
	@Transactional
	public void saveChild(Child theChild) {

		childDAO.saveChild(theChild);

	}

	@Override
	@Transactional
	public Child getChild(long theId) {
		
		return childDAO.getChild(theId);
	}

	
	
	

}
