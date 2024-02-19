/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.SiblingDAO;
import com.sense.backend.hb.entity.auth.SiblingEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class SiblingService {
     @Autowired
    private SiblingDAO dao;
    
    @Transactional
    public List<SiblingEntity> findAll() {
        return dao.findAll();
    }
    
        @Transactional
    public List<SiblingEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public SiblingEntity findById(String id) {
        return dao.findById(id);
    }
    
    @Transactional
    public void saveOrUpdate(SiblingEntity entity) {
        dao.saveOrUpdate(entity);
    }
            
    @Transactional
    public void delete(SiblingEntity entity) {
        dao.delete(entity);
    }
}
