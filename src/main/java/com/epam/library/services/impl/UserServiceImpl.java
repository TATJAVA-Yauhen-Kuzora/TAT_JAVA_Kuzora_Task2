/**
 * 
 */
package com.epam.library.services.impl;

import java.util.List;

import com.epam.library.beans.User;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.UserDAO;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.UserService;

/**
 * @author Eugene13
 *
 */
public class UserServiceImpl implements UserService {
	@Override
	public User singIn(String login, String password) throws ServiceException {
		// validator
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAO();
		User user = null;
		try {
			user = dao.signIn(login, password);
			if (user == null) {
				throw new ServiceException("Wrong login or password.");
			}
			if (user.getAccessLevel().getAccessLevelId() == 1) {
				throw new ServiceException("Accaunt has been banned.");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return user;
	}

	@Override
	public User logout() throws ServiceException {
		return null;
	}

	@Override
	public User register(String name, String secondName, String login, String password) throws ServiceException {
		// validator logina и пароля
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAO();
		User user = null;
		try {
			user = dao.register(name, secondName, login, password);

			if (user == null) {
				throw new ServiceException("Registration has not done well.");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return user;
	}

	@Override
	public User updateUserInfo(String name, String secondName, String login, int userId) throws ServiceException {
		// validator logina и пароля
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAO();
		User user = null;
		try {
			user = dao.updateUserInfo(name, secondName, login, userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return user;
	}
}
