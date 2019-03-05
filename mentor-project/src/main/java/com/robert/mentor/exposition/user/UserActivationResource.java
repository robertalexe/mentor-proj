package com.robert.mentor.exposition.user;

import com.robert.mentor.application.user.ActivateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*")
public class UserActivationResource {

    @Autowired
    private ActivateUser activateUser;

    @RequestMapping(value = "/activate/{activationToken}", method = RequestMethod.GET)
    public ResponseEntity<Void> activateUser(@PathVariable String activationToken) {
        activateUser.activate(activationToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
