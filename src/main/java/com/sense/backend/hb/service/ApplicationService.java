/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.service;

import com.sense.backend.hb.dao.auth.ApplicationDAO;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.qCandidateEntityToUse;
import com.sense.backend.hb.entity.auth.ChildEntity;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import com.sense.backend.hb.entity.auth.EducationEntity;
import com.sense.backend.hb.entity.auth.PreTestEntity;
import com.sense.backend.hb.entity.auth.QueryPDF;
import com.sense.backend.hb.entity.auth.ReferencePersonEntity;
import com.sense.backend.hb.entity.auth.SiblingEntity;
import com.sense.backend.hb.entity.auth.TrainingEntity;
import com.sense.backend.hb.entity.auth.WorkExperienceEntity;
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
    public ApplicationEntity findById(String id) {
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
    public List<AbillitiesEntity> findAbillitiesById(String id) {
        return dao.findAbillitiesByid(id);
    }

//    @Transactional
//    public List<qWorkExperienceEntityToJoin> findWorkExperienceById(String id) {
//        return dao.findWorkExperienceById(id);
//    }
    @Transactional
    public List<WorkExperienceEntity> findWorkExperienceById(String id) {
        return dao.findWorkExperienceById(id);
    }

    @Transactional
    public List<ChildEntity> findChildByid(String id) {
        return dao.findChildById(id);
    }

    @Transactional
    public List<ReferencePersonEntity> findReferencePersonById(String id) {
        return dao.findReferencePersonById(id);
    }

    @Transactional
    public List<ContactPersonEntity> findContactPersonByid(String id) {
        return dao.findContactPersonById(id);
    }

    @Transactional
    public List<DataOtherEntity> findDataOtherByid(String id) {
        return dao.findDataOtherById(id);
    }

    @Transactional
    public List<EducationEntity> findEducationById(String id) {
        return dao.findEducationById(id);
    }

    @Transactional
    public List<qPositionNameEntityToJoin> findPositionNameById(String id) {
        return dao.findPositionNameById(id);
    }

    @Transactional
    public List<SiblingEntity> findSiblingById(String id) {
        return dao.findSiblingById(id);
    }

    @Transactional
    public List<TrainingEntity> findTrainingById(String id) {
        return dao.findTrainingById(id);
    }

    @Transactional
    public List<qCandidateEntityToUse> finCandidateByStatus(String status) {
        return dao.finCandidateByStatus(status);
    }

    @Transactional
    public List<qCandidateEntityToUse> finCandidateById(String id) {
        return dao.finCandidateById(id);
    }

    @Transactional
    public QueryPDF findPDF(String id) {
        return dao.findPDF(id);
    }

    @Transactional
    public void updateApplicationStatus(String id, String status) {
        dao.UpdateApplicationStatus(id, status);
    }

    @Transactional
    public List<PreTestEntity> findPreTestById(String id) {
        return dao.findPreTestById(id);
    }
}
