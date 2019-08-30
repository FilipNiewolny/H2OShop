package pl.shop.H2OShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.service.RegistrationService;

@Controller
public class RegistrationController {


    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String getRegister(){return "register";}

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@ModelAttribute User user , Model model) throws Exception {
        return registrationService.registration(user,model);
    }


}
