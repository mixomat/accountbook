/**
 * 
 */
package org.accountbook.domain.model;

import org.accountbook.domain.ValueObject;

/**
 * @author marc
 *
 */
public class Percentage implements ValueObject<Percentage>{

	private Double amount;
	
	public Percentage() {
	}
	
	public Percentage(Double amount) {
		this.amount = amount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @see org.accountbook.domain.ValueObject#sameValueAs(java.lang.Object)
	 */
	public boolean sameValueAs(Percentage other) {
		return other == null ? false: this.amount.equals(other.getAmount());
	}
	
}
