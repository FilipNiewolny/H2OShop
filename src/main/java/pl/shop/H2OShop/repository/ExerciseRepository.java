package pl.shop.H2OShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.shop.H2OShop.domain.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
