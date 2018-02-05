package info.office.dao;

import java.util.List;

import info.office.entity.Parent;

public interface ParentDAO {
	
	public List<Parent> getParents();

	public void saveParent(Parent theParent);

	public Parent getParent(long theId);

	public void deleteParent(long theId);

}
