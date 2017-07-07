package com.epam.library.beans;

/**
 * Beans Class {@link AccessLevel}.
 * <P>
 * Class AccessLevel includes 2 fields (accessLevelId, accessLevel).
 * <P>
 * <i>This class is a member of the {@link com.epam.library.beans} package.</i>
 */
public class AccessLevel {
	/**
	 * Contains access_level_id from library.access_level table.
	 */
	private int accessLevelId;
	/**
	 * Contains access_level from library.access_level table. Description for
	 * access_level.
	 */
	private String accessLevel;

	/**
	 * Getter getAccessLevelId.
	 * 
	 * @return accessLevelId
	 */
	public int getAccessLevelId() {
		return accessLevelId;
	}

	/**
	 * Setter setAccessLevelId.
	 * 
	 * @param accessLevelId
	 *            the accessLevelIds to set
	 */
	public void setAccessLevelId(int accessLevelId) {
		this.accessLevelId = accessLevelId;
	}

	/**
	 * Getter getName.
	 * 
	 * @return accessLevel
	 */
	public String getName() {
		return accessLevel;
	}

	/**
	 * Setter setName.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.accessLevel = name;
	}
}
