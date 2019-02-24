package com.robert.mentor.domain.user;

import java.util.List;

public interface Users {

    User signUp(User user);
    List<User> findAll();
    User findOne(String username);
}
