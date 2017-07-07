/**
 * 
 */
package com.epam.library.command.impl.admin;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.BookService;

/**
 * @author Eugene13
 *
 */
public class AddBook implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 3)
			throw new CommandException("Wrong count of arguments for adding book.");
		BookService bookService = ServiceFactory.getInstance().getBookService();
		try {
			String bookName = request[0];
			String author = request[1];
			int bookStatusId = Integer.parseInt(request[2]);
			bookService.addBookToLibrary(bookName, author, bookStatusId);
			return true;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for update book status command.");
		}
	}

}
