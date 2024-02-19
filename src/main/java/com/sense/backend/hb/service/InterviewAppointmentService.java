/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.InterviewAppointmentDAO;
import com.sense.backend.hb.entity.auth.InterviewAppointmentEntity;
import com.sense.backend.hb.entity.auth.qInterviewAppointmentEntityToJoin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class InterviewAppointmentService {

    @Autowired
    private InterviewAppointmentDAO dao;

    @Transactional

    public List<InterviewAppointmentEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<InterviewAppointmentEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public InterviewAppointmentEntity findById(String id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(InterviewAppointmentEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(InterviewAppointmentEntity entity) {
        dao.delete(entity);
    }
    
    @Transactional
    public List<qInterviewAppointmentEntityToJoin> findAllName(){
        return dao.findAllName();
    }
}
