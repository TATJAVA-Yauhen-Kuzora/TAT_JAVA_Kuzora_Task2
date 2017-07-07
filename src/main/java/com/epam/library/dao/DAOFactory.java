/**
 * 
 */
package com.epam.library.dao;

import com.epam.library.dao.impl.BookSQLDAO;
import com.epam.library.dao.impl.OrdersSQLDAO;
import com.epam.library.dao.impl.UserSQLDAO;
import com.epam.library.dao.interfaces.BookDAO;
import com.epam.library.dao.interfaces.OrdersDAO;
import com.epam.library.dao.interfaces.UserDAO;

/**
 * @author Eugene13
 *
 */
public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final UserDAO sqlUserImpl = UserSQLDAO.getInstance();
	private final BookDAO sqlBookImpl = BookSQLDAO.getInstance();
	private final OrdersDAO sqlOrdersImpl = OrdersSQLDAO.getInstance();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	/**
	 * @return the sqlUserImpl
	 */
	public UserDAO getUserDAO() {
		return sqlUserImpl;
	}

	/**
	 * @return the sqlBookImpl
	 */
	public BookDAO getBookDAO() {
		return sqlBookImpl;
	}

	/**
	 * @return the sqlOrdersImpl
	 */
	public OrdersDAO getOrdersImpl() {
		return sqlOrdersImpl;
	}

}
