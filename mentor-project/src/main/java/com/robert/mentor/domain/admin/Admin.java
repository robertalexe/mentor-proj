package com.robert.mentor.domain.admin;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DDD.AggregateRoot
@Entity
@DiscriminatorValue("ADMIN")
@NoArgsConstructor
@Getter
public class Admin extends User {

}
