package pl.shop.Traning_Application.controller.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.shop.Traning_Application.domain.User;
import pl.shop.Traning_Application.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/user"})
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }
}
