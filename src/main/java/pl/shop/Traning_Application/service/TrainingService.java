package pl.shop.Traning_Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shop.Traning_Application.domain.Training;
import pl.shop.Traning_Application.repository.TrainingRepository;

import java.util.List;

@Service
public class TrainingService {
    private TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> findAllTraining(){
        return trainingRepository.findAll();
    }
}
