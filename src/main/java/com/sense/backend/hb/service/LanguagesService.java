/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.AbilitiesDAO;
import com.sense.backend.hb.dao.auth.LanguagesDAO;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.LanguagesEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class LanguagesService {
    @Autowired
    private LanguagesDAO dao;

    @Transactional
    public List<LanguagesEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<LanguagesEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public LanguagesEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(LanguagesEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(LanguagesEntity entity) {
        dao.delete(entity);
    }
}
