/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.TrainingDAO;
import com.sense.backend.hb.dao.auth.VehicleDAO;
import com.sense.backend.hb.entity.auth.TrainingEntity;
import com.sense.backend.hb.entity.auth.VehicleEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class TrainingService {

    @Autowired
    private TrainingDAO dao;

    @Transactional
    public List<TrainingEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<TrainingEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public TrainingEntity findById(String id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(TrainingEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(TrainingEntity entity) {
        dao.delete(entity);
    }
}
