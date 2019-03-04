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
public class ContactNumber extends BaseValueObject<ContactNumber> {

    @ContactNumber.ContactNumberConstraint
    @Column(name = "CONTACT_NO")
    private final String value;

    public ContactNumber(String value) {
        super(ContactNumber.class);
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

    public String getValue() {
        return value;
    }

    @Documented
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @javax.validation.Constraint(validatedBy = {})
    @NotNull
    @Size(min=1, max=15)
    private @interface ContactNumberConstraint {
        String message() default "Business rules for Contact Number are not respected or missing";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    private ContactNumber() {
        super(ContactNumber.class);
        this.value = null;
    }
}
