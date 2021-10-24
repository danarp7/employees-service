package com.employees.domain.exceptions;

public class BaseDomainException extends RuntimeException {

    public BaseDomainException(String msg) {
        super(msg);
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return null;
    }
}
