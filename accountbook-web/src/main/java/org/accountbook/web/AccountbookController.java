package org.accountbook.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountbookController {

	@RequestMapping("/account.htm")
	public String account(ModelMap model) {
		model.addAttribute("name", "account name");
		return "account";
	}
	
	@RequestMapping("/expense.htm")
	public String expenses(ModelMap model) {
		return "expense";
	}
}