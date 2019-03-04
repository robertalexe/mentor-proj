package com.robert.mentor.exposition.training;

import com.robert.mentor.domain.training.Training;

public class TrainingRepresentation {

    public String mentorFullName;
    public String trainingName;
    public String trainingCost;

    public static TrainingRepresentation toTrainingRepresentation(Training training) {
        TrainingRepresentation trainingRepresentation = new TrainingRepresentation();
        trainingRepresentation.mentorFullName = training.getMentorId().getValue();
        trainingRepresentation.trainingName = training.getTrainingName();
        trainingRepresentation.trainingCost = training.getCost().toPlainString();
        return trainingRepresentation;
    }
}
