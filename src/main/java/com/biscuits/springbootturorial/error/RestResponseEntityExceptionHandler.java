package com.biscuits.springbootturorial.error;

import com.biscuits.springbootturorial.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/* This class will handle all the exception messages we want to display...*/

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//method to handle the department not found exception...

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
