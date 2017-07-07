/**
 * 
 */
package com.epam.library.dao.impl;

import java.sql.*;
import java.util.ArrayList;
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
	private final static String SIGN_UPDATE = "SELECT user_id, name, second_name, login, password, acc_level, access_level FROM user LEFT JOIN access_level ON user.acc_level = access_level.access_level_id WHERE user_id=?";
	private final static String REGISTER = "INSERT INTO user (`name`, `second_name`, `login`, `password`, `acc_level`) VALUES(?,?,?,?,2)";
	private final static String GET_ALL_USERS = "SELECT user_id, name, second_name, login, password, acc_level, access_level FROM user LEFT JOIN access_level ON user.acc_level = access_level.access_level_id";
	private final static String UPDATE_USER_INFO = "UPDATE user SET name = ?, second_name= ?, login= ? WHERE user_id= ?;";

	private final static String BAN_USER = "UPDATE user SET acc_level= 1 WHERE user_id= ?;";

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
			throw e;
		}
		return null;
	}

	@Override
	public ArrayList<User> getAllUsers() throws DAOException {
		Connection connection = null;
		PreparedStatement pSt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(GET_ALL_USERS);
			rs = pSt.executeQuery();
			User localUser;
			ArrayList<User> users = new ArrayList<>();
			while (rs.next()) {
				localUser = new User();
				localUser.setUserId(rs.getInt(USER_ID));
				localUser.setName(rs.getString(USER_NAME));
				localUser.setSecondName(rs.getString(USER_SECOND_NAME));
				localUser.setLogin(rs.getString(USER_LOGIN));
				localUser.setPassword(rs.getString(USER_PASSWORD));
				AccessLevel accessLevel = new AccessLevel();
				accessLevel.setAccessLevelId(rs.getInt(USER_ACCESS_LEVEL_ID));
				accessLevel.setName(rs.getString(USER_ACCESS_LEVEL_NAME));
				localUser.setAccessLevel(accessLevel);
				users.add(localUser);
			}
			return users;
		} catch (SQLException e) {
			throw new DAOException("Get list of users sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		}
	}

	@Override
	public User updateUserInfo(String name, String secondName, String login, int userId) throws DAOException {
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pSt = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(UPDATE_USER_INFO);
			pSt.setString(1, name);
			pSt.setString(2, secondName);
			pSt.setString(3, login);
			pSt.setInt(4, userId);
			int access = pSt.executeUpdate();
			if (access > 0) {
				pSt = connection.prepareStatement(SIGN_UPDATE);
				pSt.setInt(1, userId);
				rs = pSt.executeQuery();
				if (!rs.next()) {
					return null;
				}
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
			throw new DAOException("Update user sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		}
	}

	@Override
	public void banUser(int UserId) throws DAOException {
		Connection connection = null;
		PreparedStatement pSt = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(BAN_USER);
			pSt.setInt(1, UserId);
			int access = pSt.executeUpdate();
			if (access > 0) {
			}
		} catch (SQLException e) {
			throw new DAOException("Ban user sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		}
	}

	@Override
	public void promoteUser(int UserId) throws DAOException {
		// TODO Auto-generated method stub

	}
}
