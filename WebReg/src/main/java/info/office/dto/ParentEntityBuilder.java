package info.office.dto;

import info.office.entity.Child;
import info.office.entity.Parent;
import info.office.entity.Users;

public interface ParentEntityBuilder {

	Parent build();
	
	ParentEntityBuilderImpl id(final Long id);
	ParentEntityBuilderImpl surname(final String surname);
	ParentEntityBuilderImpl name(final String name);
	ParentEntityBuilderImpl telephoneNumber(final String telephoneNumber);
	ParentEntityBuilderImpl email(final String email);
	ParentEntityBuilderImpl child(final Child child);
	ParentEntityBuilderImpl users(final Users users);
}
