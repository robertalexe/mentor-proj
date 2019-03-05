package com.robert.mentor.exposition.technologies;

import com.robert.mentor.domain.technology.Technology;

public class TechnologyRepresentation {

    public String technology;

    public static TechnologyRepresentation toTechnologyRepresentation(Technology technology) {
        TechnologyRepresentation representation = new TechnologyRepresentation();
        representation.technology = technology.getValue();
        return representation;
    }
}
