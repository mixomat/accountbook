package org.accountbook.domain.model;

import java.util.Set;

import org.accountbook.domain.BaseEntity;
import org.accountbook.domain.Entity;

/**
 * Expenses ...
 * 
 * @author marc
 */
public class Expense extends BaseEntity<Expense> implements Entity<Expense>{
	
	private Long id;

	private Double amount;

	private boolean cleared;

	private String description;

	private Category category;

	private User user;
	
	/**
	 * @see org.accountbook.domain.BaseEntity#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}
	
	/**
	 * @see org.accountbook.domain.BaseEntity#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
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
		Set<Expense> expenses = user.getExpenses();
		for (Expense expense : expenses) {
			expense.clear();
		}
	}

	// @Transient
	private void clear() {
		setCleared(true);
	}

	@Override
	public String toString() {
		return String
				.format(
						"Expense [amount=%s, category=%s, cleared=%s, description=%s, id=%s]",
						amount, category, cleared, description, id);
	}
	
	
}
