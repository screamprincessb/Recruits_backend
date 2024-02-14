/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.ApplicationDAO;
import com.sense.backend.hb.dao.auth.DataOtherDAO;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import com.sense.backend.hb.entity.auth.qApplicationEntity;
import com.sense.backend.hb.entity.auth.qDataApplicationAllEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class ApplicationService {
    @Autowired
    private ApplicationDAO dao;

    @Transactional
    public List<ApplicationEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<ApplicationEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public ApplicationEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(ApplicationEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(ApplicationEntity entity) {
        dao.delete(entity);
    }
    
    @Transactional
    public List<qApplicationEntity> findAllName() {
        return dao.findAllName();
    }
    
    @Transactional
    public List<qDataApplicationAllEntity> findAllNameById(int id) {
        return dao.findAllNameById(id);
    }
}
