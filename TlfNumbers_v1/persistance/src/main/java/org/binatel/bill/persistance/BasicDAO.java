
package org.binatel.bill.persistance;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicDAO {
     private static final Logger log = LoggerFactory.getLogger(BasicDAO.class);
     
    public static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    public Serializable addEntity(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Serializable id = session.save(entity);
        session.getTransaction().commit();
        return id;
    }
        
    
    public Object getEntity(Class clazz, Serializable entityId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Object entity = session.get(clazz, entityId);
        session.getTransaction().commit();
        return entity;
    }
}
