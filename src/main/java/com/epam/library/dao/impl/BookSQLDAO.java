/**
 * 
 */
package com.epam.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.library.beans.AccessLevel;
import com.epam.library.beans.Book;
import com.epam.library.beans.BookStatus;
import com.epam.library.dao.connection.ConnectionSQLDAO;
import com.epam.library.dao.connection.ConnectionSQLException;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.BookDAO;

/**
 * @author Eugene13
 *
 */
public class BookSQLDAO implements BookDAO {
	private final static String GET_LIST_OF_BOOKS = "SELECT book_id, book_name, author, description, book.book_status_id,  book_status FROM book LEFT JOIN book_status ON book.book_status_id = book_status.book_status_id";

	private final static String BOOK_ID = "book_id";
	private final static String BOOK_NAME = "book_name";
	private final static String BOOK_AUTHOR = "author";
	private final static String BOOK_DESCRIPTION = "description";
	private final static String BOOK_STATUS_ID = "book.book_status_id";
	private final static String BOOK_STATUS_NAME = "book_status";

	private static final BookDAO instance = new BookSQLDAO();

	private BookSQLDAO() {
	}

	public static BookDAO getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Book> getAllbooks() throws DAOException {
		Connection connection = null;
		PreparedStatement pSt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(GET_LIST_OF_BOOKS);
			rs = pSt.executeQuery();
			Book book;
			ArrayList<Book> books = new ArrayList<>();
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt(BOOK_ID));
				book.setBookName(rs.getString(BOOK_NAME));
				book.setAuthor(rs.getString(BOOK_AUTHOR));
				book.setDescription(rs.getString(BOOK_DESCRIPTION));
				BookStatus status = new BookStatus();
				status.setBookStatusId(rs.getInt(BOOK_STATUS_ID));
				status.setBookStatus(rs.getString(BOOK_STATUS_NAME));

				book.setBookStatus(status);
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			throw new DAOException("Get list of book sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		}
	}

}
