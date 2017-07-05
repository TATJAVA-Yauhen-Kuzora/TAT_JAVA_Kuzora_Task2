/**
 * 
 */
package com.epam.library.dao.impl;

import java.sql.*;
import java.util.List;

import com.epam.library.beans.AccessLevel;
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
	private final static String SIGN_IN = "SELECT user_id, name, second_name, login, password, acc_level, access_level FROM user LEFT JOIN access_level ON user.acc_level = access_level.access_level_id WHERE login=? and password=?";
	private final static String REGISTER = "INSERT INTO user (`name`, `second_name`, `login`, `password`, `acc_level`) VALUES(?,?,?,?,2)";

	private final static String USER_ID = "user_id";
	private final static String USER_NAME = "name";
	private final static String USER_SECOND_NAME = "second_name";
	private final static String USER_LOGIN = "login";
	private final static String USER_PASSWORD = "password";
	private final static String USER_ACCESS_LEVEL_ID = "acc_level";
	private final static String USER_ACCESS_LEVEL_NAME = "access_level";

	private static final UserDAO instance = new UserSQLDAO();

	private UserSQLDAO() {
	}

	public static UserDAO getInstance() {
		return instance;
	}

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
			AccessLevel accessLevel = new AccessLevel();
			accessLevel.setAccessLevelId(rs.getInt(USER_ACCESS_LEVEL_ID));
			accessLevel.setName(rs.getString(USER_ACCESS_LEVEL_NAME));
			user.setAccessLevel(accessLevel);
			return user;
		} catch (SQLException e) {
			throw new DAOException("Login sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		}
	}

	@Override
	public User register(String name, String secondName, String login, String password) throws DAOException {
		Connection connection = null;
		PreparedStatement pSt = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(REGISTER);
			pSt.setString(1, name);
			pSt.setString(2, secondName);
			pSt.setString(3, login);
			pSt.setString(4, password);
			int i = pSt.executeUpdate();
			if (i > 0) {
				return signIn(login, password);
			}
		} catch (SQLException e) {
			throw new DAOException("Register sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		} catch (DAOException e) {
			throw new DAOException(e);
		}
		return null;
	}
}
