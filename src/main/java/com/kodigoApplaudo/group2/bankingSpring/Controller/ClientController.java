package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Repository.CustomerRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private CustomerRepository clientRepository;

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(value = "/client", method = RequestMethod.GET, produces = "application/json")
    public List<Customer> Get() {
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Customer> GetById(@PathVariable(value = "id") long id) {
        Optional<Customer> client = clientRepository.findById(id);
        if (client.isPresent())
            return new ResponseEntity<Customer>(client.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Customer Post(@Validated @RequestBody Customer client) {
        return clientRepository.save(client);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Customer> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Customer newClient) {
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
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Customer> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.delete(client.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
