/**
 * 
 */
package com.epam.library.guicontroller;

import java.util.HashMap;
import java.util.Map;

import com.epam.library.beans.AccessLevel;
import com.epam.library.command.impl.guest.*;
import com.epam.library.command.impl.user.*;
import com.epam.library.command.impl.admin.*;
import com.epam.library.command.impl.superAdmin.*;
import com.epam.library.command.interfaces.Command;

/**
 * @author Eugene13
 *
 */
public class CommandProvider {
	private Map<CommandName, Command> guestCommands = new HashMap<>();
	private Map<CommandName, Command> userCommands = new HashMap<>();
	private Map<CommandName, Command> adminCommands = new HashMap<>();
	private Map<CommandName, Command> superAdminCommands = new HashMap<>();

	private static final CommandProvider instance = new CommandProvider();

	private CommandProvider() {
		// гость
		guestCommands.put(CommandName.LOGIN, new Login());
		// пользователь
		userCommands.put(CommandName.LOGOUT, new Logout());
		// admin
		adminCommands.putAll(userCommands);
		// superadmin
		superAdminCommands.putAll(adminCommands);
	}

	static CommandProvider getInstance() {
		return instance;
	}

	Command getCommand(int level, String stringCommand) {
		String com = stringCommand.replace("-", "_").toUpperCase();
		Command command;
		CommandName name = null;
		try {
			name = CommandName.valueOf(com);
			switch (level) {
			case 1:
				return guestCommands.get(name);
			case 2:
				return userCommands.get(name);
			case 3:
				return adminCommands.get(name);
			case 4:
				return superAdminCommands.get(name);
			default:
				return guestCommands.get(name);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			command = new WrongCommand();
		}
		return command;
	}
}
