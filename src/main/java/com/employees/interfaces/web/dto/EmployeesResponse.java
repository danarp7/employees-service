package com.employees.interfaces.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeesResponse<T> {
    private T data;
    private String message;

    public static EmployeesResponse success(Object data) {
        return new EmployeesResponse(data, "Success");
    }

    public static EmployeesResponse error(String message) {
        return new EmployeesResponse(null, message);
    }
}
