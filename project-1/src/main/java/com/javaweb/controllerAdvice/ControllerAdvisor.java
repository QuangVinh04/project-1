package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.Model.ErrorResponseDTO;

import customs_exception.FieldRequiredException;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(
    		ArithmeticException ex, WebRequest request) {
		ErrorResponseDTO err = new ErrorResponseDTO();
		err.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Số nguyên không chia cho 0 được");
		err.setDetail(details);
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
	@ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleArithmeticException(
    		FieldRequiredException ex, WebRequest request) {
		
		ErrorResponseDTO err = new ErrorResponseDTO();
		err.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("name or numberofbasement is null!");
		err.setDetail(details);
        return new ResponseEntity<>(err, HttpStatus.BAD_GATEWAY);
    }
}

