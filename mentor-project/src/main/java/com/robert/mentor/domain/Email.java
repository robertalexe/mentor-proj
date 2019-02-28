package com.robert.mentor.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.annotation.*;
import java.util.List;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

@DDD.ValueObject
@Getter
@Embeddable
public class Email extends BaseValueObject<Email> implements Serializable {

    @EmailConstraint
    @Column(name = "EMAIL")
    private final String value;

    public Email(String value) {
        super(Email.class);
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
    @javax.validation.constraints.Email
    private @interface EmailConstraint {
        String message() default "Business rules for Email are not respected or missing";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    private Email() {
        super(Email.class);
        this.value = null;
    }
}
