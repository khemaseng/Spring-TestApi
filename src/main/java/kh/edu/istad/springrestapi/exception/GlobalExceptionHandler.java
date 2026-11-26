package kh.edu.istad.springrestapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handlerResponseStatusException(ResponseStatusException e) {
        log.error("ResponseStatusException: {}", e.getMessage());

        HttpStatus status = HttpStatus.resolve(e.getStatusCode().value());
        int statusCode = e.getStatusCode().value();
        String message = e.getReason() != null
                ? e.getReason()
                : (status != null ? status.getReasonPhrase() : "Error");

        Map<String, Object> body = new HashMap<>();
        body.put("message", message);
        body.put("status", statusCode);
        body.put("timestamp", Instant.now().toString());

        return ResponseEntity.status(e.getStatusCode()).body(body);
    }
}