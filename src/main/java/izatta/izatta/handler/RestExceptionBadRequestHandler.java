package izatta.izatta.handler;

import izatta.izatta.exception.ResourceBadRequestDetails;
import izatta.izatta.exception.ResourceBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionBadRequestHandler {

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> handleResourceNotFoundException (ResourceBadRequestException rfnException){
        ResourceBadRequestDetails rnfDetails = ResourceBadRequestDetails.builder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Resource bad request")
                .detail(rfnException.getMessage())
                .message(rfnException.getClass().getName()).build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.BAD_REQUEST);
    }
}
