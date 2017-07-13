package com.epam.library.guicontroller;

import java.util.HashMap;
import java.util.Map;
import com.epam.library.command.impl.guest.*;
import com.epam.library.command.impl.user.*;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.impl.admin.*;
import com.epam.library.command.impl.superAdmin.*;
import com.epam.library.command.interfaces.Command;

/**
 * Class {@link CommandProvider}.
 * <P>
 * Class CommandProvider includes 1 method {@link #getCommand(int, String)}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.guicontroller}
 * package.</i>
 */
public class CommandProvider {
	private static final String ILLEGAL_COMMAND = "Illegal command for current user.";
	private Map<CommandName, Command> guestCommands = new HashMap<>();
	private Map<CommandName, Command> userCommands = new HashMap<>();
	private Map<CommandName, Command> adminCommands = new HashMap<>();
	private Map<CommandName, Command> superAdminCommands = new HashMap<>();
	private static final CommandProvider instance = new CommandProvider();

	private CommandProvider() {
		//
		// Guest or banned user
		guestCommands.put(CommandName.LOGIN, new Login());
		guestCommands.put(CommandName.REGISTRATION, new Registration());
		guestCommands.put(CommandName.VIEW_ALL_BOOKS, new ViewAllBooks());
		//
		// User
		userCommands.put(CommandName.LOGOUT, new Logout());
		userCommands.put(CommandName.UPDATE_USER_INFO, new UpdateInfo());
		userCommands.put(CommandName.VIEW_ALL_BOOKS, new ViewAllBooks());
		userCommands.put(CommandName.VIEW_ALL_ORDERS, new ViewAllOrders());
		userCommands.put(CommandName.ORDER_BOOK, new OrderBook());
		//
		// Admin
		adminCommands.putAll(userCommands);
		adminCommands.put(CommandName.VIEW_ALL_USERS, new ViewAllUsers());
		adminCommands.put(CommandName.CHANGE_BOOK_STATUS, new ChangeBookStatus());
		adminCommands.put(CommandName.CONFIRM_ORDER, new SendOrder());
		adminCommands.put(CommandName.RETURN_ORDER, new ReturnOrder());
		adminCommands.put(CommandName.BAN_USER, new BanUser());
		adminCommands.put(CommandName.UNBAN_USER, new UnBanUser());
		adminCommands.put(CommandName.ADD_BOOK, new AddBook());
		//
		// SuperAdmin
		superAdminCommands.putAll(adminCommands);
		superAdminCommands.put(CommandName.GIVE_ADMIN, new GiveAdminForUser());
	}

	public static CommandProvider getInstance() {
		return instance;
	}

	/**
	 * Method getCommand returns object of {@link Command} type.
	 * 
	 * @param userLevel
	 *            id of user access level
	 * @param stringCommand
	 *            commnd name in String presentation
	 * @return object of {@link Command} type
	 * @throws CommandException
	 *             Exception type for controller layer
	 */
	public Command getCommand(int userLevel, String stringCommand) throws CommandException {
		String com = stringCommand.replace("-", "_").toUpperCase();
		Command command;
		CommandName name = null;
		try {
			name = CommandName.valueOf(com);
			switch (userLevel) {
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
			throw new CommandException(ILLEGAL_COMMAND);
		return command;
	}
}
