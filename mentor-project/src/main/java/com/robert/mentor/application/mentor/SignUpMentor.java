package com.robert.mentor.application.mentor;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.RegistrationCodeGenerator;
import com.robert.mentor.domain.email.VerificationCodeSender;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.mentor.Mentors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DDD.ApplicationService
@Service
public class SignUpMentor {

    @Autowired
    private Mentors mentors;
    @Autowired
    private VerificationCodeSender verificationCodeSender;

    @Autowired
    private RegistrationCodeGenerator registrationCodeGenerator;

    public String signUp(Mentor mentor) throws Exception {
        mentor.setRegisteredCode(registrationCodeGenerator.generateSignUpCode());
        verificationCodeSender.sendVerificationCodeTo(mentor);
        return mentors.signUp(mentor).getId().getValue();
    }
}
