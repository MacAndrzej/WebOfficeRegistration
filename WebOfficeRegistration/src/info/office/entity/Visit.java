package info.office.entity;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@NotNull
	@Column(name="surname")
	private String surname;
	
	@NotNull
	@Column(name="name")
	private String name;

	@Column(name="term_of_visit_planned")
	private Date termOfVisitPlanned;

	@Column(name="term_of_visit_cancelled")
	private Date termOfVisitCancelled;

	@Column(name="term_of_visit_changed")
	private Date termOfVisitChanged;

	@NotNull
	@Column(name="absence")
	private boolean absence;
	
	public Visit() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTermOfVisitPlanned() {
		return termOfVisitPlanned;
	}

	public void setTermOfVisitPlanned(Date termOfVisitPlanned) {
		this.termOfVisitPlanned = termOfVisitPlanned;
	}

	public Date getTermOfVisitCancelled() {
		return termOfVisitCancelled;
	}

	public void setTermOfVisitCancelled(Date termOfVisitCancelled) {
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

	public Visit(String surname, String name, Date termOfVisitPlanned, Date termOfVisitCancelled,
			Date termOfVisitChanged, boolean absence) {
		this.surname = surname;
		this.name = name;
		this.termOfVisitPlanned = termOfVisitPlanned;
		this.termOfVisitCancelled = termOfVisitCancelled;
		this.termOfVisitChanged = termOfVisitChanged;
		this.absence = absence;
	}

	@Override
	public String toString() {
		return "Visit [Id=" + Id + ", surname=" + surname + ", name=" + name + ", termOfVisitPlanned="
				+ termOfVisitPlanned + ", termOfVisitCancelled=" + termOfVisitCancelled + ", termOfVisitChanged="
				+ termOfVisitChanged + ", absence=" + absence + "]";
	}
}
