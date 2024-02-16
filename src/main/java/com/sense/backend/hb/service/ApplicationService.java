/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.ApplicationDAO;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.ChildEntity;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import com.sense.backend.hb.entity.auth.EducationEntity;
import com.sense.backend.hb.entity.auth.SiblingEntity;
import com.sense.backend.hb.entity.auth.TrainingEntity;
import com.sense.backend.hb.entity.auth.qApplicationEntity;
import com.sense.backend.hb.entity.auth.qPositionNameEntityToJoin;
import com.sense.backend.hb.entity.auth.qWorkExperienceEntityToJoin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SenseInfoTech
 */
@Service
public class ApplicationService {

    @Autowired
    private ApplicationDAO dao;

    @Transactional
    public List<ApplicationEntity> findAll() {
        return dao.findAll();
    }

    @Transactional
    public List<ApplicationEntity> findBySQL(String sql) {
        return dao.findBySQL(sql);
    }

    @Transactional
    public ApplicationEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void saveOrUpdate(ApplicationEntity entity) {
        dao.saveOrUpdate(entity);
    }

    @Transactional
    public void delete(ApplicationEntity entity) {
        dao.delete(entity);
    }

    @Transactional
    public List<qApplicationEntity> findAllName() {
        return dao.findAllName();
    }

    @Transactional
    public List<AbillitiesEntity> findAbillitiesById(int id) {
        return dao.findAbillitiesByid(id);
    }

    @Transactional
    public List<qWorkExperienceEntityToJoin> findWorkExperienceByid(int id) {
        return dao.findWorkExperienceByid(id);
    }

    @Transactional
    public List<ChildEntity> findChildByid(int id) {
        return dao.findChildById(id);
    }

    @Transactional
    public List<ContactPersonEntity> findContactPersonByid(int id) {
        return dao.findContactPersonById(id);
    }

    @Transactional
    public List<DataOtherEntity> findDataOtherByid(int id) {
        return dao.findDataOtherById(id);
    }

    @Transactional
    public List<EducationEntity> findEducationById(int id) {
        return dao.findEducationById(id);
    }

    @Transactional
    public List<qPositionNameEntityToJoin> findPositionNameById(int id) {
        return dao.findPositionNameById(id);
    }

    @Transactional
    public List<SiblingEntity> findSiblingById(int id) {
        return dao.findSiblingById(id);
    }

    @Transactional
    public List<TrainingEntity> findTrainingById(int id) {
        return dao.findTrainingById(id);
    }
}
