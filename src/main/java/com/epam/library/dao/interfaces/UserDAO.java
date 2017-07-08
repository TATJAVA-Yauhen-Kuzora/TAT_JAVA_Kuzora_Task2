package com.epam.library.dao.interfaces;

import java.util.ArrayList;
import com.epam.library.bean.User;
import com.epam.library.dao.exception.DAOException;

public interface UserDAO {
	User signIn(String login, String password) throws DAOException;

	User register(String name, String secondName, String login, String password) throws DAOException;

	ArrayList<User> getAllUsers() throws DAOException;

	User updateUserInfo(String name, String secondName, String login, int userId) throws DAOException;

	void banUser(int UserId) throws DAOException;

	void unBanUser(int UserId) throws DAOException;

	void giveAdminForUser(int UserId) throws DAOException;
}
