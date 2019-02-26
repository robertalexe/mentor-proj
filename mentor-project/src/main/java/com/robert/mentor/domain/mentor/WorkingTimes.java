package com.robert.mentor.domain.mentor;

import com.robert.mentor.domain.BaseValueObject;
import com.robert.mentor.domain.DDD;
import com.robert.mentor.domain.DayOFWeek;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

@DDD.ValueObject
@Getter
public class WorkingTimes extends BaseValueObject<WorkingTimes> {

    @ElementCollection
    @CollectionTable(name = "MENTOR_WORKING_TIMES")
    @MapKeyColumn(name = "DAY_OF_WEEK")
    @Enumerated(EnumType.STRING)
    private Map<DayOFWeek, WorkingHours> workingTimesData;

    public WorkingTimes(Map<DayOFWeek, WorkingHours> workingTimesData) {
        super(WorkingTimes.class);
        this.workingTimesData = new HashMap<>(workingTimesData);
        validate(this);
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(workingTimesData);
    }

    public String toString() {
        return format("%s{workingTimesData=%s}", getClass().getSimpleName(), this.workingTimesData);
    }
}
