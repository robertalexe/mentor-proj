package com.robert.mentor.domain.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;

import java.util.List;

@DDD.Repository
public interface TrainingProposals {

    void proposeTraining(TrainingProposal trainingProposal);

    List<TrainingProposal> getAllProposedTrainingsForMentor(Email mentorEmail);

    void acceptProposal(TrainingProposal trainingProposal);

}
