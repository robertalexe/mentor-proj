package com.robert.mentor.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;
import java.util.List;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

@DDD.ValueObject
@Getter
@Embeddable
public class Password extends BaseValueObject<Password> {

    @Password.PasswordConstraint
    @Column(name = "PASSWORD")
    private final String password;

    public Password(String value) {
        super(Password.class);
        this.password = value;
        validate(this);
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(password);
    }

    public String toString() {
        return format("%s{password=%s}", getClass().getSimpleName(), this.password);
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @javax.validation.Constraint(validatedBy = {})
    @NotNull
    @Size(min=1, max=30)
    private @interface PasswordConstraint {
        String message() default "Business rules for Password are not respected or missing";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
