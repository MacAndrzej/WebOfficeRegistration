package info.office.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import info.office.entity.Parent;

@Repository
public interface ParentDAO extends CrudRepository<Parent, Long> {

}
