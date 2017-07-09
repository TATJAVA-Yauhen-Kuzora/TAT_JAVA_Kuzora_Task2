package com.epam.library.services.impl;

import java.util.ArrayList;
import com.epam.library.bean.Book;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.BookDAO;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.BookService;

/**
 * Class {@link BookServiceImpl}.
 * <P>
 * Class BookServiceImpl implements all methods from {@link BookService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.services.impl}
 * package.</i>
 */
public class BookServiceImpl implements BookService {
	/**
	 * Implementation of getAllBooks method.
	 */
	@Override
	public ArrayList<Book> getAllBooks() throws ServiceException {
		// validator
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO dao = daoFactory.getBookDAO();
		ArrayList<Book> books = new ArrayList<>();
		try {
			books = dao.getAllbooks();
			return books;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of changeBookStatus method.
	 */
	@Override
	public void changeBookStatus(int bookStatusAvailiable, int bookId) throws ServiceException {
		// validator
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO dao = daoFactory.getBookDAO();
		try {
			if (bookStatusAvailiable == 1) {
				dao.setNotAvailiableStatus(bookId);
			} else {
				dao.setAvailiableStatus(bookId);
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of addBookToLibrary method.
	 */
	@Override
	public void addBookToLibrary(String bookName, String author, int bookStatusId) throws ServiceException {
		// validator
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO dao = daoFactory.getBookDAO();
		try {
			dao.addBookToLibrary(bookName, author, bookStatusId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
