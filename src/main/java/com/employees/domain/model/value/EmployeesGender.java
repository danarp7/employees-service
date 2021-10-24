package com.employees.domain.model.value;

import com.employees.domain.exceptions.UnsupportedDataTypeException;

public enum EmployeesGender {
    MALE("M"),
    FEMALE("F")
    ;

    private final String value;

    EmployeesGender(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static EmployeesGender of(String gender) {
        for (EmployeesGender value : EmployeesGender.values()) {
            if (value.name().equalsIgnoreCase(gender)) {
                return value;
            }
        }
        throw new UnsupportedDataTypeException("gender " + gender);
    }
}
