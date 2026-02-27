package com.polytech.commandes.service.impl;

import com.polytech.commandes.entity.Commande;
import com.polytech.commandes.entity.CommandeStatus;
import com.polytech.commandes.entity.LigneCommande;
import com.polytech.commandes.entity.Produit;
import com.polytech.commandes.repository.CommandeRepository;
import com.polytech.commandes.repository.LigneCommandeRepository;
import com.polytech.commandes.repository.ProduitRepository;
import com.polytech.commandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Commande create(Commande commande) {
        // Initialisation de la commande
        commande.setDateCommande(LocalDateTime.now());
        commande.setStatus(CommandeStatus.CREATED);

        // Sauvegarde de la commande
        return commandeRepository.save(commande);
    }

    @Override
    public Commande validate(Long commandeId) {

        // 1️⃣ Charger la commande
        Commande commande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        // 2️⃣ Vérifier les stocks
        for (LigneCommande ligne : commande.getLignes()) {
            Produit produit = ligne.getProduit();
            Integer quantite = ligne.getQuantite();

            if (produit.getStock() < quantite) {
                throw new RuntimeException(
                        "Stock insuffisant pour le produit : " + produit.getNom()
                );
            }
        }

        // 3️⃣ Mettre à jour les stocks
        for (LigneCommande ligne : commande.getLignes()) {
            Produit produit = ligne.getProduit();
            Integer quantite = ligne.getQuantite();

            produit.setStock(produit.getStock() - quantite);
            produitRepository.save(produit);
        }

        // 4️⃣ Valider la commande
        commande.setStatus(CommandeStatus.VALIDATED);

        // 5️⃣ Sauvegarder et retourner
        return commandeRepository.save(commande);
    }
}

