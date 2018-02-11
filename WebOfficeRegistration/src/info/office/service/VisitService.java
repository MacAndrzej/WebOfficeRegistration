package info.office.service;

import java.util.List;

import info.office.entity.Visit;


public interface VisitService {

	List<Visit> getVisits();

	void save(Visit theVisit);
	

}
