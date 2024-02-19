/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sense.backend.hb.dao.auth;

import com.sense.backend.hb.dao.BaseDAO;
import com.sense.backend.hb.entity.auth.ReferencePersonEntity;
import com.sense.backend.hb.entity.auth.WorkExperienceEntity;
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
public class WorkExperienceDAO extends BaseDAO<WorkExperienceEntity, Integer> {
    
    @Autowired
    private SessionFactory sessionFactory;

    public WorkExperienceDAO() {
        super(WorkExperienceEntity.class);
    }

    public List<ReferencePersonEntity> findRefById(Integer id) {
        List<ReferencePersonEntity> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select reference_person.*");
        sql.append("from work_experience ");
        sql.append("inner join reference_person on work_experience.work_experience_id = reference_person.work_experience_id ");
        sql.append("where application_id = :id");
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql.toString(), ReferencePersonEntity.class);
        query.setParameter("id", id);
        result = query.getResultList();

        return result;
    }
}
