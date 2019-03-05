package com.robert.mentor.exposition.mentor;

import com.robert.mentor.domain.mentor.Timezones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/timezones")
@CrossOrigin(origins = "*")
public class TimezoneResource {

    @Autowired
    private Timezones timezones;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Set<String>> allTimezones() {
        return new ResponseEntity<>(timezones.allAvailableTimezones(), HttpStatus.OK);
    }
}
