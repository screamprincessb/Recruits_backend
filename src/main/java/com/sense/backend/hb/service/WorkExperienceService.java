/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.WorkExperienceDAO;
import com.sense.backend.hb.entity.auth.ReferencePersonEntity;
import com.sense.backend.hb.entity.auth.WorkExperienceEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class WorkExperienceService {
    @Autowired
    private WorkExperienceDAO dao;

    @Transactional
    public List<WorkExperienceEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<WorkExperienceEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public WorkExperienceEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(WorkExperienceEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(WorkExperienceEntity entity) {
        dao.delete(entity);
    }
    
        @Transactional
    public List<ReferencePersonEntity> findRefById(int id) {
        return dao.findRefById(id);
    }
}
