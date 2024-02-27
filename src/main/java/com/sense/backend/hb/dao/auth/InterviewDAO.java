/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.InterviewEntity;
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
public class InterviewDAO extends BaseDAO<InterviewEntity, String>{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public InterviewDAO(){
        super(InterviewEntity.class);
    }
    
    public List<qInterviewAppointmentEntity> findAllInterApp(){
        List<qInterviewAppointmentEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select interview.*, application.can_first_name_th ,application.can_last_name_th ,hr.hr_first_name  ,hr.hr_last_name ,position_link_form.position_id , position_link_form.position_name ");
        sql.append("from interview ");
        sql.append("inner join application on application.application_id = interview.application_id ");
        sql.append("inner join position_link_form on position_link_form.position_id  = application.position_id ");
        sql.append("inner join hr on hr.hr_id = interview.hr_id ");
        
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qInterviewAppointmentEntity.class);
        result = query.getResultList();
        return result;
    }
    
        public List<qInterviewAppointmentEntity> findInterAppById(String id){
        List<qInterviewAppointmentEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select interview.*, application.can_first_name_th ,application.can_last_name_th ,hr.hr_first_name  ,hr.hr_last_name ,position_link_form.position_id , position_link_form.position_name ");
        sql.append("from interview ");
        sql.append("inner join application on application.application_id = interview.application_id ");
        sql.append("inner join position_link_form on position_link_form.position_id  = application.position_id ");
        sql.append("inner join hr on hr.hr_id = interview.hr_id ");
        sql.append("where interview_id = :id");
        
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qInterviewAppointmentEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }
    
}
