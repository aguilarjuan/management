package com.nisum.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {


	@ExceptionHandler(value = EmailDuplicatedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ErrorResponseDTO handleEmailDuplicatedException(EmailDuplicatedException ex) {
		return ErrorResponseDTO.builder().httpMessage(ex.getMessage()).build();
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ErrorResponseDTO handleArgumentNotValidException(MethodArgumentNotValidException ex) {
		return ErrorResponseDTO.builder().httpMessage("validation error in dto request data").build();
	}

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ErrorResponseDTO handleRuntimeException(RuntimeException ex) {
		return ErrorResponseDTO.builder().httpMessage("Application Error processing the request").build();
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ErrorResponseDTO handleGenericException(Exception ex) {
		return ErrorResponseDTO.builder().httpMessage("unexpected error in server").build();
	}
}
