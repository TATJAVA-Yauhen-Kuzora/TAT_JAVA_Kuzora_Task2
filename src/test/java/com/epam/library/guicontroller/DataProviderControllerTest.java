package com.epam.library.guicontroller;

import org.testng.annotations.DataProvider;

public class DataProviderControllerTest {
	@DataProvider
	public Object[][] positiveLogin() { //
		return new Object[][] { //
				new Object[] { "super", "Login|super|12345" }, //
		};
	}

	@DataProvider
	public Object[][] negativeLogin() { //
		return new Object[][] { //
				new Object[] { "super", "Login|super|123" }, // wrong password
				new Object[] { "super", "Logn|super|12345" }, // wrong command
				new Object[] { "super", "Logn|super" }, // wrong count of
														// arguments
		};
	}

	@DataProvider
	public Object[][] positiveRegistration() { //
		return new Object[][] { //
				new Object[] { "testLogin", "Registration|name|secondName|testLogin|12345" }, //
		};
	}
}
