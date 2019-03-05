package com.robert.mentor.infrastructure.appusers;

import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.appusers.AppUser;
import com.robert.mentor.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUsersSdj extends JpaRepository<AppUser, Email> {

    AppUser findByRegisteredCode(String code);
}
