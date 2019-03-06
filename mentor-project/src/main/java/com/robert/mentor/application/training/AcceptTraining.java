package com.robert.mentor.application.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.training.TrainingProposals;
import com.robert.mentor.domain.training.Trainings;
import com.robert.mentor.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DDD.ApplicationService
@Service
@Transactional
public class AcceptTraining {

    @Autowired
    private Users users;
    @Autowired
    private Trainings trainings;
    @Autowired
    private TrainingProposals trainingProposals;

    public void acceptTraining(Email username, String trainingName) {
        Training training = trainings.findTrainingByTrainingName(trainingName).orElseThrow(IllegalArgumentException::new);
        users.acceptedTraining(username, training);
        trainingProposals.acceptProposal(trainingProposals.findTrainingProposal(username, training).orElseThrow(IllegalArgumentException::new));
    }

}
