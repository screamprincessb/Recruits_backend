/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.ContactPersonDAO;
import com.sense.backend.hb.dao.auth.TrainingDAO;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;
import com.sense.backend.hb.entity.auth.TrainingEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class ContactPersonService {
    @Autowired
    private ContactPersonDAO dao;

    @Transactional
    public List<ContactPersonEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<ContactPersonEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public ContactPersonEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(ContactPersonEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(ContactPersonEntity entity) {
        dao.delete(entity);
    }
}
