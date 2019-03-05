package com.robert.mentor.domain.technology;

import com.robert.mentor.domain.DDD;

import java.util.List;

@DDD.Repository
public interface Technologies {

    List<Technology> getAllTechnologies();
}
