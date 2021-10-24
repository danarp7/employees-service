package com.employees.domain.exceptions;

public class DuplicateDataException extends BaseDomainException {
    public DuplicateDataException(String msg) {
        super("duplicate data. " + msg);
    }
}
