package izatta.izatta.handler;

import izatta.izatta.exception.ResourceNotFoundDetails;
import izatta.izatta.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionNotFoundHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFoundException rfnException){

        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .message(rfnException.getClass().getName()).build();

        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }
}