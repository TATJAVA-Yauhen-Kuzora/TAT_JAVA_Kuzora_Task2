/**
 * 
 */
package com.epam.library.command.impl.admin;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.BookService;
import com.epam.library.services.interfaces.UserService;

/**
 * @author Eugene13
 *
 */
public class ChangeBookStatus implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 2)
			throw new CommandException("Wrong count of arguments for logging.");
		BookService bookService = ServiceFactory.getInstance().getBookService();
		try {
			int bookStatusAvailiable = Integer.parseInt(request[0]);
			int bookId = Integer.parseInt(request[1]);
			bookService.changeBookStatus(bookStatusAvailiable, bookId);
			return true;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for update book status command.");
		}
	}

}
