package com.epam.library.command.impl.guest;

import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.UserService;

/**
 * Class {@link Login}.
 * <P>
 * Class Login implements {@link Command} interface for calling login process
 * logic from {@link UserService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.guest}
 * package.</i>
 */
public class Login implements Command {
	/**
	 * Method execute for logging logic.
	 * 
	 * @return user object packed in Object Class
	 */
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
