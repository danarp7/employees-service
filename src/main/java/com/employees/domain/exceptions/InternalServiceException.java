package com.employees.domain.exceptions;

public class InternalServiceException extends BaseDomainException {
    public InternalServiceException(String msg) {
        super("problem internal service. " + msg);
    }
}
