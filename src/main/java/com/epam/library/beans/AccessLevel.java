/**
 * 
 */
package com.epam.library.beans;

/**
 * @author Eugene13
 *
 */
public class AccessLevel {
	private int accessLevelId;
	private String accessLevel;

	public int getAccessLevelId() {
		return accessLevelId;
	}

	public void setAccessLevelId(int accessLevelId) {
		this.accessLevelId = accessLevelId;
	}

	public String getName() {
		return accessLevel;
	}

	public void setName(String name) {
		this.accessLevel = name;
	}
}
