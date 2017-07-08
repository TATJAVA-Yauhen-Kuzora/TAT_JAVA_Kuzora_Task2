/**
 * 
 */
package com.epam.library.services.exception;

/**
 * @author Eugene13
 *
 */
public class ServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1499677754326455467L;

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}
}
