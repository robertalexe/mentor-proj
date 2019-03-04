package com.robert.mentor.infrastructure;

import com.robert.mentor.domain.Email;
import com.robert.mentor.domain.IdentitySupplier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityIdentitySupplier implements IdentitySupplier {

    @Override
    public Email get() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            return new Email(((UserDetails)principal).getUsername());
        }
        throw new UsernameNotFoundException(principal.toString());
    }
}
