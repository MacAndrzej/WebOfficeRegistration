<<<<<<< HEAD
package info.office.service;

import java.util.List;

import info.office.entity.Parent;

public interface ParentService {

	List<Parent> getParents();

	Parent saveParent(Parent theParent);

	Parent getParent(long theId);

	void deleteParent(long theId);

	Parent findByName(String username);
	
}
=======
package info.office.service;

import java.util.List;

import info.office.entity.Parent;
import info.office.exception.IdNotFoundException;

public interface ParentService {

	List<Parent> getParents();

	void saveParent(Parent theParent);

	Parent getParent(long theId) throws IdNotFoundException;

	void deleteParent(long theId);

	Parent findByName(String username);
	
}
>>>>>>> refs/heads/ExceptionHandling
