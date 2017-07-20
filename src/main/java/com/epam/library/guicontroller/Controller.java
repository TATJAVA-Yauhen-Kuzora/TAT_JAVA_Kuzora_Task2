package com.epam.library.guicontroller;

import java.util.ArrayList;
import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.impl.guest.WrongCommand;
import com.epam.library.command.interfaces.Command;

public class Controller {
	User sessionUser;
	static final int bookStatusAvailable = 1;
	static final int orderStatusBooked = 1;
	static final int orderStatusOnHands = 2;
	static final int userStatusBanned = 1;
	static final int userStatusUser = 2;
	static final int userStatusAdmin = 3;
	static final int userStatusSuperAdmin = 4;
	static final int minimalCountsParamInRequest = 1;
	static final CommandProvider commandProvider = CommandProvider.getInstance();

	public Object executeTask(String request) throws CommandException {
		String commandName;
		Command executionCommand;
		int accessLevelId;
		ArrayList<String> requestAfterParse = CommandParser.getInstance().parse(request);
		if (requestAfterParse.size() < minimalCountsParamInRequest) {
			return new WrongCommand().execute(request);
		}
		commandName = requestAfterParse.get(0);
		requestAfterParse.remove(0);
		if (sessionUser == null) {
			accessLevelId = userStatusBanned;
		} else {
			accessLevelId = sessionUser.getAccessLevel().getAccessLevelId();
		}
		executionCommand = commandProvider.getCommand(accessLevelId, commandName);
		String[] stringsArray = new String[requestAfterParse.size()];
		stringsArray = requestAfterParse.toArray(stringsArray);
		Object resultOfExecuting = executionCommand.execute(stringsArray);
		try {
			sessionUser = (User) resultOfExecuting;
		} catch (Exception e) {
		}
		return resultOfExecuting;
	}
}
