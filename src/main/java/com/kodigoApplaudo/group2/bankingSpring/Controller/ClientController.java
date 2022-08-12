package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private CustomerRepository clientRepository;

    @RequestMapping(value = "/client", method = RequestMethod.GET, produces = "application/json")
    @Operation(summary = "List of customers")
    public List<Customer> Get() {
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = "application/json")
    @Operation(summary = "Get a customer by id")
    public ResponseEntity<Customer> GetById(@PathVariable(value = "id") int id) {
        Optional<Customer> client = clientRepository.findById(id);
        if (client.isPresent())
            return new ResponseEntity<Customer>(client.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getClient")
    @Operation(summary = "Get a customer by id")
    public List<Customer> getList(@RequestParam(name = "id") int id) {
        Optional<Customer> account = clientRepository.findById(id);
        List<Customer> list = new ArrayList<Customer>();
        list.add(account.get());
        return list;
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @Operation(summary = "Create a new client")
    public Customer Post(@Validated @RequestBody Customer client) {
        return clientRepository.save(client);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @Operation(summary = "Updating customer by id")
    public ResponseEntity<Customer> Put(@PathVariable(value = "id") int id, @Validated @RequestBody Customer newClient) {
        Optional<Customer> oldClient = clientRepository.findById(id);
        if (oldClient.isPresent()) {
            Customer client = oldClient.get();
            client.setCustomer_name(newClient.getCustomer_name());
            clientRepository.save(client);
            return new ResponseEntity<Customer>(client, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @Operation(summary = "Delete customer by id")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id) {
        Optional<Customer> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.delete(client.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
