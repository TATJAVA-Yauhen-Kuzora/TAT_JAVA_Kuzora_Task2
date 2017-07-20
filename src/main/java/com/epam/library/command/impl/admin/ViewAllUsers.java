package com.epam.library.command.impl.admin;

import java.util.ArrayList;

import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.UserService;

/**
 * Class {@link ViewAllUsers}.
 * <P>
 * Class ViewAllUsers implements {@link Command} interface for calling unBanUser
 * logic from {@link UserService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.admin}
 * package.</i>
 */
public class ViewAllUsers implements Command {
	/**
	 * Method execute for viewing list of all users.
	 * 
	 * @return ArrayList<{@link User}> object packed in Object Class
	 */
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
