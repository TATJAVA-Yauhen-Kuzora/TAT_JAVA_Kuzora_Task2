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
public class Registration implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 4)
			throw new CommandException("Wrong count of arguments for regitration.");
		User user = null;
		UserService userService = ServiceFactory.getInstance().getUserService();
		String name = request[0];
		String secondName = request[1];
		String login = request[2];
		String password = request[3];
		try {
			user = userService.register(name, secondName, login, password);
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return user;
	}
}