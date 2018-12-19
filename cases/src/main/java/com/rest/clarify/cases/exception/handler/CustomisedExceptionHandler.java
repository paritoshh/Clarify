package com.rest.clarify.cases.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.clarify.cases.exception.CaseNotFoundException;
import com.rest.clarify.cases.exception.GenericException;
import com.rest.clarify.cases.model.ErrorDetails;

@ControllerAdvice
@RestController
public class CustomisedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CaseNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleCaseNotFoundException(CaseNotFoundException exception,
			WebRequest request) {
		return new ResponseEntity<>(
				ErrorDetails.builder().code("ER001").message(exception.getMessage()).details("").build(),
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(GenericException.class)
	public final ResponseEntity<ErrorDetails> handleCaseNotFoundException(GenericException exception) {
		return new ResponseEntity<>(
				ErrorDetails.builder().code("ER002").message(exception.getMessage()).details("").build(),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
