package info.office.service;

import java.util.List;

import info.office.entity.Child;

public interface ChildService {

	public List<Child> getChildren();

	public void saveChild(Child theChild);

	public Child getChild(long theId);
}
