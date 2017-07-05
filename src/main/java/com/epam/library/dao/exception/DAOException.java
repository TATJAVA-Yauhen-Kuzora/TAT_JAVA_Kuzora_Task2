/**
 * 
 */
package com.epam.library.dao.exception;

/**
 * @author Eugene13
 *
 */
public class DAOException extends Exception {
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
