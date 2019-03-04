package com.robert.mentor.domain.mentor;

import com.robert.mentor.domain.*;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.user.User;
import com.robert.mentor.infrastructure.ZoneIdConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;

@DDD.AggregateRoot
@Entity @DiscriminatorValue("MENTOR")
@NoArgsConstructor
@Getter
public class Mentor extends User {

    public Mentor(Email id, Password password, NameFragment firstName, NameFragment lastName,
                  ContactNumber contactNumber, LocalDateTime registeredDate, ZoneId timeZone,
                  WorkingTimes workingTimes, Set<Technology> technologies, Url linkedInUrl,
                  int yearsOfExperience, List<Training> trainings) {
        super(id, password, firstName, lastName, contactNumber, registeredDate);
        this.timeZone = timeZone;
        this.workingTimes = workingTimes;
        this.technologies = technologies;
        this.linkedInUrl = linkedInUrl;
        this.yearsOfExperience = yearsOfExperience;
        this.trainings = trainings;
    }

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

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public WorkingTimes getWorkingTimes() {
        return workingTimes;
    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }

    public Url getLinkedInUrl() {
        return linkedInUrl;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("America/Anchorage");
        System.out.println(zoneId.toString());
    }
}
