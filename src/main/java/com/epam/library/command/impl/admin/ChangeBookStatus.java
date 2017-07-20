package com.epam.library.command.impl.admin;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.BookService;

/**
 * Class {@link ChangeBookStatus}.
 * <P>
 * Class ChangeBookStatus implements {@link Command} interface for calling
 * change book status logic from {@link BookService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.admin}
 * package.</i>
 */
public class ChangeBookStatus implements Command {
	/**
	 * Method execute for changing book status from Available on Not available
	 * and conversely.
	 * 
	 * @return true as boolean value (of course packed in Object Class), if book
	 *         status has been changed in data base successfully
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		if (request.length != 2)
			throw new CommandException("Wrong count of arguments for logging.");
		BookService bookService = ServiceFactory.getInstance().getBookService();
		try {
			int bookStatus = Integer.parseInt(request[0]);
			int bookId = Integer.parseInt(request[1]);
			boolean resultOfExecution = bookService.changeBookStatus(bookStatus, bookId);
			return resultOfExecution;
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new CommandException("Invalid parameters for update book status command.");
		}
	}

}
