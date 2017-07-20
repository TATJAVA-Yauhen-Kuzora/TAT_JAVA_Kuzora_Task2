package com.epam.library.command.impl.superAdmin;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.UserService;

/**
 * Class {@link GiveAdminForUser}.
 * <P>
 * Class GiveAdminForUser implements {@link Command} interface for calling
 * giveAdminForUser logic from {@link UserService}.
 * <P>
 * <i>This Class is a member of the
 * {@link com.epam.library.command.impl.superAdmin} package.</i>
 */
public class GiveAdminForUser implements Command {
	/**
	 * Method execute for giving admin rights to user.
	 * 
	 * @return true as boolean value (of course packed in Object Class), if user
	 *         status has been changed from User on Admin successfully
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 1)
			throw new CommandException("Wrong count of arguments for adding admin to user.");
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			int userId = Integer.parseInt(request[0]);
			boolean resultOfExecution = userService.giveAdminForUser(userId);
			return resultOfExecution;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for Give_Admin command.");
		}
	}
}
