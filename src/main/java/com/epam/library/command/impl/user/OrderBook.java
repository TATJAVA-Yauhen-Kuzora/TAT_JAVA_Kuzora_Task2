/**
 * 
 */
package com.epam.library.command.impl.user;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.OrdersService;

/**
 * @author Eugene13
 *
 */
public class OrderBook implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 2)
			throw new CommandException("Wrong count of arguments for logging.");
		OrdersService ordersService = ServiceFactory.getInstance().getOrdersService();
		try {
			int userId = Integer.parseInt(request[0]);
			int bookId = Integer.parseInt(request[1]);
			ordersService.addOrdersInHistory(userId, bookId);
			return true;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for add order command.", e);
		}
	}
}
