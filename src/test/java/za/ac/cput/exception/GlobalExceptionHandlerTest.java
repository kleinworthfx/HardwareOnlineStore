package za.ac.cput.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
class GlobalExceptionHandlerTest { @Test void handlerReturns404(){var response=new GlobalExceptionHandler().handleNotFound(new ResourceNotFoundException("missing")); assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());} @Test void handlerReturns400(){var response=new GlobalExceptionHandler().handleBadRequest(new IllegalArgumentException("bad")); assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());} }
