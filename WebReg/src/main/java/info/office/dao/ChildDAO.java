package info.office.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import info.office.entity.Child;

@Repository
public interface ChildDAO extends CrudRepository<Child, Long> {

	Child findByParent_id(Long theId);

}
