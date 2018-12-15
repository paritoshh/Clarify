package com.rest.clarify.cases.exception;

public class CaseNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaseNotFoundException(String exception) {
		super(exception);
	}

}
