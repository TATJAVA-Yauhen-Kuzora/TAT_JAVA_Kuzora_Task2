package com.epam.library.dao.interfaces;

import java.util.ArrayList;
import com.epam.library.bean.Book;
import com.epam.library.bean.User;
import com.epam.library.dao.exception.DAOException;

/**
 * Interface {@link BookDAO}.
 * <P>
 * Interface BookDAO includes 4 methods ({@link #getAllbooks()},
 * {@link #setAvailiableStatus(int)}, {@link #setNotAvailiableStatus(int)},
 * {@link #addBookToLibrary(String, String, int)}).
 * <P>
 * <i>This interface is a member of the {@link com.epam.library.dao.interfaces}
 * package.</i>
 */
public interface BookDAO {
	/**
	 * Method getAllBooks returns list of all books.
	 * 
	 * @return object of ArrayList<{@link User}> type
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	ArrayList<Book> getAllbooks() throws DAOException;

	/**
	 * Method setAvailiableStatus changes book status on Available.
	 * 
	 * @param bookId
	 *            value of int type as book id from library.book.book_id
	 * @return boolean value as result of successfully execution
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	boolean setAvailiableStatus(int bookId) throws DAOException;

	/**
	 * Method setNotAvailiableStatus changes book status on Not available.
	 * 
	 * @param bookId
	 *            value of int type as book id from library.book.book_id
	 * @return boolean value as result of successfully execution
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	boolean setNotAvailiableStatus(int bookId) throws DAOException;

	/**
	 * Method isAvailiableStatus checks book status.
	 * 
	 * @param bookId
	 *            value of int type as book id from library.book.book_id
	 * @return boolean value as result of successfully execution
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	boolean isAvailiableStatus(int bookId) throws DAOException;

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
	 * @return boolean value as result of successfully execution
	 * @throws DAOException
	 *             Exception type for dao layer
	 */
	boolean addBookToLibrary(String bookName, String author, int bookStatusId) throws DAOException;
}
