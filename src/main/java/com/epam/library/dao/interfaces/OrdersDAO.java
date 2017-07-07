/**
 * 
 */
package com.epam.library.dao.interfaces;

import java.util.ArrayList;
import com.epam.library.beans.Orders;
import com.epam.library.dao.exception.DAOException;

/**
 * @author Eugene13
 *
 */
public interface OrdersDAO {
	ArrayList<Orders> getAllOrders() throws DAOException;

	void addOrder(int userId, int bookId) throws DAOException;

	void confirmOrder(int orderId) throws DAOException;

	void confirmReturn(int orderId) throws DAOException;
}
