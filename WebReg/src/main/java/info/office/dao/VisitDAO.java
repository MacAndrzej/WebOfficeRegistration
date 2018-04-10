package info.office.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.office.entity.Visit;

@Repository
public interface VisitDAO extends JpaRepository<Visit, Long> {	
	
	

}
