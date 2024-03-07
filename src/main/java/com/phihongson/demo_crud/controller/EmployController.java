package com.phihongson.demo_crud.controller;

import com.phihongson.demo_crud.model.Employee;
import com.phihongson.demo_crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployController {
    @Autowired
    private IEmployeeService iEmployeeService;

    //    Test
    @GetMapping("/")
    public String test() {
        return "Hello";
    }

    //    API add
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return iEmployeeService.addEmployee(employee);
    }

    //    API Update
    @PutMapping("/update")
    public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee employee) {
        return iEmployeeService.updateEmployee(id, employee);
    }

    //    API delete
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") long id) {
        return iEmployeeService.deleteEmployee(id);
    }

    //    API lay all
    @GetMapping("/list")
    public List<Employee> getAllEmployee() {
        return iEmployeeService.getAllEmployee();
    }
}
