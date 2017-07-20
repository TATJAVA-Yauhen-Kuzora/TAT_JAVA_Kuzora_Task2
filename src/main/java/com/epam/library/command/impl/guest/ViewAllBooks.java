package com.epam.library.command.impl.guest;

import java.util.ArrayList;

import com.epam.library.bean.Book;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.BookService;

/**
 * Class {@link ViewAllBooks}.
 * <P>
 * Class ViewAllBooks implements {@link Command} interface for calling
 * getAllBooks process logic from {@link BookService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.guest}
 * package.</i>
 */
public class ViewAllBooks implements Command {
	/**
	 * Method execute for viewing list of all books.
	 * 
	 * @return ArrayList<{@link Book}> object packed in Object Class
	 */
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
