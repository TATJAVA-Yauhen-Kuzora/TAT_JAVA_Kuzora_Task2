package com.epam.library.dao.interfaces;

import java.sql.Connection;

import com.epam.library.dao.connection.ConnectionSQLException;

/**
 * Interface {@link ConnectionDAO}.
 * <P>
 * Interface ConnectionDAO includes 1 methods ({@link #takeConnection()}).
 * <p>
 * <i>This interface is a member of the {@link com.epam.library.dao.interfaces}
 * package.</i>
 */
public interface ConnectionDAO {
	/**
	 * Method takeConnection returns connection to data base.
	 * 
	 * @return object of Connection Class
	 * @throws ConnectionSQLException
	 *             Exception type for service layer
	 */
	Connection takeConnection() throws ConnectionSQLException;
}
