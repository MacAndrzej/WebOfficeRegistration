package info.office.dao;

import java.util.List;

import info.office.entity.Child;

public interface ChildDAO {
	
	public List<Child> getChildren();

	public void saveChild(Child theChild);

	public Child getChild(long theId);
	
	

}
