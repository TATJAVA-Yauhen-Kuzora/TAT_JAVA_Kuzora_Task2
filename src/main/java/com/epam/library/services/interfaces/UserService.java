/**
 * 
 */
package com.epam.library.services.interfaces;

import java.util.ArrayList;

import com.epam.library.beans.User;
import com.epam.library.services.exception.ServiceException;

/**
 * @author Eugene13
 *
 */
public interface UserService {
	User singIn(String login, String password) throws ServiceException;

	User logout() throws ServiceException;

	User register(String name, String secondName, String login, String password) throws ServiceException;

	ArrayList<User> viewAllUsers() throws ServiceException;

	User updateUserInfo(String name, String secondName, String login, int userId) throws ServiceException;

	void banUser(int userId) throws ServiceException;

	void unBanUser(int userId) throws ServiceException;

	void giveAdminForUser(int userId) throws ServiceException;
}
