package com.polytech.commandes.config;

import com.polytech.commandes.entity.*;
import com.polytech.commandes.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("dev")
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;
    private final CommandeRepository commandeRepository;
    private final LigneCommandeRepository ligneCommandeRepository;

    public DataInitializer(
            ClientRepository clientRepository,
            ProduitRepository produitRepository,
            CommandeRepository commandeRepository,
            LigneCommandeRepository ligneCommandeRepository) {
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @Override
    public void run(String... args) {

        // Client
        Client client = new Client();
        client.setNom("Client Dev");
        client.setEmail("client@dev.com");
        clientRepository.save(client);

        // Produits
        Produit p1 = new Produit();
        p1.setNom("Souris");
        p1.setPrix(new BigDecimal("5000"));
        p1.setStock(20);
        produitRepository.save(p1);

        Produit p2 = new Produit();
        p2.setNom("Clavier");
        p2.setPrix(new BigDecimal("15000"));
        p2.setStock(10);
        produitRepository.save(p2);

        // Commande
        Commande commande = new Commande();
        commande.setClient(client);
        commandeRepository.save(commande);

        // Lignes de commande
        LigneCommande l1 = new LigneCommande();
        l1.setProduit(p1);
        l1.setQuantite(2);
        l1.setPrixUnitaire(p1.getPrix());
        l1.setCommande(commande);

        LigneCommande l2 = new LigneCommande();
        l2.setProduit(p2);
        l2.setQuantite(1);
        l2.setPrixUnitaire(p2.getPrix());
        l2.setCommande(commande);

        ligneCommandeRepository.saveAll(List.of(l1, l2));
    }
}
