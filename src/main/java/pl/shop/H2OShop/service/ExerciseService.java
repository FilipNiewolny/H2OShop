package pl.shop.H2OShop.service;

import org.springframework.stereotype.Service;
import pl.shop.H2OShop.repository.ExerciseRepository;

@Service
public class ExerciseService {

    ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
}
