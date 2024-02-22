/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.AbillitiesEntity;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.qCandidateEntityToUse;
import com.sense.backend.hb.entity.auth.ChildEntity;
import com.sense.backend.hb.entity.auth.ContactPersonEntity;
import com.sense.backend.hb.entity.auth.DataOtherEntity;
import com.sense.backend.hb.entity.auth.EducationEntity;
import com.sense.backend.hb.entity.auth.SiblingEntity;
import com.sense.backend.hb.entity.auth.TrainingEntity;
import com.sense.backend.hb.entity.auth.qApplicationEntity;
import com.sense.backend.hb.entity.auth.qPositionNameEntityToJoin;
import com.sense.backend.hb.entity.auth.qWorkExperienceEntityToJoin;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SenseInfoTech
 */
@Repository
public class ApplicationDAO extends BaseDAO<ApplicationEntity, String> {

    @Autowired
    private SessionFactory sessionFactory;

    public ApplicationDAO() {
        super(ApplicationEntity.class);
    }

    public List<qApplicationEntity> findAllName() {
        List<qApplicationEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.application_id ,position_link_form.position_id ,application.application_submit_date ,application.can_first_name_th ,application.can_last_name_th , position_link_form.position_name ,application.application_status ");
        sql.append("from application ");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");

        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qApplicationEntity.class);
        result = query.getResultList();
        return result;
    }

    public List<AbillitiesEntity> findAbillitiesByid(String id) {
        List<AbillitiesEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from abillities ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), AbillitiesEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<qWorkExperienceEntityToJoin> findWorkExperienceByid(String id) {
        List<qWorkExperienceEntityToJoin> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select work_experience.*, reference_person.ref_first_name, reference_person.ref_last_name, reference_person.ref_job_position ,reference_person.ref_work_location ,reference_person.ref_phone ");
        sql.append("from work_experience ");
        sql.append("inner join reference_person on work_experience.work_experience_id = reference_person.work_experience_id ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qWorkExperienceEntityToJoin.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<ChildEntity> findChildById(String id) {
        List<ChildEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM child  ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), ChildEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<ContactPersonEntity> findContactPersonById(String id) {
        List<ContactPersonEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from contact_person ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), ContactPersonEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<DataOtherEntity> findDataOtherById(String id) {
        List<DataOtherEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from data_other ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), DataOtherEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<EducationEntity> findEducationById(String id) {
        List<EducationEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from education ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), EducationEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<qPositionNameEntityToJoin> findPositionNameById(String id) {
        List<qPositionNameEntityToJoin> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.application_id , position_link_form.position_name ");
        sql.append("from application ");
        sql.append("inner join position_link_form on position_link_form.position_id = application.position_id ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qPositionNameEntityToJoin.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<SiblingEntity> findSiblingById(String id) {
        List<SiblingEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from sibling ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), SiblingEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<TrainingEntity> findTrainingById(String id) {
        List<TrainingEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from training ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), TrainingEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }
    
        public List<qCandidateEntityToUse> finCandidateByStatus(String status) {
        List<qCandidateEntityToUse> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select application.application_id ,application.can_first_name_th , application.can_last_name_th ,application.application_status ");
        sql.append("from application ");
        sql.append("where application_status = :status");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qCandidateEntityToUse.class);
        query.setParameter("status", status);
        result = query.getResultList();
        return result;
    }
}
