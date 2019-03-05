package com.robert.mentor.domain.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@DDD.ValueObjectId
@Embeddable @NoArgsConstructor @Getter
public class TrainingProposalId implements Serializable {

    @Column(name = "USER_EMAIL")
    private Email userEmail;
    @Column(name = "TRAINING_ID")
    private Id id;

    public TrainingProposalId(Email userEmail, Id id) {
        this.userEmail = userEmail;
        this.id = id;
    }
}
