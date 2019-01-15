package com.robert.mentor.domain;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RegistrationCodeGenerator {

    private final int CODE_LENGTH = 20;

    public String generateSignUpCode() {
        return RandomStringUtils.randomAlphanumeric(CODE_LENGTH);
    }
}
