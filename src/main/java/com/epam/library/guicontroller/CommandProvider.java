/**
 * 
 */
package com.epam.library.guicontroller;

import java.util.HashMap;
import java.util.Map;

import com.epam.library.beans.AccessLevel;
import com.epam.library.command.impl.guest.*;
import com.epam.library.command.impl.user.*;
import com.epam.library.command.exception.CommandException;
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
		//
		// гость
		guestCommands.put(CommandName.LOGIN, new Login());
		guestCommands.put(CommandName.REGISTRATION, new Registration());
		guestCommands.put(CommandName.VIEW_ALL_BOOKS, new ViewAllBooks());
		//
		// пользователь
		userCommands.put(CommandName.LOGOUT, new Logout());
		userCommands.put(CommandName.UPDATE_USER_INFO, new UpdateInfo());
		userCommands.put(CommandName.VIEW_ALL_BOOKS, new ViewAllBooks());
		userCommands.put(CommandName.VIEW_ALL_ORDERS, new ViewAllOrders());
		userCommands.put(CommandName.CHANGE_STATUS_BOOK_FOR_BOOKING, new ChangeBookStatus());
		userCommands.put(CommandName.ORDER_BOOK, new OrderBook());
		//
		// admin
		adminCommands.putAll(userCommands);
		adminCommands.put(CommandName.VIEW_ALL_USERS, new ViewAllUsers());
		adminCommands.put(CommandName.CHANGE_BOOK_STATUS, new ChangeBookStatus());
		adminCommands.put(CommandName.CONFIRM_ORDER, new SendOrder());
		adminCommands.put(CommandName.RETURN_ORDER, new ReturnOrder());
		adminCommands.put(CommandName.BAN_USER, new BanUser());
		adminCommands.put(CommandName.UNBAN_USER, new UnBanUser());
		adminCommands.put(CommandName.ADD_BOOK, new AddBook());
		//
		// superadmin
		superAdminCommands.putAll(adminCommands);
		superAdminCommands.put(CommandName.GIVE_ADMIN, new GiveAdminForUser());
	}

	public static CommandProvider getInstance() {
		return instance;
	}

	public Command getCommand(int level, String stringCommand) throws CommandException {
		String com = stringCommand.replace("-", "_").toUpperCase();
		Command command;
		CommandName name = null;
		try {
			name = CommandName.valueOf(com);
			switch (level) {
			case 1:
				command = guestCommands.get(name);
				break;
			case 2:
				command = userCommands.get(name);
				break;
			case 3:
				command = adminCommands.get(name);
				break;
			case 4:
				command = superAdminCommands.get(name);
				break;
			default:
				command = guestCommands.get(name);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			throw new CommandException(e.getMessage(), e);
		}
		if (command == null)
			throw new CommandException("Illigal command for curent user.");
		return command;
	}
}
