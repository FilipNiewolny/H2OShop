package pl.shop.Traning_Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shop.Traning_Application.domain.Exercise;
import pl.shop.Traning_Application.repository.ExerciseRepository;

import java.util.List;

@Service
public class ExerciseService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void saveWithoutNull(Exercise exercise) {

        exerciseRepository.save(exercise);
    }

    public Exercise findById(Long id) {

        if (exerciseRepository.findById(id).isPresent()){
            return exerciseRepository.findById(id).get();
        }else {
            return new Exercise();
        }
    }


    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public void save(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    public void delete(Long exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }

    public boolean isExist(Long exerciseId) {
        return exerciseRepository.existsById(exerciseId);
    }

}
