package com.spring.scheduledevelop.exception;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Builder
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ErrorHandler errorHandler;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validation(MethodArgumentNotValidException e) {
        Map<String, String> error = new HashMap<>();
        e.getAllErrors().forEach(
                c -> error.put(((FieldError) c).getField(), c.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ScheduleDevelopException.class)
    public ResponseEntity<Object> handlerAlarmTodoListException(ScheduleDevelopException e) {
        ErrorCode errorCode = e.getErrorCode();
        return errorHandler.handleExceptionInternal(errorCode);
    }
}
