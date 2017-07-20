package com.epam.library.service.impl;

import static com.epam.library.service.validator.Validator.*;
import java.util.ArrayList;
import com.epam.library.bean.Order;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.BookDAO;
import com.epam.library.dao.interfaces.OrdersDAO;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.OrdersService;

/**
 * Class {@link OrdersServiceImpl}.
 * <P>
 * Class OrdersServiceImpl implements all methods from {@link OrdersService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.service.impl}
 * package.</i>
 */
public class OrdersServiceImpl implements OrdersService {
	/**
	 * Implementation of getAllOrders method.
	 */
	@Override
	public ArrayList<Order> getAllOrders() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrdersDAO dao = daoFactory.getOrdersDAOImpl();
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
	public boolean addOrdersInHistory(int userId, int bookId) throws ServiceException {
		validateOrderInfoForAdding(userId, bookId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrdersDAO orderDao = daoFactory.getOrdersDAOImpl();
		BookDAO bookDao = daoFactory.getBookDAOImpl();
		try {
			if (bookDao.isAvailiableStatus(bookId)) {
				if (bookDao.setNotAvailiableStatus(bookId)) {
					return orderDao.addOrder(userId, bookId);
				}
			}
			return false;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of sendOrder method.
	 */
	@Override
	public boolean sendOrder(int orderId) throws ServiceException {
		validateOrderInfo(orderId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrdersDAO dao = daoFactory.getOrdersDAOImpl();
		try {
			return dao.confirmOrder(orderId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of returnOrder method.
	 */
	@Override
	public boolean returnOrder(int orderId, int bookId) throws ServiceException {
		validateOrderInfo(orderId, bookId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		OrdersDAO orderDao = daoFactory.getOrdersDAOImpl();
		BookDAO bookDao = daoFactory.getBookDAOImpl();
		try {
			if (bookDao.setAvailiableStatus(bookId))
				return orderDao.confirmReturn(orderId);
			return false;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
