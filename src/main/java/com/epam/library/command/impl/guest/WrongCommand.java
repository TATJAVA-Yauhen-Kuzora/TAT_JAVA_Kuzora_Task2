/**
 * 
 */
package com.epam.library.command.impl.guest;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;

/**
 * @author Eugene13
 *
 */
public class WrongCommand implements Command {

	@Override
	public Object execute(String... request) throws CommandException {
		return null;
	}
}
