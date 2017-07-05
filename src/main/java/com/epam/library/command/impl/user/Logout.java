/**
 * 
 */
package com.epam.library.command.impl.user;

import com.epam.library.beans.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.UserService;

/**
 * @author Eugene13
 *
 */
public class Logout implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		User user = null;
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			user = userService.logout();
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return user;
	}
}
