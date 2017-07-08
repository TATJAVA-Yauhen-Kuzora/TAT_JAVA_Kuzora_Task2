package com.epam.library.dao.interfaces;

import java.util.ArrayList;
import com.epam.library.bean.Book;
import com.epam.library.dao.exception.DAOException;

public interface BookDAO {
	ArrayList<Book> getAllbooks() throws DAOException;

	void setAvailiableStatus(int bookId) throws DAOException;

	void setNotAvailiableStatus(int bookId) throws DAOException;

	void addBookToLibrary(String bookName, String author, int bookStatusId) throws DAOException;
}
