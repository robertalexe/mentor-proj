package com.robert.mentor.exposition.training;

import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.Id;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class MentorTrainingRepresentation {

    public String mentorEmail;
    public String mentorFullName;
    public String technologiesList;
    public int yearsOfExperience;
    public String trainingName;
    public String trainingCost;
    public String enrolledUsers;

    public static List<MentorTrainingRepresentation> toMentorTrainingsRepresentation(Mentor mentor) {
        return mentor.getTrainings().stream()
                .map(training -> toMentorTrainingRepresentation(mentor, training))
                .collect(Collectors.toList());
    }

    private static String computeMentorFullName(Mentor mentor) {
        return mentor.getFirstName().getValue() + " " + mentor.getLastName().getValue();
    }

    private static String computeMentorTechnologiesList(Mentor mentor) {
        StringBuilder mentorTechList = new StringBuilder();
        mentor.getTechnologies().forEach(
                tech -> mentorTechList.append(tech.getTechnology()).append(",")
        );
        mentorTechList.deleteCharAt(mentorTechList.length() - 1);
        return mentorTechList.toString();
    }

    private static MentorTrainingRepresentation toMentorTrainingRepresentation(Mentor mentor, Training training) {
        MentorTrainingRepresentation mentorTrainingRepresentation = new MentorTrainingRepresentation();
        mentorTrainingRepresentation.mentorEmail = mentor.getId().getValue();
        mentorTrainingRepresentation.mentorFullName = computeMentorFullName(mentor);
        mentorTrainingRepresentation.technologiesList = computeMentorTechnologiesList(mentor);
        mentorTrainingRepresentation.yearsOfExperience = mentor.getYearsOfExperience();
        mentorTrainingRepresentation.trainingName = training.getTrainingName();
        mentorTrainingRepresentation.trainingCost = training.getCost().toPlainString();
        mentorTrainingRepresentation.enrolledUsers = training.getEnrolledUsers().stream().map(User::getId).map(Email::toString).collect(Collectors.joining(","));
        return mentorTrainingRepresentation;
    }

}
