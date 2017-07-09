package com.epam.library.dao.interfaces;

import java.util.ArrayList;
import com.epam.library.bean.User;
import com.epam.library.dao.exception.DAOException;

/**
 * Interface {@link UserDAO}.
 * <P>
 * Interface UserDAO includes 7 methods ({@link #signIn(String, String)},
 * {@link #register(String, String, String, String)}, {@link #getAllUsers()},
 * {@link #updateUserInfo(String, String, String, int)}, {@link #banUser(int)},
 * {@link #unBanUser(int)}, {@link #giveAdminForUser(int)}).
 * <p>
 * <i>This interface is a member of the {@link com.epam.library.dao.interfaces}
 * package.</i>
 */
public interface UserDAO {
	/**
	 * Method singIn returns user if login and password exist in data base.
	 * 
	 * @param login
	 *            login of user
	 * @param password
	 *            password of user
	 * @return object of User Class
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	User signIn(String login, String password) throws DAOException;

	/**
	 * Method register returns user as User object if registration has been made
	 * successfully.
	 * 
	 * @param name
	 *            name of user
	 * @param secondName
	 *            second name of user
	 * @param login
	 *            login of user
	 * @param password
	 *            password of user
	 * @return object of User Class
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	User register(String name, String secondName, String login, String password) throws DAOException;

	/**
	 * Method getAllUsers returns list of all users from db.
	 * 
	 * @return object of ArrayList<{@link User}> type.
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	ArrayList<User> getAllUsers() throws DAOException;

	/**
	 * Method updateUserInfo returns user as User object if registration has
	 * been made successfully.
	 * 
	 * @param name
	 *            name of user
	 * @param secondName
	 *            second name of user
	 * @param login
	 *            login of user
	 * @param userId
	 *            unique user id
	 * @return object of User Class
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	User updateUserInfo(String name, String secondName, String login, int userId) throws DAOException;

	/**
	 * Method banUser bans user using user id.
	 * 
	 * @param userId
	 *            unique user id
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	void banUser(int userId) throws DAOException;

	/**
	 * Method unBanUser unbans user using user id.
	 * 
	 * @param userId
	 *            unique user id
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	void unBanUser(int userId) throws DAOException;

	/**
	 * Method giveAdminForUser gives user admin level using user id.
	 * 
	 * @param userId
	 *            unique user id
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	void giveAdminForUser(int userId) throws DAOException;
}
