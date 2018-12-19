package com.rest.clarify.cases.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDetails {

	private String code;
	private String message;
	private String details;
	private Date timestamp;


	public ErrorDetails(String code, String message, String details, Date timestamp) {
		this.code = code;
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}

}
