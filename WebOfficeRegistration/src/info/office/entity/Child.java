package info.office.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Id;


@Entity
@Table(name="child")
public class Child {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long Id;
	
	@NotNull
	@Size(min=3,message="is required")
	@Column(name="name")
	private String name;
	
	@NotNull
	@Size(min=3,message="is required")
	@Column(name="surname")
	private String surname;
	
	@NotNull
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Child() {
		
	}

	public Child(String name, String surname, Date dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Child [Id=" + Id + ", name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}
