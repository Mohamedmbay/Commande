package com.polytech.commandes.service;

import com.polytech.commandes.entity.Produit;
import java.util.List;

public interface ProduitService {

    Produit create(Produit produit);

    List<Produit> getAll();
}