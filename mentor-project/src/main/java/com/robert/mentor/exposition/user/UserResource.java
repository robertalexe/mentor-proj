package com.robert.mentor.exposition.user;

import com.robert.mentor.application.user.SignUpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*")
public class UserResource {

    @Autowired
    private SignUpUser signUpUser;

    @RequestMapping(method = POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signUpUser(@RequestBody UserRepresentation userRepresentation) throws Exception {
        return new ResponseEntity<>(signUpUser.signUp(userRepresentation.toDomainSignUpUser()), HttpStatus.OK);
    }

}
