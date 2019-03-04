package com.robert.mentor.domain.training;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@DDD.Entity
@Entity @Table(name = "TRAININGS")
@NoArgsConstructor @Getter @Setter
public class Training {

    @Id @NotNull @EmbeddedId
    private com.robert.mentor.domain.Id id;
    @Column(name = "NAME")
    private String trainingName;
    @Column(name = "COST")
    private BigDecimal cost;
    @Embedded @AttributeOverride(name = "value", column = @Column(name = "MENTOR_ID"))
    private Email mentorId;
    @ElementCollection
    @CollectionTable(name = "TRAINING_ENROLLED", joinColumns = @JoinColumn(name = "EMAIL"))
    private Set<User> enrolledUsers;

    public Training(com.robert.mentor.domain.Id id, String trainingName, BigDecimal cost) {
        this.id = id;
        this.trainingName = trainingName;
        this.cost = cost;
    }

    public com.robert.mentor.domain.Id getId() {
        return id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Email getMentorId() {
        return mentorId;
    }

    public Set<User> getEnrolledUsers() {
        return enrolledUsers;
    }
}
