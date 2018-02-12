package info.office.dao;

import java.util.List;

import info.office.entity.Visit;

public interface VisitDAO {

	List<Visit> getVisits();

	void save(Visit theVisit);

	Visit getVisit(long theId);


}
