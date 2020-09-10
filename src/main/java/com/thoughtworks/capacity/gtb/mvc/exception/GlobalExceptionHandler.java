package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        ErrorMessage errorResult = new ErrorMessage(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(UserNameAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> notExistsHandler(UserNameAlreadyExistsException e) {
        ErrorMessage errorResult = new ErrorMessage("用户名已存在");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResult);
    }

    @ExceptionHandler(UserNameOrPassWordInvalidException.class)
    public ResponseEntity<ErrorMessage> invalidHandler(UserNameOrPassWordInvalidException e) {
        ErrorMessage errorResult = new ErrorMessage("用户名或密码错误");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }
}
