package pl.shop.H2OShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }
@GetMapping("/home")
    public String home2(){
        return "index";
    }


}
