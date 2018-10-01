package ru.core.services;

import ru.core.domain.Client;

import java.util.List;

public interface ClientService {
    Client createClient(String login, String password, String fullName, Character sex);

    Client getClientByLogin(String login);

    List<Client> getAll();

}
