package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Repository.CustomerRepository;
import java.util.List;

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

    @GetMapping("/customers-table")
    @Operation(summary = "List of custormer with frontend")
    public String getClients(Model model){
        List<Customer>clients = customerRepository.findAll();
        model.addAttribute("Customers",clients);
        return "customers-list";
    }

    @PostMapping("/addCustomer")
    @ResponseBody
    @Operation(summary = "View of create new customer")
    public void addCustomer(Customer client){
        customerRepository.save(client);
    }

    @PostMapping("/deleteCustomer")
    @ResponseBody
    @Operation(summary = "view for delete a customer")
    public void deleteCustomer(Customer client){
        customerRepository.delete(client);
    }


}
