package com.polytech.commandes.controller;

import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Créer une commande
    @PostMapping
    public Commande create(@RequestBody Commande commande) {
        return commandeService.create(commande);
    }

    // Valider une commande
    @PutMapping("/{id}/validate")
    public Commande validate(@PathVariable Long id) {
        return commandeService.validate(id);
    }
}
