package org.accountbook.web;

import org.accountbook.accountbook.service.ExpenseService;
import org.accountbook.domain.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	
	private static Logger logger = LoggerFactory.getLogger(ExpenseController.class);
	
	private User marc = new User("marc");

	@Autowired
	private ExpenseService expenseService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String expenses(ModelMap model) {
		model.addAttribute("expenses",expenseService.getAllExpenses());
		return "expense";
	}
	
	
	@RequestMapping(value = "/add/{amount}", method = RequestMethod.GET)
	public String addExpense(@PathVariable("amount") Double amount, ModelMap model) {
		logger.debug("creating expense for user {}",marc);
		expenseService.createExpenseForUser(amount,marc);
		model.addAttribute("expenses", expenseService.getAllExpensesForUser(marc));
		return "expense";
	}
}