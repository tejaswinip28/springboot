package com.usecase.springtraining.annotation;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ScheduleDateCheck.class)
public @interface ScheduleDate {
    public String message() default "Invalid Date.";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}


