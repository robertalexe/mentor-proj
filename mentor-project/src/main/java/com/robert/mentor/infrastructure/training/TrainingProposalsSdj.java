package com.robert.mentor.infrastructure.training;

import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.training.TrainingProposal;
import com.robert.mentor.domain.training.TrainingProposalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingProposalsSdj extends JpaRepository<TrainingProposal, TrainingProposalId> {

    List<TrainingProposal> findTrainingProposalsByMentorEmail(Email mentorEmail);
}
