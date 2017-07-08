/**
 * 
 */
package com.epam.library.dao.exception;

/**
 * @author Eugene13
 *
 */
public class DAOException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8398923831597328506L;

	public DAOException(String message, Exception e) {
		super(message, e);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}
}
