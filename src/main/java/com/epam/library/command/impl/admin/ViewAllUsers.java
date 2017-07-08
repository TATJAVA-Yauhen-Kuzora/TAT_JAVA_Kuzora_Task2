/**
 * 
 */
package com.epam.library.command.impl.admin;

import java.util.ArrayList;

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
public class ViewAllUsers implements Command {
	@Override
	public Object execute(String... request) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		ArrayList<User> users = null;
		try {
			users = userService.viewAllUsers();
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		}
		return users;
	}
}
