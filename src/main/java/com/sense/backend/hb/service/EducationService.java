/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.DataOtherDAO;
import com.sense.backend.hb.dao.auth.EducationDAO;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import com.sense.backend.hb.entity.auth.EducationEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class EducationService {
    @Autowired
    private EducationDAO dao;

    @Transactional
    public List<EducationEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<EducationEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public EducationEntity findById(String id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(EducationEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(EducationEntity entity) {
        dao.delete(entity);
    }
}
