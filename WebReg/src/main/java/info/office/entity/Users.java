package info.office.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class Users {
	

	@NotNull(message="pole wymagane")
	@Size(min=1, message="proszę podać minimum 3 znaki")
	@Column(name="username")
	@Id
	private String username;

	@NotNull(message="pole wymagane")
	@Size(min=3, message="proszę podać minimum 3 znaki")
	@Column(name="password")
	private String password;

	@Column(name="enabled")
	private Integer enabled;
	
	@OneToOne(mappedBy="users")
	private Parent parent;
	

	public Users() {
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Users [userName=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	};

}














