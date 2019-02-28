package com.robert.mentor.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;
import java.util.List;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

@DDD.ValueObject
@Getter
@Embeddable
public class Url extends BaseValueObject<Url> {

    @Url.UrlConstraint
    @Column(name = "LINKEDIN_URL")
    private final String value;

    public Url(String value) {
        super(Url.class);
        this.value = value;
        validate(this);
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
    //TODO regexp url format
    private @interface UrlConstraint {
        String message() default "Business rules for Url are not respected or missing";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    private Url() {
        super(Url.class);
        this.value = null;
    }
}
