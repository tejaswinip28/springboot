package com.usecase.springtraining.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class ScheduleNumberCheck implements ConstraintValidator<ScheduleNumber, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) 
	{
		
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		boolean isValid = false;
		try {
            Phonenumber.PhoneNumber indiaNumberProto = phoneUtil.parse(value, "IN");
            isValid = phoneUtil.isValidNumber(indiaNumberProto);
            return isValid;
        }  catch (Exception e) {
			return false;
		}
	}	 
}