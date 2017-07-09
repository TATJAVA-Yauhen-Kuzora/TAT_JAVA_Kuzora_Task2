package com.epam.library.dao.connection;

import com.epam.library.dao.interfaces.ConnectionDAO;

import java.sql.*;

/**
 * Class {@link ConnectionSQLDAO}.
 * <P>
 * Class ConnectionSQLDAO implements all methods from {@link ConnectionDAO}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.dao.connection}
 * package.</i>
 */
public class ConnectionSQLDAO implements ConnectionDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/library";
	private static final String USERNAME = "delavega";
	private static final String PASSWORD = "qwerty4356678";
	private static final ConnectionSQLDAO instance = new ConnectionSQLDAO();

	public static ConnectionSQLDAO getInstance() {
		return instance;
	}

	/**
	 * Implementation of takeConnection method.
	 */
	@Override
	public Connection takeConnection() throws ConnectionSQLException {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ConnectionSQLException(e.getMessage(), e);
		}
		return connection;
	}
}
