/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.qLanguagesEntityToJoin;
import com.sense.backend.hb.entity.auth.qVehicleEntityToJoin;
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
    
    public List<qVehicleEntityToJoin> findVehicleById(Integer id){
        List<qVehicleEntityToJoin> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select abillities.abillities_id , vehicle.vehicle_drive ,vehicle.vehicle_own ,vehicle.vehicle_no ,vehicle.vehicle_type ");
        sql.append("from abillities ");
        sql.append("inner join vehicle on abillities.abillities_id = vehicle.abillities_id ");
        sql.append("where application_id =:id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qVehicleEntityToJoin.class);
        query.setParameter("id", id);
        result = query.getResultList();
        
        return result;
    }
    
        public List<qLanguagesEntityToJoin> findLanguagesById(Integer id){
        List<qLanguagesEntityToJoin> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select abillities.abillities_id ,languages.languages_name ,languages.languages_speaking,languages.languages_reading ,languages.languages_writing ,languages.languages_typewriter  ");
        sql.append("from abillities  ");
        sql.append("inner join languages on abillities.abillities_id  = languages.abillities_id ");
        sql.append("where application_id =:id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qLanguagesEntityToJoin.class);
        query.setParameter("id", id);
        result = query.getResultList();
        
        return result;
    }
    
}
