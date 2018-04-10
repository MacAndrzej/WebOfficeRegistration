package info.office.service;

import java.util.List;

import info.office.entity.Parent;

public interface ParentService {

	List<Parent> getParents();

	void saveParent(Parent theParent);

	Parent getParent(long theId);

	void deleteParent(long theId);

	Parent findByName(String username);
	
}
