package com.robert.mentor.infrastructure.user;

import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersSdj extends JpaRepository<User, Email> {

}
