/**
 * 
 */
package com.epam.library.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.epam.library.beans.Book;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.dao.interfaces.BookDAO;
import com.epam.library.services.exception.ServiceException;
import com.epam.library.services.interfaces.BookService;

/**
 * @author Eugene13
 *
 */
public class BookServiceImpl implements BookService {

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
}
