package pl.shop.H2OShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shop.H2OShop.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
