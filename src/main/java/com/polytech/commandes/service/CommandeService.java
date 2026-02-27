package com.polytech.commandes.service;

import com.polytech.commandes.entity.Commande;

public interface CommandeService {

    Commande create(Commande commande);

    Commande validate(Long commandeId);
}
