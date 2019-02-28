package com.robert.mentor.domain.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;

import java.util.List;

@DDD.Repository
public interface Mentors {

    Mentor findOne(Email username);
    List<Mentor> findAll();
    Mentor signUp(Mentor mentor);
}
