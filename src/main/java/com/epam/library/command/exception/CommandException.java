/**
 * 
 */
package com.epam.library.command.exception;

/**
 * @author Eugene13
 *
 */
public class CommandException extends Exception {
	public CommandException(String message) {
		super(message);
	}

	public CommandException(String message, Exception e) {
		super(message, e);
	}
}
