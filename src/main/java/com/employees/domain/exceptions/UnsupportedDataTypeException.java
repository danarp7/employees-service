package com.employees.domain.exceptions;

public class UnsupportedDataTypeException extends BaseDomainException {
    public UnsupportedDataTypeException(String msg) {
        super("unsupported data type. " + msg);
    }
}
