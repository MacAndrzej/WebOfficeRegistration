package info.office.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import info.office.entity.Child;
import info.office.entity.Visit;

public class VisitEntityBuilderImpl implements VisitEntityBuilder {

	private Visit visit;

	public VisitEntityBuilderImpl() {
		visit = new Visit();
	}

	@Override
	public Visit build() {
		return visit;
	}

	@Override
	public VisitEntityBuilderImpl id(Long id) {
		visit.setId(id);
		return this;
	}

	@Override
	public VisitEntityBuilderImpl dateOfVisitPlanned(LocalDate dateOfVisitPlanned) {
		visit.setDateOfVisitPlanned(dateOfVisitPlanned);
		return this;
	}

	@Override
	public VisitEntityBuilderImpl timeOfVisitPlanned(LocalTime timeOfVisitPlanned) {
		visit.setTimeOfVisitPlanned(timeOfVisitPlanned);
		return this;
	}

	@Override
	public VisitEntityBuilderImpl termOfVisitCancelled(boolean termOfVisitCancelled) {
		visit.setTermOfVisitCancelled(termOfVisitCancelled);
		return this;
	}

	@Override
	public VisitEntityBuilderImpl dateOfVisitChanged(Date dateOfVisitChanged) {
		visit.setDateOfVisitChanged(dateOfVisitChanged);
		return this;
	}

	@Override
	public VisitEntityBuilderImpl timeOfVisitChanged(Date timeOfVisitChanged) {
		visit.setTimeOfVisitChanged(timeOfVisitChanged);
		return this;
	}

	@Override
	public VisitEntityBuilderImpl termOfModification(LocalDate termOfModification) {
		visit.setTermOfModification(termOfModification);
		return this;
	}

	@Override
	public VisitEntityBuilderImpl absence(boolean absence) {
		visit.setAbsence(absence);
		return this;
	}

	@Override
	public VisitEntityBuilderImpl child(Child child) {
		visit.setChild(child);
		return this;
	}

}
