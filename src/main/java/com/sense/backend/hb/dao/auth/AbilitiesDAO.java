/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.LanguagesEntity;
import com.sense.backend.hb.entity.auth.VehicleEntity;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SenseInfoTech
 */
@Repository
public class AbilitiesDAO extends BaseDAO <AbillitiesEntity, Integer> {
    @Autowired
    private SessionFactory sessionFactory;
    
    public AbilitiesDAO() {
            super(AbillitiesEntity.class);
        }  
    
    public List<VehicleEntity> findVehicleById(Integer id){
        List<VehicleEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select  vehicle.*");
        sql.append("from abillities ");
        sql.append("inner join vehicle on abillities.abillities_id = vehicle.abillities_id ");
        sql.append("where application_id = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), VehicleEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        
        return result;
    }
    
        public List<LanguagesEntity> findLanguagesById(Integer id){
        List<LanguagesEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select languages.* ");
        sql.append("from abillities  ");
        sql.append("inner join languages on abillities.abillities_id  = languages.abillities_id ");
        sql.append("where application_id = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), LanguagesEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        
        return result;
    }
    
}
