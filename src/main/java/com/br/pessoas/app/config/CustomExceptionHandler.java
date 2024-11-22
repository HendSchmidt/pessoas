package com.br.pessoas.app.config;

import com.br.pessoas.useCase.exception.PersonCreateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(PersonCreateException.class)
	public ResponseEntity<?> personCreateException(PersonCreateException ex) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getMessage());
	}
}
