package com.epam.library.bean;

import java.io.Serializable;

/**
 * Beans Class {@link User}.
 * <P>
 * Class User includes 7 fields ({@link #serialVersionUID}, {@link #userId},
 * {@link #name}, {@link #secondName}, {@link #secondName}, {@link #password},
 * {@link #accessLevel}), getters and setters for changeable fields, methods
 * {@link #hashCode()} and {@link #equals(Object)}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.bean} package.</i>
 */
public class User implements Serializable {
	/**
	 * SerialVersionUID for object of {@link User} Class.
	 */
	private static final long serialVersionUID = 4532962557083146008L;
	/**
	 * Contains user_id from library.user.user_id.
	 */
	private int userId;
	/**
	 * Contains name of user from library.user.name.
	 */
	private String name;
	/**
	 * Contains second name from library.user.second_name.
	 */
	private String secondName;
	/**
	 * Contains users login from library.user.login.
	 */
	private String login;
	/**
	 * Contains users password from library.user.password.
	 */
	private String password;
	/**
	 * Contains {@link AccessLevel} object as summary info about user access
	 * level from library.access_level.
	 */
	private AccessLevel accessLevel;

	/**
	 * Getter getUserId.
	 * 
	 * @return unique user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Setter setUserId.
	 * 
	 * @param userId
	 *            the unique user id to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Getter getName.
	 * 
	 * @return name of user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter setName.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter getSecondName.
	 * 
	 * @return secondName of user
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * Setter setSecondName.
	 * 
	 * @param secondName
	 *            the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * Getter getLogin.
	 * 
	 * @return login of user
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Setter setLogin.
	 * 
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Getter getPassword.
	 * 
	 * @return password of user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter setPassword.
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter getAccessLevel.
	 * 
	 * @return accessLevel as Object of {@link AccessLevel} Class
	 */
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	/**
	 * Setter setAccessLevel.
	 * 
	 * @param accessLevel
	 *            the accessLevel as Object of {@link AccessLevel} Class to set
	 */
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	/**
	 * Method toString.
	 * 
	 * @return summary info about user
	 */
	@Override
	public String toString() {
		String infoAboutUser = String.format("%-10s  %-10s  /  %-10s  /  %-10s", this.name, this.secondName, this.login,
				this.accessLevel.getName());
		return infoAboutUser;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return unique hashCode for {@link User} object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessLevel == null) ? 0 : accessLevel.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		result = prime * result + userId;
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            the reference object with which to compare
	 * @return boolean value as the result of comparing {@link User} objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accessLevel == null) {
			if (other.accessLevel != null)
				return false;
		} else if (!accessLevel.equals(other.accessLevel))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}
