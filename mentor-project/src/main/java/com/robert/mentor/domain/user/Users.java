package com.robert.mentor.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Users {

    User signUp(User user);
}
