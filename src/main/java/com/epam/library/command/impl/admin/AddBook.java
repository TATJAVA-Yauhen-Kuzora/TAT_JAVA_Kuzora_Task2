package com.epam.library.command.impl.admin;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.BookService;

/**
 * Class {@link AddBook}.
 * <P>
 * Class AddBook implements {@link Command} interface for add book process logic
 * from {@link BookService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.admin}
 * package.</i>
 */
public class AddBook implements Command {
	/**
	 * Method execute for adding book logic.
	 * 
	 * @return true as boolean value (of course packed in Object Class), if book
	 *         has been added in data base successfully
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 3)
			throw new CommandException("Wrong count of arguments for adding book.");
		BookService bookService = ServiceFactory.getInstance().getBookService();
		try {
			String bookName = request[0];
			String author = request[1];
			int bookStatusId = Integer.parseInt(request[2]);
			boolean resultOfExecution = bookService.addBookToLibrary(bookName, author, bookStatusId);
			return resultOfExecution;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for update book status command.");
		}
	}
}
