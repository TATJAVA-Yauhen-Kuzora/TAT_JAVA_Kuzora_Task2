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
				new Object[] { "super", "Login|super|123" }, //
				new Object[] { "super", "Logn|super|12345" }, //
				new Object[] { "super", "Logn|super" }, //
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
				new Object[] { "testLogin11", "Registion|name|secondName|testLogin11|12345" }, //
				new Object[] { "testLogin111", "Registration|name|secondName|testLogin111" }, //
				// count
				// of
				// args
				new Object[] { "super", "Registration|Eugene|Kuzora|super|12345" }, };
	}

	@DataProvider
	public Object[][] positiveUpdateUserInfo() { //
		return new Object[][] { //
				new Object[] { "super1", "Update_user_info|super1|super1|super1|14|1234" }, //
				new Object[] { null, "Update_user_info|name|secondName|testLogin2|12|11" }, //
		};
	}

	@DataProvider
	public Object[][] negativeUpdateUserInfo() { //
		return new Object[][] { //
				new Object[] { "testLogin3", "Update_user5inf4|name|secondName|testLogin4|12" }, //
				new Object[] { "testLogin3", "Update_user_info|name|secondName|12" }, //
				new Object[] { "testLogin3", "Update_user_info|name|secondName|testLogin4|%12.54|43" }, //
		};
	}

	@DataProvider
	public Object[][] positiveChangeBookStatus() { //
		return new Object[][] { //
				new Object[] { true, "Change_book_status|1|3" }, //
				new Object[] { true, "Change_book_status|2|3" }, //
		};
	}

	@DataProvider
	public Object[][] negativeChangeBookStatus() { //
		return new Object[][] { //
				new Object[] { "Change_book_stat|2|1" }, //
				new Object[] { "Change_book_status|1" }, //
				new Object[] { "Change_book_status|2|2.6" }, //
		};
	}

	@DataProvider
	public Object[][] positiveOrderBook() { //
		return new Object[][] { //
				new Object[] { true, "Order_book|7|1" }, //
				new Object[] { false, "Order_book|7|1" }, //
		};
	}

	@DataProvider
	public Object[][] negativeOrderBook() { //
		return new Object[][] { //
				new Object[] { "Order_boo|7|2" }, //
				new Object[] { "Order_book|7|10.5" }, //
		};
	}

	@DataProvider
	public Object[][] positiveConfirmOrder() { //
		return new Object[][] { //
				new Object[] { true, "CONFIRM_ORDER|62" }, //
				new Object[] { false, "CONFIRM_ORDER|61" }, //
		};
	}

	@DataProvider
	public Object[][] negativeConfirmOrder() { //
		return new Object[][] { // 
				new Object[] { "CONFIRM_ORD|48" }, //
		};
	}

	@DataProvider
	public Object[][] positiveReturnOrder() { //
		return new Object[][] { //
				new Object[] { true, "Return_ORDER|66|4" }, //
		};
	}

	@DataProvider
	public Object[][] negativeReturnOrder() { //
		return new Object[][] { // F
				new Object[] { "Return_ORDER|48" }, //
				new Object[] { "Return_ORDER|48.442" }, //
		};
	}

	@DataProvider
	public Object[][] positiveBanAndPromoteUser() { //
		return new Object[][] { //
				new Object[] { true, "Ban_user|9" }, //
				new Object[] { false, "Ban_user|7" }, // super
				new Object[] { true, "UNBAN_USER|9" }, //
				new Object[] { false, "UNBAN_USER|7" }, // super
				new Object[] { true, "GIVE_ADMIN|9" }, //
				new Object[] { false, "GIVE_ADMIN|7" }, // super
		};
	}

	@DataProvider
	public Object[][] negativebanUser() { //
		return new Object[][] { // F
				new Object[] { "Ban_user|9.5" }, //
				new Object[] { "Return_ORDER|48.442" }, //
		};
	}

	// @DataProvider
	// public Object[][] positiveUnBanUser() { //
	// return new Object[][] { //
	// new Object[] { true, "UNBAN_USER|9" }, //
	// new Object[] { false, "UNBAN_USER|7" }, // super
	// };
	// }

	@DataProvider
	public Object[][] negativeUnBanUser() { //
		return new Object[][] { // F
				new Object[] { "UNBAN_USER|9.5" }, //
				new Object[] { "UNBAN_USE|10" }, //
		};
	}

	// @DataProvider
	// public Object[][] positiveGiveAdmin() { //
	// return new Object[][] { //
	// new Object[] { true, "Ban_user|9" }, //
	// new Object[] { true, "GIVE_ADMIN|9" }, //
	// new Object[] { false, "GIVE_ADMIN|7" }, // super
	// };
	// }

	@DataProvider
	public Object[][] negativeGiveAdmin() { //
		return new Object[][] { // F
				new Object[] { "GIVE_ADMIN|9.5" }, //
				new Object[] { "GIVE_ADN|9.5" }, //
		};
	}
}
