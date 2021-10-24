package com.employees.config.advice;

import com.employees.domain.exceptions.*;
import com.employees.interfaces.web.dto.EmployeesResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid param value", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeesResponse.class))
        })
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {
            IllegalArgumentException.class, DuplicateDataException.class, InvalidFormatException.class,
            UnsupportedDataTypeException.class, AlreadyExistException.class
    })
    protected ResponseEntity<Object> illegalArgument(RuntimeException ex, WebRequest request) {
        EmployeesResponse body = EmployeesResponse.error(ex.getMessage());
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "data not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeesResponse.class))
        })
    })
    @ExceptionHandler(value = {DataNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> dataNotFound(RuntimeException ex, WebRequest request) {
        EmployeesResponse body = EmployeesResponse.error(ex.getMessage());
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "500", description = "internal server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeesResponse.class))
        })
    })
    @ExceptionHandler(value = {InternalServiceException.class, Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> internalServerError(RuntimeException ex, WebRequest request) {
        EmployeesResponse body = EmployeesResponse.error(ex.getMessage());
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String errors = ex.getBindingResult().getAllErrors().stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.joining(", "));

        EmployeesResponse body = EmployeesResponse.error(errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String msg = getRootCauseMessage(ex);
        EmployeesResponse body = EmployeesResponse.error(msg);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    private String getRootCauseMessage(Exception ex) {
        if (ex == null) {
            return null;
        }
        return ex.getMessage().substring(0, ex.getMessage().indexOf("; ")).replaceAll("\"","'");
    }
}
