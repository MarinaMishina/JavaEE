package org.binatel.bill.persistance;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {
    
    private Class<T> entityClass;
    //private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TlfNumbers_v1PU");;
    
    private EntityManager em;
    private EntityManagerFactory emf;
    
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
     public void init() {
       emf = Persistence.createEntityManagerFactory("TlfNumbers_v1PU");
        System.out.println(emf.getClass().getSimpleName());
       em = emf.createEntityManager();
        System.out.println(em.getClass().getSimpleName());
    } 
    
//   public void beginTransaction() {
//        em = emf.createEntityManager();
// 
//        em.getTransaction().begin();
//    }
 
    public void commit() {
        em.getTransaction().commit();
    }
 
    public void rollback() {
        em.getTransaction().rollback();
    }
 
    public void closeTransaction() {
        em.close();
    }
 
    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }
 
    public void flush() {
        em.flush();
    }
 
    public void joinTransaction() {
        em = emf.createEntityManager();
        em.joinTransaction();
    }
    
    public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
 
    public void remove(T entity) {
        em.remove(em.merge(entity));
    }

    public T find(Object id) {
        return em.find(entityClass, id);
    }
    
    public boolean contains(T entity) {
        return em.contains(entity);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    
}
