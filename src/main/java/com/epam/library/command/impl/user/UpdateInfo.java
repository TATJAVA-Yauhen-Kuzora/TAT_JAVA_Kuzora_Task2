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
public class UpdateInfo implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 4)
			throw new CommandException("Wrong count of arguments for logging.");
		User user = null;
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			user = userService.updateUserInfo(request[0], request[1], request[2], Integer.parseInt(request[3]));
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for updateInfo command.");
		}
		return user;
	}

}
