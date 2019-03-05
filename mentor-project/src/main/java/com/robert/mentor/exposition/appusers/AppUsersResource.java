package com.robert.mentor.exposition.appusers;

import com.robert.mentor.application.appusers.AllApplicationUsers;
import com.robert.mentor.domain.appusers.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AppUsersResource {

    @Autowired
    private AllApplicationUsers allApplicationUsers;

    @RequestMapping(value = "/app-users", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppUserRepresentation> getAppUsers() {
        List<AppUser> appUsers = allApplicationUsers.allApplicationUsers();
        return appUsers.stream().map(AppUserRepresentation::toAppUserRepresentation).collect(toList());
    }
}
