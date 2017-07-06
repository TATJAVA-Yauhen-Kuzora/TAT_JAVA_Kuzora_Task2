/**
 * 
 */
package com.epam.library.dao;

import com.epam.library.dao.impl.BookSQLDAO;
import com.epam.library.dao.impl.UserSQLDAO;
import com.epam.library.dao.interfaces.BookDAO;
import com.epam.library.dao.interfaces.UserDAO;

/**
 * @author Eugene13
 *
 */
public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final UserDAO sqlUserImpl = UserSQLDAO.getInstance();
	private final BookDAO sqlBookImpl = BookSQLDAO.getInstance();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return sqlUserImpl;
	}

	public BookDAO getBookDAO() {
		return sqlBookImpl;
	}
}
