/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.ContactPersonDAO;
import com.sense.backend.hb.dao.auth.PreTestDAO;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;
import com.sense.backend.hb.entity.auth.PreTestEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class PreTestService {
    @Autowired
    private PreTestDAO dao;

    @Transactional
    public List<PreTestEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<PreTestEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public PreTestEntity findById(String id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(PreTestEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(PreTestEntity entity) {
        dao.delete(entity);
    }
}
