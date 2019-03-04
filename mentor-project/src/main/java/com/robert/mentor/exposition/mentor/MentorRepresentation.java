package com.robert.mentor.exposition.mentor;

import com.robert.mentor.domain.Technology;
import com.robert.mentor.domain.mentor.Mentor;

import java.util.stream.Collectors;

public class MentorRepresentation {

    public String email;
    public String firstName;
    public String lastName;
    public String contactNumber;
    public String timeZone;
    public String technologiesList;
    public String linkedInUrl;
    public int yearsOfExperience;

    public static MentorRepresentation toMentorRepresentation(Mentor mentor) {
        MentorRepresentation mentorRepresentation = new MentorRepresentation();
        mentorRepresentation.email = mentor.getId().getValue();
        mentorRepresentation.firstName = mentor.getFirstName().getValue();
        mentorRepresentation.lastName = mentor.getLastName().getValue();
        mentorRepresentation.contactNumber = mentor.getContactNumber().getValue();
        mentorRepresentation.timeZone = mentor.getTimeZone().toString();
        mentorRepresentation.technologiesList = mentor.getTechnologies().stream().map(Technology::getTechnology).collect(Collectors.joining(","));
        mentorRepresentation.linkedInUrl = mentor.getLinkedInUrl().getValue();
        mentorRepresentation.yearsOfExperience = mentor.getYearsOfExperience();
        return mentorRepresentation;
    }
}
