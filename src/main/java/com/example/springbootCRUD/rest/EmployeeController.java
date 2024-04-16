package com.example.springbootCRUD.rest;

import com.example.springbootCRUD.exception.UserNotFoundException;
import com.example.springbootCRUD.model.EmployeeDTO;
import com.example.springbootCRUD.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/crud")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping("/employee")
    public ResponseEntity<EmployeeDTO> getEmployee(@RequestParam Long id) throws UserNotFoundException {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) throws UserNotFoundException {
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDTO));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws UserNotFoundException {
         employeeService.deleteEmployee(id);
         return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/health")
    public String ping(){
        return "Hello Spring Boot";
    }
}
