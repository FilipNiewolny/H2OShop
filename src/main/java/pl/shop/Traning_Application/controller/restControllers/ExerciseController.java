package pl.shop.Traning_Application.controller.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.shop.Traning_Application.domain.Exercise;
import pl.shop.Traning_Application.domain.Muscle;
import pl.shop.Traning_Application.service.ExerciseService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExerciseController {

    private  ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService= exerciseService;
    }

    @GetMapping("/add")
    public void addSome(){
       exerciseService.save( new Exercise().builder()
                .description("Wyciskaj")
                .muscle(Muscle.Klatka)
                .name("wyciskanie")
                .reps(null)
                .build());
    }

    @GetMapping("/list/exercise")
    public @NotNull List<Exercise> getExercise(){
        return exerciseService.findAll();
    }


    @GetMapping("/exercise/{exerciseId}")
    Exercise findById(@PathVariable Long exerciseId){
        return exerciseService.findById(exerciseId);
    }


    @PostMapping("/exercise")
    void addExercise (@RequestBody Exercise exercise){
        exerciseService.save(exercise);
    }

    @GetMapping("/exercise/delete/{exerciseId}")
    ResponseEntity<Void> deleteExercise(@PathVariable Long exerciseId){
        if (exerciseService.isExist(exerciseId)) {
            exerciseService.delete(exerciseId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }


    }
}
