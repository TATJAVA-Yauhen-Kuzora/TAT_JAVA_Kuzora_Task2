package com.epam.library.services.impl;

import java.util.ArrayList;
import com.epam.library.bean.Order;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.OrdersDAO;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.OrdersService;

/**
 * Class {@link OrdersServiceImpl}.
 * <P>
 * Class OrdersServiceImpl implements all methods from {@link OrdersService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.services.impl}
 * package.</i>
 */
public class OrdersServiceImpl implements OrdersService {
	/**
	 * Implementation of getAllOrders method.
	 */
	@Override
	public ArrayList<Order> getAllOrders() throws ServiceException {
		// validator
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrdersDAO dao = daoFactory.getOrdersImpl();
		ArrayList<Order> orders = new ArrayList<>();
		try {
			orders = dao.getAllOrders();
			return orders;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of addOrdersInHistory method.
	 */
	@Override
	public void addOrdersInHistory(int userId, int bookId) throws ServiceException {
		// validator
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrdersDAO dao = daoFactory.getOrdersImpl();
		try {
			dao.addOrder(userId, bookId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of sendOrder method.
	 */
	@Override
	public void sendOrder(int orderId) throws ServiceException {
		// validator
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrdersDAO dao = daoFactory.getOrdersImpl();
		try {
			dao.confirmOrder(orderId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of returnOrder method.
	 */
	@Override
	public void returnOrder(int orderId) throws ServiceException {
		// validator
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrdersDAO dao = daoFactory.getOrdersImpl();
		try {
			dao.confirmReturn(orderId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
