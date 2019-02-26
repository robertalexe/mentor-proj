package com.robert.mentor.exposition.training;

import com.robert.mentor.domain.training.Training;

public class TrainingRepresentation {

    public String id;
    public String name;
    public String cost;

    public static TrainingRepresentation toTrainingRepresentation(Training training) {
        TrainingRepresentation trainingRepresentation = new TrainingRepresentation();
        trainingRepresentation.id = training.getId().getValue();
        trainingRepresentation.name = training.getTrainingName();
        trainingRepresentation.cost = training.getCost().toString();
        return trainingRepresentation;
    }

}
