package com.polytech.commandes.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class LigneCommande {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Produit produit;

    private Integer quantite;

    private BigDecimal prixUnitaire;

    @ManyToOne
    private Commande commande;

    // 🔹 Constructeur vide obligatoire
    public LigneCommande() {
    }

    // 🔹 Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}