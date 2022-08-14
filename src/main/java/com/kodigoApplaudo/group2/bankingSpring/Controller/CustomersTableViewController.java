package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

import com.kodigoApplaudo.group2.bankingSpring.Services.UserService;
import com.kodigoApplaudo.group2.bankingSpring.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view")

public class CustomersTableViewController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired private UserService userService;

    @GetMapping("/customers-table")
    @Operation(summary = "List of custormer with frontend")
    public String getClients(Model model){
        List<Customer>clients = customerRepository.findAll();
        model.addAttribute("Customers",clients);
        return "customers-list";
    }

    @PostMapping("/addClient")
    @ResponseBody
    @Operation(summary = "View of create new customer")
    public void addCustomerr(Customer client){
        customerRepository.save(client);
    }

    @PostMapping("/addCustomer")
    @ResponseBody
    @Operation(summary = "View of create new customer")
    public void addCustomer(@RequestParam String customer_name,@RequestParam String phone,
                             @RequestParam String username, @RequestParam String password){
        Customer customer = new Customer();
        customer.setCustomer_name(customer_name);
        customer.setPhone(phone);
        customer.setUsername(username);

        customerRepository.save(customer);
        userService.saveUser(new User(null,customer.getUsername(),password,new ArrayList<>()));
        userService.addRoleToUser(customer.getUsername(),"ROLE_USER");
    }

    @PostMapping("/deleteCustomer")
    @ResponseBody
    @Operation(summary = "view for delete a customer")
    public void deleteCustomer(Customer client){
        customerRepository.delete(client);
    }


}
