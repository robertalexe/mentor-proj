package com.robert.mentor.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.*;
import java.util.List;

import static java.util.Collections.singletonList;

@DDD.ValueObject
@Getter
@Embeddable
public class UserType extends BaseValueObject<UserType> {

    @Column(name = "USER_TYPE", insertable = false, updatable = false)
    @UserType.UserTypeConstraint
    private final String value;

    public UserType(String value) {
        super(UserType.class);
        this.value = value;
        validate(this);
    }

    @Override
    public List<Object> attributesContainedInValueObject() {
        return singletonList(value);
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @javax.validation.Constraint(validatedBy = {})
    @NotNull
    @Size(min = 1, max = 10) //Short: USER, ADMIN, MENTOR
    private @interface UserTypeConstraint {
        String message() default "Business rules for Email are not respected or missing";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};

    }
}
