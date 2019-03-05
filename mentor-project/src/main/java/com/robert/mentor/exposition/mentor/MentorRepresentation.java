package com.robert.mentor.exposition.mentor;

import com.robert.mentor.domain.*;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.WorkingHours;
import com.robert.mentor.domain.mentor.WorkingTimes;
import org.joda.time.LocalDate;
import org.springframework.util.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static org.springframework.util.StringUtils.isEmpty;

public class MentorRepresentation {

    public String email;
    public String firstName;
    public String lastName;
    public String contactNumber;
    public String timezone;
    public List<String> technologies;
    public String linkedinUrl;
    public int yearsOfExperience;
    public String password;
    public Map<DayOFWeek, DailyIntervalRepresentation> dailyIntervalTimes;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static MentorRepresentation toMentorRepresentation(Mentor mentor) {
        MentorRepresentation mentorRepresentation = new MentorRepresentation();
        mentorRepresentation.email = mentor.getId().getValue();
        mentorRepresentation.firstName = mentor.getFirstName().getValue();
        mentorRepresentation.lastName = mentor.getLastName().getValue();
        mentorRepresentation.contactNumber = mentor.getContactNumber().getValue();
        mentorRepresentation.timezone = mentor.getTimeZone().toString();
        mentorRepresentation.technologies = mentor.getTechnologies().stream().map(Technology::getTechnology).collect(Collectors.toList());
        mentorRepresentation.linkedinUrl = mentor.getLinkedInUrl().getValue();
        mentorRepresentation.yearsOfExperience = mentor.getYearsOfExperience();
        return mentorRepresentation;
    }

    public Mentor toDomainSignUpMentor() {
        return new Mentor(
                new Email(email),
                new Password(password),
                new NameFragment(firstName),
                new NameFragment(lastName),
                new ContactNumber(contactNumber),
                now(),
                ZoneId.of(timezone),
                mapWorkingTimes(),
                technologies.stream().map(Technology::new).collect(Collectors.toSet()),
                new Url(linkedinUrl),
                yearsOfExperience,
                Collections.emptyList()
        );
    }

    private WorkingTimes mapWorkingTimes() {
        Map<DayOFWeek, WorkingHours> data = new HashMap<>();
        dailyIntervalTimes.keySet().forEach( key -> {
            DailyIntervalRepresentation interval = dailyIntervalTimes.get(key);
            if(!isEmpty(interval.startTime) && !isEmpty(interval.endTime)) {
                data.put(
                        key,
                        new WorkingHours(
                                LocalTime.parse(interval.startTime, TIME_FORMATTER),
                                LocalTime.parse(interval.endTime, TIME_FORMATTER)
                        )
                );
            }
        });
        return new WorkingTimes(data);
    }
}
