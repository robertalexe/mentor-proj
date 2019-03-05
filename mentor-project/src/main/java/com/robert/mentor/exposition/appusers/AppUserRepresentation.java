package com.robert.mentor.exposition.appusers;

import com.robert.mentor.domain.appusers.AppUser;

public class AppUserRepresentation {

    public String email;
    public String firstName;
    public String lastName;
    public boolean active;
    public String userType;

    public static AppUserRepresentation toAppUserRepresentation(AppUser appUser) {
        AppUserRepresentation representation = new AppUserRepresentation();
        representation.email = appUser.getId().getValue();
        representation.firstName = appUser.getFirstName().getValue();
        representation.lastName = appUser.getLastName().getValue();
        representation.active = appUser.isActive();
        representation.userType = appUser.getUserType().getValue();
        return representation;
    }
}
