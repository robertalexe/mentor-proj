package com.robert.mentor.infrastructure.user;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.admin.Admin;
import com.robert.mentor.domain.mentor.Mentor;
import com.robert.mentor.domain.training.Training;
import com.robert.mentor.domain.user.User;
import com.robert.mentor.domain.user.Users;
import com.robert.mentor.infrastructure.admin.AdminSdj;
import com.robert.mentor.infrastructure.mentor.MentorsSdj;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@DDD.RepositoryImpl
public class SdjUsers implements Users, UserDetailsService {

    @Autowired
    private UsersSdj usersSdj;
    @Autowired
    private MentorsSdj mentorsSdj;
    @Autowired
    private AdminSdj adminSdj;

    @Override
    public User signUp(User user) {
        return usersSdj.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersSdj.findAll();
    }

    @Override
    public User findOne(Email username) {
        return usersSdj.findById(username).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public void acceptedTraining(Email username, Training training) {
        User user = usersSdj.findById(username).orElseThrow(() -> new UsernameNotFoundException("not found"));
        user.addActiveTraining(training);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersSdj.findById(new Email(username));
        if(user.isPresent() && user.get().isActive()) {
            return new org.springframework.security.core.userdetails.User(user.get().getId().getValue(), user.get().getPassword().getPassword(), getAuthority());
        }
        Optional<Mentor> mentor = mentorsSdj.findById(new Email(username));
        if(mentor.isPresent() && mentor.get().isActive()) {
            return new org.springframework.security.core.userdetails.User(mentor.get().getId().getValue(), mentor.get().getPassword().getPassword(), getAuthority());
        }
        Optional<Admin> admin = adminSdj.findById(new Email(username));
        if(admin.isPresent() && admin.get().isActive()) {
            return new org.springframework.security.core.userdetails.User(admin.get().getId().getValue(), admin.get().getPassword().getPassword(), getAuthority());
        }
        throw new UsernameNotFoundException("Username not found");
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
