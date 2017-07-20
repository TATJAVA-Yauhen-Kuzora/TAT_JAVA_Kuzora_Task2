package com.epam.library.service;

import com.epam.library.service.impl.BookServiceImpl;
import com.epam.library.service.impl.OrdersServiceImpl;
import com.epam.library.service.impl.UserServiceImpl;
import com.epam.library.service.interfaces.BookService;
import com.epam.library.service.interfaces.OrdersService;
import com.epam.library.service.interfaces.UserService;

/**
 * Singleton Class {@link ServiceFactory}.
 * <P>
 * Class ServiceFactory gives different objects depended on type of object that
 * command layer has called.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.service}
 * package.</i>
 */
public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	public static ServiceFactory getInstance() {
		return instance;
	}

	/**
	 * Creating {@link UserServiceImpl} object.
	 */
	private UserService userService = new UserServiceImpl();
	/**
	 * Creating {@link BookServiceImpl} object.
	 */
	private BookService bookService = new BookServiceImpl();
	/**
	 * Creating {@link OrdersServiceImpl} object.
	 */
	private OrdersService ordersService = new OrdersServiceImpl();

	/**
	 * @return the userService as object of {@link UserService} type
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @return the bookService as object of {@link BookService} type
	 */
	public BookService getBookService() {
		return bookService;
	}

	/**
	 * @return the ordersService as object of {@link OrdersService} type
	 */
	public OrdersService getOrdersService() {
		return ordersService;
	}
}
