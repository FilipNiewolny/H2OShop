package pl.shop.H2OShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private UserRepository userRepository;
    private EmailService emailService;


    @Autowired
    public UserService(UserRepository userRepository , EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void createNewUser (User user) throws Exception {
        Optional<User> userExists = userRepository.findByUsername(user.getUsername());

        if (userExists.isPresent())
            throw new Exception( "That user name is exist");
        String newActivationCode = UUID.randomUUID().toString();
        user.setActivationCode(newActivationCode);
        emailService.sendAuthenticationEmail(user);
        userRepository.save(user);
    }
    public void authenticate(String activationCode) {
        User byActivationCode = userRepository.findByActivationCode(activationCode);
        byActivationCode.setActivated(true);
        byActivationCode.setActivationCode(null);
        userRepository.save(byActivationCode);
    }
    public Optional<User> findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
