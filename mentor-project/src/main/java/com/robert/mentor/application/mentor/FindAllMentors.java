package com.robert.mentor.application.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.Mentors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.search.SearchTerm;
import java.util.Set;

@DDD.ApplicationService
@Service
public class FindAllMentors {

    @Autowired
    private Mentors mentors;

    public Set<Mentor> findAllMentors() {
        return mentors.findAll();
    }
}
