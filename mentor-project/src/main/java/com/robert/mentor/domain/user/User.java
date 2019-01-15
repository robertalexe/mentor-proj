package com.robert.mentor.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "APP_USERS")
@NoArgsConstructor
@Getter @Setter
public class User {

    @Id @NotNull
    private String id;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "CONTACT_NO")
    private String contactNumber;
    @Column(name = "REG_DATE")
    private LocalDateTime registeredDate;
    @Column(name = "REG_CODE")
    private String registeredCode;
    @Column(name = "ACTIVE")
    private boolean active;

    public User(String id, String userName, String password, String firstName, String lastName, String contactNumber, LocalDateTime registeredDate, String registeredCode, boolean active) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.registeredDate = registeredDate;
        this.registeredCode = registeredCode;
        this.active = active;
    }

    public User(String id, String userName, String password, String firstName, String lastName, String contactNumber, LocalDateTime registeredDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.registeredDate = registeredDate;
        this.active = false;
    }

}
