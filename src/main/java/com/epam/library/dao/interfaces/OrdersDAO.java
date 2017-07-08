/**
 * 
 */
package com.epam.library.dao.interfaces;

import java.util.ArrayList;
import com.epam.library.bean.Order;
import com.epam.library.dao.exception.DAOException;

/**
 * @author Eugene13
 *
 */
public interface OrdersDAO {
	ArrayList<Order> getAllOrders() throws DAOException;

	void addOrder(int userId, int bookId) throws DAOException;

	void confirmOrder(int orderId) throws DAOException;

	void confirmReturn(int orderId) throws DAOException;
}
