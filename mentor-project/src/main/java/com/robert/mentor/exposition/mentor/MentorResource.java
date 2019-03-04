package com.robert.mentor.exposition.mentor;

import com.robert.mentor.application.mentor.FindCurrentMentor;
import com.robert.mentor.domain.mentor.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.robert.mentor.exposition.mentor.MentorRepresentation.toMentorRepresentation;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class MentorResource {

    @Autowired
    private FindCurrentMentor currentMentor;

    @RequestMapping(value = "/mentor-details", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public MentorRepresentation getMentorDetails() {
        Mentor mentor = currentMentor.findCurrentMentor();
        return toMentorRepresentation(mentor);
    }
}
