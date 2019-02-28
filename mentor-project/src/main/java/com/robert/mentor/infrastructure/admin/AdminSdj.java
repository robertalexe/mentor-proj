package com.robert.mentor.infrastructure.admin;

import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminSdj extends JpaRepository<Admin, Email> {
}
