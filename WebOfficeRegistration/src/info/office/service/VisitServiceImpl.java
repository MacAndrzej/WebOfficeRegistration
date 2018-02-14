package info.office.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.office.dao.VisitDAO;
import info.office.entity.Visit;

@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitDAO visitDAO;

	@Transactional
	@Override
	public List<Visit> getVisits() {

		return visitDAO.getVisits();
	}

	@Transactional
	@Override
	public void save(Visit theVisit) {

		visitDAO.save(theVisit);

	}

	@Transactional
	@Override
	public Visit getVisit(long theId) {

		return visitDAO.getVisit(theId);
	}

}
