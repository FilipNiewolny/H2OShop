package pl.shop.Traning_Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.shop.Traning_Application.domain.User;
import pl.shop.Traning_Application.service.RegistrationService;
import pl.shop.Traning_Application.validators.UserRegistrationValidator;

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
        userRegistrationValidator.validate(user , bindingResult);
        if (bindingResult.hasErrors()){
            return "register";
        }
        return registrationService.registration(user,model);
    }


}
