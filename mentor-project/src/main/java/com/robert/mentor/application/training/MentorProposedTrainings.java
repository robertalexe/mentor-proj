package com.robert.mentor.application.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.IdentitySupplier;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.training.TrainingProposal;
import com.robert.mentor.domain.training.TrainingProposals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DDD.ApplicationService
@Service
public class MentorProposedTrainings {

    @Autowired
    private TrainingProposals trainingProposals;
    @Autowired
    private IdentitySupplier identitySupplier;

    public List<TrainingProposal> proposedTrainingsForMentor() {
        return trainingProposals.getAllProposedTrainingsForMentor(identitySupplier.get());
    }
}
