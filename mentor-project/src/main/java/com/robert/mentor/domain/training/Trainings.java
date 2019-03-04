package com.robert.mentor.domain.training;

import com.robert.mentor.domain.user.User;

import java.util.Set;

public interface Trainings {

    Set<Training> findAll();

    Set<Training> findTrainingsForUser(User user);
}
