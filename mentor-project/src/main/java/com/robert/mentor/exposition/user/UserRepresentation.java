package com.robert.mentor.exposition.user;

import com.robert.mentor.domain.user.User;

import static com.robert.mentor.exposition.DateConverter.parseDate;
import static java.time.LocalDateTime.now;

public class UserRepresentation {

    public String id;
    public String userName;
    public String password;
    public String firstName;
    public String lastName;
    public String contactNumber;
    public String registeredDate;

    public User toDomain() {
        return null;
    }

    public User toDomainSignUpUser() {
        return null;
    }
}
