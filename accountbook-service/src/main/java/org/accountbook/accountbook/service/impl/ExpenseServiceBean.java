package org.accountbook.accountbook.service.impl;

import java.util.List;

import org.accountbook.accountbook.service.ExpenseService;
import org.accountbook.domain.model.Expense;
import org.accountbook.domain.model.User;
import org.accountbook.repository.hibernate.ExpenseRepository;
import org.accountbook.repository.hibernate.UserRepository;
import org.apache.commons.lang.Validate;

/**
 * Expense service default implementation.
 * 
 * @author marc
 * @since 1.0.0
 */
public class ExpenseServiceBean implements ExpenseService {

	private ExpenseRepository expenseRepository;
	
	private UserRepository userRepository;
	
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

	/**
	 * @see org.accountbook.accountbook.service.ExpenseService#createExpenseForUserName(java.lang.Double, java.lang.String)
	 */
	public Expense createExpenseForUserName(Double amount, String name) {
		Validate.notNull(name, "user name should not be null");
		Validate.notNull(amount, "amount should not be null");
		
		User user = new User(name);
		List<User> users = userRepository.findByExample(user);
		
		if (users.isEmpty()) {
			return createExpenseForUser(amount, user);
		} else {
			return createExpenseForUser(amount, users.get(0));
		}
	}
	
	/**
	 * @see org.accountbook.accountbook.service.ExpenseService#getAllExpensesForUser(org.accountbook.domain.model.User)
	 */
	public List<Expense> getAllExpensesForUser(User user) {
		return expenseRepository.findByUser(user);
	}

	/**
	 * @see org.accountbook.accountbook.service.ExpenseService#getAllExpenses()
	 */
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	public void setExpenseRepository(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	
}
