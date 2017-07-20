package com.epam.library.service.impl;

import static com.epam.library.service.validator.Validator.*;
import java.util.ArrayList;
import com.epam.library.bean.User;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.UserDAO;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.UserService;

/**
 * Class {@link UserServiceImpl}.
 * <P>
 * Class UserServiceImpl implements all methods from {@link UserService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.service.impl}
 * package.</i>
 */
public class UserServiceImpl implements UserService {
	/**
	 * Implementation of singIn method.
	 */
	@Override
	public User singIn(String login, String password) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAOImpl();
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

	/**
	 * Implementation of logout method.
	 */
	@Override
	public User logout() throws ServiceException {
		return null;
	}

	/**
	 * Implementation of register method.
	 */
	@Override
	public User register(String name, String secondName, String login, String password) throws ServiceException {
		validateUserInfo(name, secondName, login, password);
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAOImpl();
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

	/**
	 * Implementation of updateUserInfo method.
	 */
	@Override
	public User updateUserInfo(String name, String secondName, String login, int userId, String password)
			throws ServiceException {
		validateUserInfo(userId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAOImpl();
		User user = null;
		try {
			user = dao.updateUserInfo(name, secondName, login, userId, password);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return user;
	}

	/**
	 * Implementation of viewAllUsers method.
	 */
	@Override
	public ArrayList<User> viewAllUsers() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAOImpl();
		ArrayList<User> users = new ArrayList<>();
		try {
			users = dao.getAllUsers();
			return users;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of banUser method.
	 * 
	 * @return
	 */
	@Override
	public boolean banUser(int userId) throws ServiceException {
		validateUserInfo(userId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAOImpl();
		try {
			return dao.banUser(userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of unBanUser method.
	 * 
	 * @return
	 */
	@Override
	public boolean unBanUser(int userId) throws ServiceException {
		validateUserInfo(userId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAOImpl();
		try {
			return dao.unBanUser(userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of giveAdminForUser method.
	 * 
	 * @return
	 */
	@Override
	public boolean giveAdminForUser(int userId) throws ServiceException {
		validateUserInfo(userId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO dao = daoFactory.getUserDAOImpl();
		try {
			return dao.giveAdminForUser(userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
