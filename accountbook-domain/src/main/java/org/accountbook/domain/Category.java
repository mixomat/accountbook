package org.accountbook.domain;

/**
 * Categories
 * 
 * @author marc
 * @since 1.0
 */
public class Category {
	private String name;
	private String description;
	private Double percentage;

	public Category(Double percentage) {
		this("", percentage);
	}

	public Category(String name, Double percentage) {
		this.name = name;
		this.percentage = percentage;
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

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	public double calculatePercentage(Double amount) {
		return amount * percentage;
	}

}
