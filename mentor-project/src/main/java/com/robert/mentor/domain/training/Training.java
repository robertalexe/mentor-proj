package com.robert.mentor.domain.training;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TRAININGS")
@NoArgsConstructor
@Getter
@Setter
public class Training {

    @Id @NotNull
    private String id;
    @Column(name = "NAME")
    private String trainingName;
    @Column(name = "COST")
    private BigDecimal cost;

    public Training(String trainingName, BigDecimal cost) {
        this.id = UUID.randomUUID().toString();
        this.trainingName = trainingName;
        this.cost = cost;
    }
}
