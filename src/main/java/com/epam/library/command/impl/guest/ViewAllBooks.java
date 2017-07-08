/**
 * 
 */
package com.epam.library.command.impl.guest;

import java.util.ArrayList;

import com.epam.library.bean.Book;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.BookService;

/**
 * @author Eugene13
 *
 */
public class ViewAllBooks implements Command {
	@Override
	public Object execute(String... request) throws CommandException {
		BookService bookService = ServiceFactory.getInstance().getBookService();
		ArrayList<Book> books = null;
		try {
			books = bookService.getAllBooks();
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		}
		return books;
	}
}
