package org.accountbook.domain;

import static org.junit.Assert.*;

import org.accountbook.domain.model.Category;
import org.accountbook.domain.model.Expense;
import org.accountbook.domain.model.User;
import org.junit.Test;

/**
 * Expense test class.
 * 
 * @author marc
 * @since 1.0
 */
public class ExpenseTest {
	
	@Test
	public void testExpenseCreation() throws Exception {
		Category category = new Category(0.4);
		
		Expense expense = new Expense();
		expense.setAmount(10.0);
		expense.setCategory(category);
		
		assertEquals("bookable amount should match", new Double(4.0), expense.getBookableAmount());
	}
	
	@Test
	public void testExpenseClearance() throws Exception {
		Category category = new Category(0.5);
		User marc = new User("marc");
		
		Expense expense = new Expense();
		expense.setAmount(20.1);
		expense.setCategory(category);
		
		marc.addExpense(expense);
		
		assertFalse("expense should not be cleared", expense.isCleared());
		expense.clearExpensesForUser(marc);
		assertTrue("expense should be cleared", expense.isCleared());
	}
}
