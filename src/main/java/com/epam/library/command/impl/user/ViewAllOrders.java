/**
 * 
 */
package com.epam.library.command.impl.user;

import java.util.ArrayList;

import com.epam.library.bean.Order;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.OrdersService;

/**
 * @author Eugene13
 *
 */
public class ViewAllOrders implements Command {

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
