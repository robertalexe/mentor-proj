package com.robert.mentor.infrastructure.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.training.TrainingProposal;
import com.robert.mentor.domain.training.TrainingProposals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DDD.RepositoryImpl
@Service
public class SdjTrainingProposals implements TrainingProposals {

    @Autowired
    private TrainingProposalsSdj sdj;

    @Override
    public void proposeTraining(TrainingProposal trainingProposal) {
        sdj.save(trainingProposal);
    }

    @Override
    public List<TrainingProposal> getAllProposedTrainingsForMentor(Email mentorEmail) {
        return sdj.findTrainingProposalsByMentorEmail(mentorEmail);
    }

    @Override
    public void acceptProposal(TrainingProposal trainingProposal) {
        sdj.delete(trainingProposal);
    }
}
