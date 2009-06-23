package org.accountbook.repository.hibernate;

import java.util.List;

import org.accountbook.domain.model.Expense;
import org.accountbook.domain.model.User;

/**
 * Repository for Expense persistence handling.
 * 
 * @author marc
 * @since 1.0.0
 */
public interface ExpenseRepository extends Repository<Expense> {

	/**
	 * Finds a list of expenses by given user.
	 * 
	 * @param user a user.
	 * @return a list of expenses.
	 */
	List<Expense> findByUser(User user);

	
}
