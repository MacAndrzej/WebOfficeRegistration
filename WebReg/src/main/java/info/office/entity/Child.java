package info.office.entity;

import java.time.LocalDate;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = "child")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull(message = "pole nie może być puste")
	@Size(min = 3, message = "podaj poprawne dane")
	@Column(name = "surname")
	private String surname;

	@NotNull(message = "pole nie może być puste")
	@Size(min = 3, message = "podaj poprawne dane")
	@Column(name = "name")
	private String name;

	@Past
	@NotNull(message = "pole nie może być puste")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	private Parent parent;

	@OneToMany(mappedBy="child",cascade = CascadeType.ALL)
	private List<Visit> visit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public Child() {

	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", surname=" + surname + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", parent=" + parent + ", visit=" + visit + "]";
	}

	public Child(Long id, String surname, String name, LocalDate dateOfBirth) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
}
