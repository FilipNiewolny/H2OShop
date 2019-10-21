package pl.shop.Traning_Application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import pl.shop.Traning_Application.domain.Role;
import pl.shop.Traning_Application.domain.User;
import pl.shop.Traning_Application.repository.UserRepository;
import pl.shop.Traning_Application.service.ResourceNotFoundException;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName).orElseThrow(ResourceNotFoundException::new);


        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isActivated(),
                true,true,true,
                Collections.singleton(new SimpleGrantedAuthority(Role.ROLE_USER.getRole())));
        return userDetails;
    }
}
