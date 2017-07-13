package com.epam.library.guicontroller;

/**
 * Enum {@link LabelMessage }.
 * <P>
 * Enum LabelMessage  includes 8 members for different labels in {@link GuiController} Class.
 * <P>
 * <i>This Enum is a member of the
 * {@link com.epam.library.guicontroller} package.</i>
 */
public enum LabelMessage {
	LOGIN("Login"), 
	LOGOUT("Logout"), 
	BLANK(""), 
	ADMIN_CONTROL_PANEL("Admin users control panel"),
	SUPERADMIN_CONTROL_PANEL("SuperAdmin users control panel"),
	USER("User"),
	PASSWORD_ETT("Pay attention to passwords."),
	Changes_HAVE_SAVED("Changes have saved."),
	;
	private String message;

	LabelMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Getter getMessage.
	 * 
	 * @return message of enum member
	 */
	public String getMessage() {
		return message;
	}
}
