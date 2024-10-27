package org.example.minievaluation.dao;

import org.example.minievaluation.config.HibernateUtil;
import org.example.minievaluation.controller.CoursController;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class RepositoryImpl<T> implements Repository<T> {
    protected Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    private static final Logger logger = LoggerFactory.getLogger(CoursController.class);

    @Override
    public boolean save(T t) {
        try {
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override
    public boolean delete(long id, T t) {
        try {
            transaction = session.beginTransaction();
            session.delete(session.get(t.getClass(), id));
            transaction.commit();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override
    public boolean update(T t) {
        try {
            transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> list(T t) {
        logger.info("T" + t);
        // Utilisation de l'API criteria
        session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(t.getClass());
        Root<T> root = (Root<T>) cq.from(t.getClass());
        cq.select(root);
        return session.createQuery(cq).getResultList();

    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(long id, T t) {
        return (T) session.get(t.getClass(), id);
    }

}