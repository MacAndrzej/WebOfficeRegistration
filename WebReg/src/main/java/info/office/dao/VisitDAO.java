package info.office.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import info.office.entity.Visit;

@Repository
public interface VisitDAO extends CrudRepository<Visit, Long> {

}
