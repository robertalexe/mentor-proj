package com.robert.mentor.infrastructure.user;

import com.robert.mentor.domain.user.User;
import com.robert.mentor.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SdjUsers implements Users, UserDetailsService {

    @Autowired
    private UsersSdj usersSdj;


    @Override
    public User signUp(User user) {
        return usersSdj.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersSdj.findAll();
    }

    @Override
    public User findOne(String username) {
        return usersSdj.findById(username).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersSdj.findById(username).orElseThrow( () -> new UsernameNotFoundException("Invalid username or password"));
        return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
