package pl.shop.Traning_Application.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.shop.Traning_Application.domain.User;
import pl.shop.Traning_Application.service.UserService;

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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findUserByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        // checks the password for 1 special mark, >8 , <32 ,
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32
                && user.getPassword().matches("(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-])")) {
            errors.rejectValue("password", "Size.userForm.password");
        }

//        if (!user.getPasswordConfirm().equals(user.getPassword())) {
//            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
//        }

/*       Checks if phone number has 9 digits
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "NotEmpty");
        if (user.getPhoneNumber().toString().length() != 9L ){
            errors.rejectValue("phoneNumber", "Size.userForm.phoneNumber");
    }*/
//      Checks if email is an email if contains '@'.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (!user.getEmail().contains("@") || !user.getEmail().contains(".")){
            errors.rejectValue("email", "Contains.userForm.email");
        }


    }

}
