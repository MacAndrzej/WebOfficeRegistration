package info.office.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@Entity
@Table(name = "parent")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull(message = "pole nie może być puste")
	@Size(min = 3, message = "podaj poprawne dane")
	@Column(name = "surname")
	private String surname;

	@Size(min = 3, message = "podaj poprawne dane")
	@NotNull(message = "pole nie może być puste")
	@Column(name = "name")
	private String name;

	@Pattern(regexp = "[0-9]{7}", message = "to nie jest poprawny numer telefonu")
	@NotNull(message = "pole nie może być puste")
	@Column(name = "telephone_number")
	private String telephoneNumber;

	@NotNull(message = "pole nie może być puste")
	@Size(min = 3, message = "podaj poprawne dane")
	@Email(message = "podaj poprawny adres email")
	@Column(name = "email")
	private String email;

	@OneToOne(mappedBy = "parent",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Child child;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "users_username")
	private Users users;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Parent() {

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

	public Parent(Long id, String surname, String name, String telephoneNumber, String email, Child child) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.child = child;
	}

	public Parent(String surname, String name, String telephoneNumber, String email, Child child) {
		this(null, surname, name, telephoneNumber, email, child);
	}
	
	

	public Parent(String surname, String name, String telephoneNumber, String email) {
		this.surname = surname;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", surname=" + surname + ", name=" + name + ", telephoneNumber=" + telephoneNumber
				+ ", email=" + email + ", child=" + child + "]";
	}

	// public void addChild(Child tempChild) {
	// if (tempChild == null) {
	// children = new ArrayList<>();
	// }
	// children.add(tempChild);
	//
	// tempChild.setParent(this);
	// }

}
