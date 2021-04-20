package com.example.tracker_v3.error_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice("com.example.tracker_v3.user")
public class ExceptionAdvice_User {

    //specific exceptions
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException e){
        LinkedHashMap<String, Object> error = new LinkedHashMap<String, Object>(){};
        error.put("error", "Bad Request");
        error.put("message", "userId parameter is required.");
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleIllegalStateException(
            IllegalStateException e){
        LinkedHashMap<String, Object> error = new LinkedHashMap<String, Object>(){};
        error.put("error", "Bad Request");
        error.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    //global exceptions

}
