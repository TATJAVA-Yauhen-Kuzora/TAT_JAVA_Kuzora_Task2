/**
 * 
 */
package com.epam.library.services.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.library.services.exception.ServiceException;

/**
 * @author Eugene13
 *
 */
public class Validator {
	public static boolean validateBookInfo(int bookStatusAvailiable, int bookId) throws ServiceException {
		if (bookStatusAvailiable < 1 && bookStatusAvailiable > 2)
			throw new ServiceException("Book availiable status id is not correct.");
		if (bookId < 1)
			throw new ServiceException("Book id is not correct.");
		return true;
	}

	public static boolean validateBookInfo(String bookName, String author, int bookStatusId) throws ServiceException {
		if (bookStatusId < 1 && bookStatusId > 2)
			throw new ServiceException("Book availiable status id is not correct.");
		return true;
	}

	public static boolean validateOrderInfoForAdding(int userId, int bookId) throws ServiceException {
		if (userId < 1)
			throw new ServiceException("User id is not correct.");
		if (bookId < 1)
			throw new ServiceException("Book id is not correct.");
		return true;
	}

	public static boolean validateOrderInfo(int orderId) throws ServiceException {
		if (orderId < 1)
			throw new ServiceException("Order id is not correct.");
		return true;
	}

	public static boolean validateOrderInfo(int orderId, int bookId) throws ServiceException {
		if (orderId < 1)
			throw new ServiceException("Order id is not correct.");
		if (bookId < 1)
			throw new ServiceException("Book id is not correct.");
		return true;
	}

	public static boolean validateUserInfo(String name, String secondName, String login, String password)
			throws ServiceException {
		String regExp = "[A-Za-z0-9]{5-20}$";
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new ServiceException("Weak password.");
		}
		return true;
	}

	public static boolean validateUserInfo(int userId) throws ServiceException {
		if (userId < 1)
			throw new ServiceException("User id is not correct.");
		return true;
	}

}
