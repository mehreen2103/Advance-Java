package in.com.rays.jdbc.preparedStatement;

import java.util.Date;

public class UserBean {

	private int id;
	private String firstName;
	private String LastName;
	private String login; 
	private String password;
	
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
