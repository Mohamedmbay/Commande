package com.polytech.commandes.service.impl;

import com.polytech.commandes.entity.Produit;
import com.polytech.commandes.repository.ProduitRepository;
import com.polytech.commandes.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit create(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> getAll() {
        return produitRepository.findAll();
    }
}