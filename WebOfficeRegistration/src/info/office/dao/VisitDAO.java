package info.office.dao;

import java.util.List;

import info.office.entity.Visit;

public interface VisitDAO {

	public List<Visit> getVisits();

	public void save(Visit theVisit);

	public Visit getVisit(long theId);


}
