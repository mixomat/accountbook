package org.accountbook.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccountbookController {

	@RequestMapping("/account.html")
	public String account() {
		return "account";
	}
}