/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.ApplicationEntity;
import com.sense.backend.hb.entity.auth.ChildEntity;
import com.sense.backend.hb.entity.auth.qApplicationEntity;
import com.sense.backend.hb.entity.auth.qDataAbillitiesEntityToJoin;
import com.sense.backend.hb.entity.auth.qInterviewAppointmentEntityToJoin;
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
public class ApplicationDAO extends BaseDAO<ApplicationEntity, Integer> {

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

    public List<qDataAbillitiesEntityToJoin> findAbillitiesByid(Integer id) {
        List<qDataAbillitiesEntityToJoin> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select abillities.*, vehicle.vehicle_drive ,vehicle.vehicle_own ,vehicle.vehicle_no ,vehicle.vehicle_type ,languages.languages_name ,languages.languages_speaking,languages.languages_reading ,languages.languages_writing ,languages.languages_typewriter  ");
        sql.append("from abillities  ");
        sql.append("inner join vehicle on abillities.abillities_id = vehicle.abillities_id ");
        sql.append("inner join languages on abillities.abillities_id  = languages.abillities_id ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), qDataAbillitiesEntityToJoin.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }

    public List<qWorkExperienceEntityToJoin> findWorkExperienceByid(Integer id) {
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

    public List<ChildEntity> findChildById(Integer id) {
        List<ChildEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM child  ");
        sql.append("where application_id  = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), ChildEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();
        return result;
    }
}
