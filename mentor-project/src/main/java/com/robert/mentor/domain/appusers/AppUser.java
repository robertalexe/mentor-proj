package com.robert.mentor.domain.appusers;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.NameFragment;
import com.robert.mentor.domain.UserType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@DDD.AggregateRoot
@Entity @Table(name = "APP_USERS")
public class AppUser {

    @Id
    @NotNull
    @EmbeddedId
    private Email id;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "FIRST_NAME"))
    private NameFragment firstName;
    @Embedded @AttributeOverride(name = "value", column = @Column(name = "LAST_NAME"))
    private NameFragment lastName;
    @Column(name = "ACTIVE")
    private boolean active;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "REG_CODE")
    private String registeredCode;

    public Email getId() {
        return id;
    }

    public NameFragment getFirstName() {
        return firstName;
    }

    public NameFragment getLastName() {
        return lastName;
    }

    public boolean isActive() {
        return active;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getRegisteredCode() {
        return registeredCode;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
