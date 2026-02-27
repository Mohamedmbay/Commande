package com.polytech.commandes.controller;

import com.polytech.commandes.entity.Client;
import com.polytech.commandes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }
}
