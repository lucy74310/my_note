package com.lucy.my_note_backend.error;

import com.lucy.my_note_backend.entity.JsonError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionController {

    @ExceptionHandler
    public ResponseEntity<JsonError> handle(IOException ex) {
        int status = Integer.parseInt(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        String errorMessage = ex.getMessage();
        JsonError errorResponse = new JsonError(status, errorMessage);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
