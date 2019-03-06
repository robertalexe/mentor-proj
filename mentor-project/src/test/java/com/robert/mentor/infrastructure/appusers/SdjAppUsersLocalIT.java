package com.robert.mentor.infrastructure.appusers;

import com.robert.mentor.config.MentorProjectApplication;
import com.robert.mentor.domain.*;
import com.robert.mentor.domain.appusers.AppUser;
import com.robert.mentor.domain.user.User;
import com.robert.mentor.infrastructure.user.UsersSdj;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MentorProjectApplication.class)
public class SdjAppUsersLocalIT {

    @Autowired
    private SdjAppUsers sut;
    @Autowired
    private UsersSdj usersSdj;

    private static final Email EMAIL1 = new Email("abc@abc.com");
    private static final Email EMAIL2 = new Email("test@test.com");
    private static final String REG_CODE1 = "code1";
    private static final String REG_CODE2 = "code2";

    @Before
    public void init_repo_with_two_users() {
        usersSdj.deleteAll();
        usersSdj.save(generateAppUserWithEmailAndRegistrationCode(EMAIL1, REG_CODE1));
        usersSdj.save(generateAppUserWithEmailAndRegistrationCode(EMAIL2, REG_CODE2));
    }

    @Test
    public void get_all_should_return_two_users() {
        List<AppUser> actualList = sut.getAll();
        assertThat(actualList).isNotEmpty();
        assertThat(actualList).hasSize(2);
    }

    @Test
    public void get_user_by_reg_code_should_return_one_user() {
        Optional<AppUser> actualFoundUser = sut.getUserByRegistrationCode(REG_CODE1);
        assertThat(actualFoundUser.isPresent()).isTrue();
        assertThat(actualFoundUser.get().getId()).isEqualTo(EMAIL1);
    }

    @Test
    public void get_user_by_unknown_reg_code_should_return_empty_optional() {
        Optional<AppUser> actualFoundUser = sut.getUserByRegistrationCode("unknown");
        assertThat(actualFoundUser.isPresent()).isFalse();
    }

    private User generateAppUserWithEmailAndRegistrationCode(Email email, String regCode) {
        return new User(
                email,
                new Password("pass"),
                new NameFragment("test"),
                new NameFragment("test"),
                new ContactNumber("9999"),
                LocalDateTime.now(),
                regCode,
                true
        );
    }
}
