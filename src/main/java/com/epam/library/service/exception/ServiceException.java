package com.epam.library.service.exception;

/**
 * Class {@link ServiceException}.
 * <P>
 * Class ServiceException - user exception class for
 * {@link com.epam.library.service} layer, extends Exception Class and overloads
 * 3 constructors with different parameters.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.service.exception}
 * package.</i>
 */
public class ServiceException extends Exception {
	/**
	 * SerialVersionUID for object of {@link ServiceException} Class.
	 */
	private static final long serialVersionUID = 1499677754326455467L;

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 * @param message
	 *            as info for creating user exception
	 */
	public ServiceException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            as info for creating user exception
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 */
	public ServiceException(Exception e) {
		super(e);
	}
}
