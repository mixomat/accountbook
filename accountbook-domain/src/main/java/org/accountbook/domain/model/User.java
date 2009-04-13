package org.accountbook.domain.model;

import java.util.HashSet;
import java.util.Set;

import org.accountbook.domain.BaseEntity;
import org.accountbook.domain.Entity;

/**
 * Account book user
 *  
 * @author marc
 */
public class User extends BaseEntity<User> implements Entity<User>{
	private Long id;
	private String name;
	private String description;
	private Set<Expense> expenses = new HashSet<Expense>();

	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}

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

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}
	
	// @Transient
	public void addExpense(Expense expense) {
		expense.setUser(this);
		getExpenses().add(expense);
	}

	@Override
	public String toString() {
		return name;
	}
	
	

}
