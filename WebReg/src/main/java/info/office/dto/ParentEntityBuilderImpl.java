package info.office.dto;

import info.office.entity.Child;
import info.office.entity.Parent;
import info.office.entity.Users;

public class ParentEntityBuilderImpl implements ParentEntityBuilder {

	private Parent parent;

	public ParentEntityBuilderImpl() {
		parent = new Parent();
	}

	@Override
	public Parent build() {
		return parent;
	}

	@Override
	public ParentEntityBuilderImpl id(Long id) {
		parent.setId(id);
		return this;
	}

	@Override
	public ParentEntityBuilderImpl surname(String surname) {
		parent.setSurname(surname);
		return this;
	}

	@Override
	public ParentEntityBuilderImpl name(String name) {
		parent.setName(name);
		return this;
	}

	@Override
	public ParentEntityBuilderImpl telephoneNumber(String telephoneNumber) {
		parent.setTelephoneNumber(telephoneNumber);
		return this;
	}

	@Override
	public ParentEntityBuilderImpl email(String email) {
		parent.setEmail(email);
		return this;
	}

	@Override
	public ParentEntityBuilderImpl child(Child child) {
		parent.setChild(child);
		return this;
	}

	@Override
	public ParentEntityBuilderImpl users(Users users) {
		parent.setUsers(users);
		return this;
	}

}
