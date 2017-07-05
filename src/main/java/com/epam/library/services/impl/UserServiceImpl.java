/**
 * 
 */
package com.epam.library.services.impl;

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
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public User logout() throws ServiceException {
		return null;
	}

	@Override
	public User register() throws ServiceException {
		// validator logina и пароля
		DAOFactory daoFactory = DAOFactory.getInstance();
		return null;
	}

}
