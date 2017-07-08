/**
 * 
 */
package com.epam.library.command.impl.guest;

import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.UserService;

/**
 * @author Eugene13
 *
 */
public class Login implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 2)
			throw new CommandException("Wrong count of arguments for logging.");
		User user = null;
		UserService userService = ServiceFactory.getInstance().getUserService();
		String login = request[0];
		String password = request[1];
		try {
			user = userService.singIn(login, password);
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		}
		return user;
	}
}
