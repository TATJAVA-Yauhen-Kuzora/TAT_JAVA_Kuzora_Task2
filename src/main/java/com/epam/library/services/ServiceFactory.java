/**
 * 
 */
package com.epam.library.services;

import com.epam.library.services.impl.BookServiceImpl;
import com.epam.library.services.impl.UserServiceImpl;
import com.epam.library.services.interfaces.BookService;
import com.epam.library.services.interfaces.UserService;

/**
 * @author Eugene13
 *
 */
public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	public static ServiceFactory getInstance() {
		return instance;
	}

	private UserService userService = new UserServiceImpl();
	private BookService bookService = new BookServiceImpl();

	public UserService getUserService() {
		return userService;
	}

	/**
	 * @return the bookService
	 */
	public BookService getBookService() {
		return bookService;
	}
}
