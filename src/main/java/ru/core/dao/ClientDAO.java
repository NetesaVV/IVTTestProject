package ru.core.dao;

import ru.core.domain.Client;
import java.util.List;

public interface ClientDAO {
    Client save(Client client);

    Client get(String login);

    List<Client> getAll();
}
