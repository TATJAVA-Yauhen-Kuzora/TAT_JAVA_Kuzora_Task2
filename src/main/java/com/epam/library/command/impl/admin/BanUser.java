/**
 * 
 */
package com.epam.library.command.impl.admin;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.UserService;

/**
 * Class {@link BanUser}.
 * <P>
 * Class BanUser implements {@link Command} interface for calling ban user logic
 * from {@link UserService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.admin}
 * package.</i>
 */
public class BanUser implements Command {
	/**
	 * Method execute for changing user status on Banned.
	 * 
	 * @return true as boolean value (of course packed in Object Class), if user
	 *         has been banned successfully
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 1)
			throw new CommandException("Wrong count of arguments for banning user.");
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			int userId = Integer.parseInt(request[0]);
			boolean resultOfExecution = userService.banUser(userId);
			return resultOfExecution;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for ban user command.");
		}
	}
}
