/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.InterviewDAO;
import com.sense.backend.hb.entity.auth.InterviewEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class InterviewService {
    
    @Autowired
    private InterviewDAO dao;

    @Transactional

    public List<InterviewEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<InterviewEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public InterviewEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(InterviewEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(InterviewEntity entity) {
        dao.delete(entity);
    }
    
}
