/**
 * 
 */
package com.epam.library.dao.connection;

/**
 * @author Eugene13
 *
 */
public class ConnectionSQLException extends Exception {
	public ConnectionSQLException(Exception exception) {
		super(exception);
	}
}
