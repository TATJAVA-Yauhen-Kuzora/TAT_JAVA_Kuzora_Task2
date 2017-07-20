package com.epam.library.guicontroller;

import org.testng.annotations.Test;
import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.fail;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ControllerTest {
	private Controller controller;
	private static final String commandForLoggingAdmin = "Login|PIZDECLOGIN|12345";
	private static final String commandForLoggingSuper = "Login|super|12345";
	private static final String commandForLoggingUser = "Login|super1|1234";

	@BeforeMethod(groups = { "smoke", "methods", "exceptions", "positive", "negative" })
	public void beforeMethod() {
		controller = new Controller();
	}

	@AfterMethod(groups = { "smoke", "methods", "exceptions", "positive", "negative" })
	public void afterMethod() {
		controller = null;
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveLogin", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_login(String expected, String request) {
		User testUser;
		try {
			testUser = (User) controller.executeTask(request);
			Assert.assertEquals(expected, testUser.getLogin());
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeLogin", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_exception_execute_login(String expected, String request) throws CommandException {
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveRegistration", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_registration(String expected, String request) {
		User testUser;
		try {
			testUser = (User) controller.executeTask(request);
			Assert.assertEquals(expected, testUser.getLogin());
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeRegistration", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_registration(String expected, String request) throws CommandException {
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveUpdateUserInfo", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_updateUserInfo(String expected, String request) {
		User testUser;
		try {
			logInSystem(commandForLoggingUser);
			testUser = (User) controller.executeTask(request);
			if (testUser == null) {
				Assert.assertEquals(testUser, expected);
			} else {
				Assert.assertEquals(testUser.getLogin(), expected);
			}
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeUpdateUserInfo", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_updateUserInfo(String expected, String request) throws CommandException {
		logInSystem(commandForLoggingUser);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveChangeBookStatus", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_changeBookStatus(boolean expected, String request) {
		try {
			logInSystem(commandForLoggingAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeChangeBookStatus", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_changeBookStatus(String request) throws CommandException {
		logInSystem(commandForLoggingAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveOrderBook", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_orderBook(boolean expected, String request) {
		try {
			logInSystem(commandForLoggingAdmin);
			Assert.assertEquals(((boolean) controller.executeTask(request)), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeOrderBook", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_orderBook(String request) throws CommandException {
		logInSystem(commandForLoggingAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveConfirmOrder", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_confirmOrder(boolean expected, String request) {
		try {
			logInSystem(commandForLoggingAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeConfirmOrder", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_confirmOrder(String request) throws CommandException {
		logInSystem(commandForLoggingAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveReturnOrder", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_returnOrder(boolean expected, String request) {
		try {
			logInSystem(commandForLoggingAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeReturnOrder", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_returnOrder(String request) throws CommandException {
		logInSystem(commandForLoggingAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveBanAndPromoteUser", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_banUser(boolean expected, String request) {
		try {
			logInSystem(commandForLoggingSuper);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativebanUser", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_BanUser(String request) throws CommandException {
		logInSystem(commandForLoggingSuper);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveBanAndPromoteUser", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_unBanUser(boolean expected, String request) {
		try {
			logInSystem(commandForLoggingSuper);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeUnBanUser", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_unbanUser(String request) throws CommandException {
		logInSystem(commandForLoggingSuper);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveBanAndPromoteUser", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_GiveAdmin(boolean expected, String request) {
		try {
			logInSystem(commandForLoggingSuper);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeGiveAdmin", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_GiveAdmin(String request) throws CommandException {
		logInSystem(commandForLoggingSuper);
		controller.executeTask(request);
	}

	private void logInSystem(String logCommand) {
		try {
			controller.executeTask(logCommand);
		} catch (CommandException e) {
		}
	}
}
