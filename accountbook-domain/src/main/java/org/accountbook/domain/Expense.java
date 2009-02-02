package org.accountbook.domain;

import java.util.List;

/**
 * Expenses ...
 * 
 * @author marc
 */
public class Expense {
	private Double amount;

	private boolean cleared;

	private String description;

	private Category category;

	private User user;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// @Transient
	public Double getBookableAmount() {
		assert category != null;
		return category.calculatePercentage(amount);
	}

	// @Transient
	public void clearExpensesForUser(User user) {
		List<Expense> expenses = user.getExpenses();
		for (Expense expense : expenses) {
			expense.clear();
		}
	}

	// @Transient
	private void clear() {
		setCleared(true);
	}
}
