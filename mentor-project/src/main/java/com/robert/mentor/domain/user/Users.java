package com.robert.mentor.domain.user;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.training.Training;

import java.util.List;

@DDD.Repository
public interface Users {

    User signUp(User user);
    List<User> findAll();
    User findOne(Email username);
    void acceptedTraining(Email username, Training training);
}
