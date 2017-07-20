package com.epam.library.service.impl;

import static com.epam.library.service.validator.Validator.*;
import java.util.ArrayList;
import com.epam.library.bean.Book;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.BookDAO;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.interfaces.BookService;

/**
 * Class {@link BookServiceImpl}.
 * <P>
 * Class BookServiceImpl implements all methods from {@link BookService}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.service.impl}
 * package.</i>
 */
public class BookServiceImpl implements BookService {
	/**
	 * Implementation of getAllBooks method.
	 */
	@Override
	public ArrayList<Book> getAllBooks() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO dao = daoFactory.getBookDAOImpl();
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
	public boolean changeBookStatus(int bookStatusAvailiable, int bookId) throws ServiceException {
		validateBookInfo(bookStatusAvailiable, bookId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO dao = daoFactory.getBookDAOImpl();
		try {
			if (bookStatusAvailiable == 1) {
				return dao.setNotAvailiableStatus(bookId);
			} else {
				return dao.setAvailiableStatus(bookId);
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Implementation of addBookToLibrary method.
	 */
	@Override
	public boolean addBookToLibrary(String bookName, String author, int bookStatusId) throws ServiceException {
		validateBookInfo(bookName, author, bookStatusId);
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDAO dao = daoFactory.getBookDAOImpl();
		try {
			return dao.addBookToLibrary(bookName, author, bookStatusId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
