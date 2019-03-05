package com.robert.mentor.infrastructure.mentor;

import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.mentor.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorsSdj extends JpaRepository<Mentor, Email> {

    Mentor findByRegisteredCode(String code);
}
