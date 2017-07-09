package com.epam.library.dao;

import com.epam.library.dao.impl.BookSQLDAO;
import com.epam.library.dao.impl.OrdersSQLDAO;
import com.epam.library.dao.impl.UserSQLDAO;
import com.epam.library.dao.interfaces.BookDAO;
import com.epam.library.dao.interfaces.OrdersDAO;
import com.epam.library.dao.interfaces.UserDAO;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.interfaces.UserService;

/**
 * Singleton Class {@link DAOFactory}.
 * <P>
 * Class DAOFactory gives different objects depended on type of object that
 * services layer has called.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.dao} package.</i>
 */
public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	/**
	 * Creating {@link UserSQLDAO} object.
	 */
	private final UserDAO sqlUserImpl = UserSQLDAO.getInstance();
	/**
	 * Creating {@link BookSQLDAO} object.
	 */
	private final BookDAO sqlBookImpl = BookSQLDAO.getInstance();
	/**
	 * Creating {@link OrdersSQLDAO} object.
	 */
	private final OrdersDAO sqlOrdersImpl = OrdersSQLDAO.getInstance();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	/**
	 * @return the sqlUserImpl as object of {@link UserDAO} type
	 */
	public UserDAO getUserDAO() {
		return sqlUserImpl;
	}

	/**
	 * @return the sqlBookImpl as object of {@link BookDAO} type
	 */
	public BookDAO getBookDAO() {
		return sqlBookImpl;
	}

	/**
	 * @return the sqlOrdersImpl as object of {@link OrdersDAO} type
	 */
	public OrdersDAO getOrdersImpl() {
		return sqlOrdersImpl;
	}

}
