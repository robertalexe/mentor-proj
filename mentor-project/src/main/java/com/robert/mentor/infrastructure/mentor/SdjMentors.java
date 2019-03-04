package com.robert.mentor.infrastructure.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.Mentors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@DDD.RepositoryImpl
@Service
public class SdjMentors implements Mentors {

    @Autowired
    private MentorsSdj sdj;

    @Override
    public Optional<Mentor> findOne(Email username) {
        return Optional.of(sdj.getOne(username));
    }

    @Override
    public Set<Mentor> findAll() {
        return new HashSet<>(sdj.findAll());
    }

    @Override
    public Mentor signUp(Mentor mentor) {
        return sdj.save(mentor);
    }
}
