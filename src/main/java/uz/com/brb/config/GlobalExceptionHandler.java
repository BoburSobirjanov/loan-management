package uz.com.brb.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.com.brb.exception.DataHasAlreadyExistsException;
import uz.com.brb.exception.DataNotFoundException;
import uz.com.brb.model.response.StandardResponse;
import uz.com.brb.model.response.Status;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<StandardResponse<String>> dataNotFoundExceptionHandler(
            DataNotFoundException e){
        return ResponseEntity.status(404).body(StandardResponse.<String>builder().status(Status.ERROR).message(e.getMessage()).build());
    }

    @ExceptionHandler(value = {DataHasAlreadyExistsException.class})
    public ResponseEntity<StandardResponse<String>> dataHasAlreadyExistsExceptionHandler(
            DataHasAlreadyExistsException e){
       return ResponseEntity.status(100).body(StandardResponse.<String>builder().status(Status.ERROR).message(e.getMessage()).build());
    }
}
