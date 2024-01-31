/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;


import com.sense.backend.hb.dao.auth.ChildDAO;
import com.sense.backend.hb.entity.auth.ChildEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class ChildService {
        @Autowired
    private ChildDAO dao;
    
    @Transactional
    public List<ChildEntity> findAll() {
        return dao.findAll();
    }
    
        @Transactional
    public List<ChildEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public ChildEntity findById(int id) {
        return dao.findById(id);
    }
    
    @Transactional
    public void saveOrUpdate(ChildEntity entity) {
        dao.saveOrUpdate(entity);
    }
            
    @Transactional
    public void delete(ChildEntity entity) {
        dao.delete(entity);
    }
}
