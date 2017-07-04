package com.epam.library.dao.interfaces;

import com.epam.library.beans.User;
import com.epam.library.dao.exception.DAOException;

public interface UserDAO {
	User signIn(String login, String password) throws DAOException;

	User register(User user);
}
