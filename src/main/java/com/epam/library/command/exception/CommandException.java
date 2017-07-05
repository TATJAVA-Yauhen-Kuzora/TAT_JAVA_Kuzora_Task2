/**
 * 
 */
package com.epam.library.command.exception;

import com.epam.library.services.exception.ServiceException;

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

	public CommandException(Exception e) {
		super(e);
	}
}
