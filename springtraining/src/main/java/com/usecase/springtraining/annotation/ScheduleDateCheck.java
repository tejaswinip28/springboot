package com.usecase.springtraining.annotation;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScheduleDateCheck implements ConstraintValidator<ScheduleDate, String>
{
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
               LocalDateTime.parse(value);
		}
        catch (Exception e) {
               return false;
        }
        return true;
	}
}
