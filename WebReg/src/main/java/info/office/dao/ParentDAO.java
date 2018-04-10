package info.office.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.office.entity.Parent;

@Repository
public interface ParentDAO extends JpaRepository<Parent, Long> {
	
	Parent findByName(String username);

}
