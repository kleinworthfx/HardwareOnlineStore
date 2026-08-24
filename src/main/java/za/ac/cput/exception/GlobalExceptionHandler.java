package za.ac.cput.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

/* GlobalExceptionHandler.java
   GlobalExceptionHandler
   Author: Paul Khumalo (230108547)
   Date: 22 August 2026 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<Map<String,Object>> response(HttpStatus status, String message)
    { return ResponseEntity.status(status).body(Map.of("timestamp", LocalDateTime.now().toString(), "status", status.value(), "error", status.getReasonPhrase(), "message", message));}

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNotFound(ResourceNotFoundException e)
    { return response(HttpStatus.NOT_FOUND, e.getMessage()); }

    @ExceptionHandler({InvalidInputException.class, IllegalArgumentException.class})
    public ResponseEntity<Map<String,Object>> handleBadRequest(RuntimeException e)
    { return response(HttpStatus.BAD_REQUEST, e.getMessage()); }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleAll(RuntimeException e)
    { return response(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()); }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String,Object>> handleConflict(DataIntegrityViolationException e)
    { return response(HttpStatus.CONFLICT, "Database constraint violation"); }
}
