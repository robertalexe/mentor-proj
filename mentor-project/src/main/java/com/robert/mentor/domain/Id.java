package com.robert.mentor.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.annotation.*;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

@DDD.ValueObjectId
@Embeddable
public class Id extends BaseValueObject<Id> implements Serializable {

    @Id.IdConstraint
    @Column(name = "ID")
    private final String value;

    public Id() {
        super(Id.class);
        this.value = UUID.randomUUID().toString();
        validate(this);
    }

    public String getValue() {
        return value;
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(value);
    }

    public String toString() {
        return format("%s{value=%s}", getClass().getSimpleName(), this.value);
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @javax.validation.Constraint(validatedBy = {})
    @NotNull
    private @interface IdConstraint {
        String message() default "Business rules for Unique identifier are not respected or missing";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
