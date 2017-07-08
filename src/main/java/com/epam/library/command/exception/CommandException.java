/**
 * 
 */
package com.epam.library.command.exception;

/**
 * @author Eugene13
 *
 */
public class CommandException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3013341579430727192L;

	public CommandException(String message) {
		super(message);
	}

	public CommandException(String message, Exception e) {
		super(message, e);
	}

	public CommandException(Exception e) {
		super(e);
	}
}
