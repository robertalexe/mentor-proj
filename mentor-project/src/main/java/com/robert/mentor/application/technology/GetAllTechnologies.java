package com.robert.mentor.application.technology;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.technology.Technologies;
import com.robert.mentor.domain.technology.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DDD.ApplicationService
@Service
public class GetAllTechnologies {

    @Autowired
    private Technologies technologies;

    public List<Technology> getAllAvailableTechnologies() {
        return technologies.getAllTechnologies();
    }
}
