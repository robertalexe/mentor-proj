package com.robert.mentor.application.user;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.appusers.AppUser;
import com.robert.mentor.domain.appusers.AppUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@DDD.ApplicationService
@Service
@Transactional
public class ActivateUser {

    @Autowired
    private AppUsers appUsers;

    public void activate(String activationToken) {
        AppUser user = appUsers.getUserByRegistrationCode(activationToken).orElseThrow( () -> new UsernameNotFoundException("User not found"));
        user.setActive(true);
    }
}
