package com.robert.mentor.domain.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Technology;
import com.robert.mentor.domain.Url;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.user.User;
import com.robert.mentor.infrastructure.ZoneIdConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;

@DDD.AggregateRoot
@Entity @DiscriminatorValue("MENTOR")
@NoArgsConstructor
@Getter
public class Mentor extends User {

    @Convert(converter = ZoneIdConverter.class)
    @Column(name = "ZONE_ID")
    private ZoneId timeZone;
    @Embedded
    private WorkingTimes workingTimes;
    @ElementCollection
    @CollectionTable(name = "TECHNOLOGIES", joinColumns = @JoinColumn(name = "EMAIL"))
    private Set<Technology> technologies;
    @Embedded
    private Url linkedInUrl;
    @Column(name = "YEARS_EXP")
    private int yearsOfExperience;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MENTOR_ID")
    private List<Training> trainings;

}
