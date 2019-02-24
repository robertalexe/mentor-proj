package com.robert.mentor.domain.admin;

import com.robert.mentor.domain.user.User;

import java.time.LocalDateTime;

public class Admin extends User {

    public Admin(String id, String userName, String password, String firstName, String lastName, String contactNumber, LocalDateTime registeredDate, String registeredCode, boolean active) {
        super(id, userName, password, firstName, lastName, contactNumber, registeredDate, registeredCode, active);
    }

}
