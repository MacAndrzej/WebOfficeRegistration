package info.office.service;

import java.util.List;

import info.office.entity.Visit;

public interface VisitService {

	List<Visit> getVisits();

	void save(Visit theVisit);

	Visit getVisit(long theId);

	void deleteVisit(long theId);

}
