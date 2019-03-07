package com.robert.mentor.infrastructure.user;

import com.robert.mentor.config.MentorProjectApplication;
import com.robert.mentor.domain.ContactNumber;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.NameFragment;
import com.robert.mentor.domain.Password;
import com.robert.mentor.domain.user.User;
import com.robert.mentor.domain.user.Users;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MentorProjectApplication.class)
public class SdjUsersLocalIT {

    @Autowired
    private Users sut;
    @Autowired
    private UsersSdj usersSdj;

    private final Email email = new Email("test@test.com");
    private final Password password = new Password("pass");
    private final NameFragment firstName = new NameFragment("first");
    private final NameFragment lastName = new NameFragment("last");
    private final ContactNumber contactNumber = new ContactNumber("+000030303");
    private final LocalDateTime registeredDate = LocalDateTime.of(2019, 02, 02, 12, 00, 00);

    @Before
    public void initUser() {
        usersSdj.save(new User(email, password, firstName, lastName, contactNumber, registeredDate));
    }

    @Test
    public void should_retrieve_existing_user() {
        User user = sut.findOne(email);
        assertThat(user).isNotNull();
    }

    @Test
    public void should_persist_new_user() {
        User user = new User(
                new Email("AAA@AAB.COM"), new Password("password"),
                new NameFragment("First"), new NameFragment("Second"), new ContactNumber("111"),
                LocalDateTime.now()
        );
        assertThat(user).isNotNull();
    }
}
