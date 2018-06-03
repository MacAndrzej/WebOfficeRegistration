package info.office.dto;

import java.time.LocalDate;
import java.util.List;

import info.office.entity.Parent;
import info.office.entity.Visit;

/**
 * 
 * @author Andrzej
 *
 */
public class ChildDto {

	private Long id;
	private String surname;
	private String name;
	private LocalDate dateOfBirth;
	private Parent parent;
	private List<Visit> visit;

	public ChildDto(Long id, String surname, String name, LocalDate dateOfBirth, Parent parent, List<Visit> visit) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.parent = parent;
		this.visit = visit;
	}

	public ChildDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public List<Visit> getVisit() {
		return visit;
	}

	public void setVisit(List<Visit> visit) {
		this.visit = visit;
	}

	@Override
	public String toString() {
		return "ChildDto [id=" + id + ", surname=" + surname + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", parent=" + parent + ", visit=" + visit + "]";
	}

}
