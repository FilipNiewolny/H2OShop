package pl.shop.H2OShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shop.H2OShop.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);
    User findByActivationCode (String activationCode);

}
