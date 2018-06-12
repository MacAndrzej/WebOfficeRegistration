package info.office.service;

import java.util.List;

import info.office.entity.Visit;
import info.office.exception.IdNotFoundException;

public interface VisitService {

	List<Visit> getVisits();

	void save(Visit theVisit);

	Visit getVisit(long theId) throws IdNotFoundException;

	void deleteVisit(long theId);


}
