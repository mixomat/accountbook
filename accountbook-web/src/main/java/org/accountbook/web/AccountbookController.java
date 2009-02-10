package org.accountbook.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccountbookController {

	@RequestMapping("/account.htm")
	public String account() {
		return "account";
	}
}