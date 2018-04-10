package info.office.entity;

import javax.validation.Valid;

import info.office.entity.Child;
import info.office.entity.Parent;

public class CompositeParentChild {

	@Valid
	private Parent parent;
	@Valid
	private Child child;
	

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

	public CompositeParentChild() {
	}

	public CompositeParentChild(Parent parent) {
		this.parent = parent;
	}

	public CompositeParentChild(Child child) {
		this.child = child;
	}

	public CompositeParentChild(Parent parent, Child child) {
		this.parent = parent;
		this.child = child;
	}
	

}
