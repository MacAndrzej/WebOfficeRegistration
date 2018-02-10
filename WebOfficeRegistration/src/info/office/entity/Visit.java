package info.office.entity;

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

@Entity
@Table
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "term_of_visit_planned")
	private Date termOfVisitPlanned;

	@Column(name = "term_of_visit_cancelled")
	private boolean termOfVisitCancelled;

	@Column(name = "term_of_visit_changed")
	private Date termOfVisitChanged;

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

	public Date getTermOfVisitPlanned() {
		return termOfVisitPlanned;
	}

	public void setTermOfVisitPlanned(Date termOfVisitPlanned) {
		this.termOfVisitPlanned = termOfVisitPlanned;
	}

	public boolean isTermOfVisitCancelled() {
		return termOfVisitCancelled;
	}

	public void setTermOfVisitCancelled(boolean termOfVisitCancelled) {
		this.termOfVisitCancelled = termOfVisitCancelled;
	}

	public Date getTermOfVisitChanged() {
		return termOfVisitChanged;
	}

	public void setTermOfVisitChanged(Date termOfVisitChanged) {
		this.termOfVisitChanged = termOfVisitChanged;
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

	public Visit(Date termOfVisitPlanned, boolean termOfVisitCancelled, Date termOfVisitChanged, boolean absence) {
		this.termOfVisitPlanned = termOfVisitPlanned;
		this.termOfVisitCancelled = termOfVisitCancelled;
		this.termOfVisitChanged = termOfVisitChanged;
		this.absence = absence;
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", termOfVisitPlanned=" + termOfVisitPlanned + ", termOfVisitCancelled="
				+ termOfVisitCancelled + ", termOfVisitChanged=" + termOfVisitChanged + ", absence=" + absence
				+ ", child=" + child + "]";
	}

	
}
