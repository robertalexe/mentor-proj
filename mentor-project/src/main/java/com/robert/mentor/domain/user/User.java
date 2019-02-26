package com.robert.mentor.domain.user;

import com.robert.mentor.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@DDD.AggregateRoot
@Entity @Table(name = "APP_USERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
@DiscriminatorValue("USER")
@NoArgsConstructor @Getter @Setter
public class User {

    @Id @NotNull @EmbeddedId
    private Email id;
    @Embedded
    private Password password;
    @Embedded @AttributeOverride(name = "value", column = @Column(name = "FIRST_NAME"))
    private NameFragment firstName;
    @Embedded @AttributeOverride(name = "value", column = @Column(name = "LAST_NAME"))
    private NameFragment lastName;
    @Embedded
    private ContactNumber contactNumber;
    @Column(name = "REG_DATE")
    private LocalDateTime registeredDate;
    @Column(name = "REG_CODE")
    private String registeredCode;
    @Column(name = "ACTIVE")
    private boolean active;
    @Embedded
    private UserType userType;

    public User(Email id, Password password, NameFragment firstName, NameFragment lastName, ContactNumber contactNumber, LocalDateTime registeredDate, String registeredCode, boolean active) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.registeredDate = registeredDate;
        this.registeredCode = registeredCode;
        this.active = active;
    }

    public User(Email id, Password password, NameFragment firstName, NameFragment lastName, ContactNumber contactNumber, LocalDateTime registeredDate) {
        this(id, password, firstName, lastName, contactNumber, registeredDate, null, false);
    }

}
