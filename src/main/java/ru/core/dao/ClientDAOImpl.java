package ru.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.core.domain.Client;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClientDAOImpl implements ClientDAO{
    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public Client save(Client player) {
        player.setId((Integer) sessionFactory.getCurrentSession().save(player));
        sessionFactory.getCurrentSession().flush();
        return player;
    }

    @Override
    public Client get(String login) {
        return (Client) sessionFactory.getCurrentSession()
                .createCriteria(Client.class)
                .add(Restrictions.eq("login", login))
                .list()
                .get(0);
    }

    @Override
    public List<Client> getAll() {
        return (List<Client>) sessionFactory.getCurrentSession()
                .createCriteria(Client.class)
                .list();
    }
}
