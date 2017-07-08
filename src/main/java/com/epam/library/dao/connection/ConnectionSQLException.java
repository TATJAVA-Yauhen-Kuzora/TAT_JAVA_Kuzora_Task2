/**
 * 
 */
package com.epam.library.dao.connection;

/**
 * @author Eugene13
 *
 */
public class ConnectionSQLException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8769023482145883475L;

	public ConnectionSQLException(Exception exception) {
		super(exception);
	}
}
