package com.epam.library.service.interfaces;

import java.util.ArrayList;
import com.epam.library.bean.Book;
import com.epam.library.bean.User;
import com.epam.library.service.exception.ServiceException;

/**
 * Interface {@link BookService}.
 * <P>
 * Interface BookService includes 3 methods
 * ({@link #changeBookStatus(int, int)}, {@link #getAllBooks()},
 * {@link #addBookToLibrary(String, String, int)}).
 * <P>
 * <i>This interface is a member of the
 * {@link com.epam.library.service.interfaces} package.</i>
 */
public interface BookService {
	/**
	 * Method getAllBooks returns list of all books.
	 * 
	 * @return object of ArrayList<{@link User}> type
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	ArrayList<Book> getAllBooks() throws ServiceException;

	/**
	 * Method changeBookStatus changes book status on opposite.
	 * 
	 * @param bookStatusAvailiable
	 *            value of int type as book status id from
	 *            library.book_status.book_status_id
	 * @param bookId
	 *            value of int type as book id from library.book.book_id
	 * @return boolean value as result of executing
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	boolean changeBookStatus(int bookStatusAvailiable, int bookId) throws ServiceException;

	/**
	 * Method addBookToLibrary adds book to library's books.
	 * 
	 * @param bookName
	 *            name of book
	 * @param author
	 *            name of author
	 * @param bookStatusId
	 *            value of int type as book status id from
	 *            library.book_status.book_status_id
	 * @return boolean value as result of executing
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	boolean addBookToLibrary(String bookName, String author, int bookStatusId) throws ServiceException;
}
