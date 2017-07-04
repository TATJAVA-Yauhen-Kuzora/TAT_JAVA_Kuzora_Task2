/**
 * 
 */
package com.epam.library.services;

import com.epam.library.services.impl.UserServiceImpl;
import com.epam.library.services.interfaces.UserService;

/**
 * @author Eugene13
 *
 */
public class ServiceFactory {
	public static final ServiceFactory INSTANCE = new ServiceFactory();

	public static ServiceFactory getInstance() {
		return INSTANCE;
	}

	private UserService userService = new UserServiceImpl();

	public UserService getUserService() {
		return userService;
	}

}
