package com.epam.library.dao.exception;

/**
 * Class {@link DAOException}.
 * <P>
 * Class DAOException - user exception class for {@link com.epam.library.dao}
 * layer, extends Exception Class and overloads 3 constructors with different
 * parameters.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.dao.exception}
 * package.</i>
 */
public class DAOException extends Exception {
	/**
	 * SerialVersionUID for object of {@link DAOException} Class.
	 */
	private static final long serialVersionUID = -8398923831597328506L;

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 * @param message
	 *            as info for creating user exception
	 */
	public DAOException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            as info for creating user exception
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 */
	public DAOException(Exception e) {
		super(e);
	}
}
