package com.robert.mentor.domain.valueobjects;

import com.robert.mentor.domain.Validable;

import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

public class Email implements Validable {

    @EmailConstraint
    private String value;

    public Email(String value) {
        this.value = value;
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @javax.validation.Constraint(validatedBy = {})
    @NotNull
    @javax.validation.constraints.Email
    private @interface EmailConstraint {
        String message() default "Business rules for User Name are not respected or missing";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
