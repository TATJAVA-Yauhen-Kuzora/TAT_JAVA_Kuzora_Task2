/**
 * 
 */
package com.epam.library.services.interfaces;

import com.epam.library.beans.User;
import com.epam.library.services.exception.ServiceException;

/**
 * @author Eugene13
 *
 */
public interface UserService {
	User singIn(String login, String password) throws ServiceException;

	User logout() throws ServiceException;
	
	User register() throws ServiceException;
}
