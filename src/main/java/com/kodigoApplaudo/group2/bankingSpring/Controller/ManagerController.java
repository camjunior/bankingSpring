package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Employee;
import com.kodigoApplaudo.group2.bankingSpring.Model.Manager;
import com.kodigoApplaudo.group2.bankingSpring.Repository.EmployeeRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.ManagerRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.UserRepository;
import com.kodigoApplaudo.group2.bankingSpring.Services.UserService;
import com.kodigoApplaudo.group2.bankingSpring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired private ManagerRepository managerRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;

    @GetMapping("/getEmployeeList")
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    @GetMapping("/getManagerList")
    public List<Manager> getManagerList(){
        return managerRepository.findAll();
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestParam int managerId, @RequestParam String employeeName,
                              @RequestParam String employeePhone, @RequestParam String username,
                              @RequestParam String password) throws Exception {

        Employee employee = new Employee();
        employee.setEmployee_name(employeeName);
        employee.setPhone(employeePhone);
        employee.setUsername(username);
        employee.setManager_id(managerId);

        User user =  userRepository.findByUsername(username);

        if (user != null){
            return "User already exists.";
        }

        try {
            employeeRepository.save(employee);
            userService.saveUser(new User(null,employee.getUsername(),password,new ArrayList<>()));
            userService.addRoleToUser(employee.getUsername(),"ROLE_EMPLOYEE");

        } catch (Exception e) {
            return "Failed. Unable to save employee. Check input or if manager_id exits.";
        }
        return "Succeed. Employee "+ employee.getEmployee_name() + " added.";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam(name = "employee_id") int id){
        Optional<Employee> employee = employeeRepository.findById(id);
        try {
            userRepository.delete(userRepository.findByUsername(employee.get().getUsername()));
            employeeRepository.delete(employee.get());
        } catch (Exception e){
            return "Error. Unable to delete. Check input or if employee exists.";
        }
        return "Success. Employee " + employee.get().getEmployee_name() + " removed.";
    }
}
