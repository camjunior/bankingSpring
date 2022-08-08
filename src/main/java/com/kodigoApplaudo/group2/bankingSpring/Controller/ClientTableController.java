package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Client;
import com.kodigoApplaudo.group2.bankingSpring.Repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")

public class ClientTableController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    @GetMapping("/clients-table")
    public String getClients(Model model){


        List<Client>clients = clientRepository.findAll();
        model.addAttribute("clients",clients);
        return "clients-list";
    }

    @RequestMapping("/addClient")
    @ResponseBody
    public void addClient(Client client){
        clientRepository.save(client);
    }

    @RequestMapping("/deleteClient")
    @ResponseBody
    public void deleteClient(Client client){
        clientRepository.delete(client);
    }


}
