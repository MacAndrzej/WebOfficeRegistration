package info.office.dto;

import info.office.entity.Child;
import info.office.entity.Users;

public class ParentDto {
	
	private Long id;
	private String surname;
	private String name;
	private String telephoneNumber;
	private String email;
	private Child child;
	private Users users;
	
	public ParentDto(Long id, String surname, String name, String telephoneNumber, String email, Child child,
			Users users) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.child = child;
		this.users = users;
	}

	public ParentDto() {
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

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "ParentDto [id=" + id + ", surname=" + surname + ", name=" + name + ", telephoneNumber="
				+ telephoneNumber + ", email=" + email + ", child=" + child + ", users=" + users + "]";
	}
	
	
	
	

}
