/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.ReferencePersonDAO;
import com.sense.backend.hb.entity.auth.ReferencePersonEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class ReferencePersonService {
   @Autowired
    private ReferencePersonDAO dao;

    @Transactional
    public List<ReferencePersonEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<ReferencePersonEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public ReferencePersonEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(ReferencePersonEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(ReferencePersonEntity entity) {
        dao.delete(entity);
    }
}
