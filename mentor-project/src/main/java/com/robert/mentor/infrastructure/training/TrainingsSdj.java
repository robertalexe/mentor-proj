package com.robert.mentor.infrastructure.training;

import com.robert.mentor.domain.training.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingsSdj extends JpaRepository<Training, String> {
}
