package com.robert.mentor.infrastructure.user;

import com.robert.mentor.config.MentorProjectApplication;
import com.robert.mentor.domain.ContactNumber;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.NameFragment;
import com.robert.mentor.domain.Password;
import com.robert.mentor.domain.user.User;
import com.robert.mentor.domain.user.Users;
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

    @Test
    public void should_retrieve_existing_user() {
        User user = sut.findOne(new Email("ABC@ABC.COM"));
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
