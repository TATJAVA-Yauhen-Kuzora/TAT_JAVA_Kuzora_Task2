package com.epam.library.command.impl.user;

import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.UserService;

/**
 * Class {@link Logout}.
 * <P>
 * Class Logout implements {@link Command} interface for calling logout logic
 * from {@link UserService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.user}
 * package.</i>
 */
public class Logout implements Command {
	/**
	 * Method execute for calling logout logic.
	 * 
	 * @return null as result of successfully executing this implementation
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		User user = null;
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			user = userService.logout();
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		}
		return user;
	}
}
