package info.office.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "date_of_visit_planned")
	private LocalDate dateOfVisitPlanned;
	
	@Column(name = "time_of_visit_planned")
	private LocalTime timeOfVisitPlanned;

	@Column(name = "term_of_visit_cancelled")
	private boolean termOfVisitCancelled;

	@Column(name = "date_of_visit_changed")
	private Date dateOfVisitChanged;
	
	@Column(name = "time_of_visit_changed")
	private Date timeOfVisitChanged;
	
	@Column(name="term_of_modification")
	private Date termOfModification;

	@NotNull
	@Column(name = "absence")
	private boolean absence;

	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name="child_id")
	private Child child;

	public Visit() {

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

	public Date getTermOfModification() {
		return termOfModification;
	}

	public void setTermOfModification(Date termOfModification) {
		this.termOfModification = termOfModification;
	}


	public Visit(LocalDate dateOfVisitPlanned, LocalTime timeOfVisitPlanned, boolean termOfVisitCancelled,
			Date dateOfVisitChanged, Date timeOfVisitChanged, Date termOfModification, @NotNull boolean absence,
			Child child) {
		this.dateOfVisitPlanned = dateOfVisitPlanned;
		this.timeOfVisitPlanned = timeOfVisitPlanned;
		this.termOfVisitCancelled = termOfVisitCancelled;
		this.dateOfVisitChanged = dateOfVisitChanged;
		this.timeOfVisitChanged = timeOfVisitChanged;
		this.termOfModification = termOfModification;
		this.absence = absence;
		this.child = child;
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", dateOfVisitPlanned=" + dateOfVisitPlanned + ", timeOfVisitPlanned="
				+ timeOfVisitPlanned + ", termOfVisitCancelled=" + termOfVisitCancelled + ", dateOfVisitChanged="
				+ dateOfVisitChanged + ", timeOfVisitChanged=" + timeOfVisitChanged + ", termOfModification="
				+ termOfModification + ", absence=" + absence + ", child=" + child + "]";
	}
	
}
