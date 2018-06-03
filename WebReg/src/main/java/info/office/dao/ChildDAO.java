package info.office.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.office.entity.Child;

@Repository
public interface ChildDAO extends JpaRepository<Child, Long> {

	Child findByParent_id(Long theId);
	
	Optional<Child> findById(Long Id);


}
