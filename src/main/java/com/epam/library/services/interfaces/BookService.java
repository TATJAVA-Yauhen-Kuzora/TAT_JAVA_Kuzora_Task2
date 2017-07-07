/**
 * 
 */
package com.epam.library.services.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.epam.library.beans.Book;
import com.epam.library.services.exception.ServiceException;

/**
 * @author Eugene13
 *
 */
public interface BookService {
	ArrayList<Book> getAllBooks() throws ServiceException;

	void changeBookStatus(int bookStatusAvailiable, int bookId) throws ServiceException;
}
