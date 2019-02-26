package com.robert.mentor.domain.mentor;

import com.robert.mentor.domain.BaseValueObject;
import com.robert.mentor.domain.DDD;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@DDD.ValueObject
@Embeddable
@Getter
public class WorkingHours extends BaseValueObject<WorkingHours> {

    @Column(name = "FROM_HOUR")
    private final LocalTime from;
    @Column(name = "TO_HOUR")
    private final LocalTime to;

    public WorkingHours(LocalTime from, LocalTime to) {
        super(WorkingHours.class);
        this.from = from;
        this.to = to;
        validate(this);
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return asList(from, to);
    }
}
