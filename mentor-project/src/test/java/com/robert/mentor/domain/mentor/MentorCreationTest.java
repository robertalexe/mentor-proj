package com.robert.mentor.domain.mentor;

import com.robert.mentor.MentorProjectTestUtils;
import com.robert.mentor.domain.*;
import com.robert.mentor.domain.training.Training;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.robert.mentor.MentorProjectTestUtils.*;
import static com.robert.mentor.MentorProjectTestUtils.generateTraining;
import static org.assertj.core.api.Assertions.assertThat;

public class MentorCreationTest {

    private final Email email = new Email("test@test.com");
    private final Password password = new Password("pass");
    private final NameFragment firstName = new NameFragment("first");
    private final NameFragment lastName = new NameFragment("last");
    private final ContactNumber contactNumber = new ContactNumber("+000030303");
    private final LocalDateTime registeredDate = LocalDateTime.of(2019, 02, 02, 12, 00, 00);
    private final ZoneId zoneId = ZoneId.of("Australia/Darwin");
    private final WorkingTimes workingTimes = generateWorkingTimes();
    private final Set<Technology> technologies = Collections.singleton(new Technology("Java8"));
    private final Url linedinUrl = new Url("http://linkedin.com");
    private final int yearsOfExperience = 5;
    private final List<Training> trainings = Collections.singletonList(generateTraining());

    @Test
    public void should_create_mentor_with_all_details() {
        Mentor mentor = new Mentor(email, password, firstName, lastName, contactNumber,
                registeredDate, zoneId, workingTimes, technologies,
                linedinUrl, yearsOfExperience, trainings);
        assertThat(mentor).isNotNull();
        assertThat(mentor.getId()).isEqualTo(email);
        assertThat(mentor.getTechnologies()).isEqualTo(technologies);
        assertThat(mentor.getYearsOfExperience()).isEqualTo(yearsOfExperience);
        assertThat(mentor.getTrainings()).isEqualTo(trainings);
    }
}
