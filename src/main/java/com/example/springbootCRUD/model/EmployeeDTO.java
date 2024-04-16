package com.example.springbootCRUD.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;

    private double salary;
}
