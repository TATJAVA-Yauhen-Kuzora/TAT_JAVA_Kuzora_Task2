/**
 * 
 */
package com.epam.library.dao;

import com.epam.library.dao.impl.UserSQLDAO;
import com.epam.library.dao.interfaces.UserDAO;

/**
 * @author Eugene13
 *
 */
public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final UserDAO sqlUserImpl = UserSQLDAO.getInstance();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return sqlUserImpl;
	}
}
