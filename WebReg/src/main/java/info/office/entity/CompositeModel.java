package info.office.entity;

import javax.validation.Valid;

import info.office.entity.Child;
import info.office.entity.Parent;

public class CompositeModel {

	@Valid
	private Parent parent;
	@Valid
	private Child child;
	private String password;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public CompositeModel() {
	}

	public CompositeModel(Parent parent) {
		this.parent = parent;
	}

	public CompositeModel(Child child) {
		this.child = child;
	}

	public CompositeModel(Parent parent, Child child) {
		this.parent = parent;
		this.child = child;
	}

	public CompositeModel(Parent parent, Child child, String password) {
		this.parent = parent;
		this.child = child;
		this.password = password;
	}
	
	
	

}
