/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.InterviewDAO;
import com.sense.backend.hb.dao.auth.InterviewerDAO;
import com.sense.backend.hb.entity.auth.InterviewEntity;
import com.sense.backend.hb.entity.auth.InterviewerEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class InterviewerService {

    @Autowired
    private InterviewerDAO dao;

    @Transactional

    public List<InterviewerEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<InterviewerEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public InterviewerEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(InterviewerEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(InterviewerEntity entity) {
        dao.delete(entity);
    }

}
