package com.exercisetwo.exception;

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
  @ExceptionHandler(SubjectNotFoundException.class)
  public final ResponseEntity<Object> handleParentNotFoundExceptions(
      SubjectNotFoundException subjectNotFoundException, WebRequest webRequest) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
        subjectNotFoundException.getMessage(), webRequest.getDescription(false));
    log.info("handleSubjectNotFoundExceptions");
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(ClassNotFoundException.class)
  public final ResponseEntity<Object> handleClassNotFoundExceptions(
		  ClassNotFoundException classNotFoundException, WebRequest webRequest) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
    		classNotFoundException.getMessage(), webRequest.getDescription(false));
    log.info("handleClassNotFoundExceptions");
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

}
