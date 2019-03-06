package com.robert.mentor.infrastructure.appusers;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.appusers.AppUser;
import com.robert.mentor.domain.appusers.AppUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@DDD.RepositoryImpl
@Service
public class SdjAppUsers implements AppUsers {

    @Autowired
    private AppUsersSdj appUsers;

    @Override
    public List<AppUser> getAll() {
        return appUsers.findAll();
    }

    @Override
    public Optional<AppUser> getUserByRegistrationCode(String code) {
        return Optional.ofNullable(appUsers.findByRegisteredCode(code));
    }
}
