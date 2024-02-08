/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.PositionDAO;
import com.sense.backend.hb.entity.auth.PositionEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class PositionService {
        @Autowired
    private PositionDAO dao;
    
    @Transactional
    public List<PositionEntity> findAll() {
        return dao.findAll();
    }
    
        @Transactional
    public List<PositionEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public PositionEntity findById(int id) {
        return dao.findById(id);
    }
    
    @Transactional
    public void saveOrUpdate(PositionEntity entity) {
        dao.saveOrUpdate(entity);
    }
            
    @Transactional
    public void delete(PositionEntity entity) {
        dao.delete(entity);
    }
}
