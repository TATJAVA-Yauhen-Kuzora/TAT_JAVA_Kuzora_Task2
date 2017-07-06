package com.epam.library.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.epam.library.beans.Book;
import com.epam.library.dao.exception.DAOException;

public interface BookDAO {
	ArrayList<Book> getAllbooks() throws DAOException;
}
