/**
 * 
 */
package com.epam.library.services.interfaces;

import java.util.ArrayList;

import com.epam.library.beans.Orders;
import com.epam.library.services.exception.ServiceException;

/**
 * @author Eugene13
 *
 */
public interface OrdersService {
	ArrayList<Orders> getAllOrders() throws ServiceException;

	void addOrdersInHistory(int userId, int bookId) throws ServiceException;

	void sendOrder(int orderId) throws ServiceException;

	void returnOrder(int orderId) throws ServiceException;
}
