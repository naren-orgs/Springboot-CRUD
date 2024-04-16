package com.example.springbootCRUD.service;

import com.example.springbootCRUD.entity.Employee;
import com.example.springbootCRUD.exception.UserNotFoundException;
import com.example.springbootCRUD.mapper.EmployeeMapper;
import com.example.springbootCRUD.model.EmployeeDTO;
import com.example.springbootCRUD.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee= employeeMapper.convertToEntity(employeeDTO);
        employee=employeeRepository.save(employee);
        return employeeMapper.convertToDTO(employee);
    }

    public EmployeeDTO getEmployee(Long id) throws UserNotFoundException {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Employee not found with given ID "+id));
        return employeeMapper.convertToDTO(employee);
    }

    public void deleteEmployee(Long id) throws UserNotFoundException {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Employee not found with given ID "+id));
        employeeRepository.deleteById(id);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) throws UserNotFoundException {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Employee not found with given ID "+id));
        employeeDTO.setId(id);
        employeeMapper.updateEmployeeFromDTO(employee,employeeDTO);
        employee=employeeRepository.save(employee);
        return employeeMapper.convertToDTO(employee);
    }
}
