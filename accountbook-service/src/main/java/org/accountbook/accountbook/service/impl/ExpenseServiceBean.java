/**
 * 
 */
package org.accountbook.accountbook.service.impl;

import org.accountbook.accountbook.service.ExpenseService;
import org.accountbook.domain.model.Expense;
import org.accountbook.domain.model.User;
import org.accountbook.repository.hibernate.ExpenseRepository;
import org.apache.commons.lang.Validate;

/**
 * Expense service default implementation.
 * 
 * @author marc
 * @since 1.0.0
 */
public class ExpenseServiceBean implements ExpenseService {

	ExpenseRepository expenseRepository;
	
	/**
	 * @see org.accountbook.accountbook.service.ExpenseService#createExpenseForUser(org.accountbook.domain.model.User)
	 */
	public Expense createExpenseForUser(Double amount, User user) {
		Validate.notNull(user, "user should not be null");
		Validate.notNull(amount, "amount should not be null");
		
		Expense expense = new Expense();
		expense.setAmount(amount);
		expense.setUser(user);
		
		expenseRepository.save(expense);
		return expense;
	}

	public void setExpenseRepository(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
}
