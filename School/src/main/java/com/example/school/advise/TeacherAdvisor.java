package com.example.school.advise;

import com.example.school.dto.Api;
import com.example.school.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;

public class TeacherAdvisor {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Api> ApiException(ApiException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new Api(msg,400));
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Api> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new Api(msg, 400));
    }
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Api> EntityNotFoundException(EntityNotFoundException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new Api(msg, 400));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Api> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new Api(msg, 400));
    }

}
