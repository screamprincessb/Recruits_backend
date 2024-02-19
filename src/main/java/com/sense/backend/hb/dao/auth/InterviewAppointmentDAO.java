/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.InterviewAppointmentEntity;
import com.sense.backend.hb.entity.auth.qInterviewAppointmentEntityToJoin;
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
public class InterviewAppointmentDAO extends BaseDAO<InterviewAppointmentEntity, String>{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public InterviewAppointmentDAO(){
        super(InterviewAppointmentEntity.class);
    }
    
    public List<qInterviewAppointmentEntityToJoin> findAllName(){
        List<qInterviewAppointmentEntityToJoin> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select interview_appointment.inter_app_id, application.can_first_name_th, application.can_last_name_th, position_link_form.position_name, hr.hr_first_name , hr.hr_last_name, interview_appointment.inter_app_date, interview_appointment.inter_app_time, interview_appointment.inter_app_time_to, interview_appointment.inter_app_status, interview_appointment.inter_app_location ");
        sql.append("from interview_appointment ");
        sql.append("inner join interview  on interview.interview_id = interview_appointment.interview_id ");
        sql.append("inner join application on application.application_id = interview.application_id ");
        sql.append("inner join position_link_form   on position_link_form.position_id  = application.position_id ");
        sql.append("inner join interviewer on interviewer.interviewer_id = interview.interviewer_id ");
        sql.append("inner join hr on hr.hr_id = interviewer.hr_id");
        
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qInterviewAppointmentEntityToJoin.class);
        result = query.getResultList();
        return result;
    } 
    
}
