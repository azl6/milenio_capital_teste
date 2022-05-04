package com.azold6.m_capital.controllers;

import com.azold6.m_capital.exceptions.ExistentPathException;
import com.azold6.m_capital.exceptions.ObjectNotFoundException;
import com.azold6.m_capital.exceptions.StandardError;
import com.azold6.m_capital.utils.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e){
        StandardError error = new StandardError(
                e.getMessage(),
                DateUtil.convertSystemTimeMillisToString(System.currentTimeMillis()),
                HttpStatus.NOT_FOUND.value()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ExistentPathException.class)
    public ResponseEntity<StandardError> existentPath(ExistentPathException e){
        StandardError error = new StandardError(
                e.getMessage(),
                DateUtil.convertSystemTimeMillisToString(System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST.value()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }








}
