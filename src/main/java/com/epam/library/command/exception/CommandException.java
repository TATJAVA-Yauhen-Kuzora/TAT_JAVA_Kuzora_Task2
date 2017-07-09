package com.epam.library.command.exception;

/**
 * Class {@link CommandException}.
 * <P>
 * Class CommandException - user exception class for
 * {@link com.epam.library.command} layer, extends Exception Class and overloads
 * 3 constructors with different parameters.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.exception}
 * package.</i>
 */
public class CommandException extends Exception {
	/**
	 * SerialVersionUID for object of {@link CommandException} Class.
	 */
	private static final long serialVersionUID = -3013341579430727192L;

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            as info for creating user exception
	 */
	public CommandException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 * @param message
	 *            as info for creating user exception
	 */
	public CommandException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 */
	public CommandException(Exception e) {
		super(e);
	}
}
