package pl.shop.H2OShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.service.RegistrationService;
import pl.shop.H2OShop.validators.UserRegistrationValidator;

@Controller
public class RegistrationController {


    private RegistrationService registrationService;
    private UserRegistrationValidator userRegistrationValidator;

    @Autowired
    public RegistrationController(RegistrationService registrationService, UserRegistrationValidator userRegistrationValidator) {
        this.registrationService = registrationService;
        this.userRegistrationValidator = userRegistrationValidator;
    }



    @GetMapping("/register")
    public String getRegister(){return "register";}

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@ModelAttribute User user , BindingResult bindingResult, Model model) throws Exception {
        UserRegistrationValidator.validate(user , bindingResult);
        if (bindingResult.hasErrors()){
            return "register";
        }
        return registrationService.registration(user,model);
    }


}
