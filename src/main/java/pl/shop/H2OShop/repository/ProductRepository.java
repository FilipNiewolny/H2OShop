package pl.shop.H2OShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.shop.H2OShop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByVolume(double volume);
    Product findByType (String type);
}
