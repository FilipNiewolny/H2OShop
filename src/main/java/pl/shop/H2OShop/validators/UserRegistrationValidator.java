package pl.shop.H2OShop.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.service.UserService;

@Component
public class UserRegistrationValidator implements Validator {

    private UserService userService;

    @Autowired
    public UserRegistrationValidator(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        // checks username size and duplicate in database
        ValidationUtils.rejectIfEmptyOrWhitespace(errors , "username" ,"It cannot be empty");
        if(user.getUsername().length() <6 || user.getUsername().length() > 32) {
            errors.rejectValue("username" , "Size.userForm.username");
        }

    }
}
