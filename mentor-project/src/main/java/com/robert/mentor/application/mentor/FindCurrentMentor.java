package com.robert.mentor.application.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.IdentitySupplier;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.Mentors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

@DDD.ApplicationService
@Service
public class FindCurrentMentor {

    private IdentitySupplier identitySupplier;
    private Mentors mentors;

    public FindCurrentMentor(IdentitySupplier identitySupplier, Mentors mentors) {
        this.identitySupplier = requireNonNull(identitySupplier);
        this.mentors = requireNonNull(mentors);
    }

    public Mentor findCurrentMentor() {
        Email email = identitySupplier.get();
        return mentors.findOne(email).orElseThrow(() -> new UsernameNotFoundException(email.getValue()));
    }
}
