package com.robert.mentor.application.user;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.IdentitySupplier;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.training.Trainings;
import com.robert.mentor.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@DDD.ApplicationService
@Service
public class UserActiveTrainings {

    @Autowired
    private IdentitySupplier identitySupplier;
    @Autowired
    private Users users;
    @Autowired
    private Trainings trainings;

    public Set<Training> userActiveTrainings() {
        Email currentUserEmail = identitySupplier.get();
        return trainings.findTrainingsForUser(users.findOne(currentUserEmail));
    }
}
