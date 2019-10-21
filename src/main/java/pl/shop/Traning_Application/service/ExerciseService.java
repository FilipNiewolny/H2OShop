package pl.shop.Traning_Application.service;

import org.springframework.stereotype.Service;
import pl.shop.Traning_Application.repository.ExerciseRepository;

@Service
public class ExerciseService {

    ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
}
