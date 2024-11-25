package com.br.pessoas.app.config;

import com.br.pessoas.app.dto.ErrorResponse;
import com.br.pessoas.useCase.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(value = PersonCreateException.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody ErrorResponse personCreateException(final PersonCreateException ex){
		return new ErrorResponse(HttpStatus.ACCEPTED.value(), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = PersonRecoveryException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse personRecoveryException(final PersonRecoveryException ex){
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = AddressCreateException.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody ErrorResponse addressCreateException(final AddressCreateException ex){
		return new ErrorResponse(HttpStatus.ACCEPTED.value(), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = AddressRecoveryException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse addressRecoveryException(final AddressRecoveryException ex){
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
	}


	@ExceptionHandler(value = EmailCreateException.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody ErrorResponse emailCreateException(final EmailCreateException ex){
		return new ErrorResponse(HttpStatus.ACCEPTED.value(), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = EmailRecoveryException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse emailRecoveryException(final EmailRecoveryException ex){
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
	}


	@ExceptionHandler(value = TelephoneCreateException.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody ErrorResponse telephoneCreateException(final TelephoneCreateException ex){
		return new ErrorResponse(HttpStatus.ACCEPTED.value(), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = TelephoneRecoveryException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse telephoneRecoveryException(final TelephoneRecoveryException ex){
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
	}
}
