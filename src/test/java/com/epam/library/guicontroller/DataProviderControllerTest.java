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

	@DataProvider
	public Object[][] negativeRegistration() { //
		return new Object[][] { //
				new Object[] { "testLogin11", "Registion|name|secondName|testLogin11|12345" }, // wrong
																								// command
				new Object[] { "testLogin111", "Registration|name|secondName|testLogin111" }, // wrong
				// count
				// of
				// args
				new Object[] { "super", "Registration|Eugene|Kuzora|super|12345" }, // try
																					// to
																					// add
																					// login
																					// that
																					// already
																					// exist
		};
	}

	@DataProvider
	public Object[][] positiveUpdateUserInfo() { //
		return new Object[][] { //
				new Object[] { "testLogin2", "Update_user_info|name|secondName|testLogin2|12" }, //
		};
	}
}
