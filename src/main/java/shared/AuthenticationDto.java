package shared;

import java.io.Serializable;

public class AuthenticationDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String login;
	
	private String password;

	/* getter and setter */
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
