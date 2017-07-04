package com.epam.library.dao.connection;

import com.epam.library.dao.interfaces.ConnectionDAO;

import java.sql.*;

public class ConnectionSQLDAO implements ConnectionDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/library";
	private static final String USERNAME = "delavega";
	private static final String PASSWORD = "qwerty4356678";
	private static final ConnectionSQLDAO instance = new ConnectionSQLDAO();

	public static ConnectionSQLDAO getInstance() {
		return instance;
	}

	@Override
	public Connection takeConnection() throws ConnectionSQLException {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ConnectionSQLException(e);
		}
		return connection;
	}
}
