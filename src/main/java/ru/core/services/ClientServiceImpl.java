package ru.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.core.dao.ClientDAO;
import ru.core.domain.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client createClient(String login, String password, String fullName, Character sex) {
        Client client = new Client();
        client.setLogin(login);
        client.setPassword(password);
        client.setFullName(fullName);
        client.setSex(sex);
        return clientDAO.save(client);
    }

    @Override
    public Client getClientByLogin(String login) {
        return clientDAO.get(login);
    }

    @Override
    public List<Client> getAll() {
        return clientDAO.getAll();
    }
}
