package com.robert.mentor.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

@DDD.ValueObject
@Getter
@Embeddable
public class Technology extends BaseValueObject<Technology> {

    @Technology.TechnologyConstraint
    @Column(name = "TECHNOLOGY")
    private final String technology;

    public Technology(String technology) {
        super(Technology.class);
        this.technology = technology;
        validate(this);
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(technology);
    }

    public String toString() {
        return format("%s{technology=%s}", getClass().getSimpleName(), this.technology);
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @javax.validation.Constraint(validatedBy = {})
    @NotNull
    @Size(min = 1, max = 250)
    private @interface TechnologyConstraint {
        String message() default "Business rules for Technology are not respected or missing";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
