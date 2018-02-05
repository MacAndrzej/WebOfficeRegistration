package info.office.service;

import java.util.List;

import info.office.entity.Parent;

public interface ParentService {
	public List<Parent> getParents();

	public void saveParent(Parent theParent);

	public Parent getParent(long theId);

	public void deleteParent(long theId);

}
