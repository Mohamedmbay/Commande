package com.polytech.commandes.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
public class Produit {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private Integer stock;
    private BigDecimal prix;

    public Produit() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public BigDecimal getPrix() {
        return prix;
    }
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }


}