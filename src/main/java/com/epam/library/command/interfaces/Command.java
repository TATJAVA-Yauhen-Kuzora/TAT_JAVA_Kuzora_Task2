package com.epam.library.command.interfaces;

import com.epam.library.command.exception.CommandException;

/**
 * Interface {@link Command}.
 * <P>
 * Interface Command includes method {@link #execute(String...)}
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.command.interfaces}
 * package.</i>
 */
public interface Command {
	Object execute(String... request) throws CommandException;
}
