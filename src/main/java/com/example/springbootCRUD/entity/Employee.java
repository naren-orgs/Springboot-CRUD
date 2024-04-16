package com.example.springbootCRUD.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="emp_id")
    private long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    private double salary;
}
