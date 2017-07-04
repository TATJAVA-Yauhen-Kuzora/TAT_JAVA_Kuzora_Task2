/**
 * 
 */
package com.epam.library.dao.impl;

import java.sql.*;

import com.epam.library.beans.User;
import com.epam.library.dao.connection.ConnectionSQLDAO;
import com.epam.library.dao.connection.ConnectionSQLException;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.UserDAO;

/**
 * @author Eugene13
 *
 */
public class UserSQLDAO implements UserDAO {
	private final static String SIGN_IN = "SELECT * FROM user WHERE login=? and password=?";
	private final static String USER_ID = "user_id";
	private final static String USER_NAME = "name";
	private final static String USER_SECOND_NAME = "second_name";
	private final static String USER_LOGIN = "login";
	private final static String USER_PASSWORD = "password";
	private final static String USER_ACCESS_LEVEL = "acc_level";

	@Override
	public User signIn(String login, String password) throws DAOException {
		Connection connection = null;
		PreparedStatement pSt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(SIGN_IN);
			pSt.setString(1, login);
			pSt.setString(2, password);
			rs = pSt.executeQuery();
			if (!rs.next()) {
				return null;
			}
			User user = new User();
			user.setUserId(rs.getInt(USER_ID));
			user.setName(rs.getString(USER_NAME));
			user.setSecondName(rs.getString(USER_SECOND_NAME));
			user.setLogin(rs.getString(USER_LOGIN));
			user.setPassword(rs.getString(USER_PASSWORD));
			user.setAccessLevel(rs.getInt(USER_ACCESS_LEVEL));
			return user;
		} catch (SQLException e) {
			throw new DAOException("Wrong login to database", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Snthg wrong with connection", e);
		}
	}

	@Override
	public User register(User user) {
		return null;
	}

}
