package pl.shop.H2OShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.repository.UserRepository;
import pl.shop.H2OShop.security.WebSecurityConfig;

@Service
public class RegistrationService {



    private UserService userService;
    private WebSecurityConfig webSecurityConfig;

    @Autowired
    public RegistrationService(UserService userService, WebSecurityConfig webSecurityConfig) {
        this.userService = userService;
        this.webSecurityConfig = webSecurityConfig;
    }

    public String registration(User user, Model model) throws Exception {
        user.setPassword(webSecurityConfig
                .passwordEncoder()
                .encode(user.getPassword()));
        userService.createNewUser(user);
        model.addAttribute("user" , user);
        return "successful-registration";
            }


}
