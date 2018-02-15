package info.office.service;

import java.util.List;

import info.office.entity.Visit;


public interface VisitService {

	public List<Visit> getVisits();

	public void save(Visit theVisit);

	public Visit getVisit(long theId);

	public void deleteVisit(long theId);
	

}
