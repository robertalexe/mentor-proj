package com.robert.mentor.infrastructure.mentor;

import com.robert.mentor.config.MentorProjectApplication;
import com.robert.mentor.domain.*;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.Mentors;
import com.robert.mentor.domain.mentor.WorkingHours;
import com.robert.mentor.domain.mentor.WorkingTimes;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MentorProjectApplication.class)
public class SdjMentorsLocalIT {

    @Autowired
    private Mentors mentors;

    @Test
    public void should_retrieve_existing_mentor() {
        Mentor mentor = mentors.findOne(new Email("ABD@ABC.COM")).orElseThrow(() -> new UsernameNotFoundException("mentor"));
        assertThat(mentor).isNotNull();
    }

    @Test
    public void should_persist_new_mentor() {
        Mentor mentor = new Mentor(new Email("AAA@AAA.COM"), new Password("password"),
                new NameFragment("First"), new NameFragment("Second"), new ContactNumber("111"),
                LocalDateTime.now(), ZoneId.of("Europe/Berlin"), generateValidWorkingTimes(),
                Collections.singleton(new Technology("Java8")), new Url("http://"),
                2, emptyList());
        Mentor mentor1 = mentors.signUp(mentor);
        assertThat(mentor1).isNotNull();
    }

    private WorkingTimes generateValidWorkingTimes() {
        Map<DayOFWeek, WorkingHours> map = new HashMap<>();
        map.put(DayOFWeek.MONDAY, new WorkingHours(LocalTime.of(10, 00), LocalTime.of(12, 00)));
        map.put(DayOFWeek.THURSDAY, new WorkingHours(LocalTime.of(10, 00), LocalTime.of(12, 00)));
        map.put(DayOFWeek.WEDNESDAY, new WorkingHours(LocalTime.of(10, 00), LocalTime.of(12, 00)));
        map.put(DayOFWeek.TUESDAY, new WorkingHours(LocalTime.of(10, 00), LocalTime.of(12, 00)));
        map.put(DayOFWeek.FRIDAY, new WorkingHours(LocalTime.of(10, 00), LocalTime.of(12, 00)));
        return new WorkingTimes(map);
    }
}
