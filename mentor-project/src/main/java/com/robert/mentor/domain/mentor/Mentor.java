package com.robert.mentor.domain.mentor;

import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.user.User;

import java.util.List;
import java.util.TimeZone;

public class Mentor extends User {

    private TimeZone timeZone;
    private WorkingTimes workingTimes;
    private List<String> technologies;
    private String linkedInUrl;
    private int yearsOfExperience;
    private List<Training> trainings;

}
