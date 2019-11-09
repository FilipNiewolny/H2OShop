package pl.shop.Traning_Application.controller.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shop.Traning_Application.domain.Training;
import pl.shop.Traning_Application.service.TrainingService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingController {
    private TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/training/all")
    public List<Training> getAllTraining(){
        return trainingService.findAllTraining();
    }
}
