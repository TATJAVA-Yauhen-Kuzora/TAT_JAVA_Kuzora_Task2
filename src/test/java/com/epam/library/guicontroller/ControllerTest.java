package com.epam.library.guicontroller;

import org.testng.annotations.Test;
import com.epam.library.bean.AccessLevel;
import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ControllerTest {
	private Controller controller;
	private final static int userStatusUser = 2;
	private static final int userStatusAdmin = 3;
	private static final int userStatusSuperAdmin = 4;

	@BeforeMethod(groups = { "smoke", "methods", "exceptions", "positive", "negative" })
	public void beforeMethod() {
		controller = new Controller();
	}

	@AfterMethod(groups = { "smoke", "methods", "exceptions", "positive", "negative" })
	public void afterMethod() {
		Controller.sessionUser = null;
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
			setChosenAccessLevelToUser(userStatusUser);
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
		setChosenAccessLevelToUser(userStatusUser);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveChangeBookStatus", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_changeBookStatus(boolean expected, String request) {
		try {
			setChosenAccessLevelToUser(userStatusAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeChangeBookStatus", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_changeBookStatus(String request) throws CommandException {
		setChosenAccessLevelToUser(userStatusAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveOrderBook", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_orderBook(boolean expected, String request) {
		try {
			setChosenAccessLevelToUser(userStatusAdmin);
			Assert.assertEquals(((boolean) controller.executeTask(request)), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeOrderBook", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_orderBook(String request) throws CommandException {
		setChosenAccessLevelToUser(userStatusAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveConfirmOrder", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_confirmOrder(boolean expected, String request) {
		try {
			setChosenAccessLevelToUser(userStatusAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeConfirmOrder", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_confirmOrder(String request) throws CommandException {
		setChosenAccessLevelToUser(userStatusAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveReturnOrder", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_returnOrder(boolean expected, String request) {
		try {
			setChosenAccessLevelToUser(userStatusAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeReturnOrder", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_returnOrder(String request) throws CommandException {
		setChosenAccessLevelToUser(userStatusAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveBanAndPromoteUser", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_banUser(boolean expected, String request) {
		try {
			setChosenAccessLevelToUser(userStatusSuperAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativebanUser", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_BanUser(String request) throws CommandException {
		setChosenAccessLevelToUser(userStatusSuperAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveBanAndPromoteUser", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_unBanUser(boolean expected, String request) {
		try {
			setChosenAccessLevelToUser(userStatusSuperAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeUnBanUser", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_unbanUser(String request) throws CommandException {
		setChosenAccessLevelToUser(userStatusSuperAdmin);
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"positive" }, dataProvider = "positiveBanAndPromoteUser", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_GiveAdmin(boolean expected, String request) {
		try {
			setChosenAccessLevelToUser(userStatusSuperAdmin);
			Assert.assertEquals((boolean) controller.executeTask(request), expected);
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke", "exceptions",
			"negative" }, dataProvider = "negativeGiveAdmin", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_method_exception_GiveAdmin(String request) throws CommandException {
		setChosenAccessLevelToUser(userStatusSuperAdmin);
		controller.executeTask(request);
	}

	private void setChosenAccessLevelToUser(int accessId) {
		AccessLevel testAccessLevel = new AccessLevel();
		testAccessLevel.setAccessLevelId(accessId);
		Controller.sessionUser = new User();
		Controller.sessionUser.setAccessLevel(testAccessLevel);
	}
}
