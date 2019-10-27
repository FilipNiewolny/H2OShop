package pl.shop.Traning_Application.service;

import org.springframework.stereotype.Service;
import pl.shop.Traning_Application.domain.Exercise;
import pl.shop.Traning_Application.repository.ExerciseRepository;

@Service
public class ExerciseService {

    ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void saveWithoutNull(Exercise exercise){

        exerciseRepository.save(exercise);
    }
}
