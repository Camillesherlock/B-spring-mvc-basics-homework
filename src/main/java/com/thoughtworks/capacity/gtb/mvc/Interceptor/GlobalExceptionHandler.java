package com.thoughtworks.capacity.gtb.mvc.Interceptor;

import com.thoughtworks.capacity.gtb.mvc.Error.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginErrorException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserIsExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sun.jvm.hotspot.runtime.ConstructionException;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handler (MethodArgumentNotValidException ex)
    {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler({UserIsExistException.class, UserNotFoundException.class,
            LoginErrorException.class})
    public ResponseEntity<ErrorResult> handler(Exception ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResult> handler(ConstraintViolationException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

}
