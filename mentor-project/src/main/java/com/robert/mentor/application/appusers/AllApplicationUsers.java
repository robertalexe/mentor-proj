package com.robert.mentor.application.appusers;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.appusers.AppUser;
import com.robert.mentor.domain.appusers.AppUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DDD.ApplicationService
@Service
public class AllApplicationUsers {

    @Autowired
    private AppUsers appUsers;

    public List<AppUser> allApplicationUsers() {
        return appUsers.getAll();
    }
}
