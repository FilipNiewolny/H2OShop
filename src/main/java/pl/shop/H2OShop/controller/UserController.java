package pl.shop.H2OShop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.shop.H2OShop.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Authentication authentication) {
        return "login";
    }

    @GetMapping("/activate")
    public String authentication(@RequestParam(name = "link") String activationCode){
        userService.authenticate(activationCode);
        return "successful-registration";
    }
}
