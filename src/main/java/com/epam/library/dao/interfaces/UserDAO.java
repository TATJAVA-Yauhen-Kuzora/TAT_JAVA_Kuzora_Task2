package com.epam.library.dao.interfaces;

import java.util.List;

import com.epam.library.beans.User;
import com.epam.library.dao.exception.DAOException;

public interface UserDAO {
	User signIn(String login, String password) throws DAOException;

	User register(String name, String secondName, String login, String password) throws DAOException;

	List<User> getAllUsers() throws DAOException;
}
