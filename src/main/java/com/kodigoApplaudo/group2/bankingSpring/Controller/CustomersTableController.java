package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")

public class CustomersTableController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/clients")
    public List<Customer> getAllClients() {

        return customerRepository.findAll();
    }

    @GetMapping("/customers-table")
    public String getClients(Model model){


        List<Customer>clients = customerRepository.findAll();
        model.addAttribute("Customers",clients);
        return "customers-list";
    }

    @RequestMapping("/addCustomer")
    @ResponseBody
    public void addCustomer(Customer client){
        customerRepository.save(client);
    }

    @RequestMapping("/deleteCustomer")
    @ResponseBody
    public void deleteCustomer(Customer client){
        customerRepository.delete(client);
    }


}
