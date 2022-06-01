package com.usecase.springtraining.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { FIELD,METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ScheduleNumberCheck.class)
public @interface ScheduleNumber {
    public String message() default "Invalid phone number.";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}


