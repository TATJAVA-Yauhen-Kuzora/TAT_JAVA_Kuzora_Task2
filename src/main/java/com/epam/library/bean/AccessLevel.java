package com.epam.library.bean;

import java.io.Serializable;

/**
 * Beans Class {@link AccessLevel}.
 * <P>
 * Class AccessLevel includes 3 fields ({@link #serialVersionUID},
 * {@link #accessLevelId}, {@link #accessLevel}), getters and setters for
 * changeable fields, methods {@link #hashCode()} and {@link #equals(Object)}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.bean} package.</i>
 */
public class AccessLevel implements Serializable {
	/**
	 * SerialVersionUID for object of {@link AccessLevel} Class.
	 */
	private static final long serialVersionUID = -4780450351352602729L;
	/**
	 * Contains unique access_level_id from
	 * library.access_level.access_level_id.
	 */
	private int accessLevelId;
	/**
	 * Contains description of access_level from
	 * library.access_level.accessLevel.
	 */
	private String accessLevel;

	/**
	 * Getter getAccessLevelId.
	 * 
	 * @return unique access level id
	 */
	public int getAccessLevelId() {
		return accessLevelId;
	}

	/**
	 * Setter setAccessLevelId.
	 * 
	 * @param accessLevelId
	 *            the unique access level id to set
	 */
	public void setAccessLevelId(int accessLevelId) {
		this.accessLevelId = accessLevelId;
	}

	/**
	 * Getter getName.
	 * 
	 * @return access level description
	 */
	public String getName() {
		return accessLevel;
	}

	/**
	 * Setter setName.
	 * 
	 * @param name
	 *            the access level description to set
	 */
	public void setName(String name) {
		this.accessLevel = name;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return unique hashCode for {@link AccessLevel} object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessLevel == null) ? 0 : accessLevel.hashCode());
		result = prime * result + accessLevelId;
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            the reference object with which to compare
	 * @return boolean value as the result of comparing {@link AccessLevel}
	 *         objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccessLevel other = (AccessLevel) obj;
		if (accessLevel == null) {
			if (other.accessLevel != null)
				return false;
		} else if (!accessLevel.equals(other.accessLevel))
			return false;
		if (accessLevelId != other.accessLevelId)
			return false;
		return true;
	}
}
