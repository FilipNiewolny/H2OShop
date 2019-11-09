package pl.shop.Traning_Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.shop.Traning_Application.domain.Reps;

@Repository
public interface RepsRepository extends JpaRepository<Reps , Long> {
}
