package org.accountbook.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Account book user
 *  
 * @author marc
 */
public class User {
	private String name;
	private String description;
	private List<Expense> expenses = new ArrayList<Expense>();

	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	// @Transient
	public void addExpense(Expense expense) {
		expense.setUser(this);
		expenses.add(expense);
	}
}
