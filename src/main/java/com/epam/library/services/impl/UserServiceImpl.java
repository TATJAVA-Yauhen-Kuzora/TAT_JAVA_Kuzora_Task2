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
			System.out.println(login);
			System.out.println(password);
			user = dao.signIn(login, password);
			if (user == null) {
				throw new ServiceException("Wrong login or password.");
			}
			if (user.getAccessLevel() == 1) {
				// эксепшн на запрет доступа к
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return user;
	}

}
