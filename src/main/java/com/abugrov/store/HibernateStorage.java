package com.abugrov.store;

import com.abugrov.models.Show;
import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateStorage implements Storage {
    private final SessionFactory factory;

    public HibernateStorage() {
	Configuration configuration = new Configuration().configure();
	factory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
    }

    @Override
    public Collection<Show> values() {
	final Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	try {
	    return session.createQuery("from show").list();
	} finally {
	    tx.commit();
	    session.close();
	}
    }

    @Override
    public int add(final Show show) {
	final Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	try {
	    session.save(show);
	    return show.getId();
	} finally {
	    tx.commit();
	    session.close();
	}
    }

    @Override
    public void edit(Show show) {

    }

    @Override
    public void delete(int id) {
	final Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	try {
	    session.delete(new Show(id, null, null, null, null, null));
	} finally {
	    tx.commit();
	    session.close();
	}
    }

    @Override
    public Show get(int id) {
	final Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	try {
	    return (Show) session.get(Show.class, id);
	} finally {
	    tx.commit();
	    session.close();
	}
    }

    @Override
    public Collection<Show> find(final String by, final String value) {
	return null;
    }

    public Show findByLogin(String login) {
	final Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	try {
	    final Query query = session.createQuery("from Show as show where user.login=:login");
	    query.setString("login", login);
	    return (Show) query.iterate().next();
	} finally {
	    tx.commit();
	    session.close();
	}
    }

    @Override
    public int generateId() {
	return 0;
    }

    @Override
    public void close() {
	this.factory.close();
    }
}
