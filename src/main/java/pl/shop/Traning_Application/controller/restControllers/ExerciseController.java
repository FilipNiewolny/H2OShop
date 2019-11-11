package pl.shop.Traning_Application.controller.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.shop.Traning_Application.domain.Exercise;
import pl.shop.Traning_Application.domain.Muscle;
import pl.shop.Traning_Application.domain.User;
import pl.shop.Traning_Application.service.ExerciseService;
import pl.shop.Traning_Application.service.UserService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExerciseController {

    private  ExerciseService exerciseService;
    private UserService userService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, UserService userService) {
        this.exerciseService= exerciseService;
        this.userService= userService;
    }

    @GetMapping("/add")
    public void addSome() throws Exception {
       exerciseService.save( new Exercise().builder()
                .description("Wyciskaj")
                .muscle(Muscle.Klatka)
                .name("wyciskanie")
                .reps(null)
                .build());
         exerciseService.save( new Exercise().builder()
                .description("Przysiad z sztangą")
                .muscle(Muscle.Nogi)
                .name("Przysiad")
                .reps(null)
                .build());

         userService.createNewUser(new User().builder()
         .activated(true)
                 .id(5L)
         .email("daasd@wp.pl")
         .password("123")
         .username("Niewoq").build()
         );

    }

    @GetMapping("/list/exercise")
    public @NotNull List<Exercise> getExercise(){
        return exerciseService.findAll();
    }

    @GetMapping("/exercise")
    public List<Muscle> getMuscle(){
        System.out.println(exerciseService.getAllMuscleName());
        return exerciseService.getAllMuscleName();
    }



    @GetMapping("/exercise/{exerciseId}")
    Exercise findById(@PathVariable Long exerciseId){
        return exerciseService.findById(exerciseId);
    }


    @PostMapping("/exercise")
    ResponseEntity addPostExercise(@RequestBody Exercise exercise){
        try{
        exerciseService.save(exercise); }
        catch (Exception e){
            return new ResponseEntity( "Coś poszło nie tak", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
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
