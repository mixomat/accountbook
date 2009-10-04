package org.accountbook.web;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.accountbook.domain.model.Expense;

/**
 * Model bean for xml marshalling of expenses as list.
 * 
 * @author marc
 * @since 1.0.0
 */
@XmlRootElement
public class ExpenseList {
	
	@XmlTransient
	private List<Expense> expense;

	public ExpenseList() {
	}
	
	public ExpenseList(List<Expense> expense) {
		this.expense = expense;
	}

	public List<Expense> getExpense() {
		return expense;
	}

	public void setExpense(List<Expense> expense) {
		this.expense = expense;
	}

	

	
	
	
}
