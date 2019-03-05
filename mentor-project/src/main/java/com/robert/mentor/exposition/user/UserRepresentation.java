package com.robert.mentor.exposition.user;

import com.robert.mentor.domain.ContactNumber;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.NameFragment;
import com.robert.mentor.domain.Password;
import com.robert.mentor.domain.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.robert.mentor.exposition.DateConverter.parseDate;
import static java.time.LocalDateTime.now;

public class UserRepresentation {

    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public String contactNumber;

    public User toDomain() {
        return null;
    }

    public User toDomainSignUpUser() {
        return new User(
                new Email(email),
                new Password(password),
                new NameFragment(firstName),
                new NameFragment(lastName),
                new ContactNumber(contactNumber),
                now()
        );
    }
}
