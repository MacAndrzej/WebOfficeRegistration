package info.office.dto;

import java.time.LocalDate;
import java.util.List;

import info.office.entity.Child;
import info.office.entity.Parent;
import info.office.entity.Visit;

public class ChildEntityBuilderImpl implements ChildEntityBuilder {
	
	private Child child;
	
	public ChildEntityBuilderImpl() {
		child = new Child();
	}

	@Override
	public Child build() {
		return child;
	}

	@Override
	public ChildEntityBuilderImpl id(Long id) {
		child.setId(id);
		return this;
	}

	@Override
	public ChildEntityBuilderImpl surname(String surname) {
		child.setSurname(surname);
		return this;
	}

	@Override
	public ChildEntityBuilderImpl name(String name) {
		child.setName(name);
		return this;
	}

	@Override
	public ChildEntityBuilderImpl dateOfBirth(LocalDate dateOfBirth) {
		child.setDateOfBirth(dateOfBirth);
		return this;
	}

	@Override
	public ChildEntityBuilderImpl parent(Parent parent) {
		child.setParent(parent);
		return this;
	}

	@Override
	public ChildEntityBuilderImpl visit(List<Visit> visit) {
		child.setVisit(visit);
		return this;
	}

}
