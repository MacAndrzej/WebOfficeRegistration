package info.office.entity;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "parent")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(min = 3, message = "is required")
	@Column(name = "surname")
	private String surname;

	@NotNull
	@Size(min = 3, message = "is required")
	@Column(name = "name")
	private String name;

	
	// @Pattern(regexp = "[0-9]{7}", message = "to nie jest poprawny numer
	// telefonu")
	@NotNull(message = "proszę podać numer telefonu")
	@Column(name = "telephone_number")
	private String telephoneNumber;

	@Pattern(regexp = "([a-z0-9A-Z]+\\.)*([a-z0-9A-Z]+)@{1}([a-z0-9A-Z]+\\.)+([a-z0-9A-Z]+)\\.*", message = "to nie jest poprawny format adresu email")
	@Column(name = "email")
	private String email;

	// @NotNull()
	// @Column(name="alert")
	// private boolean alert;
	//
	// public boolean isAlert() {
	// return alert;
	// }
	//
	// public void setAlert(boolean alert) {
	// this.alert = alert;
	// }

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

	public Parent(String surname, String name, String telephoneNumber, String email, boolean alert) {
		this.surname = surname;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Parent [Id=" + id + ", surname=" + surname + ", name=" + name + ", telephoneNumber=" + telephoneNumber
				+ ", email=" + email + "]";
	}

}
