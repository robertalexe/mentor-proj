package com.robert.mentor.application.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.IdentitySupplier;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.Mentors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@DDD.ApplicationService
@Service
public class FindCurrentMentor {

    @Autowired
    private IdentitySupplier identitySupplier;
    @Autowired
    private Mentors mentors;

    public Mentor findCurrentMentor() {
        Email email = identitySupplier.get();
        return mentors.findOne(email).orElseThrow(() -> new UsernameNotFoundException(email.getValue()));
    }
}
