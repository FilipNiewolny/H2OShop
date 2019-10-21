package pl.shop.Traning_Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shop.Traning_Application.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String userName);
    User findByActivationCode (String activationCode);

    Optional<User> findByEmail(String email);
}
