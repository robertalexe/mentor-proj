package com.robert.mentor.infrastructure.technology;

import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.technology.Technologies;
import com.robert.mentor.domain.technology.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DDD.RepositoryImpl
@Service
public class SdjTechnology implements Technologies {

    @Autowired
    private TechnologySdj technologySdj;

    @Override
    public List<Technology> getAllTechnologies() {
        return technologySdj.findAll();
    }
}
