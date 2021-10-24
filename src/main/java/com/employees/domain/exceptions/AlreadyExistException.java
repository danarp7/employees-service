package com.employees.domain.exceptions;

public class AlreadyExistException extends BaseDomainException {
    public AlreadyExistException(String msg) {
        super("already exist. " + msg);
    }
}
