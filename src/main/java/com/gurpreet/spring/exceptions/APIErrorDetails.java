package com.gurpreet.spring.exceptions;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class APIErrorDetails {

	String message;
	String additionalDetails;
	Date timestamp;
	

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAdditionalDetails() {
		return additionalDetails;
	}
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
