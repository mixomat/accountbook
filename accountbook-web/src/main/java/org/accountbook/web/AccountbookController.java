package org.accountbook.web;

import org.accountbook.accountbook.service.ExpenseService;
import org.accountbook.domain.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountbookController {
	
	private static Logger logger = LoggerFactory.getLogger(AccountbookController.class);
	
	private User marc = new User("marc");

	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping("/account.htm")
	public String account(ModelMap model) {
		model.addAttribute("name", "account name");
		return "account";
	}
	
	@RequestMapping("/expense.htm")
	public String expenses(ModelMap model) {
		logger.debug("creating expense for user {}",marc);
		expenseService.createExpenseForUser(12.0,marc);
		
		return "expense";
	}
}