package com.robert.mentor.infrastructure.training;

import com.google.common.collect.Sets;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.training.Trainings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SdjTrainings implements Trainings {

    @Autowired
    private TrainingsSdj sdj;

    @Override
    public Set<Training> findAll() {
        return Sets.newHashSet(sdj.findAll());
    }
}