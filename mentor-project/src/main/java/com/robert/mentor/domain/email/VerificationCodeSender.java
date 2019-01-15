package com.robert.mentor.domain.email;

import com.robert.mentor.domain.user.User;

public interface VerificationCodeSender {

    void sendVerificationCodeTo(User user) throws Exception;
}
