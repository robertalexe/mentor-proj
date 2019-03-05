package com.robert.mentor.infrastructure.training;

import com.robert.mentor.domain.Id;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingsSdj extends JpaRepository<Training, Id> {

    List<Training> findTrainingsByEnrolledUsersContaining(User user);

    Training findTrainingByTrainingName(String trainingName);
}
