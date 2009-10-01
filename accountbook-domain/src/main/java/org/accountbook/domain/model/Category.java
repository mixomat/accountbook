package org.accountbook.domain.model;

import org.accountbook.domain.ValueObject;

/**
 * Categories
 * 
 * @author marc
 * @since 1.0
 */
public class Category implements ValueObject<Category>{
	
	private String name;
	private Percentage percentage;
	
	public Category() {
	}

	public Category(Double percentage) {
		this("", percentage);
	}

	public Category(String name, Double percentage) {
		this.name = name;
		this.percentage = new Percentage(percentage);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Percentage getPercentage() {
		return percentage;
	}

	public void setPercentage(Percentage percentage) {
		this.percentage = percentage;
	}

	public double calculatePercentage(Double amount) {
		return amount * percentage.getAmount();
	}

	/**
	 * @see org.accountbook.domain.ValueObject#sameValueAs(java.lang.Object)
	 */
	public boolean sameValueAs(Category other) {
		return other == null ? false : name.equals(other.getName());
	}

}
