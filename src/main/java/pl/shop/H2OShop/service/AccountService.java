package pl.shop.H2OShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;

@Service
public class AccountService {

    private UserService userService;
    @Autowired
    public AccountService( UserService userService) {
        this.userService = userService;
    }

    public String getAccount(Model model, String userName, User user, HttpServletResponse response) {
        User userByUsername = userService.findByUsername(userName).get();


        model.addAttribute("user", userByUsername);

        if (userByUsername.isActivated()) {
            return "account";
        } else {
            return "failed-login";
        }
    }

    public String getAccount(Authentication authentication, Model model) {
        User userByEmail = userService.getUserByEmail(authentication.getName()).get();
        model.addAttribute("user" , userByEmail);

        if (userByEmail.isActivated()){
            return "account";
        }else {
            return "failedlogin";
        }
    }
}