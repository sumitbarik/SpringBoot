package com.demo.spring_boot_test.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{

  @ExceptionHandler(value = Exception.class)
  public final ResponseEntity<ErrorMessage> handleAnyException(Exception ex){
    ErrorMessage errMsg = new ErrorMessage(ex.getMessage(), "Some Exception Occured");
    return new ResponseEntity<ErrorMessage>(errMsg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

class ErrorMessage{
  private String message;
  private String details;
  public ErrorMessage(String message, String details) {
    super();
    this.message = message;
    this.details = details;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String getDetails() {
    return details;
  }
  public void setDetails(String details) {
    this.details = details;
  }
  
}