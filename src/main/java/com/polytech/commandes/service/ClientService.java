package com.polytech.commandes.service;

import com.polytech.commandes.entity.Client;
import java.util.List;

public interface ClientService {

    Client create(Client client);

    List<Client> getAll();
}
