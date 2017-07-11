package com.epam.library.dao.interfaces;

import java.util.ArrayList;
import com.epam.library.bean.Order;
import com.epam.library.dao.exception.DAOException;

/**
 * Interface {@link OrdersDAO}.
 * <P>
 * Interface OrdersDAO includes 4 methods ({@link #getAllOrders()},
 * {@link #addOrder(int, int)}, {@link #confirmOrder(int)},
 * {@link #confirmReturn(int)}).
 * <P>
 * <i>This interface is a member of the {@link com.epam.library.dao.interfaces}
 * package.</i>
 */
public interface OrdersDAO {
	/**
	 * Method getAllOrders returns list of all orders from db.
	 * 
	 * @return object of ArrayList<{@link Order}> type.
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	ArrayList<Order> getAllOrders() throws DAOException;

	/**
	 * Method addOrder adds order to orders table in db.
	 * 
	 * @param userId
	 *            value of int type as user id from library.user.user_id
	 * @param bookId
	 *            value of int type as book id from library.book.book_id
	 * @return 
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	boolean addOrder(int userId, int bookId) throws DAOException;

	/**
	 * Method confirmOrder changes order status from "Booked" to "On hands".
	 * 
	 * @param orderId
	 *            value of int type as order id from library.orders.oreder_id
	 * @return 
	 * @throws DAOException
	 *             Exception type for service layer
	 */
	boolean confirmOrder(int orderId) throws DAOException;

	/**
	 * Method confirmReturn changes order status from "On hands" to "Returned".
	 * 
	 * @param orderId
	 *            value of int type as order id from library.orders.oreder_id
	 * @return 
	 * @throws DAOException
	 *             Exception type for service layer
	 */
	boolean confirmReturn(int orderId) throws DAOException;
}
