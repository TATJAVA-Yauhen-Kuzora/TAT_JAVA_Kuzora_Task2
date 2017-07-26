package com.epam.library.service.interfaces;

import java.util.ArrayList;

import com.epam.library.bean.Order;
import com.epam.library.service.exception.ServiceException;

/**
 * Interface {@link OrdersService}.
 * <P>
 * Interface OrdersService includes 4 methods ({@link #getAllOrders()},
 * {@link #addOrdersInHistory(int, int)}, {@link #sendOrder(int)},
 * {@link #returnOrder(int, int)}).
 * <p>
 * <i>This interface is a member of the
 * {@link com.epam.library.service.interfaces} package.</i>
 */
public interface OrdersService {
	/**
	 * Method getAllOrders returns list of all orders.
	 * 
	 * @return object of ArrayList<{@link Order}> type.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	ArrayList<Order> getAllOrders() throws ServiceException;

	/**
	 * Method addOrdersInHistory adds order to order list.
	 * 
	 * @param userId
	 *            value of int type as user id from library.user.user_id
	 * @param bookId
	 *            value of int type as book id from library.book.book_id
	 * @return boolean value as result of executing
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	boolean addOrdersInHistory(int userId, int bookId) throws ServiceException;

	/**
	 * Method sendOrder changes order status from "Booked" to "On hands".
	 * 
	 * @param orderId
	 *            value of int type as order id from library.orders.oreder_id
	 * @return boolean value as result of executing
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	boolean sendOrder(int orderId) throws ServiceException;

	/**
	 * Method sendOrder changes order status from "On hands" to "Returned".
	 * 
	 * @param orderId
	 *            value of int type as order id from library.orders.oreder_id
	 * @param bookId
	 *            book id
	 * @return boolean value as result of executing
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	boolean returnOrder(int orderId, int bookId) throws ServiceException;
}
