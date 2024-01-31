/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.DataOtherDAO;
import com.sense.backend.hb.dao.auth.SiblingDAO;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
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
public class DataOtherService {

    @Autowired
    private DataOtherDAO dao;

    @Transactional
    public List<DataOtherEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<DataOtherEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public DataOtherEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(DataOtherEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(DataOtherEntity entity) {
        dao.delete(entity);
    }
}
