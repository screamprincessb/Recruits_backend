/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.AbilitiesDAO;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.qLanguagesEntityToJoin;
import com.sense.backend.hb.entity.auth.qVehicleEntityToJoin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class AbilitiesService {

    @Autowired
    private AbilitiesDAO dao;

    @Transactional
    public List<AbillitiesEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<AbillitiesEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public AbillitiesEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(AbillitiesEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(AbillitiesEntity entity) {
        dao.delete(entity);
    }

    @Transactional
    public List<qVehicleEntityToJoin> findVehicleById(int id) {
        return dao.findVehicleById(id);
    }

    @Transactional
    public List<qLanguagesEntityToJoin> findLanguagesById(int id) {
        return dao.findLanguagesById(id);
    }

}
