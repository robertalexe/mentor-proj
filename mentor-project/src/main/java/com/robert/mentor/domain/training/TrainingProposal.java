package com.robert.mentor.domain.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@DDD.AggregateRoot
@Entity
@Table(name = "TRAINING_PROPOSALS")
@NoArgsConstructor @Getter
public class TrainingProposal {

    @EmbeddedId
    private TrainingProposalId id;

    @Embedded @AttributeOverride(name = "value", column = @Column(name = "MENTOR_EMAIL"))
    private Email mentorEmail;

    public TrainingProposal(TrainingProposalId id, Email mentorEmail) {
        this.id = id;
        this.mentorEmail = mentorEmail;
    }
}
