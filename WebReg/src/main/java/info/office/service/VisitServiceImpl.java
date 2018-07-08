package info.office.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.office.dao.VisitDAO;
import info.office.entity.Visit;
import info.office.exception.IdNotFoundException;

@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	private VisitDAO visitDAO;

	@Override
	@Transactional
	public List<Visit> getVisits() {

		List<Visit> visit = visitDAO.findAll();
		return visit;
	}

	@Override
	@Transactional
	public Visit save(Visit theVisit) {
		theVisit.setTermOfModification(LocalDate.now());
		Visit savedVisit = visitDAO.save(theVisit);
		return savedVisit;
	}

	@Override
	@Transactional
	public Visit getVisit(long theId) throws IdNotFoundException {
		Optional<Visit> optionalVisit = visitDAO.findById(theId);
		if (!optionalVisit.isPresent()) {
			throw new IdNotFoundException();
		}
		return optionalVisit.get();
	}

	@Override
	@Transactional
	public void deleteVisit(long theId) {
		visitDAO.deleteById(theId);
	}

}
