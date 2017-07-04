/**
 * 
 */
package com.epam.library.services.exception;

/**
 * @author Eugene13
 *
 */
public class ServiceException extends Exception {
	public ServiceException(String message, Exception e) {
		super(message, e);
	}

	public ServiceException(String message) {
		super(message);
	}
}
