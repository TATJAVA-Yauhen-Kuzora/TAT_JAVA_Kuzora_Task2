package com.epam.library.command.impl.guest;

import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;

/**
 * Class {@link WrongCommand}.
 * <P>
 * Class WrongCommand implements {@link Command} interface for returning null as
 * result of calling wrong command.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.impl.guest}
 * package.</i>
 */
public class WrongCommand implements Command {
	/**
	 * Method execute for wrong command.
	 * 
	 * @return null
	 */
	@Override
	public Object execute(String... request) throws CommandException {
		return null;
	}
}
