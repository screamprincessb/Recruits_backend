/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.HRDAO;
import com.sense.backend.hb.entity.auth.HREntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class HRService {
    
    @Autowired
    private HRDAO dao;
    
    @Transactional
    public List<HREntity> findAll() {
        return dao.findAll();
    }
    
        @Transactional
    public List<HREntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public HREntity findById(int id) {
        return dao.findById(id);
    }
    
    @Transactional
    public void saveOrUpdate(HREntity entity) {
        dao.saveOrUpdate(entity);
    }
            
    @Transactional
    public void delete(HREntity entity) {
        dao.delete(entity);
    }
    
}
