package com.example.demo.exceptions;

import com.example.demo.crosscuting.domain.HttpResponseError;
import com.example.demo.crosscuting.domain.HttpResponseOk;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.Objects;

import static org.springframework.http.HttpStatus.*;

@Log4j2
@RestControllerAdvice
public class ExceptionHandling {

  public static final String ERROR_PATH = "/error";
  private static final String ACCOUNT_LOCKED =
      "Your account has been locked. Please contact administration";
  private static final String METHOD_IS_NOT_ALLOWED =
      "This request method is not allowed on this endpoint. Please send a '%s' request";
  private static final String INTERNAL_SERVER_ERROR_MSG =
      "An error occurred while processing the request";
  private static final String INCORRECT_CREDENTIALS =
      "Username / password incorrect. Please try again";
  private static final String ACCOUNT_DISABLED =
      "Your account has been disabled. If this is an error, please contact administration";
  private static final String ERROR_PROCESSING_FILE = "Error occurred while processing file";
  private static final String NOT_ENOUGH_PERMISSION = "You do not have enough permission";

  public static ResponseEntity<HttpResponseOk> createHttpResponseOk(
      final HttpStatus httpStatus, final Object body) {
    return new ResponseEntity<>(
        HttpResponseOk.builder().response(body).code(httpStatus.value()).build(), httpStatus);
  }

  public static ResponseEntity<HttpResponseError> createHttpResponseError(
      final HttpStatus httpStatus, final String message, final int code) {
    return new ResponseEntity<>(
        HttpResponseError.builder()
            .code(code)
            .reason(httpStatus.getReasonPhrase().toUpperCase())
            .message(message)
            .build(),
        httpStatus);
  }

  public static ResponseEntity<HttpResponseError> createHttpResponseError(
      final HttpStatus httpStatus,
      final String message,
      final int code,
      final Throwable throwable) {
    return new ResponseEntity<>(
        HttpResponseError.builder()
            .code(code)
            .reason(httpStatus.getReasonPhrase().toUpperCase())
            .message(message)
            .parentException(throwable)
            .build(),
        httpStatus);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<HttpResponseError> idosdeBusinessException(
      final BusinessException exception) {
    return createHttpResponseError(OK, exception.getMessage(), OK.value(), exception.getCause());
  }

  @ExceptionHandler(ApplicationException.class)
  public ResponseEntity<HttpResponseError> idosdeApplicationException(
      final ApplicationException exception) {
    return createHttpResponseError(
        INTERNAL_SERVER_ERROR,
        exception.getMessage(),
        INTERNAL_SERVER_ERROR.value(),
        exception.getCause());
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<HttpResponseError> methodNotSupportedException(
      final HttpRequestMethodNotSupportedException exception) {
    HttpMethod supportedMethod =
        Objects.requireNonNull(exception.getSupportedHttpMethods()).iterator().next();
    return createHttpResponseError(
        METHOD_NOT_ALLOWED,
        String.format(METHOD_IS_NOT_ALLOWED, supportedMethod),
        METHOD_NOT_ALLOWED.value(),
        exception.getCause());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<HttpResponseError> internalServerErrorException(final Exception exception) {
    log.error(exception.getMessage());
    return createHttpResponseError(
        INTERNAL_SERVER_ERROR,
        INTERNAL_SERVER_ERROR_MSG,
        INTERNAL_SERVER_ERROR.value(),
        exception.getCause());
  }

  @ExceptionHandler(NoResultException.class)
  public ResponseEntity<HttpResponseError> notFoundException(final NoResultException exception) {
    log.error(exception.getMessage());
    return createHttpResponseError(
        NOT_FOUND, exception.getMessage(), NOT_FOUND.value(), exception.getCause());
  }

  @ExceptionHandler(ResourceAccessException.class)
  public ResponseEntity<HttpResponseError> resourceAccessException(
      final ResourceAccessException exception) {
    log.error(exception.getMessage());
    return createHttpResponseError(
        INTERNAL_SERVER_ERROR,
        exception.getMessage(),
        INTERNAL_SERVER_ERROR.value(),
        exception.getCause());
  }

  @ExceptionHandler(HttpStatusCodeException.class)
  public ResponseEntity<HttpResponseError> httpStatusCodeException(
      final HttpStatusCodeException exception) {
    log.error(exception.getMessage());
    return createHttpResponseError(
        INTERNAL_SERVER_ERROR,
        exception.getMessage(),
        INTERNAL_SERVER_ERROR.value(),
        exception.getCause());
  }

  @ExceptionHandler(IOException.class)
  public ResponseEntity<HttpResponseError> iOException(final IOException exception) {
    log.error(exception.getMessage());
    return createHttpResponseError(
        INTERNAL_SERVER_ERROR,
        ERROR_PROCESSING_FILE,
        INTERNAL_SERVER_ERROR.value(),
        exception.getCause());
  }

  @RequestMapping(ERROR_PATH)
  public ResponseEntity<HttpResponseError> notFound404() {
    return createHttpResponseError(
        NOT_FOUND, "There is no mapping for this URL", NOT_FOUND.value());
  }
}
