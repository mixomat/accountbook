package org.accountbook.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ModelMap;

public class AccountbookControllerTest {

	private AccountbookController accountbookController = new AccountbookController();
	
	@Test
	public void testAccount() throws Exception {
		ModelMap modelMap = new ModelMap();

		assertEquals("view name should match", "account", accountbookController.account(modelMap));
		assertEquals("account name", modelMap.get("name"));
	}
}
