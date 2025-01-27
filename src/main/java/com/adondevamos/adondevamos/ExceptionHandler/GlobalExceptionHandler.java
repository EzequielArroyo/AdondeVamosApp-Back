package com.adondevamos.adondevamos.ExceptionHandler;

import com.adondevamos.adondevamos.Entities.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handlerArgumentException(IllegalArgumentException ex, WebRequest request){
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
    /*
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRunTimeException(RuntimeException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }
    */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handlerRunTimeException(RuntimeException ex){
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                "detail"
        );
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_GATEWAY);
    }
}
