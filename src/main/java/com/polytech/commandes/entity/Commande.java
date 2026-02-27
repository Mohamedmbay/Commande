package com.polytech.commandes.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> lignes;

    private LocalDateTime dateCommande;

    @Enumerated(EnumType.STRING)
    private CommandeStatus status;

    @ManyToOne
    private Client client;

    // 🔹 Constructeur vide obligatoire
    public Commande() {
    }

    // 🔹 Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public CommandeStatus getStatus() {
        return status;
    }

    public void setStatus(CommandeStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommande> lignes) {
        this.lignes = lignes;
    }
}