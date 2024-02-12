/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.PositionLinkFormDAO;
import com.sense.backend.hb.entity.auth.PositionLinkFormEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class PositionLinkFormService {
        @Autowired
    private PositionLinkFormDAO dao;
    
    @Transactional
    public List<PositionLinkFormEntity> findAll() {
        return dao.findAll();
    }
    
        @Transactional
    public List<PositionLinkFormEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public PositionLinkFormEntity findById(int id) {
        return dao.findById(id);
    }
    
    @Transactional
    public void saveOrUpdate(PositionLinkFormEntity entity) {
        dao.saveOrUpdate(entity);
    }
            
    @Transactional
    public void delete(PositionLinkFormEntity entity) {
        dao.delete(entity);
    }
}
