package pl.shop.Traning_Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shop.Traning_Application.domain.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
