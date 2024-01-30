package com.sense.backend.hb.dao;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO<T, ID extends Serializable> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    public BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> findAll() {
        CriteriaQuery cq = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return sessionFactory.getCurrentSession().createQuery(cq).getResultList();
    }

    public T findById(ID id) {
        T result = sessionFactory.getCurrentSession().find(entityClass, id);
        return result;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<T> findRange(int beginRow, int endRow) {
        CriteriaQuery cq = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = sessionFactory.getCurrentSession().createQuery(cq);
        q.setMaxResults(endRow - beginRow + 1);
        q.setFirstResult(beginRow - 1);
        return q.getResultList();
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<T> findLazyLoad(int beginRow, int numRow) {
        CriteriaQuery cq = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = sessionFactory.getCurrentSession().createQuery(cq);
        q.setMaxResults(numRow);
        q.setFirstResult(beginRow - 1);
        return q.getResultList();
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public int countLazyLoad() {
        CriteriaBuilder builder= sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Long> countQuery=builder.createQuery(Long.class);
        countQuery.select(builder.count(countQuery.from(entityClass)));
        Query q = sessionFactory.getCurrentSession().createQuery(countQuery);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> findOne() {
        return findRange(1, 1);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<T> findTop(int beginRow, int numRow) {
        CriteriaQuery cq = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = sessionFactory.getCurrentSession().createQuery(cq);
        q.setMaxResults(numRow);
        q.setFirstResult(beginRow - 1);
        return q.getResultList();
    }

    // Not Found resutlist.size() = 0
    @SuppressWarnings("unchecked")
    public List<T> findBySQL(String sql) {
        List<T> resultList;
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql, entityClass);
        resultList = query.getResultList();
        return resultList;
    }

    // Not Found result = null
    @SuppressWarnings("unchecked")
    public T findSingleBySQL(String sql) {
        T result;
        try {
            Query query = sessionFactory.getCurrentSession().createNativeQuery(sql, entityClass);
            result = (T) query.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }

        return result;
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public boolean findCheckBySQL(String sql) {
        boolean result = false;
        try {
            Query query = sessionFactory.getCurrentSession().createNativeQuery(sql, entityClass);
            if(query.getResultList()!= null && query.getResultList().size()>0){
                result = true;
            }
            
        } catch (NoResultException e) {
            System.out.println("e "+e.getMessage());
        }

        return result;
    }
  
    public int executeBySQL(String sql) {
            
         Query query = sessionFactory.getCurrentSession().createNativeQuery(sql);
         int result = query.executeUpdate();
         return result;
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<T> findLazyLoad(String sql,int beginRow, int maxRow) {
        Query q = sessionFactory.getCurrentSession().createNativeQuery(sql,entityClass);
        q.setMaxResults(maxRow);//number of result to be display
        q.setFirstResult(beginRow - 1);//set first result start value
        return q.getResultList();
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public int countLazyLoad(String sql) {
        Query q = sessionFactory.getCurrentSession().createNativeQuery(sql);
        Object obj = q.getSingleResult();
        return (obj != null)? Integer.parseInt(obj.toString()):0;
    }
    
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void persist(T entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public Serializable save(T entity) {
        Serializable result = (Serializable) sessionFactory.getCurrentSession().save(entity);
        return result;
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public Object merge(T entity) {
        Object result = sessionFactory.getCurrentSession().merge(entity);
        return result;
    }

    public void saveOrUpdate(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }
    

}