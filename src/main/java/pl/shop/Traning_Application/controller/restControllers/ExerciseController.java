package pl.shop.Traning_Application.controller.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.shop.Traning_Application.domain.Exercise;
import pl.shop.Traning_Application.repository.ExerciseRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping("/exercise")
    public @NotNull List<Exercise> getExercise(){
        return exerciseRepository.findAll();
    }

    @PostMapping("/exercise")
    void addExercise (@RequestBody Exercise exercise){
        exerciseRepository.save(exercise);
    }
}
