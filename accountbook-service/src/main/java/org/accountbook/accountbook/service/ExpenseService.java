/**
 * 
 */
package org.accountbook.accountbook.service;

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
	Expense createExpenseForUser(User user);

}
