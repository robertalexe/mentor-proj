package com.robert.mentor.exposition.training;

import com.robert.mentor.application.mentor.FindAllMentors;
import com.robert.mentor.application.training.FindAllTrainings;
import com.robert.mentor.application.user.UserActiveTrainings;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spi.service.contexts.SecurityContext;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class TrainingResource {

    @Autowired
    private FindAllMentors allMentors;
    @Autowired
    private UserActiveTrainings activeTrainings;

    @RequestMapping(value = "/mentors-trainings", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MentorTrainingRepresentation> allTrainings() {
        Set<Mentor> mentors = allMentors.findAllMentors();
        return mentors.stream()
                .flatMap( mentor -> MentorTrainingRepresentation.toMentorTrainingsRepresentation(mentor).stream())
                .collect(toList());
    }

    @RequestMapping(value = "/user-active-trainings", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TrainingRepresentation> userActiveTrainings() {
        Set<Training> trainings = activeTrainings.userActiveTrainings();
        return trainings.stream()
                .map(TrainingRepresentation::toTrainingRepresentation)
                .collect(toList());
    }
}
