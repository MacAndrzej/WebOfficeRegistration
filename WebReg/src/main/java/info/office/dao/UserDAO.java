package info.office.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import info.office.entity.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

}
