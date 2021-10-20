package br.com.example.product.config;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.example.product.dto.ErrorMessage;
import br.com.example.product.exception.NotFoundException;

@RestControllerAdvice
public class ExceptionHandle {
	  @ExceptionHandler(value = NotFoundException.class)
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	  public ErrorMessage resourceNotFoundException(NotFoundException ex, WebRequest request) {
	    return new ErrorMessage(ex.getStatusCode(), Instant.now(), ex.getMessage());
	  }
}
