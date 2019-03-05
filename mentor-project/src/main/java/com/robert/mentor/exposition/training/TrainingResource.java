package com.robert.mentor.exposition.training;

import com.robert.mentor.application.mentor.FindAllMentors;
import com.robert.mentor.application.training.FindAllTrainings;
import com.robert.mentor.application.training.MentorProposedTrainings;
import com.robert.mentor.application.training.ProposeTraining;
import com.robert.mentor.application.user.UserActiveTrainings;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.training.Trainings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spi.service.contexts.SecurityContext;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class TrainingResource {

    @Autowired
    private FindAllMentors allMentors;
    @Autowired
    private UserActiveTrainings activeTrainings;
    @Autowired
    private ProposeTraining proposeTraining;
    @Autowired
    private MentorProposedTrainings mentorProposedTrainings;
    @Autowired
    private Trainings trainings;

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

    @RequestMapping(value = "/training/propose", method = POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> proposeTraining(@RequestBody ProposedTrainingRepresentation proposedTraining) {
        proposeTraining.proposeTraining(proposedTraining.trainingName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/training/mentor-proposed", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MentorProposedTrainingRepresentation> proposedTrainingsForMentor() {
        return mentorProposedTrainings.proposedTrainingsForMentor().stream()
                .map( training ->
                        new MentorProposedTrainingRepresentation(
                                training.getId().getUserEmail().getValue(),
                                trainings.findTrainingById(training.getId().getId()).orElseThrow(IllegalArgumentException::new).getTrainingName()))
                .collect(Collectors.toList());
    }
}
