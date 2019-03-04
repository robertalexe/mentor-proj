package com.robert.mentor.domain.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@DDD.Repository
public interface Mentors {

    Optional<Mentor> findOne(Email username);
    Set<Mentor> findAll();
    Mentor signUp(Mentor mentor);
}
