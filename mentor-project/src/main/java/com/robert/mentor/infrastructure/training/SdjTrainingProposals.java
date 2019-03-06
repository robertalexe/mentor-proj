package com.robert.mentor.infrastructure.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.training.TrainingProposal;
import com.robert.mentor.domain.training.TrainingProposalId;
import com.robert.mentor.domain.training.TrainingProposals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<TrainingProposal> findTrainingProposal(Email username, Training training) {
        TrainingProposalId id = new TrainingProposalId(username, training.getId());
        return Optional.of(sdj.findTrainingProposalById(id));
    }
}
