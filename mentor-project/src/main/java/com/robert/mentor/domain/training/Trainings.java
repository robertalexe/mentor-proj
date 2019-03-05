package com.robert.mentor.domain.training;

import com.robert.mentor.domain.Id;
import com.robert.mentor.domain.user.User;

import java.util.Optional;
import java.util.Set;

public interface Trainings {

    Set<Training> findAll();

    Set<Training> findTrainingsForUser(User user);

    Optional<Training> findTrainingByTrainingName(String trainingName);

    Optional<Training> findTrainingById(Id id);
}
