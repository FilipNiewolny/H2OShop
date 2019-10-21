package pl.shop.Traning_Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.shop.Traning_Application.service.AccountService;

@Controller
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public String getUser (Model model, Authentication authentication){
        return accountService.getAccount(authentication,model);
    }
}

