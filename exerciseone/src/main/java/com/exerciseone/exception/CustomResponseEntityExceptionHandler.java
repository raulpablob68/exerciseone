package com.exerciseone.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  Logger log = LoggerFactory.getLogger(this.getClass());
  
  /**
   * Maneja todas las excepciones generales.
   * @param exception Excepción.
   * @param webRequest WebRequest.
   * @return ResponseEntity con el estado.
   */
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception exception,
      WebRequest webRequest) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
        webRequest.getDescription(false));
    log.info("handleAllExceptions");
    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Maneja las excepciones relacionadas con Parent.
   * @param parentNotFoundException parentNotFoundException.
   * @param webRequest WebRequest.
   * @return ResponseEntity con el estado.
   */
  @ExceptionHandler(ParentNotFoundException.class)
  public final ResponseEntity<Object> handleParentNotFoundExceptions(
      ParentNotFoundException parentNotFoundException, WebRequest webRequest) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
        parentNotFoundException.getMessage(), webRequest.getDescription(false));
    log.info("handleParentNotFoundExceptions");
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

}
