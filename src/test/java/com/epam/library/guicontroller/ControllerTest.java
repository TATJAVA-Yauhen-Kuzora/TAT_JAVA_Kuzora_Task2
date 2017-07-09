package com.epam.library.guicontroller;

import org.testng.annotations.Test;

import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import org.testng.annotations.AfterMethod;

public class ControllerTest {
	private Controller controller;

	@BeforeMethod(groups = { "smoke", "methods", "exceptions" })
	public void beforeMethod() {
		controller = new Controller();
	}

	@AfterMethod(groups = { "smoke", "methods", "exceptions" })
	public void afterMethod() {
		controller = null;
	}

	@Test(groups = { "smoke",
			"methods" }, dataProvider = "positiveLogin", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_login(String expected, String request) {
		User testUser;
		try {
			testUser = (User) controller.executeTask(request);
			Assert.assertEquals(expected, testUser.getLogin());
		} catch (CommandException e) {
			fail();
		}
	}

	@Test(groups = { "smoke",
			"exceptions" }, dataProvider = "negativeLogin", dataProviderClass = DataProviderControllerTest.class, expectedExceptions = CommandException.class)
	public void tst_exception_execute_login(String expected, String request) throws CommandException {
		controller.executeTask(request);
	}

	@Test(groups = { "smoke", "methods",
			"exceptions" }, dataProvider = "positiveRegistration", dataProviderClass = DataProviderControllerTest.class)
	public void tst_method_execute_registration(String expected, String request) {
		User testUser;
		try {
			testUser = (User) controller.executeTask(request);
			Assert.assertEquals(expected, testUser.getLogin());
		} catch (CommandException e) {
			fail();
		}
	}
}
