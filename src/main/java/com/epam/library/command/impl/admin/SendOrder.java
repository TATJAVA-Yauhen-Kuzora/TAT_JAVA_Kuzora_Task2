/**
 * 
 */
package com.epam.library.command.impl.admin;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.OrdersService;

/**
 * @author Eugene13
 *
 */
public class SendOrder implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 1)
			throw new CommandException("Wrong count of arguments for confirm order.");
		OrdersService bookService = ServiceFactory.getInstance().getOrdersService();
		try {
			int orderId = Integer.parseInt(request[0]);
			bookService.sendOrder(orderId);
			return true;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for send order command.");
		}
	}
}
