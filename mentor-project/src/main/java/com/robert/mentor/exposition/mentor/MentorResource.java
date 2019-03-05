package com.robert.mentor.exposition.mentor;

import com.robert.mentor.application.mentor.FindCurrentMentor;
import com.robert.mentor.application.mentor.SignUpMentor;
import com.robert.mentor.domain.mentor.Mentor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.robert.mentor.exposition.mentor.MentorRepresentation.toMentorRepresentation;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/mentor")
@CrossOrigin(origins = "*")
public class MentorResource {

    @Autowired
    private FindCurrentMentor currentMentor;
    @Autowired
    private SignUpMentor signUpMentor;

    @RequestMapping(value = "/mentor-details", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public MentorRepresentation getMentorDetails() {
        Mentor mentor = currentMentor.findCurrentMentor();
        return toMentorRepresentation(mentor);
    }

    @RequestMapping(method = POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signUpUser(@RequestBody MentorRepresentation mentorRepresentation) throws Exception {
        return new ResponseEntity<>(signUpMentor.signUp(mentorRepresentation.toDomainSignUpMentor()), HttpStatus.OK);
    }
}
