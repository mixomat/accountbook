package org.accountbook.accountbook.service;

import java.util.List;

import org.accountbook.domain.model.Expense;
import org.accountbook.domain.model.User;

/**
 * Service for Expense handling.
 * 
 * @author marc
 * @since 1.0.0
 */
public interface ExpenseService {

	/**
	 * Creates a new expense entity for the given user.
	 * 
	 * @param user
	 *            the associated user for the newly created expense
	 */
	Expense createExpenseForUser(Double amount, User user);
	
	/**
	 * Creates a new expense entity for the given user with name.
	 * 
	 * @param amount the expense amount
	 * @param name the user name
	 */
	Expense createExpenseForUserName(Double amount, String name);

	/**
	 * Retrieves a list of expenses for a given user.
	 * 
	 * @param user
	 *            a user entity.
	 * @return a list of expenses for the given user.
	 */
	List<Expense> getAllExpensesForUser(User user);

	/**
	 * Retrieves all expenses.
	 * 
	 * @return a list of all expenses.
	 */
	List<Expense> getAllExpenses();

}
