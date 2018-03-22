package info.office.service;

import java.util.List;

import info.office.entity.Child;

public interface ChildService {

	List<Child> getChildren();

	void saveChild(Child theChild);

	Child getChild(long theId);

	void deleteChild(long theId);

}
