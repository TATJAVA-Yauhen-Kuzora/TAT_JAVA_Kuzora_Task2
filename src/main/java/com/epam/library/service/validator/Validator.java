package com.epam.library.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.epam.library.service.exception.ServiceException;

/**
 * Class {@link Validator}.
 * <P>
 * Class Validator includes 7 methods ({@link #validateBookInfo(int, int)},
 * {@link #validateBookInfo(String, String, int)},
 * {@link #validateOrderInfo(int)}, {@link #validateOrderInfo(int, int)},
 * {@link #validateOrderInfoForAdding(int, int)},
 * {@link #validateUserInfo(int)},
 * {@link #validateUserInfo(String, String, String, String)}).
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.service.validator}
 * package.</i>
 */
public class Validator {
	/**
	 * Method validateBookInfo checks bookStatusAvailiable and bookId.
	 * 
	 * @return true if all checks are passed.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	public static boolean validateBookInfo(int bookStatusAvailiable, int bookId) throws ServiceException {
		if (bookStatusAvailiable < 1 && bookStatusAvailiable > 2)
			throw new ServiceException("Book availiable status id is not correct.");
		if (bookId < 1)
			throw new ServiceException("Book id is not correct.");
		return true;
	}

	/**
	 * Method validateBookInfo checks bookStatusAvailiable.
	 * 
	 * @return true if all checks are passed.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	public static boolean validateBookInfo(String bookName, String author, int bookStatusId) throws ServiceException {
		if (bookStatusId < 1 && bookStatusId > 2)
			throw new ServiceException("Book availiable status id is not correct.");
		return true;
	}

	/**
	 * Method validateOrderInfoForAdding checks userId and bookId.
	 * 
	 * @return true if all checks are passed.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	public static boolean validateOrderInfoForAdding(int userId, int bookId) throws ServiceException {
		if (userId < 1)
			throw new ServiceException("User id is not correct.");
		if (bookId < 1)
			throw new ServiceException("Book id is not correct.");
		return true;
	}

	/**
	 * Method validateOrderInfo checks orderId.
	 * 
	 * @return true if all checks are passed.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	public static boolean validateOrderInfo(int orderId) throws ServiceException {
		if (orderId < 1)
			throw new ServiceException("Order id is not correct.");
		return true;
	}

	/**
	 * Method validateOrderInfo checks orderId.
	 * 
	 * @return true if all checks are passed.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	public static boolean validateOrderInfo(int orderId, int bookId) throws ServiceException {
		if (orderId < 1)
			throw new ServiceException("Order id is not correct.");
		if (bookId < 1)
			throw new ServiceException("Book id is not correct.");
		return true;
	}

	/**
	 * Method validateUserInfo checks password.
	 * 
	 * @return true if all checks are passed.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	public static boolean validateUserInfo(String name, String secondName, String login, String password)
			throws ServiceException {
		String regExp = "[A-Za-z0-9]{5,20}$";
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new ServiceException("Weak password.");
		}
		return true;
	}

	/**
	 * Method validateUserInfo checks userId.
	 * 
	 * @return true if all checks are passed.
	 * @throws ServiceException
	 *             Exception type for service layer
	 */
	public static boolean validateUserInfo(int userId) throws ServiceException {
		if (userId < 1)
			throw new ServiceException("User id is not correct.");
		return true;
	}
}
