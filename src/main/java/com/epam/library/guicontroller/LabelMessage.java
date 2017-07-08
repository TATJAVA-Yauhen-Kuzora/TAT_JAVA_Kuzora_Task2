/**
 * 
 */
package com.epam.library.guicontroller;

/**
 * @author Eugene13
 *
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

	public String getMessage() {
		return message;
	}
}
