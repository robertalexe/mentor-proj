package com.robert.mentor.infrastructure.user;

import com.robert.mentor.domain.user.User;
import com.robert.mentor.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SdjUsers implements Users {

    @Autowired
    private UsersSdj usersSdj;


    @Override
    public User signUp(User user) {
        return usersSdj.save(user);
    }
}
