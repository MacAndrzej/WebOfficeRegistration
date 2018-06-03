package info.office.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import info.office.entity.Child;
import info.office.entity.Visit;

public interface VisitEntityBuilder {
	
	Visit build();
	
	VisitEntityBuilderImpl id(final Long id);
	VisitEntityBuilderImpl dateOfVisitPlanned(final LocalDate dateOfVisitPlanned);
	VisitEntityBuilderImpl timeOfVisitPlanned(final LocalTime timeOfVisitPlanned);
	VisitEntityBuilderImpl termOfVisitCancelled(final boolean termOfVisitCancelled);
	VisitEntityBuilderImpl dateOfVisitChanged(final Date dateOfVisitChanged);
	VisitEntityBuilderImpl timeOfVisitChanged(final Date timeOfVisitChanged);
	VisitEntityBuilderImpl termOfModification(final LocalDate termOfModification);
	VisitEntityBuilderImpl absence(final boolean absence);
	VisitEntityBuilderImpl child(final Child child);
}
