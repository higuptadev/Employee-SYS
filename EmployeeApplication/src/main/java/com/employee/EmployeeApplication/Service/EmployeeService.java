package com.employee.EmployeeApplication.Service;

import com.employee.EmployeeApplication.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "Himanshu Gupta ", "Etah"),
            new Employee(2, "Nitin ", "Mouradabad "),
            new Employee(3, "Ashish", "Muradabad "),
            new Employee(4, "Ankur ", "Bahjoi")

    ));

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getAnEmployee(int id) {
        return employeeList.stream().filter(e -> (
                e.getEmployeeId() == id)).findFirst().get();
    }

    public void createEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void updateEmployee(Employee employee) {
        List<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == employee.getEmployeeId()) {
                emp.setEmployeeId(employee.getEmployeeId());
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployee.add(emp) ;
        }
        this.employeeList = tempEmployee;
    }
    public void deleteEmployee(int id ){
        ArrayList<Employee> tempEmployee  = new ArrayList<>() ;
        for(Employee emp :  employeeList ){
            if(emp.getEmployeeId() == id ) continue;
            tempEmployee.add(emp) ;
        }
        this.employeeList = tempEmployee ;
    }
}