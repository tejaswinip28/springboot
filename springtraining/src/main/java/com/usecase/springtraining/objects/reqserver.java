package com.usecase.springtraining.objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.usecase.springtraining.annotation.ScheduleDate;
import com.usecase.springtraining.annotation.ScheduleNumber;


public class reqserver {
	
	@NotNull(message = "message may not be null")
	@NotEmpty(message = "message may not be empty")
	private String message;
	@ScheduleNumber
	private String ph_numb;
	@ScheduleDate
	private String timeofsched;
	
	public reqserver(String message, String ph_numb, String timeofsched) {
		this.message = message;
		this.ph_numb = ph_numb;
		this.timeofsched = timeofsched;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPh_numb() {
		return ph_numb;
	}
	public void setPh_numb(String ph_numb) {
		this.ph_numb = ph_numb;
	}
	public String getTimeofsched() {
		return timeofsched;
	}
	public void setTimeofsched(String timeofsched) {
		this.timeofsched = timeofsched;
	}
	@Override
	public String toString() {
		return "reqserver [message=" + message + ", ph_numb=" + ph_numb + ", timeofsched=" + timeofsched + "]";
	}
}
