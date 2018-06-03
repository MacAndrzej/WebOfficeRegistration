package info.office.service;

import java.util.List;

import info.office.entity.Child;
/**
 * 
 * @Created by am on 2 cze 2018
 *
 */
 
public interface ChildService {

	List<Child> getChildren();

	Child saveChild(Child theChild);

	Child getChild(Long theId);

	void deleteChild(Long theId);
	
	Child findByParent_id(Long theId);

}
