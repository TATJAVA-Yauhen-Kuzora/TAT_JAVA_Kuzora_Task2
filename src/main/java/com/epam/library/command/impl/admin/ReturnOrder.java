package com.epam.library.command.impl.admin;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.OrdersService;

/**
 * Class {@link ReturnOrder}.
 * <P>
 * Class ReturnOrder implements {@link Command} interface for calling change
 * order status logic from {@link OrdersService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.admin}
 * package.</i>
 */
public class ReturnOrder implements Command {
	/**
	 * Method execute for changing book status from "On Hands" to "Returned".
	 * 
	 * @return true as boolean value (of course packed in Object Class), if
	 *         order status has been changed in data base successfully
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 2)
			throw new CommandException("Wrong count of arguments for return order.");
		OrdersService bookService = ServiceFactory.getInstance().getOrdersService();
		try {
			int orderId = Integer.parseInt(request[0]);
			int bookId = Integer.parseInt(request[1]);
			boolean resultOfExecution = bookService.returnOrder(orderId, bookId);
			return resultOfExecution;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for return order command.");
		}
	}
}
