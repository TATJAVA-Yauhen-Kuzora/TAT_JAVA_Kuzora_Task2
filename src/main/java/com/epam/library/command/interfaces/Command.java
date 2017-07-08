package com.epam.library.command.interfaces;

import com.epam.library.command.exception.CommandException;

/**
 * @author Eugene13
 *
 */
public interface Command {
	Object execute(String... request) throws CommandException;
}
