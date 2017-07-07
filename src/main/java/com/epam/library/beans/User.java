/**
 * 
 */
package com.epam.library.beans;

/**
 * @author Eugene13
 *
 */
public class User {
	private int userId;
	private String name;
	private String secondName;
	private String login;
	private String password;
	private AccessLevel accessLevel;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

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

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		String infoAboutUser = String.format("%-10s  %-10s  /  %-10s  /  %-10s", this.name, this.secondName, this.login,
				this.accessLevel.getName());
		return infoAboutUser;
	}
}
