package info.office.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import info.office.entity.Child;

public class VisitDto {

	private Long id;
	private LocalDate dateOfVisitPlanned;
	private LocalTime timeOfVisitPlanned;
	private boolean termOfVisitCancelled;
	private Date dateOfVisitChanged;
	private Date timeOfVisitChanged;
	private LocalDate termOfModification;
	private boolean absence;
	private Child child;

	public VisitDto() {
	}

	public VisitDto(Long id, LocalDate dateOfVisitPlanned, LocalTime timeOfVisitPlanned, boolean termOfVisitCancelled,
			Date dateOfVisitChanged, Date timeOfVisitChanged, LocalDate termOfModification, boolean absence,
			Child child) {
		this.id = id;
		this.dateOfVisitPlanned = dateOfVisitPlanned;
		this.timeOfVisitPlanned = timeOfVisitPlanned;
		this.termOfVisitCancelled = termOfVisitCancelled;
		this.dateOfVisitChanged = dateOfVisitChanged;
		this.timeOfVisitChanged = timeOfVisitChanged;
		this.termOfModification = termOfModification;
		this.absence = absence;
		this.child = child;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOfVisitPlanned() {
		return dateOfVisitPlanned;
	}

	public void setDateOfVisitPlanned(LocalDate dateOfVisitPlanned) {
		this.dateOfVisitPlanned = dateOfVisitPlanned;
	}

	public LocalTime getTimeOfVisitPlanned() {
		return timeOfVisitPlanned;
	}

	public void setTimeOfVisitPlanned(LocalTime timeOfVisitPlanned) {
		this.timeOfVisitPlanned = timeOfVisitPlanned;
	}

	public boolean isTermOfVisitCancelled() {
		return termOfVisitCancelled;
	}

	public void setTermOfVisitCancelled(boolean termOfVisitCancelled) {
		this.termOfVisitCancelled = termOfVisitCancelled;
	}

	public Date getDateOfVisitChanged() {
		return dateOfVisitChanged;
	}

	public void setDateOfVisitChanged(Date dateOfVisitChanged) {
		this.dateOfVisitChanged = dateOfVisitChanged;
	}

	public Date getTimeOfVisitChanged() {
		return timeOfVisitChanged;
	}

	public void setTimeOfVisitChanged(Date timeOfVisitChanged) {
		this.timeOfVisitChanged = timeOfVisitChanged;
	}

	public LocalDate getTermOfModification() {
		return termOfModification;
	}

	public void setTermOfModification(LocalDate termOfModification) {
		this.termOfModification = termOfModification;
	}

	public boolean isAbsence() {
		return absence;
	}

	public void setAbsence(boolean absence) {
		this.absence = absence;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "VisitDto [id=" + id + ", dateOfVisitPlanned=" + dateOfVisitPlanned + ", timeOfVisitPlanned="
				+ timeOfVisitPlanned + ", termOfVisitCancelled=" + termOfVisitCancelled + ", dateOfVisitChanged="
				+ dateOfVisitChanged + ", timeOfVisitChanged=" + timeOfVisitChanged + ", termOfModification="
				+ termOfModification + ", absence=" + absence + ", child=" + child + "]";
	}

}
