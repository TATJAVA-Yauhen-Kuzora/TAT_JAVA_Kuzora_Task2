package com.epam.library.guicontroller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class {@link CommandParser}.
 * <P>
 * Class CommandParser includes 1 method ({@link #parse(String)}) for parsing
 * String request on words for commands.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.guicontroller}
 * package.</i>
 */
class CommandParser {
	private static final String regExp = "[0-9A-Za-z-_.,]+";
	private static final CommandParser instance = new CommandParser();

	private CommandParser() {
	}

	/**
	 * Method parse parses String request on String array.
	 * 
	 * @param request
	 *            user String request
	 * @return ArrayList<{@link String}>
	 */
	ArrayList<String> parse(String request) {
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(request);
		ArrayList<String> arrayList = new ArrayList<>();
		while (matcher.find()) {
			arrayList.add(matcher.group());
		}
		return arrayList;
	}

	static CommandParser getInstance() {
		return instance;
	}
}
