package com.polytech.commandes.controller;

import com.polytech.commandes.entity.Produit;
import com.polytech.commandes.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping
    public Produit create(@RequestBody Produit produit) {
        return produitService.create(produit);
    }

    @GetMapping
    public List<Produit> getAll() {
        return produitService.getAll();
    }
}