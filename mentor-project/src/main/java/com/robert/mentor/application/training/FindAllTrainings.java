package com.robert.mentor.application.training;

import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.training.Trainings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FindAllTrainings {

    @Autowired
    private Trainings trainings;

    public Set<Training> findAllTrainings() {
        return trainings.findAll();
    }
}
