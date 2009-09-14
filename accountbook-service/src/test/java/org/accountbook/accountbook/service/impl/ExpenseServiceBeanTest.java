package org.accountbook.accountbook.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.accountbook.domain.model.Expense;
import org.accountbook.domain.model.User;
import org.accountbook.repository.hibernate.ExpenseRepository;
import org.accountbook.repository.hibernate.UserRepository;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for expense service.
 * 
 * @author marc
 * @since 1.0.0
 */
public class ExpenseServiceBeanTest {
	
	private ExpenseServiceBean expenseService = new ExpenseServiceBean();
	private ExpenseRepository expenseRepositoryMock = mock(ExpenseRepository.class);
	private UserRepository userRepositoryMock = mock(UserRepository.class);
	
	@Before
	public void setup() {
		expenseService.setExpenseRepository(expenseRepositoryMock);
		expenseService.setUserRepository(userRepositoryMock);
	}

	@Test
	public void testCreateExpenseForUser() throws Exception {
		User user = new User("marc");
		Expense expense = expenseService.createExpenseForUser(13.49,user);
		
		assertNotNull("expense should not be null", expense);
		assertNotNull("expense should be in persisted state", expense.getUser());
		assertEquals("user name should match", "marc", expense.getUser().getName());
		assertEquals("expense amount should match", new Double(13.49)	,expense.getAmount());
	}
	
	@Test
	public void testCreateExpenseForUserName() throws Exception {
		
		List<User> userList = new ArrayList<User>();
		User testUser = new User("test-user");
		userList.add(testUser);
		
		when(userRepositoryMock.findByExample(testUser)).thenReturn(userList);
		
		Expense expense = expenseService.createExpenseForUserName(23.09, "test-user");
		
		assertNotNull(expense);
	}
	
	@Test
	public void testGetAllExpenses() throws Exception {
		
		List<Expense> testExpenses = new ArrayList<Expense>();
		testExpenses.add(new Expense());
		when(expenseRepositoryMock.findAll()).thenReturn(testExpenses);
		
		List<Expense> expenses = expenseService.getAllExpenses();
		
		assertNotNull(expenses);
		assertEquals(1, expenses.size());
	}
}
