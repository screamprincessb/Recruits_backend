/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.qApplicationEntity;
import com.sense.backend.hb.entity.auth.qInterviewAppointmentEntity;
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
public class ApplicationDAO extends BaseDAO<ApplicationEntity, Integer>{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public ApplicationDAO (){
        super(ApplicationEntity.class);
    }
    
    public List<qApplicationEntity> findAllName(){
        List<qApplicationEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.application_id ,application.application_submit_date ,application.can_first_name_th ,application.can_last_name_th , position_link_form.position_name ,application.application_status ");
        sql.append("from application ");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");
        
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qApplicationEntity.class);
        result = query.getResultList();
        return result;
    } 
}
