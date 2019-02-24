package com.robert.mentor.exposition.training;

import com.robert.mentor.application.training.FindAllTrainings;
import com.robert.mentor.domain.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/trainings")
@CrossOrigin(origins = "*")
public class TrainingResource {

    @Autowired
    private FindAllTrainings allTrainings;

    @RequestMapping(method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TrainingRepresentation> allTrainings() {
        Set<Training> trainings = allTrainings.findAllTrainings();
        List<TrainingRepresentation> trainingRepresentations = trainings.stream()
                .map(TrainingRepresentation::toTrainingRepresentation).collect(Collectors.toList());
        return trainingRepresentations;
    }
}
