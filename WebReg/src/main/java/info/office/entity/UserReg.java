package info.office.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class UserReg {

	@NotNull(message="pole wymagane")
	@Size(min=1, message="proszę podać minimum 3 znaki")
	private String userName;

	@NotNull(message="pole wymagane")
	@Size(min=3, message="proszę podać minimum 3 znaki")
	private String password;

//	@Value("${enabled:#{true}")
	private Boolean enabled;

	public UserReg() {
	}

	public UserReg(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + ", enabled=" + enabled + "]";
	};

}














