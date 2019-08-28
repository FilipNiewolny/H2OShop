package pl.shop.H2OShop.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shop.H2OShop.domain.User;
import pl.shop.H2OShop.repository.UserRepository;

@Service
public class UserService {


    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createNewUser (User user){
        String newActivationCode = RandomStringUtils.random(15);
        user.setActivationCode(newActivationCode);
        userRepository.save(user);
    }
}
