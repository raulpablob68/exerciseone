package com.exercisetwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClassNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 523986372642767514L;

  public ClassNotFoundException(String arg0) {
    super(arg0);
  }
  
}
