package com.epam.library.command.impl.guest;

import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.UserService;

/**
 * Class {@link Registration}.
 * <P>
 * Class Registration implements {@link Command} interface for calling
 * registration process logic from {@link UserService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.guest}
 * package.</i>
 */
public class Registration implements Command {
	/**
	 * Method execute for registration logic.
	 * 
	 * @return user object packed in Object Class
	 */
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
			throw new CommandException(e.getMessage(), e);
		}
		return user;
	}
}