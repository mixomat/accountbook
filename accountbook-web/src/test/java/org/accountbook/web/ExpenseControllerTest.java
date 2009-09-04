package org.accountbook.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ModelMap;

public class ExpenseControllerTest {

	private ExpenseController accountbookController = new ExpenseController();
	
	@Test
	public void testExpenses() throws Exception {
		ModelMap modelMap = new ModelMap();

//		assertEquals("view name should match", "expense", accountbookController.expenses(modelMap));
	}
}