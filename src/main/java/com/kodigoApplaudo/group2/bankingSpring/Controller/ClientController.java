package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Client;
import com.kodigoApplaudo.group2.bankingSpring.Repository.ClientRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

}
