package com.robert.mentor.infrastructure.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.Mentors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DDD.RepositoryImpl
@Service
public class SdjMentors implements Mentors {

    @Autowired
    private MentorsSdj sdj;

    @Override
    public Mentor findOne(Email username) {
        return sdj.getOne(username);
    }

    @Override
    public List<Mentor> findAll() {
        return sdj.findAll();
    }

    @Override
    public Mentor signUp(Mentor mentor) {
        return sdj.save(mentor);
    }
}
