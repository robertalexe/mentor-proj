package com.robert.mentor.exposition.technologies;

import com.robert.mentor.application.technology.GetAllTechnologies;
import com.robert.mentor.domain.technology.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/technologies")
@CrossOrigin(origins = "*")
public class TechnologiesResource {

    @Autowired
    private GetAllTechnologies technologies;

    @RequestMapping(value = "/all", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TechnologyRepresentation> allTechnologies() {
        return technologies.getAllAvailableTechnologies()
                .stream()
                .map(TechnologyRepresentation::toTechnologyRepresentation)
                .collect(toList());
    }
}
