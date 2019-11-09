package pl.shop.Traning_Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.shop.Traning_Application.repository.RepsRepository;

@Service
public class RepsService {

    private RepsRepository repsRepository;

    @Autowired
    public RepsService(RepsRepository repsRepository) {
        this.repsRepository = repsRepository;
    }
}
