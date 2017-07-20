/**
 * 
 */
package com.epam.library.command.impl.user;

import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.UserService;

/**
 * Class {@link UpdateInfo}.
 * <P>
 * Class UpdateInfo implements {@link Command} interface for calling updating
 * process logic from {@link UserService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.user}
 * package.</i>
 */
public class UpdateInfo implements Command {
	/**
	 * Method execute for updating user info.
	 * 
	 * @return updated user object packed in Object Class
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 5)
			throw new CommandException("Wrong count of arguments for updating.");
		User user = null;
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			user = userService.updateUserInfo(request[0], request[1], request[2], Integer.parseInt(request[3]),
					request[4]);
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for update user info command.", e);
		}
		return user;
	}
}
