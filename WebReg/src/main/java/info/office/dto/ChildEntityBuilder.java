package info.office.dto;

import java.time.LocalDate;
import java.util.List;

import info.office.entity.Child;
import info.office.entity.Parent;
import info.office.entity.Visit;

public interface ChildEntityBuilder {
	
	Child build();
	
	ChildEntityBuilderImpl id(final Long id);
	ChildEntityBuilderImpl surname(final String id);
	ChildEntityBuilderImpl name(final String name);
	ChildEntityBuilderImpl dateOfBirth(final LocalDate dateOfBirth);
	ChildEntityBuilderImpl parent(final Parent parent);
	ChildEntityBuilderImpl visit(final List<Visit> visit);
}
