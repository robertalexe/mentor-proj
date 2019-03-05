package com.robert.mentor.domain.appusers;

import com.robert.mentor.domain.DDD;

import java.util.List;
import java.util.Optional;

@DDD.Repository
public interface AppUsers {

    List<AppUser> getAll();

    Optional<AppUser> getUserByRegistrationCode(String code);
}
