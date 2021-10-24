package com.employees.domain.exceptions;

public class DataNotFoundException extends BaseDomainException {
    public DataNotFoundException(String msg) {
        super("data not found. " + msg);
    }
}
