package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Employee;
import com.kodigoApplaudo.group2.bankingSpring.Repository.EmployeeRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ManagerController {

    @Autowired private ManagerRepository managerRepository;
    @Autowired private EmployeeRepository employeeRepository;

    @GetMapping("/getEmployeeList")
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestParam Map<String,String> requestParams) throws Exception {
        String managerId = requestParams.get("manager_id");
        String employeeName = requestParams.get("employee_name");
        String employeePhone = requestParams.get("employee_phone");

        Employee employee = new Employee();
        employee.setEmployee_name(employeeName);
        employee.setPhone(employeePhone);
        employee.setManager_id(Integer.parseInt(managerId));

        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            return "Failed. Unable to save employee. Check input or if manager_id exits.";
        }
        return "Succeed. Employee "+ employee.getEmployee_name() + " added.";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam(name = "employee_id") int id){
        Optional<Employee> employee = employeeRepository.findById(id);
        try {
            employeeRepository.delete(employee.get());
        } catch (Exception e){
            return "Error. Unable to delete. Check input or if employee exists.";
        }
        return "Success. Employee " + employee.get().getEmployee_name() + " removed.";
    }
}
