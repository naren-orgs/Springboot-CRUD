package com.example.springbootCRUD.mapper;

import com.example.springbootCRUD.entity.Employee;
import com.example.springbootCRUD.model.EmployeeDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper {
    EmployeeDTO convertToDTO(Employee employee);
    Employee convertToEntity(EmployeeDTO employeeDTO);
    void updateEmployeeFromDTO(@MappingTarget Employee employee, EmployeeDTO employeeDTO);
}
