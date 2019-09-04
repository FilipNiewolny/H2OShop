package pl.shop.H2OShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;

@Service
public class AccountService {

    private UserRepository userRepository;

    @Autowired
    public AccountService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getAccount(Model model, String userName, User user, HttpServletResponse response) {
        User userByUsername = userRepository.findByUsername(userName).get();


        model.addAttribute("user", userByUsername);

        if (userByUsername.isActivated()) {
            return "account";
        } else {
            return "failed-login";
        }
    }
}