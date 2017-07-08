package com.epam.library.command.interfaces;

import com.epam.library.command.exception.CommandException;

/**
 * Interface {@link Command}.
 * <P>
 * Interface Command includes method {@link #execute(String...)}.
 * <P>
 * <i>This interface is a member of the
 * {@link com.epam.library.command.interfaces} package.</i>
 */
public interface Command {
	/**
	 * Method execute.
	 * 
	 * @param request
	 *            as array of String's element's for all commands
	 * @return object of Object Class
	 * @throws CommandException
	 *             Exception type for command layer
	 */
	Object execute(String... request) throws CommandException;
}
