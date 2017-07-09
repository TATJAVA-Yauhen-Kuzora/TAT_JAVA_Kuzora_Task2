package com.epam.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.epam.library.bean.Book;
import com.epam.library.bean.BookStatus;
import com.epam.library.dao.connection.ConnectionSQLDAO;
import com.epam.library.dao.connection.ConnectionSQLException;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.BookDAO;

/**
 * Class {@link BookSQLDAO}.
 * <P>
 * Class BookSQLDAO implements all methods from {@link BookDAO}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.dao.impl}
 * package.</i>
 */
public class BookSQLDAO implements BookDAO {
	private final static String GET_LIST_OF_BOOKS = "SELECT book_id, book_name, author, book.book_status_id,  book_status FROM book LEFT JOIN book_status ON book.book_status_id = book_status.book_status_id";
	private final static String SET_STATUS = "UPDATE book SET book_status_id = ? WHERE book_id = ?;";
	private final static String ADD_BOOK = "INSERT INTO book (book_name, author, book_status_id) VALUES(?,?,?)";
	private final static String BOOK_ID = "book_id";
	private final static String BOOK_NAME = "book_name";
	private final static String BOOK_AUTHOR = "author";
	private final static String BOOK_STATUS_ID = "book.book_status_id";
	private final static String BOOK_STATUS_NAME = "book_status";
	private static final BookDAO instance = new BookSQLDAO();

	private BookSQLDAO() {
	}

	public static BookDAO getInstance() {
		return instance;
	}

	/**
	 * Implementation of getAllbooks method.
	 */
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

	/**
	 * Implementation of setAvailiableStatus method.
	 */
	@Override
	public void setAvailiableStatus(int bookId) throws DAOException {
		Connection connection = null;
		PreparedStatement pSt = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(SET_STATUS);
			pSt.setInt(1, 1);
			pSt.setInt(2, bookId);
			int access = pSt.executeUpdate();
			if (access > 0) {
				return;
			}
		} catch (SQLException e) {
			throw new DAOException("Update book status sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		}
	}

	/**
	 * Implementation of setNotAvailiableStatus method.
	 */
	@Override
	public void setNotAvailiableStatus(int bookId) throws DAOException {
		Connection connection = null;
		PreparedStatement pSt = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(SET_STATUS);
			pSt.setInt(1, 2);
			pSt.setInt(2, bookId);
			int access = pSt.executeUpdate();
			if (access > 0) {
				return;
			}
		} catch (SQLException e) {
			throw new DAOException("Update book status sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		}
	}

	/**
	 * Implementation of addBookToLibrary method.
	 */
	@Override
	public void addBookToLibrary(String bookName, String author, int bookStatusId) throws DAOException {
		Connection connection = null;
		PreparedStatement pSt = null;
		try {
			connection = ConnectionSQLDAO.getInstance().takeConnection();
			pSt = connection.prepareStatement(ADD_BOOK);
			pSt.setString(1, bookName);
			pSt.setString(2, author);
			pSt.setInt(3, bookStatusId);
			int access = pSt.executeUpdate();
			if (access > 0) {
				return;
			}
		} catch (SQLException e) {
			throw new DAOException("Add book sql exception.", e);
		} catch (ConnectionSQLException e) {
			throw new DAOException("Smthg wrong with connection.", e);
		}
	}
}
