package com.robert.mentor.application.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.IdentitySupplier;
import com.robert.mentor.domain.training.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DDD.ApplicationService
@Service
@Transactional
public class ProposeTraining {

    @Autowired
    private TrainingProposals trainingProposals;
    @Autowired
    private Trainings trainings;
    @Autowired
    private IdentitySupplier identitySupplier;

    public void proposeTraining(String trainingName) {
        Training training = trainings.findTrainingByTrainingName(trainingName).orElseThrow(IllegalArgumentException::new);
        TrainingProposal trainingProposal = new TrainingProposal(
                new TrainingProposalId(
                        identitySupplier.get(),
                        training.getId()
                ),
                training.getMentorId()
        );
        trainingProposals.proposeTraining(trainingProposal);
    }
}
