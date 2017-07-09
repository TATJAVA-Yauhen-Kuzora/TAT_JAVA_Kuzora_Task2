package com.epam.library.dao.connection;

/**
 * Class {@link ConnectionSQLException}.
 * <P>
 * Class ConnectionSQLException - user exception class for
 * {@link com.epam.library.dao.connection.ConnectionSQLDAO} Class.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.dao.connection}
 * package.</i>
 */
public class ConnectionSQLException extends Exception {
	/**
	 * SerialVersionUID for object of {@link ConnectionSQLException} Class.
	 */
	private static final long serialVersionUID = 8769023482145883475L;

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 * @param message
	 *            as info for creating user exception
	 */
	public ConnectionSQLException(String message, Exception exception) {
		super(message, exception);
	}
}
