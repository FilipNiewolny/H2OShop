package pl.shop.H2OShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.repository.UserRepository;

@Service
public class RegistrationService {



    private UserService userService;

    @Autowired
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public String registration(User user, Model model) throws Exception {
        userService.createNewUser(user);
        model.addAttribute("user" , user);
        return "successful-registration";
            }


}
