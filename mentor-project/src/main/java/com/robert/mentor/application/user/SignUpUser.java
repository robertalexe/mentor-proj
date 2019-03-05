package com.robert.mentor.application.user;

import com.robert.mentor.domain.RegistrationCodeGenerator;
import com.robert.mentor.domain.email.VerificationCodeSender;
import com.robert.mentor.domain.user.User;
import com.robert.mentor.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpUser {

    @Autowired
    private Users users;
    @Autowired
    private VerificationCodeSender verificationCodeSender;

    @Autowired
    private RegistrationCodeGenerator registrationCodeGenerator;

    public String signUp(User user) throws Exception {
        user.setRegisteredCode(registrationCodeGenerator.generateSignUpCode());
        verificationCodeSender.sendVerificationCodeTo(user);
        return users.signUp(user).getId().getValue();
    }
}
