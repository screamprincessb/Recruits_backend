/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.qApplicationEntity;
import com.sense.backend.hb.entity.auth.qDataApplicationAllEntity;
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
        sql.append("select application.application_id ,position_link_form.position_id ,application.application_submit_date ,application.can_first_name_th ,application.can_last_name_th , position_link_form.position_name ,application.application_status ");
        sql.append("from application ");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");
        
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qApplicationEntity.class);
        result = query.getResultList();
        return result;
    } 
    
    public List<qDataApplicationAllEntity> findAllNameById(Integer id){
        List<qDataApplicationAllEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.*, child.*, data_other.*, sibling.*, abillities.*, education.*, training.*, work_experience.*, contact_person.*,position_link_form.position_name ");
        sql.append("from application");
        sql.append("inner join child on application.application_id = child.application_id");
        sql.append("inner join data_other on application.application_id = data_other.application_id ");
        sql.append("inner join sibling on application.application_id = sibling.application_id");
        sql.append("inner join abillities on application.application_id = abillities.application_id ");
        sql.append("inner join education on application.application_id = education.application_id ");
        sql.append("inner join training on application.application_id = training.application_id ");
        sql.append("inner join work_experience on application.application_id = work_experience.application_id ");
        sql.append("inner join contact_person  on application.application_id = contact_person.application_id");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");
        sql.append("where application.application_id  = :id;");
        
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qDataApplicationAllEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }
}
