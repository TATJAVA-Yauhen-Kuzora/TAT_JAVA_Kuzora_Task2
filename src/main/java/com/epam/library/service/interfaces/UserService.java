package com.epam.library.service.interfaces;

import java.util.ArrayList;
import com.epam.library.bean.User;
import com.epam.library.service.exception.ServiceException;

/**
 * Interface {@link UserService}.
 * <P>
 * Interface UserService includes 8 methods ({@link #singIn(String, String)},
 * {@link #logout()}, {@link #register(String, String, String, String)},
 * {@link #viewAllUsers()},
 * {@link #updateUserInfo(String, String, String, int)}, {@link #banUser(int)},
 * {@link #unBanUser(int)}, {@link #giveAdminForUser(int)}.
 * <p>
 * <i>This interface is a member of the
 * {@link com.epam.library.service.interfaces} package.</i>
 */
public interface UserService {
	/**
	 * Method singIn returns user if login and password exist in data base.
	 * 
	 * @param login
	 *            login of user
	 * @param password
	 *            password of user
	 * @return object of User Class
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	User singIn(String login, String password) throws ServiceException;

	/**
	 * Method logout returns null.
	 * 
	 * @return null
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	User logout() throws ServiceException;

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
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	User register(String name, String secondName, String login, String password) throws ServiceException;

	/**
	 * Method viewAllUsers returns list of all users.
	 * 
	 * @return object of ArrayList<{@link User}> type.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	ArrayList<User> viewAllUsers() throws ServiceException;

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
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	User updateUserInfo(String name, String secondName, String login, int userId, String password)
			throws ServiceException;

	/**
	 * Method banUser bans user using user id.
	 * 
	 * @param userId
	 *            unique user id
	 * @return boolean value as result of executing
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	boolean banUser(int userId) throws ServiceException;

	/**
	 * Method unBanUser unbans user using user id.
	 * 
	 * @param userId
	 *            unique user id
	 * @return boolean value as result of executing
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	boolean unBanUser(int userId) throws ServiceException;

	/**
	 * Method giveAdminForUser gives user admin level using user id.
	 * 
	 * @param userId
	 *            unique user id
	 * @return boolean value as result of executing
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	boolean giveAdminForUser(int userId) throws ServiceException;
}
