package com.epam.library.command.impl.user;

import java.util.ArrayList;

import com.epam.library.bean.Order;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.OrdersService;

/**
 * Class {@link ViewAllOrders}.
 * <P>
 * Class ViewAllOrders implements {@link Command} interface for viewing list of
 * all orders from {@link OrdersService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.user}
 * package.</i>
 */
public class ViewAllOrders implements Command {
	/**
	 * Method execute for viewing list of all orders.
	 * 
	 * @return ArrayList<{@link Order}> object packed in Object Class
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		OrdersService ordersService = ServiceFactory.getInstance().getOrdersService();
		ArrayList<Order> orders = null;
		try {
			orders = ordersService.getAllOrders();
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		}
		return orders;
	}
}
